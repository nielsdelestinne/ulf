package be.niedel.ulf.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.NonNull;

@Controller
public final class FirstWebSocketController implements WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(FirstWebSocketController.class);

    private final Sinks.Many<String> sink;

    public FirstWebSocketController(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    public String path() {
        return "simple-messages";
    }

    @Override
    @NonNull
    public Mono<Void> handle(@NonNull WebSocketSession session) {
        sink.asFlux().subscribe(new SendMessageBack(session));

        Mono<Void> input = session.receive()
                .doOnNext(webSocketMessage -> logger.info("Message received from client: {}", webSocketMessage))
                .then();

        return Flux.merge(input).then();
    }
}
