package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage ;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credtable) {
		
		List<Map<String, String>> credList = credtable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get(" http://automationpractice.com/index.php?\"\r\n" + 
				"+ \"controller=authentication&back=my-account");
		accountsPage= loginPage.doLogin(username, password);
	}
	
	@Given("user is on Accounts Page")
	public void user_is_on_Accounts_Page() {

		accountsPage.getAccountsPageTitle();
	}
	
	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
		//this is expected list in the datatable from accounts page feature file
		List<String> expectedSectionsList = sectionTable.asList(); 
		System.out.println("Expected accounts section list " + expectedSectionsList);
		
		/*this is actual list  from getAccountsSectionsList() method 
		in the accountsPage class which gets the actual list */ 
		List<String> actualSectionsList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list " + actualSectionsList);
		
		Assert.assertTrue(expectedSectionsList.containsAll(actualSectionsList));
		
	}
	
	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be (Integer expectedSectionCount) {

		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
