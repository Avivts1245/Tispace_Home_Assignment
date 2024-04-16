package Tispace_HW.EX1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class EX1 {

	public static void TimeOut(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		
// 1. Open YouTube website
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");

//2. Search 
		WebElement searchRow = driver.findElement(By.cssSelector("input#search"));
		searchRow.sendKeys("I Will Survive - Alien song");

		WebElement searchButton = driver.findElement(By.cssSelector("[role='search'] > [aria-label] yt-icon div"));
		searchButton.click();
		TimeOut(driver, 1);
		
		
//3. Click on filters		
		WebElement filter = driver
				.findElement(By.cssSelector("[aria-label='מסנני חיפוש'] .yt-spec-touch-feedback-shape__fill"));
		filter.click();
		TimeOut(driver, 2);

//4. Select Type
		driver.findElement(By.cssSelector("[title='חיפוש של סרטון'] [dir]")).click();
		TimeOut(driver, 2);
	
//5+6. Sort by view count
//		filter.click();
//		driver.findElement(By.cssSelector("[title='מיון לפי מספר צפיות'] [dir]")).click();
//		TimeOut(driver,2);
		
//7. find video by url	
		WebElement video = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=ybXrrTX3LuI']"));
		
//8. Fetch channel name
		WebElement channelName = video.findElement(By.xpath(
				"/html//div[@id='channel-info']/ytd-channel-name[@id='channel-name']//yt-formatted-string[@id='text']/a[@href='/@nikki7993']"));
		System.out.println("Channel Name: " + channelName.getText());

// 9. Play the video
		driver.findElement(By.cssSelector("[title='I Will Survive - Alien Song'] [dir]")).click();

// 10. Skip Ads
		List<WebElement> skipButtons = driver.findElements(By.xpath("//button[@class='ytp-ad-skip-button']"));
		for (WebElement skipButton : skipButtons) {
			skipButton.click();
		}
		TimeOut(driver, 6);

// 11. Click the 'Show more' button
		WebElement showMoreButton = driver.findElement(By.xpath("/html//tp-yt-paper-button[@id='expand']"));
		showMoreButton.click();

// 12. Fetch the artist's name and print it
		WebElement artistName = driver
				.findElement(By.cssSelector(" div#items .yt-video-attribute-view-model__subtitle"));
		System.out.println("Artist Name: " + artistName.getText());

		
	}
}
