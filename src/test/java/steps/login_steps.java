package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class login_steps {


    WebDriver driver;

    public login_steps(Common_Steps common_steps) { //feed from Common_Steps.java
        this.driver = common_steps.getDriver();
    }

    @Given("I am on Banking line online Login Page")
    public void i_am_on_banking_line_online_login_page() {
        driver.get("https://demo.testfire.net/login.jsp");
        System.out.println("I am on demo.testfire Login Page");

    }
    @When("I enter my credentials on login page")
    public void i_enter_my_credentials_on_login_page() {
        driver.findElement(By.id("uid")).sendKeys("jsmith");
        driver.findElement(By.id("passw")).sendKeys("demo1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
    @Then("I validate that the login is successfully")
    public void i_validate_that_the_login_is_successfully() throws InterruptedException {
        Thread.sleep(2000);
        //WebElement actTitle = driver.findElement(By.xpath("//span[contains(.,'" + title + "')]"));
        String validation = String.valueOf(driver.findElement(By.xpath("//h2[contains(.,'Congratulations! ')]")));
        //WebElement assert = driver.findElement(By.xpath("//h2[contains(.,'Congratulations! ')]")).click();
        System.out.println("El script finalizo con exito");
    }


}

