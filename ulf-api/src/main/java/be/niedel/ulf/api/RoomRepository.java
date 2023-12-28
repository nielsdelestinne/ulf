package be.niedel.ulf.api;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Component
@Scope(value = SCOPE_SINGLETON)
public class RoomRepository {

    private final Map<UUID, Room> rooms = new HashMap<>();

    void saveRoom(Room room) {
        rooms.put(room.roomId(), room);
    }

    Room getRoom(UUID roomId) {
        return rooms.get(roomId);
    }

}
