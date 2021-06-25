package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitCountProject {
	WebDriver driver; 

    By divProject = By.cssSelector("div[class=\"width-full text-bold\"]");
    List<WebElement> countProjects;
    
    public GitCountProject(WebDriver driver) {
    	this.driver = driver;
    }
    
    //set userName
    private void setCountProjects() {
    	this.countProjects = driver.findElements(divProject);
    }
    
    public int count(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(divProject));
    	this.setCountProjects();
    	return this.countProjects.size();
    }
}
