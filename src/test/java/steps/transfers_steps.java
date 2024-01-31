package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class transfers_steps {

    WebDriver driver;

    public transfers_steps(Common_Steps common_steps) { //feed from Common_Steps.java
        this.driver = common_steps.getDriver();
    }

    @Given("I am on transfers funds page")
    public void i_am_on_transfers_funds_page() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a#MenuHyperLink3")).click();

        Thread.sleep(2000);
        System.out.println("I am on transfers funds page");
    }

    @When("I select {string} and {string} account")
    public void i_select_and_account(String string, String string2) throws InterruptedException {
        Select fromAccount = new Select(driver.findElement(By.id("fromAccount")));
        fromAccount.selectByValue(string);
        Thread.sleep(2000);
        Select toAccount = new Select(driver.findElement(By.id("toAccount")));
        toAccount.selectByVisibleText(string2);


    }
    @When("I enter an amount {string}")
    public void i_enter_an(String string)  throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("transferAmount")).sendKeys(string);        //
    }


    @Then("I validate that transfer is successfull")
    public void i_validate_that_transfer_is_successfull() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='transfer']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(@style, 'color: Red')][contains(., 'successfully')]"));
    }
}
