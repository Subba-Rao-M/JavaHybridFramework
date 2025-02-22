package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//This is without using PageFactory
	WebDriver driver; //class variable
	//Constructor
	LoginPage(WebDriver driver){ //method variable received 
		this.driver = driver;
	}
	
	//Locators
	By txt_username_loc = By.xpath("//input[@placeholder ='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder ='Password']");
	By btn_login_loc = By.xpath("//button[@type='submit']");
	
	//Action Methods
	
	public void setUserName(String user) {
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login_loc).click();
	}

}
