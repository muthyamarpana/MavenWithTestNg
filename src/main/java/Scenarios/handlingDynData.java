package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class handlingDynData {
WebDriver driver;
	
	@Test
	public void dynData() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		driver.manage().window().maximize();
		String str=driver.findElement(By.id("ebcaptchatext")).getText();
		System.out.println(str);
		String str1=str.substring(8, 9);
		String str2=str.substring(12,13);
		Integer res=Integer.valueOf(str1)+Integer.valueOf(str2);
		System.out.println(res);
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
		Thread.sleep(5000);
		driver.quit();
}
}
