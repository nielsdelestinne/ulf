package be.niedel.ulf.datasink.collectors.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;

import java.util.Set;

import static java.util.stream.Collectors.toMap;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
public class WebSocketCollectorConfiguration {

    private final Set<WebSocketCollector> webSocketCollectors;

    public WebSocketCollectorConfiguration(Set<WebSocketCollector> webSocketCollectors) {
        this.webSocketCollectors = webSocketCollectors;
    }

    @Bean
    public HandlerMapping webSocketHandlerMapping() {
        var collectorsByPath = webSocketCollectors.stream()
                .collect(toMap(WebSocketCollector::path, webSocketCollector -> webSocketCollector));

        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        handlerMapping.setOrder(HIGHEST_PRECEDENCE);
        handlerMapping.setUrlMap(collectorsByPath);
        return handlerMapping;
    }

}
