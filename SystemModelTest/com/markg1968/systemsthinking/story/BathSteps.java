package com.markg1968.systemsthinking.story;

import com.markg1968.systemsthinking.Quantity;
import com.markg1968.systemsthinking.Time;
import com.markg1968.systemsthinking.Unit;
import com.markg1968.systemsthinking.system.Bath;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BathSteps {
    private Bath bath;
    private Time bathTime;

    @Given("that the Bath initially has $initialAmount Litres")
    public void theBathIsCreated(long initialAmount) {
        bath = new Bath(Quantity.of(initialAmount, Unit.Litres));
    }

    @When("the time is at $time Second")
    public void theTImeIs(long time) {
        bathTime = Time.atSeconds(time);
    }

    @Then("the bath should contain $currentAmount Litres")
    public void theGridShouldLookLike(long currentAmount) {
        assertThat(bath.getMeasure(bathTime), is(equalTo(Quantity.of(currentAmount, Unit.Litres))));
    }
}
