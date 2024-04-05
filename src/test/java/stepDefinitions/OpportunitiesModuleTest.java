package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_Utilities.SeleniumUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom_Repository.AddOrganizationPage;
import pom_Repository.CreateNewOpportunityPage;
import pom_Repository.DeletePage;
import pom_Repository.HomePage;
import pom_Repository.LoginPage;
import pom_Repository.OpportunitiesPage;

public class OpportunitiesModuleTest {
	WebDriver driver;
	SeleniumUtilities sutil = new SeleniumUtilities();
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() throws Exception {
	    driver = new ChromeDriver();
	    sutil.maximizeWindow(driver);
	    sutil.implicitWait(driver);
	    sutil.screenshot(driver, "log in validation");
	    System.out.println("browser launched successfully");
	}
	@Given("Load the URl")
	public void load_the_u_rl() {
	    driver.get("http://localhost:8888/");
	}
	@When("Log in page is displayed enter the username and password and click on the log in button")
	public void log_in_page_is_displayed_enter_the_username_and_password_and_click_on_the_log_in_button() {
		LoginPage lp = new LoginPage(driver);
	    lp.logInToApp("admin", "admin");
	    System.out.println("logged in successfully");
	}
	@Then("Validate for Homepage")
	public void validate_for_homepage() throws Exception {
	    sutil.screenshot(driver, "homepage validation");
	}
	@When("Homepage is visible click on opportunities link")
	public void homepage_is_visible_click_on_opportunities_link() {
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOpportunities();
	}
	@Then("validate opportunities page is visible")
	public void validate_opportunities_page_is_visible() throws Exception {
	    sutil.screenshot(driver, "oppurtunities page validation");
	}
	@When("opportunities page is visible click on Add opportunities picture")
	public void opportunities_page_is_visible_click_on_add_opportunities_picture() {
	    OpportunitiesPage op = new OpportunitiesPage(driver);
	    op.clickOnAddOpportunities();
	}
	@Then("validate create new opportunities page is visible")
	public void validate_create_new_opportunities_page_is_visible() throws Exception {
	    sutil.screenshot(driver, "new opportunities page visible validation");
	}
	@When("new opportunities page is visible fill up the mandatory fields in create opportunities page and save it")
	public void new_opportunities_page_is_visible_fill_up_the_mandatory_fields_in_create_opportunities_page_and_save_it() {
	    CreateNewOpportunityPage cop = new CreateNewOpportunityPage(driver);
	    cop.clickOnOpportunityName("New Opportunity");
	    cop.clickOnAddRelatedTo();
	    sutil.switchingWindow(driver);
	    AddOrganizationPage aop = new AddOrganizationPage(driver);
	    aop.clickOnOrganizationName();
	    sutil.switchingMainWindow(driver);
	    WebElement OpportunityType = cop.getOpportunityType();
	    sutil.dropDownHandling(OpportunityType, "New Business");
	    cop.clickOnSave();
	}
	@Then("validate a new opportunities is created")
	public void validate_a_new_opportunities_is_created() throws Exception {
	    sutil.screenshot(driver, "new opportunities creation validation");
	}
	@When("going backward twice opportunities page is visible")
	public void going_backward_twice_opportunities_page_is_visible() {
	    sutil.back(driver);
	}
	@Then("click on delete opportunities")
	public void click_on_delete_opportunities() {
	    DeletePage dp = new DeletePage(driver);
	    dp.clickOnCheckBox();
	    dp.clickOnDelete();
	}
	@When("alert asking for confirmation")
	public void alert_asking_for_confirmation() throws Exception {
		System.out.println("alert is asking");
	}
	@Then("accept the alert")
	public void accept_the_alert() throws InterruptedException {
	    sutil.alertHanlding(driver);
	}
	@Then("take a screenshot for validation")
	public void take_a_screenshot_for_validation() throws Exception {
	    sutil.screenshot(driver, "deletion validation");
	    System.out.println("Test case is passed");
	}
	@When("homepage is displayed move to adminstrator")
	public void homepage_is_displayed_move_to_adminstrator() throws InterruptedException {
	    HomePage hp = new HomePage(driver);    
	    sutil.mouseHover(driver, hp.getAdminstrator());
	}
	@When("Click on sign out")
	public void click_on_sign_out() {
	    HomePage hp = new HomePage(driver);
	    hp.SignOut();
	}
	@Then("validate for signout")
	public void validate_for_signout() throws Exception {
		sutil.screenshot(driver, "sign out validation");
		System.out.println("sign out successful");
	}
	@Then("close the browser")
	public void close_the_browser() {
	    driver.close();
	    System.out.println("Closing browser successfully");
	}


}
