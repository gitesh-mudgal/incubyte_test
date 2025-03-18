package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.BaseClass;
import pageObjects.SignupPage;

public class SignupSteps {
    WebDriver driver;
    SignupPage signupPage;

    @Given("User is on the signup page")
    public void user_is_on_signup_page() {
        BaseClass.startBrowser();
        driver = BaseClass.driver;
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signupPage = new SignupPage(driver);
    }
    @When("User enters valid details and submits")
    public void user_enters_valid_details_and_submits() {
        signupPage.enterFirstName("Test");
        signupPage.enterLastName("User");
        signupPage.enterEmail("xaceras648@doishy.com");
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        signupPage.clickCreateAccount();
    }
    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("customer/account"));
        BaseClass.tearDown();
    }
}
