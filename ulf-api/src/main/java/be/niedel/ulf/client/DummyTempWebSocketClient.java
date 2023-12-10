package be.niedel.ulf.client;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;
import java.util.UUID;

public class DummyTempWebSocketClient {

    public static void main(String[] args) {
        createClient();
    }

    public static void createClient() {
        var key = UUID.randomUUID().toString().substring(0, 5);
        WebSocketClient client = new ReactorNettyWebSocketClient();
        URI uri = URI.create("ws://localhost:8080/simple-messages");

        client.execute(uri, webSocketSession ->
                // send msg
                webSocketSession.send(Mono.just(webSocketSession.textMessage(key))
                ).and(
                        // receive message
                        webSocketSession.receive()
                                .map(WebSocketMessage::getPayloadAsText)
                                .log()
                ).then()
        ).block(Duration.ofSeconds(500));
    }

}
