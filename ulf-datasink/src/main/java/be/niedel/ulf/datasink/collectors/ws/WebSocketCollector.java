package be.niedel.ulf.datasink.collectors.ws;

import org.springframework.web.reactive.socket.WebSocketHandler;

public interface WebSocketCollector extends WebSocketHandler {

    String path();
}
