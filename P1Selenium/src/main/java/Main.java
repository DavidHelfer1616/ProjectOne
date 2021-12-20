import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Tools\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://localhost:7000");


        Thread.sleep(3000); //explicit amount of time related to animation
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("stinkydragon");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("p4ssw0rd");

        WebElement loginBtn = driver.findElement(By.id("loginbtn"));
        loginBtn.click();

        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("reimbursement"), 0));
        }catch(TimeoutException e){
            System.out.println("no reimbursements");
        }

        WebElement amount = driver.findElement(By.id("amount"));
        amount.sendKeys("420.69");

        WebElement desc = driver.findElement(By.id("desc"));
        desc.sendKeys("Japanese candy shaped like cat girls");

        WebElement type = driver.findElement(By.id("type"));
        type.click();
        WebElement option = driver.findElement(By.id("OTHER"));
        option.click();

        WebElement submitBtn = driver.findElement(By.id("submitBtn"));
        submitBtn.click();

        Thread.sleep(7000);
        driver.quit();
    }
}
