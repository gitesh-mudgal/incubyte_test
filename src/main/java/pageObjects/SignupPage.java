package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFirstName(String fname) {
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lname);
    }

    public void enterEmail(String emailAddress) {
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
    }

    public void enterPassword(String pass) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
    }

    public void enterConfirmPassword(String confirmPass) {
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys(confirmPass);
    }

    public void clickCreateAccount() {
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
    }
}
