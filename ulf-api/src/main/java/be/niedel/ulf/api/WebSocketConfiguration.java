package be.niedel.ulf.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import reactor.core.publisher.Sinks;

import java.util.Set;

import static java.util.stream.Collectors.toMap;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
public class WebSocketConfiguration {

    /**
     * Maps all WebSocketController beans as web socket handlers
     */
    @Bean
    public HandlerMapping webSocketHandlerMapping(Set<WebSocketController> webSocketCollectors) {
        var collectorsByPath = webSocketCollectors.stream()
                .collect(toMap(WebSocketController::path, webSocketCollector -> webSocketCollector));

        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        handlerMapping.setOrder(HIGHEST_PRECEDENCE);
        handlerMapping.setUrlMap(collectorsByPath);
        return handlerMapping;
    }

    @Bean
    public Sinks.Many<String> sink() {
        // unicast v.s. multicast & backPressure v.s. bestEffort ...
        return Sinks.many().multicast().onBackpressureBuffer();
    }


}
