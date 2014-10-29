package com.markg1968.systemsthinking.spec;

import com.markg1968.systemsthinking.Quantity;
import com.markg1968.systemsthinking.Time;
import com.markg1968.systemsthinking.Unit;
import com.markg1968.systemsthinking.system.Bath;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class BathFixture {

    private Bath bath;

    @Before
    public void setup() {
        bath = new Bath(Quantity.of(50, Unit.Litres));
    }

    public long getFor(long time) {
        return bath.getMeasure(Time.atSeconds(time)).asMagnitudeOf(Unit.Litres);
    }
}

