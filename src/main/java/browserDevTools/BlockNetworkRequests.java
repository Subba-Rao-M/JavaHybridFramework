package browserDevTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;

import com.google.common.collect.ImmutableList;


public class BlockNetworkRequests {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * block the network requests to make application execution faster
		 * block only content which is not required and application functionality is not impacted
		 */
		

			ChromeDriver driver = new ChromeDriver();
			DevTools devTools= driver.getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
			devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
			long startTime =System.currentTimeMillis();
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.findElement(By.linkText("Browse Products")).click();
			driver.findElement(By.linkText("Selenium")).click();
			driver.findElement(By.cssSelector(".add-to-cart")).click();
			String text = driver.findElement(By.cssSelector("p")).getText();
			System.out.println(text);
			long endTime =System.currentTimeMillis();
			long execTime= endTime-startTime;
			System.out.println(execTime);

	}

}
