package testNGconceptPKG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Googlepage {
	
	WebDriver driver;
  /*@Test
  public void f() {
  }*/
	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Stuff\\Automation software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=3,groups="title")
	public void googleTitleTest() {
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google","Title is not matched");
	}
	@Test(priority=2,groups="Logo")
	public void googleLogoTest() {
		boolean b=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(b);
		Assert.assertTrue(b);
	}
	@Test(priority=1,groups="Linktext")
	public void maillinkTest() {
		boolean gmaillinkTest=driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(gmaillinkTest);
	}
	@Test(groups="test")
	public void test1() {
		System.out.println("test1");
	}
	@Test(groups="test")
	public void test2() {
		System.out.println("test2");
	}
	@Test(groups="test")
	public void test3() {
		System.out.println("test3");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
