package cukes.steps;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class PoolingSteps {
	
	public static Map<String, String> offer;
	
	@Given("^I have the folowing offers:$")
	public void I_have_the_folowing_offers(DataTable arg1) {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
		//arg1.;
	    //throw new PendingException();
	}
	
	@When("^I register a car polling offer$")
	public void I_register_a_car_polling_offer() {
		offer = new HashMap<String, String>();
	}

	@When("^I specify the departure from \"([^\"]*)\" on \"([^\"]*)\" at \"([^\"]*)\"$")
	public void I_specify_the_departure_from_on_at(String from, String fromDate, String fromTime) {
		offer.put("from", from);
	}

	@When("^I specify the destination as \"([^\"]*)\"$")
	public void I_specify_the_destination_as(String to) {
		offer.put("to", to);
	}

	@Then("^The offer should be in the system$")
	public void The_offer_should_be_in_the_system() {
		Assert.assertNotNull(offer);
		//Assert.assertNotNull(offer.get("fromDate"));
		//Assert.assertNotNull(offer.get("fromTime"));
	}
	
}
