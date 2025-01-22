package rsUdemyCourse;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_28_InvokingMultipleWindows_Demo_1 {

	public static void main(String[] args) throws IOException {
		/**
		 *	Introduced in selenium 4
		 * Invoking window is different from opening new window using switch windows
		 * 
		 */
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//Switching Window

		driver.switchTo().newWindow(WindowType.WINDOW); //type can be window or tab
		
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowId = it.next();
		String childWindow =it.next();

		driver.switchTo().window(childWindow); //Open the url in new window or tab and get the first coursename form UI
		driver.get("https://rahulshettyacademy.com/"); 
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

		driver.switchTo().window(parentWindowId); //Switch back to parent window and copy the course name to name field
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);

		//Take the screenthot of name field for above copied text

		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

		//Get Height & Width of name text field as per UI requirement definition to verify if defined

		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());

		driver.quit();

	}

}
