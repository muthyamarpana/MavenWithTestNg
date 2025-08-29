package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWindows {

	WebDriver driver;
	@Test
	public void switchWin()
	{
		driver=new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWinIds=driver.getWindowHandles();  // fetch all window ids opend by the driver object 
		System.out.println("Total Windows="+allWinIds.size());
		Iterator<String> itr=allWinIds.iterator();
		String win1=itr.next();
		String win2=itr.next();
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Window1--"+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2--"+driver.getTitle());
		boolean chkSignin=driver.findElement(By.xpath("//*[@id=\"tnb-login-btn\"]/span[1]")).isEnabled();
		System.out.println(chkSignin);
		Assert.assertEquals(chkSignin, true);
		driver.quit();
		
		
		//driver.quit();
	}
}
