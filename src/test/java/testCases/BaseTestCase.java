package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTestCase {

    WebDriver driver;
    String githubLink = "https://github.com/login";

    //multi browsers
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //close the tab/window last opened
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Data Provider method to provide input test cases
    @DataProvider(name = "credentials")
    public Object[][] getLoginData() {
        return new Object[][] {
              {"TC001","tassneemiyad2019@gmail.com", "tassneemiyad1*"},//TC001
                {"TC002","tassneemiyad2024@gmail.com", "tassneemiyad1*"},//TC002
                {"TC003","tassneemiyad2019@gmail.com", "12345678901*"},//TC003
                {"TC004","", ""}, //TC004
        };
    }



}
