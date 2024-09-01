package selemium.learn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {


	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://amazon.in");

		
		/* **********************************************************************************************
		 * This is an example of Explicit wait where driver will wait until amazon logo will display. 
		 * if displayed then it will move to next step or show timeout.
		 * **********************************************************************************************
		 */
		WebElement Amazonlogo= driver.findElement(By.id("nav-logo-sprites"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Amazonlogo));
		
		WebElement strStartherelink=driver.findElement(By.xpath("//a[@class=\"sign-in-tooltip-link\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(strStartherelink));
		
		/*
		 ************************************************************************************************** 
		 */
		
		String strSearch="Apple iphone 15";
		WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(strSearch);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		WebElement searchedText=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span[1]"));
		String strSearchedText=searchedText.getText();
		System.out.println("Search results displayed as:"+strSearchedText + " for "+strSearch);
		System.out.println("Exact number of serach results displayed as: "+strSearchedText.substring(8,20));
		
		
		driver.quit();

	}

}
