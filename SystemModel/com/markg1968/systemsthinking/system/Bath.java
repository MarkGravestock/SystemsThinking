package com.markg1968.systemsthinking.system;

import com.google.common.collect.ImmutableSet;
import com.markg1968.systemsthinking.*;

public class Bath implements Measurable {
    public static final String STOCK_NAME = "Bath";
    public static final String IN_FLOW_NAME = "Tap";
    public static final String OUT_FLOW_NAME = "Plug";

    private Stock stock;

    public Bath(Quantity initialMeasure) {

        stock = new Stock(STOCK_NAME, ImmutableSet.of(new FixedInflow(IN_FLOW_NAME), new FixedOutflow(OUT_FLOW_NAME)), initialMeasure);
    }

    @Override
    public Quantity getMeasure(Time time) {
        return stock.getMeasure(time);
    }
}
