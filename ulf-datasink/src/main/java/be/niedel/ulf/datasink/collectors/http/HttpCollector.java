package be.niedel.ulf.datasink.collectors.http;

import be.niedel.ulf.model.CounterWidget;
import be.niedel.ulf.model.TextWidget;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/collectors")
public final class HttpCollector implements CollectableWidgets {

    @PutMapping("text")
    @Override
    public void collect(TextWidget widget) {

    }

    @PutMapping("counter")
    @Override
    public void collect(CounterWidget widget) {

    }
}
