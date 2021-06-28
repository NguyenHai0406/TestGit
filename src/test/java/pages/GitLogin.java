package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitLogin {
	WebDriver driver; 

    By btnSignIn = By.cssSelector("a[class='HeaderMenu-link flex-shrink-0 no-underline']");

    By passwordGit = By.id("password");
    
    By usernameGit = By.id("login_field");

    By btnSubmit = By.cssSelector("input[class='btn btn-primary btn-block']");
    
    public GitLogin(WebDriver driver) {
    	this.driver = driver;
    }
    
    //set userName
    private void setUserName(String userName) {
    	driver.findElement(usernameGit).sendKeys(userName);
    }
    
    //set password
    private void setPassword(String password) {
    	driver.findElement(passwordGit).sendKeys(password);
    }
    
    //click submit
    private void clickSubmit() {
    	driver.findElement(btnSubmit).click();
    }
    
    private void clickLogin() {
    	driver.findElement(btnSignIn).click();
    }
    
    public String getTitle() {
    	return driver.getTitle();
    }
    public void loginGit(String userName, String password, WebDriverWait wait) {
    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignIn));
		this.clickLogin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameGit));
		
    	this.setUserName(userName);
    	this.setPassword(password);
    	this.clickSubmit();
    }
}
