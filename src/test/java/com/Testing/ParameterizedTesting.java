package com.Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTesting {
	
	WebDriver driver;
	@BeforeClass
	@Parameters({"url","email","password"})
	public void setup(String url, String email, String password) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("_r_1_")).sendKeys(email);
		driver.findElement(By.id("_r_2_")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(3000);
		
		}
	
	@Test
	public void testLogin() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://test.fieldforceconnect.com/dashboard");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}