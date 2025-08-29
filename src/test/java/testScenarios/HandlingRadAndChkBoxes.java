package testScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingRadAndChkBoxes {

	WebDriver driver= null;
	@Test
	public void setRadBtnAndChkBox() throws InterruptedException
	{
		driver=new EdgeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement bmwRad=driver.findElement(By.id("bmwradio"));
		WebElement bmwChk=driver.findElement(By.id("bmwcheck"));
		WebElement benzChk=driver.findElement(By.id("benzcheck"));
		
		bmwRad.click();
		bmwChk.click();
		benzChk.click();
		
		//verify they are selected or not
		Assert.assertEquals(bmwRad.isSelected(), true);
		if(bmwRad.isSelected())
		{
			System.out.println("Radio button is selected..");
		}
		else
		{
			System.out.println("Radio button is not selected..");
		}
		if(bmwChk.isSelected() && benzChk.isSelected())
		{
			System.out.println("BMW and Benj checkboxes are selected...");
		}
		else
		{
			System.out.println("BMW and Benj checkboxes are not selected...");
			
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
