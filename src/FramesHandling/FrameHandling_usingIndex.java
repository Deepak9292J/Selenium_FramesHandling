package FramesHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling_usingIndex {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.xpath("//iframe")).size()); //Get the number of frames on the webpage
		driver.switchTo().frame(0); //Switch to the frame depending upon the index of the frame.
		WebElement source = driver.findElement(By.id("draggable")); // Source of drag and drop operation
		WebElement destination = driver.findElement(By.id("droppable")); //target of drag and drop operation
		
		Actions a = new Actions(driver); 
		a.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
	}

}