package be.niedel.ulf.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

import java.util.UUID;

import static be.niedel.ulf.api.Room.room;

@RestController
@RequestMapping("api/v1/rooms")
public final class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostMapping
    public ResponseEntity<UUID> create() {
        var room = room(Sinks.many().multicast().onBackpressureBuffer());
        roomRepository.saveRoom(room);
        return ResponseEntity.ok(room.roomId());
    }

    @GetMapping(path = "{roomId}")
    public void emit(@PathVariable UUID roomId) {
        var room = roomRepository.getRoom(roomId);
        room.sink().tryEmitNext("Sending a message to the whole room: %s".formatted(roomId));
    }
}
