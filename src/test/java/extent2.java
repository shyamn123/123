import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class extent2 {
    ExtentReports extent;
    WebDriver driver;
    @BeforeMethod
    public void Prerequisuit() {
        String Report = System.getProperty("user.dir")+"\\report2.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(Report);
        reporter.config().setReportName("Report2");
        reporter.config().setDocumentTitle("ReportSecond");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tested by", "shyam");
        extent.setSystemInfo("operationg system", "windos 10");

    }

    @Test
   public void TestOne(){
        ExtentTest etest= extent.createTest("TestOne");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        etest.info("navigated sucessfully");
        driver.get("https://www.youtube.com/watch?v=qfbZc1IEQNQ&t=2239s");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        etest.info("Test sucessfully complited");
        }
        @AfterMethod
    public void closer(){
        driver.close();
        extent.flush();
        }

}
