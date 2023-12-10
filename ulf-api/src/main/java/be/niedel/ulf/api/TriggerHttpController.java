package be.niedel.ulf.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("api/v1/trigger")
public final class TriggerHttpController {

    Sinks.Many<String> sink;

    public TriggerHttpController(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    @GetMapping("send-message-back")
    public void sendMessageBack() {
        sink.tryEmitNext("Sending a message back to all clients!");
    }
}
