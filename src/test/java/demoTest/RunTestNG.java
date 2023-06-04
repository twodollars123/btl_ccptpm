package demoTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunTestNG {
    public static void main(String[] args){

        WebDriver driver;
        WebDriverManager.chromedriver().setup(); //goij phieen banr browser
        driver = new ChromeDriver(); //khởi tạo driver
        driver.get("http://localhost:3000/");
    }
}
