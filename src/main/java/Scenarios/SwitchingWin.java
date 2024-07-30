package Scenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWin {

	WebDriver driver;
	
	@Test
	public void switchWin()
	{
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWins=driver.getWindowHandles();
		System.out.println("total windows="+allWins.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWins.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println(win1);
		System.out.println(win2);
		driver.switchTo().window(win2);
		System.out.println("title window2="+driver.getTitle());
		driver.quit();
	}
}
