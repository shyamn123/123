import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Extends4 {
    WebDriver driver;
    ExtentReports extent;
    @BeforeMethod
    public void Pre(){
       String Report = System.getProperty("user.dir")+"\\report4.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(Report);
         extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tested By", "Shyam");
        extent.setSystemInfo("Guided by", "Arun Motori");

    }
    @Test
    public void TestOne() throws IOException {
        ExtentTest Etest = extent.createTest("TestOne");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Etest.info("Test started");
        driver.get("https://www.evernote.com/Home.action#n=5e1b793a-964c-485d-ab73-fff97cd6e988&s=s744&ses=4&sh=2&sds=5&");
        File Src3 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Src3, new File("D:\\New folder\\shyam\\WebScreenshot\\Extent.jpg"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        Etest.info("Test complited");
    }

    @AfterMethod
    public void Closer(){
        driver.close();
        extent.flush();

    }



}
