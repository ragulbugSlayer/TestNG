package testng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {

	WebDriver driver;
	@BeforeTest
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\raagu\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/reg/");
	}

	@Test(priority=1)
	public void VerifyFirstname() 
	{
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Raagul");
	}

	@Test(priority=2)
	public void VerifySurname() {
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kanna");
	}

	@Test(priority=3)
	public void VerifyMail() {
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("raagulkanna1998@gmail.com");
	}

	@Test(priority=4)
	public void VerifyConfrom() {
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("raagulkanna1998@gmail.com");
	}

	@Test(priority=5)
	public void VerifyPassword() {
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("raagul@123");
	}

	@Test(priority=6)
	public void VerifyDay() {
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select s = new Select(day);
		s.selectByVisibleText("9");
	}

	@Test(priority=7)
	public void VerifyMonth() {
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select m = new Select(month);
		m.selectByIndex(4);
	}

	@Test(priority=8)
	public void VerifyYear() {
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select y = new Select(year);
		y.selectByVisibleText("1998");
	}

	@Test(priority=9)
	public void VerifyGender() {
		driver.findElement(By.xpath("//input[@value='2']")).click();
	}

	@Test(priority=10)
	public void VerifyText() {
		WebElement t = driver.findElement(By.xpath("//div[@class='_52lr _9bq0 fsm fwn fcg']"));
		String Text=t.getText();
		System.out.println(Text);
	}

	@Test(priority=11)
	public void VerifyScroll() throws InterruptedException {
		JavascriptExecutor a = (JavascriptExecutor)driver;
		a.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		a.executeScript("window.scrollBy(0,-3000)");
	}

	@Test(priority=12)
	public void VerifyScreenshot() throws IOException {

		File src =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.openqa.selenium.io.FileHandler.copy(src, new File("C:\\Users\\raagu\\Desktop\\ScreenShot\\S1.jpg"));
	}	


	@AfterTest
	public void Teardown() {
		//		driver.close();
	}
}
