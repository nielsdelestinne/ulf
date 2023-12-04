package be.niedel.ulf.datasink.collectors.http;

import be.niedel.ulf.model.CounterWidget;
import be.niedel.ulf.model.TextWidget;

sealed interface CollectableWidgets permits HttpCollector {

    void collect(TextWidget widget);

    void collect(CounterWidget widget);

}
