package com.markg1968.systemsthinking;

import java.util.Optional;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

public class Flow implements Measurable, Named {
    private String name;
    private Set<FlowCalculator> flowCalculator;

    public Flow(String name, Set<FlowCalculator> calculators) {
        checkNotNull(name);
        checkNotNull(calculators);

        this.flowCalculator = calculators;
        this.name = name;
    }

    @Override
    public String getName() {

        return name;
    }

     @Override
     public Quantity getMeasure(Time time) {

         Optional<FlowCalculator> correctCalculator = flowCalculator.stream().filter(x -> x.canCalculate(time)).findFirst();

         correctCalculator.orElseThrow(IllegalStateException::new);

         return correctCalculator.get().getMeasure(time);
     }
}
