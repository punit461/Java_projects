package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {
	static WebDriver driver;	
	static FileInputStream file;
	static Properties prop;
	
	public void openbrowser() throws Exception {
			System.setProperty("webdriver.chrome.driver","E:\\Project_Zoho\\JARS\\chromedriver.exe" ); 
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			file = new FileInputStream("F:\\punit_java_eclipse\\CRMframeworkZoho\\src\\objectrepository\\objectrepository.properties");
			prop = new Properties();
			prop.load(file);
			
		}
	public void navigate(String data) {
		driver.get(data);
		}
	public void input(String data, String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(data);
		
		
	}
	public void click(String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		
		
	}




}
