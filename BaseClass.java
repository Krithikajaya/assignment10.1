   package assignment10StaticParameter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public RemoteWebDriver driver;
	@Parameters({"driver","url","username","password"})
	@BeforeMethod
	public void precondition(String browser,String link, String uname, String pword) {
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();	
	}
	@AfterMethod
		public void postcondition() {
		driver.close();
		}
	

}
