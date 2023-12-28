package be.niedel.ulf.api;

import reactor.core.publisher.Sinks;

import java.util.Objects;
import java.util.UUID;

public final class Room {

    private final UUID roomId;
    private final Sinks.Many<String> sink;

    private Room(UUID roomId, Sinks.Many<String> sink) {
        this.roomId = roomId;
        this.sink = sink;
    }

    public static Room room(Sinks.Many<String> sink) {
        return new Room(UUID.randomUUID(), sink);
    }

    public UUID roomId() {
        return roomId;
    }

    public Sinks.Many<String> sink() {
        return sink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }
}
