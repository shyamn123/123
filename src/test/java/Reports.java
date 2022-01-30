import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Reports {
    WebDriver driver;
    ExtentReports extent;
    @BeforeMethod
    public void RPt(){
        String Report = System.getProperty("user.dir")+"\\report1.html";
        ExtentSparkReporter reporter =  new ExtentSparkReporter(Report);
        reporter.config().setReportName("ExtentReport");
        reporter.config().setDocumentTitle("FirstReport");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("operating system ", "windos 10");
        extent.setSystemInfo("Tested By ", "Shyam");
    }
    @Test
    public void REports(){
      ExtentTest etest =extent.createTest("REports started");
      etest.info("chrome browser stsrted");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       String path =  System.getProperty("user.dir");
        System.out.println(path);
        etest.info("chrome navigated to website");
        driver.get("https://mvnrepository.com/artifact/com.aventstack/extentreports/5.0.9");
    }
    @AfterTest
    public void closr(){
        driver.close();
        extent.flush();
    }
}
