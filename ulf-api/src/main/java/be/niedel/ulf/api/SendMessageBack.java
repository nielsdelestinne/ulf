package be.niedel.ulf.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class SendMessageBack implements Consumer<String> {

    private static final Logger logger = LoggerFactory.getLogger(SendMessageBack.class);

    private final WebSocketSession session;

    public SendMessageBack(WebSocketSession session) {
        this.session = session;
    }

    @Override
    public void accept(String message) {
        logger.info("Sending message {}", message);
        session.send(Mono.just(session.textMessage(message))).subscribe();

    }
}
