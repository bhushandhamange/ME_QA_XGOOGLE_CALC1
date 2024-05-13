package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//input[@value='Google Search']/../../..//textarea")).sendKeys("calculator");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();

        if (driver.findElement(By.xpath("//table[@class='HOoTuc']")).isDisplayed() && 
            driver.findElement(By.xpath("//table[@class='ElumCf']")).isDisplayed() ){
                System.out.println("Google Calculator loaded");
            } else {
                System.out.println("Google Calculator not loaded ");
            }

        if(driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText().equals("0")){
            System.out.println("Initial Display shows zero(0)");
        } else {
            System.out.println("Initial Display doesn't show zero(0)");
        }

        System.out.println("end Test case: testCase01");
    }


    public void testCase02(){
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//input[@value='Google Search']/../../..//textarea")).sendKeys("calculator");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();

        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='7']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='+']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='5']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='=']")).click();

        if (driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText().equals("12")){
            System.out.println("Addition passed");
        } else {
            System.out.println("Addition failed");
        }

        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='1']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='5']")).click();
        driver.findElement(By.xpath("(//table[@class='ElumCf']//tr//td//div)[32]")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='8']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='=']")).click();

        if (driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText().equals("7")){
            System.out.println("Subtraction passed");
        } else {
            System.out.println("Subtaction failed");
        }

        System.out.println("end Test case: testCase02");
    }

    public void testCase03(){
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//input[@value='Google Search']/../../..//textarea")).sendKeys("calculator");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();

        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='1']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='0']")).click();
        driver.findElement(By.xpath("(//table[@class='ElumCf']//tr//td//div)[25]")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='3']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='=']")).click();


        if (driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText().equals("30")){
            System.out.println("Multiplication passed");
        } else {
            System.out.println("Multiplication failed");
        }

        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='AC']")).click();

        if (driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText().equals("0")){
            System.out.println("All Clear passed");
        } else {
            System.out.println("All Clear failed");
        }

        System.out.println("end Test case: testCase03");
    }

    public void testCase04(){
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.google.com");

        String currentURL = driver.getCurrentUrl();

        if(currentURL.contains("google")){
            System.out.println("Google Loads");
        } else {
            System.out.println("Google not loaded");
        }

        driver.findElement(By.xpath("//input[@value='Google Search']/../../..//textarea")).sendKeys("calculator");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();

        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='2']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='0']")).click();
        driver.findElement(By.xpath("(//table[@class='ElumCf']//tr//td//div)[16]")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='4']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//tr//td//div[text()='=']")).click();

        if (driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText().equals("5")){
            System.out.println("Division Passed");
        } else {
            System.out.println("Division Failed");
        }

        System.out.println("end Test case: testCase04");
    }


}
