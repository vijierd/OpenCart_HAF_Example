package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver d;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters("browser")
	public void setup(String br) throws IOException
	{
		logger = LogManager.getLogger(this.getClass());	
		
		FileReader file	= new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		String url = p.getProperty("appURL");
		
		if (br.equalsIgnoreCase("chrome")) 
		{
			d=new ChromeDriver();
		}else if (br.equalsIgnoreCase("edge")) 
		{
			d=new EdgeDriver();
		}else if (br.equalsIgnoreCase("firefox")) 
		{
			d=new FirefoxDriver();
		}
		
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get(url);
		d.manage().window().maximize();
		logger.info("URL is Opened...");
	}

	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		d.quit();
		logger.info("Browser closed...");
	}
	
	
	public String randomAlphabetic()
	{	
		return RandomStringUtils.randomAlphabetic(5);	
	}
	public String randomNumeric()
	{
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String randomAlphanumeric()
	{
		return RandomStringUtils.randomAlphanumeric(6);	
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) d;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
