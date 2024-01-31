package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Common_Steps {

    private WebDriver driver;

    @Before(order = 1)
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Resources\\chromedriver\\118\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Global before Hook Executed");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()) {
            final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(scr, "image/png", scenario.getName());
        }
        driver.quit();
        Thread.sleep(1000);
        System.out.println("Global after Hook Executed");
    }


    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return null;
    }

}
