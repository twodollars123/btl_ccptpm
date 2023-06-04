package demoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.nio.charset.Charset;
import java.util.Random;
public class testNG {
    WebDriver driver;



    public String randomAlphaNumeric() {
        int len = 6; // Độ dài của String random
        byte[] array = new byte[len];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }




    @Test(priority = 1)
    public void Test01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/");

        driver.quit();
    }

    @Test(priority = 2)
    public void Test02(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/");

        driver.quit();
    }

    @Test(priority = 3)
    public void Test03(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/");

        driver.quit();
    }

    @Test(priority = 4)
    public void Test04(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/");

        driver.quit();
    }

    @Test(priority = 5)
    public void Test05(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/loggin");

        WebElement username = driver.findElement(By.id("user__name"));
        username.clear();
        username.sendKeys("user001");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("123456789");


        WebElement btnLogin = driver.findElement(By.id("btn__login"));
        btnLogin.click();

        WebElement successToast = driver.findElement(By.className("Toastify__toast--success"));
        waitForElementToBeDisplayed(successToast);

        // Kiểm tra xem thông báo có hiển thị thành công hay không
        Assert.assertTrue(successToast.isDisplayed());



        driver.quit();
    }

    @Test(priority = 6)
    public void TestLoginFailure(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/loggin");

        WebElement username = driver.findElement(By.id("user__name"));
        username.clear();
        username.sendKeys("user001");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("12345678");


        WebElement btnLogin = driver.findElement(By.id("btn__login"));
        btnLogin.click();

        WebElement successToast = driver.findElement(By.className("Toastify__toast--error"));
        waitForElementToBeDisplayed(successToast);

        // Kiểm tra xem thông báo có hiển thị thành công hay không
        Assert.assertTrue(successToast.isDisplayed());



        driver.quit();
    }

    @Test(priority = 7)
    public void TestSignupSuccessful(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/signup");
        String ramdomString = randomAlphaNumeric();

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys(ramdomString);

        WebElement username = driver.findElement(By.id("user__name"));
        username.clear();
        username.sendKeys(ramdomString);


        WebElement password = driver.findElement(By.id("password"));
        password.clear();

        password.sendKeys(ramdomString);


        WebElement btnLogin = driver.findElement(By.id("btn__signup"));
        btnLogin.click();

        WebElement successToast = driver.findElement(By.className("Toastify__toast--success"));
        waitForElementToBeDisplayed(successToast);

        // Kiểm tra xem thông báo có hiển thị thành công hay không
        Assert.assertTrue(successToast.isDisplayed());



        driver.quit();
    }

    private void waitForElementToBeDisplayed(WebElement element) {
        int maxAttempts = 5;
        int attempts = 0;
        while (!element.isDisplayed() && attempts < maxAttempts) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }
}
