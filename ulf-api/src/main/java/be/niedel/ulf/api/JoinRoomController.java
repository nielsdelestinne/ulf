package be.niedel.ulf.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import java.util.UUID;

@Controller
public final class JoinRoomController implements WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(JoinRoomController.class);

    @Override
    public String path() {
        return "join-room";
    }

    private final RoomRepository roomRepository;

    public JoinRoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    @NonNull
    public Mono<Void> handle(@NonNull WebSocketSession session) {
        Mono<Void> input = session.receive()
                .doOnNext(webSocketMessage -> {
                    logger.info("Message received from client: {}", webSocketMessage);
                    var room = roomRepository.getRoom(UUID.fromString(webSocketMessage.getPayloadAsText()));
                    room.sink().asFlux().subscribe(new SendMessageToRoom(session));
                })
                .then();

        return Flux.merge(input).then();
    }
}
