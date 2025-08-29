package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverActions {

	WebDriver driver;
	@Test(priority=1)
	public void dragAndDrop()
	{
		driver=new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		//action.dragAndDrop(drag, drop).perform();
		action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
		driver.quit();
	}
	
	@Test(priority=2)
	public void datePicker()
	{
		Integer exp_yr=2026;
		String exp_month="August";
		driver=new EdgeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		while(true)
		{
		String act_yr=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText(); //year
		String act_month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText(); //month
		System.out.println("Actual Date--"+act_month+"\t"+act_yr);
		if(act_yr.equals(String.valueOf(exp_yr)) && act_month.equals(exp_month))
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click(); //20th date is clicked
			break;
		}
		if(exp_yr<Integer.valueOf(act_yr))  //2026<2025
		{
			//clicks on the previous button
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
		}
		else
		{
			//clicks on Next button
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
		}
		
		}
		driver.quit();
	}
}
