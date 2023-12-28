package be.niedel.ulf.client;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

public class DummyTempWebSocketClient {

    public static void main(String[] args) {
        createClient();
    }

    public static void createClient() {
        var roomId = "50616cf4-ceda-46b7-a0e4-516fa468d07e";
        WebSocketClient client = new ReactorNettyWebSocketClient();
        URI uri = URI.create("ws://localhost:8123/join-room");

        client.execute(uri, webSocketSession ->
                // send msg
                webSocketSession.send(Mono.just(webSocketSession.textMessage(roomId))
                ).and(
                        // receive message
                        webSocketSession.receive()
                                .map(WebSocketMessage::getPayloadAsText)
                                .log()
                ).then()
        ).block(Duration.ofSeconds(500));
    }

}
