package bdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import evaluator.PostFixEvaluator;

public class PostFixEvaluatorSteps {
  PostFixEvaluator evaluator;
  Double computedResult;
  
  @Given("^User enters \"([^\"]*)\"$")
  public void user_enters(String expression) throws Throwable {
    evaluator = new PostFixEvaluator(expression);
  }

  @When("^User asks for result$")
  public void user_asks_for_result() throws Throwable {
    computedResult = evaluator.evaluate();
  }

  @Then("^result should be (\\d+)$")
  public void result_should_be(Double result) throws Throwable {
    assertEquals(result, computedResult);
  }
  
  @Then("^result should be \"([^\"]*)\"$")
  public void result_should_be(String result) throws Throwable {
    assertTrue(Double.parseDouble(result) == computedResult);
  }
 

}
