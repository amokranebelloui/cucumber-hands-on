package cukes.steps;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cukes.AuthenticationService;

public class AuthenticationSteps {
	
	//public static String loggedInUsername;
	public static String sessionId;

	public static AuthenticationService authenticationService = new AuthenticationService();
	
	@Given("^I am not logged in$")
	public void I_am_not_logged_in() {
		sessionId = null;
		//loggedInUsername = null;
		sessionId = null;
	}

	@Given("^I am logged in as \"([^\"]*)\"$")
	public void I_am_logged_in_as(String username) throws Exception {
		authenticationService.register(username, "tmp-pwd");
		sessionId = authenticationService.login(username, "tmp-pwd");
	    //loggedInUsername = username;
	}

	@Given("^the account \"([^\"]*)\" with password \"([^\"]*)\" exists$")
	public void the_account_with_password_exists(String username, String password) {
		boolean exists = authenticationService.exists(username);
	    Assert.assertEquals("Account " + username + " doesn't exist", true, exists);
	}

	@When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_login_with_and(String username, String password) throws Exception {
		sessionId = authenticationService.login(username, password);
	}

	@Then("^A session should exist for \"([^\"]*)\"$")
	public void A_session_should_exist_for(String username) {
		Assert.assertTrue("no session found for " + username, StringUtils.isNotBlank(sessionId));
	}

	
}
