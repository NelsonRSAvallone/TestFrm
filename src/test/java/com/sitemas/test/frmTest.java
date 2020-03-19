package com.sitemas.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class frmTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(); //Instancia del ChromeDriver
		driver.manage().window().maximize(); // para que la instancia se inicie maximizada
		driver.get("http://www.frm.utn.edu.ar/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	@Test
	public void test() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			
			driver.findElement(By.xpath("//*[@id=\'ja-rightcol\']/div[3]/div/a/img")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("30536289");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("MEIJI123");
			driver.findElement(By.xpath("//input[@class='habilitado']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit' and @class=\'habilitado\' and @value=\'Legajo: 46045 Alumno\']")).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
