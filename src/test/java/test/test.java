package example;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	
	public static void main(String[] args) throws InterruptedException {
		
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","E:\\hoc\\file cai dat\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		//get data
        String baseUrl = allObjects.getProperty("url");
        String username = allObjects.getProperty("username");
        String password = allObjects.getProperty("password");
        
        //run
        driver.get(baseUrl);
        
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")).click();
        
        
        String expectedTitle = "Sign in to GitHub · GitHub";
        String actualTitle = driver.getTitle();

        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field")));
        
        WebElement usernameElement = driver.findElement(By.id("login_field"));
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[3]/main/div/div[4]/form/div/input[12]")).click();
        
        String expectedTitleLogin = "GitHub";
        String actualTitleLogin = driver.getTitle();
        
        if (actualTitleLogin.contentEquals(expectedTitleLogin)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        //close google
        driver.close();
       
    }
}
