package xola;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	public String baseUrl = "https://sandbox-checkout.xola.com/index.html#seller/58e235b107876cdd1f8b45e2/experiences/58e2371107876cdd1f8b45e5";  
//	String driverPath = "\\Users\\veronicagonsalves\\downloads\\chromedriver.exe";  
	public WebDriver driver ;   
	@Test  (priority=1)           

	public void test() {      
	driver = new ChromeDriver();  
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
	driver.manage().window().maximize();  
	driver.get(baseUrl);  
	// get the current URL of the page  
	String URL= driver.getCurrentUrl();  
	System.out.print(URL);  
	//get the title of the page  
	String title = driver.getTitle();                  
	System.out.println(title);  
	String pageTitle=driver.findElement(By.xpath("//h2[text()='Booking Details']")).getText();
	Assert.assertEquals("BOOKING DETAILS", pageTitle);
	
	}   
	@Test
	(priority=1,dependsOnMethods="test")
	public void loginFunctionality()
	{
		driver.findElement(By.xpath("//input[@type='radio' and @value='private']")).click();
		driver.findElement(By.xpath("//span[text()='Children ']//preceding::button[@class='btn btn-default spin-up']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'under 5 years')]//preceding::button[@class='btn btn-default spin-up'][1]")).click();
		driver.findElement(By.xpath("//a[text()='22']")).click();
		driver.findElement(By.xpath("//input[@name='customerName']")).sendKeys("Veronica");
		driver.findElement(By.xpath("//input[@name='customerEmail']")).sendKeys("Veronica@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("0987654321");
		driver.findElement(By.xpath("//div[contains(text(),'Add Ons')]//following::button[@class='btn btn-default spin-up'][1]")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
	}
	
	@AfterTest  
	public void afterTest() {  
	//driver.quit();  
	System.out.println("after test");  
	}         
	}  


