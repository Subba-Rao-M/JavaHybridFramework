package rsUdemyCourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class TC_02_Locators_Demo_1_RestructuredCode {
	
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		String name = "subbaraw@gmail.com";

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Methods can be called using class name object or by making method static
		String password = getPassword(driver);

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(name);

		driver.findElement(By.name("inputPassword")).sendKeys(password);

		driver.findElement(By.className("signInBtn")).click();

		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		driver.close();
		System.out.println("End");
		}



		public static String getPassword(WebDriver driver) throws InterruptedException



		{

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String passwordText =driver.findElement(By.cssSelector("form p")).getText();

		//Please use temporary password 'rahulshettyacademy' to Login.
		// Split using '
		String[] passwordArray = passwordText.split("'");
		//0th index - Please use temporary password

		//1st index - rahulshettyacademy' to Login.

		// String[] passwordArray2 = passwordArray[1].split("'");

		// passwordArray2[0]

		//Again split using '
		String password = passwordArray[1].split("'")[0];
		
		//0th index - rahulshettyacademy

		//1st index - to Login.

		return password;
		}

}
