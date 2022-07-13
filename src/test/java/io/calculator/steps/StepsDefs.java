package io.calculator.steps;

import io.calculator.Functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepsDefs {

 Functions functions;
  int actualResult;

  @Given("^I create a new Function object$")
  public void createNewObject() {
    functions = new Functions();
  }

  @When("^I add (.*) and (.*) into the function$")
  public void addTwoNumberToFunction(int a, int b) {
    actualResult = functions.addition(a, b);
  }

  @Then("^I get (.*) as a result$")
  public void checkResult(int expectedResult) {
    assertEquals(expectedResult, actualResult);
  }


}
