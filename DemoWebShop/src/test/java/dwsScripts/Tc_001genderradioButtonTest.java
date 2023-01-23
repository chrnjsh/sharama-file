package dwsScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_Library.ReadData;
import pom_Repo.RegisterPage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.CommonPage;
public class Tc_001genderradioButtonTest{
	public WebDriver driver;
	public CommonPage comp;
	public WebDriverWait explicitWait;
	@Parameters("browsername")
	@Test(groups = "launch")
	public void launchBrowser(@Optional("chrome") String bname) {
		String[][] data=ReadData.readDataExcel("testData",2);
		String url=ReadData.fromProperty("Url");
		// Launching empty browser and maximize the window
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
			Reporter.log("pass the valid data",true);
		Reporter.log("Empty browser is launched",true);
		driver.manage().window().maximize();
		Reporter.log("browser is maximized",true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		comp=new CommonPage(driver);
		explicitWait=new WebDriverWait(driver, 15);
 
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url,"Home page is not displayed");
		
		CommonPage cp = new CommonPage(driver);
		cp.getRegisterLink().click();
	
	RegisterPage rp = new RegisterPage(driver);
	String gender = ReadData.fromProperty("Gender");
	if (gender.equalsIgnoreCase("female")) {
		rp.getFemalegenderRadioButton().click();
		Assert.assertEquals(rp.getFemalegenderRadioButton().isSelected(), true, "Female radio button is not selected");
		Reporter.log("Female radio button is selected successfully",true);
	}
	else if(gender.equalsIgnoreCase("male")) {
		rp.getMalegenderRadioButton().click();
		Assert.assertEquals(rp.getMalegenderRadioButton().isSelected(), true, "male radio button is not selected");
		Reporter.log("Male radio button is selected successfully",true);
	}
	else {
		Reporter.log("invalid gender");
	}
		
	}
	

}

