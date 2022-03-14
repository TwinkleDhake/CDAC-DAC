package Selenium.Flipkart;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FlipkartLogin {
	ChromeDriver driver;
	String url = "http://www.flipkart.com";

	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Boss\\Desktop\\CDAC PG-DAC\\Module8(SoftwareDevelopmentMethodologies)\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		
		//driver = new EdgeDriver();

		//driver.manage().window().maximize();

		//driver.manage().deleteAllCookies();

		//driver.manage().timeouts();

		driver.get("http://www.flipkart.com");

	}
	
	//public void navigate() throws InterruptedException
	//{
	//	driver.navigate().to("https://www.flipkart.com/");
		
	//}

	public void LoginFlipkart() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//input[@type='text']")).sendKeys("twinkledhake@gmail.com");
		
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//input[@type='password']")).sendKeys("twinkledhake@1234567890");
		
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//button[@type='submit']")).click();
		
		driver.findElement(By.id("identierId")).sendKeys("twinkledhake@gmail.com");
		
		driver.findElement(By.className("_2IX_2- _3mctLh VJZDxU")).sendKeys("9876543210");
        Thread.sleep(1000);
        driver.close();
	}
	
	public static void main( String[] args ) throws InterruptedException
    {
      App ob = new App();
      ob.launchBrowser();
      ob.navigate();
      ob.LoginFlipkart();
    	
    }
	
	public void closeBrowser() {
		driver.quit();
	}
}

/*public class FlipkartLogin 
{
		ChromeDriver driver;
		public void launchBrowser() 
		{
			System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\Boss\\Desktop\\CDAC PG-DAC\\Module8(SoftwareDevelopmentMethodologies)\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			 
		}
		public void navigate() throws InterruptedException
		{
			driver.navigate().to("https://www.flipkart.com/");
			
			
		}
		public void LoginFlipkart() throws InterruptedException
		{
		
	         driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//input[@type='text']")).sendKeys("1234567890");
			
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//input[@type='password']")).sendKeys("Twinkle@0987654321");
			
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//button[@type='submit']")).click();
			Thread.sleep(1000);
			
			driver.close();
			
		}
		
		public static void main(String[] args) throws InterruptedException 
		{
			FlipkartLogin ob = new FlipkartLogin();
			ob.launchBrowser();
			ob.navigate();
			ob.LoginFlipkart();
			
		}
	
}*/