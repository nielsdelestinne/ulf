package be.niedel.ulf.datasink.collectors.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

@Controller
public final class TextWidgetWebSocketCollector implements WebSocketCollector {

    public String path() {
        return "text";
    }

    @Override
    @NonNull
    public Mono<Void> handle(WebSocketSession session) {
        return session.receive()
                .map(msg -> "RECEIVED ON SERVER :: " + msg.getPayloadAsText())
                .map(session::textMessage)
                .then();
    }
}
