package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseClass;
import pageObjects.SignupPage;
import io.cucumber.java.en.*;

import java.time.Duration;

public class SignupSteps {
    WebDriver driver;
    SignupPage signupPage;

    @Given("User is on the signup page")
    public void user_is_on_signup_page() {
        BaseClass.startBrowser();
        driver = BaseClass.driver;
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        signupPage = new SignupPage(driver);
    }

    @When("User enters valid details and submits")
    public void user_enters_valid_details_and_submits() {
        signupPage.enterFirstName("Test");
        signupPage.enterLastName("User");
        signupPage.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        signupPage.clickCreateAccount();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        By successMessageLocator = By.xpath("//*[text()='Thank you for registering with Main Website Store.']");
        BaseClass.wait("//*[text()='Thank you for registering with Main Website Store.']");
        WebElement successMessage = driver.findElement(successMessageLocator);
        Assert.assertTrue("Success message is displayed!", successMessage.isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters an already registered email")
    public void user_enters_an_already_registered_email() {
        signupPage.enterFirstName("John");
        signupPage.enterLastName("Doe");
        signupPage.enterEmail("xaceras648@doishy.com"); // Use an existing email
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        signupPage.clickCreateAccount();
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        By errorLocator = By.xpath("//*[contains(text(),'There is already an account with this email address')]");
        BaseClass.wait("//*[contains(text(),'There is already an account with this email address')]");
        Assert.assertTrue("Error message displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters an invalid email format")
    public void user_enters_an_invalid_email_format() {
        signupPage.enterFirstName("Invalid");
        signupPage.enterLastName("Email");
        signupPage.enterEmail("invalid-email-format"); // Invalid email
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        signupPage.clickCreateAccount();
    }

    @Then("An appropriate error message should be displayed")
    public void an_appropriate_error_message_should_be_displayed() {
        By errorLocator = By.xpath("//*[contains(text(),'Please enter a valid email address')]");
        BaseClass.wait("//*[contains(text(),'Please enter a valid email address')]");
        Assert.assertTrue("Invalid email format error displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters a weak password")
    public void user_enters_a_weak_password() {
        signupPage.enterFirstName("Weak");
        signupPage.enterLastName("Password");
        signupPage.enterEmail("weakpassword" + System.currentTimeMillis() + "@gmail.com");
        signupPage.enterPassword("1234"); // Weak password
        signupPage.enterConfirmPassword("1234");
        signupPage.clickCreateAccount();
    }

    @Then("A password strength error message should be displayed")
    public void a_password_strength_error_message_should_be_displayed() {
        By errorLocator = By.xpath("//*[contains(text(),'Minimum length of this field must be')]");
        BaseClass.wait("//*[contains(text(),'Minimum length of this field must be')]");
        Assert.assertTrue("Weak password error displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User submits the form without entering required fields")
    public void user_submits_the_form_without_entering_required_fields() {
        signupPage.clickCreateAccount(); // Submit form without entering anything

    }

    @Then("Validation messages should be displayed")
    public void validation_messages_should_be_displayed() {
        By errorLocator = By.xpath("//*[@class='mage-error']");
        BaseClass.wait("//*[@class='mage-error']");
        Assert.assertTrue("Required fields error displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters different passwords in password and confirm password fields")
    public void user_enters_different_passwords() {
        signupPage.enterFirstName("Admin");
        signupPage.enterLastName("super");
        signupPage.enterEmail("mismatch" + System.currentTimeMillis() + "@gmail.com");
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Mismatch@5678");
        signupPage.clickCreateAccount();
    }

    @Then("A password mismatch error message should be displayed")
    public void a_password_mismatch_error_message_should_be_displayed() {
        By errorLocator = By.xpath("//*[contains(text(),'Please enter the same value again.')]");
        BaseClass.wait("//*[contains(text(),'Please enter the same value again.')]");
        Assert.assertTrue("Mismatch password error displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters only spaces in mandatory fields")
    public void user_enters_only_spaces_in_mandatory_fields() {
        signupPage.enterFirstName("   ");
        signupPage.enterLastName("   ");
        signupPage.enterEmail("   ");
        signupPage.enterPassword("   ");
        signupPage.enterConfirmPassword("   ");
        signupPage.clickCreateAccount();
    }

    @Then("An invalid input error should be displayed")
    public void an_invalid_input_error_should_be_displayed() {
        By errorLocator = By.xpath("//*[contains(text(),'This is a required field')]");
        BaseClass.wait("//*[contains(text(),'This is a required field')]");
        Assert.assertTrue("Invalid input error displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters special characters in name fields")
    public void user_enters_special_characters_in_name_fields() {
        signupPage.enterFirstName("@#$%");
        signupPage.enterLastName("&*()");
        signupPage.enterEmail("test" + System.currentTimeMillis() + "@gmail.com");
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        signupPage.clickCreateAccount();
    }

    @Then("A name format validation message should be displayed")
    public void a_name_format_validation_message_should_be_displayed() {
        By errorLocator = By.xpath("//*[text()='Thank you for registering with Main Website Store.']");
        BaseClass.wait("//*[text()='Thank you for registering with Main Website Store.']");
        Assert.assertFalse("No validation error displayed!", driver.findElement(errorLocator).isDisplayed());
        BaseClass.tearDown();
    }

    @When("User enters maximum allowed characters in all fields")
    public void user_enters_maximum_allowed_characters() {
        String longText = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        signupPage.enterFirstName(longText);
        signupPage.enterLastName(longText);
        signupPage.enterEmail(longText + "@gmail.com");
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        signupPage.clickCreateAccount();
    }

    @Then("Account should be created successfully or an error message should be displayed")
    public void account_should_be_created_or_error_displayed() {
        By successLocator = By.xpath("//*[text()='Thank you for registering with Main Website Store.']");
        BaseClass.wait("//*[text()='Thank you for registering with Main Website Store.']");
        boolean isSuccessDisplayed = !driver.findElements(successLocator).isEmpty();

        Assert.assertFalse("Account is created!", isSuccessDisplayed);
        BaseClass.tearDown();
    }
}
