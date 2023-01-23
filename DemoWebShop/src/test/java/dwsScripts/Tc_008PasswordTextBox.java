

package dwsScripts;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import dataProvider.ToReadDataFromExcelToDemoWebShop;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.CommonPage;
import pom_Repo.ReadData;
import pom_Repo.RegisterPage;

public class Tc_008PasswordTextBox {
	public WebDriver driver;
	public CommonPage comp;
	public WebDriverWait explicitWait;
	@Parameters("browsername")
	@Test(groups = "launch")
	public void launchBrowser(@Optional("chrome") String bname) {
		String url = ReadData.fromProperty("Url");
		// Launching empty browser and maximize the window
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			Reporter.log("pass the valid data", true);
		Reporter.log("Empty browser is launched", true);
		driver.manage().window().maximize();
		Reporter.log("browser is maximized", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		comp = new CommonPage(driver);
		explicitWait = new WebDriverWait(driver, 15);

		// navigate to the application
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(), url, "Home page is not displayed");

		CommonPage cp = new CommonPage(driver);
		cp.getRegisterLink().click();
		Reporter.log("navigated to register page",true);
		RegisterPage rp = new RegisterPage(driver);
		rp.getPasswordTextbox().click();
		Assert.assertEquals(rp.getPasswordTextbox().isDisplayed(),true);
		Reporter.log("click action on text box",true);
		rp.getPasswordTextbox().sendKeys("charan@35");
		//String firstNameTextBox = ReadData.fromProperty("firstname").toString();
		//Assert.assertEquals(,true,"data is not matched");
		Reporter.log("data successfully entered in text box",true);
	}

}



