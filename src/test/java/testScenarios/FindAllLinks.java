package testScenarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FindAllLinks {
	WebDriver driver;
	String src="C:\\selenium_new\\Sel@7AM(IST)\\links.txt";
	FileReader fr;
	BufferedReader br;
	ArrayList<String> all_exp_links=new ArrayList<String>();
	@Test
	public void fetchAndDispLinkUrlAndNames() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String li=null;
		while((li=br.readLine())!=null)
		{
			all_exp_links.add(li);
		}

		driver=new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("total links="+allLinks.size());
		int i=0;
		for(WebElement link:allLinks)
		{
			System.out.println(all_exp_links.get(i));
			System.out.println(link.getAttribute("href"));
			System.out.println("=======================================");
			//System.out.println(link.getAttribute("href"));
			if(all_exp_links.get(i).equals(link.getAttribute("href")))
			{
				System.out.println("Link Matched...");
			}
			else
			{
				System.out.println("Link not Matched..");
			}
			i++;
		}

		br.close();
		//Enter Email and password
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		WebElement em=driver.findElement(By.id("email"));
		WebElement pwd=driver.findElement(By.id("pass"));
		WebElement btn=driver.findElement(By.name("login"));
		sendKeys(driver, em, 10, "Jack");
		sendKeys(driver, pwd, 10, "Jack123");
		driver.quit();
	}
	//generic methods
	public static void sendKeys(WebDriver driver,WebElement element,int timeout,String value)
	{
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void clickOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Button is Clickable...");
	}
}
