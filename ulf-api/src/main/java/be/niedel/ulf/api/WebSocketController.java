package be.niedel.ulf.api;

import org.springframework.web.reactive.socket.WebSocketHandler;

public interface WebSocketController extends WebSocketHandler {

    String path();
}
