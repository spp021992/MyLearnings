package selemium.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://amazon.in");

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
