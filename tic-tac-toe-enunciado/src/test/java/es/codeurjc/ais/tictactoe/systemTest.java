package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class systemTest {
	
	protected WebDriver driver1;
	protected WebDriver driver2;
	
	@BeforeClass
    public static void setupClass() {
		System.setProperty("webdriver.chrome.driver","src/test/java/es/codeurjc/ais/tictactoe/chromedriver.exe");
		WebApp.start();
	}
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}

	@Before
	public void setupTest() {
		driver1 = new ChromeDriver();
		driver2 = new ChromeDriver();
	}

	@After
	public void teardown() {
		if (driver1 != null) {
			driver1.quit();
		}
		if (driver2 != null) {
			driver2.quit();
		}
    }


	@Test
	public void winTest() throws InterruptedException {
		//Gana jugador 1
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
		driver1.findElement(By.id("nickname")).sendKeys("pepe");
		driver1.findElement(By.id("startBtn")).click();
		driver2.findElement(By.id("nickname")).sendKeys("manolo");
		driver2.findElement(By.id("startBtn")).click();
		driver1.findElement(By.id("cell-0")).click();
		driver2.findElement(By.id("cell-3")).click();
		driver1.findElement(By.id("cell-1")).click();
		driver2.findElement(By.id("cell-4")).click();
		driver1.findElement(By.id("cell-2")).click();
		String mensaje="pepe wins! manolo looses.";
		String alert1=driver1.switchTo().alert().getText();
		String alert2=driver2.switchTo().alert().getText();
		assertEquals(mensaje,alert1);
		assertEquals(mensaje,alert2);
			
	}
	
	@Test
	public void loseTest() throws InterruptedException {
		//Gana jugador 2
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
		driver1.findElement(By.id("nickname")).sendKeys("pepe");
		driver1.findElement(By.id("startBtn")).click();
		driver2.findElement(By.id("nickname")).sendKeys("manolo");
		driver2.findElement(By.id("startBtn")).click();
		driver1.findElement(By.id("cell-0")).click();
		driver2.findElement(By.id("cell-3")).click();
		driver1.findElement(By.id("cell-1")).click();
		driver2.findElement(By.id("cell-4")).click();
		driver1.findElement(By.id("cell-8")).click();
		driver2.findElement(By.id("cell-5")).click();		
		String mensaje="manolo wins! pepe looses.";
		String alert1=driver1.switchTo().alert().getText();
		String alert2=driver2.switchTo().alert().getText();
		assertEquals(mensaje,alert1);
		assertEquals(mensaje,alert2);
	}
	
	@Test
	public void drawTest() {
		//Empate
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
		driver1.findElement(By.id("nickname")).sendKeys("pepe");
		driver1.findElement(By.id("startBtn")).click();
		driver2.findElement(By.id("nickname")).sendKeys("manolo");
		driver2.findElement(By.id("startBtn")).click();
		driver1.findElement(By.id("cell-0")).click();
		driver2.findElement(By.id("cell-2")).click();
		driver1.findElement(By.id("cell-1")).click();
		driver2.findElement(By.id("cell-3")).click();
		driver1.findElement(By.id("cell-5")).click();
		driver2.findElement(By.id("cell-4")).click();
		driver1.findElement(By.id("cell-6")).click();
		driver2.findElement(By.id("cell-7")).click();
		driver1.findElement(By.id("cell-8")).click();
		String mensaje="Draw!";
		String alert1=driver1.switchTo().alert().getText();
		String alert2=driver2.switchTo().alert().getText();
		assertEquals(mensaje,alert1);
		assertEquals(mensaje,alert2);
	}

}
