package exercise_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class test {
	WebDriver driver;
	String URL = "http://localhost:4444/grid/console";
	@BeforeClass
    @Parameters("browser")
	@Test
    public void setUpRunParallelUsingGrid(String browser) throws Exception {
        //data = getDataFromExcel();
        String Hub = "http://localhost:4444/wd/hub";
        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println(" Executing on FireFox using Grid");
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(Hub), cap);
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println(" Executing on CHROME using Grid");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(Hub), cap);
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        // Launch website
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
    }

}
