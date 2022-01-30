import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class extend3 {
    WebDriver driver;
    ExtentReports extent;
    @BeforeMethod
    public void Pre() {
        String Report = System.getProperty("user.dir") + "\\report3.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(Report);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tested By", "shyam");
        extent.setSystemInfo("Operating Sys", "Windos 10");
    }

    @Test
    public void TestTwo(){
        ExtentTest etest = extent.createTest("Test Two");
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         etest.info("test started");
         driver.get("https://mail.google.com/mail/u/0/#inbox?projector=1");

    }
    @AfterMethod
    public void closer(){
        driver.close();
        extent.flush();
    }
}
