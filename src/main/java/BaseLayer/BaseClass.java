package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	protected static WebDriver driver;
	protected static Properties prop;
	
	public BaseClass()
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\configLayer\\config.properties"));
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}



	public static void initialization(String browsername)
	{
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\AllDrivers\\chromedriver.exe");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firfox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("headless"))
		{
			ChromeOptions chromOptions=new ChromeOptions();
			chromOptions.addArguments("--headless");
			driver=new ChromeDriver(chromOptions);
		}
		else if(browsername.equalsIgnoreCase("incognito"))
		{
			ChromeOptions chromOptions=new ChromeOptions();
			chromOptions.addArguments("--incognito");
			driver=new ChromeDriver(chromOptions);
			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String url=prop.getProperty("url");		
		driver.get(url);
			

	
	}

}
