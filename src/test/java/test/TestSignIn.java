package test;

import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import config.ReadObject;
import pages.GitCountProject;
import pages.GitLogin;

public class TestSignIn {
	
	String baseUrl = null;
    String username = null;
    String password = null;
    WebDriver driver;    
    GitCountProject pageCountProject;
    GitLogin pageLogin;
    WebDriverWait wait;
    
	@BeforeTest
	public void load() {
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","E:\\hoc\\file cai dat\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
    	
		//get data
        baseUrl = allObjects.getProperty("url");
        username = allObjects.getProperty("username");
        password = allObjects.getProperty("password");
        
        //run
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, 2);
	}
	
	@Test(priority = 0)
	public void signIn() {		
        
        pageLogin = new GitLogin(driver);
        pageLogin.loginGit(username, password, wait);
        String expectedTitleLogin = "GitHub";
        String actualTitleLogin = pageLogin.getTitle();
        
        Assert.assertEquals(actualTitleLogin, expectedTitleLogin);
               
    }
	
	@Test(priority = 1)
	public void countProjects() {
		pageCountProject = new GitCountProject(driver);
		int expectedCount = pageCountProject.count(wait);
        Assert.assertTrue(expectedCount > 0);
	}
	
	@AfterTest
	public void closeBrowser() {
		//close google
        driver.quit();
	}
}
