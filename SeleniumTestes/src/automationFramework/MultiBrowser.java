package automationFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class MultiBrowser {
	
	public WebDriver driver;
	//Logger logger = Logger.getLogger(MultiBrowser.class);
	

  @Parameters("browser")

  @BeforeClass

  // Passing Browser parameter from TestNG xml

  public void beforeTest(String browser) {
	  
  // If the browser is Firefox, then do this

  if(browser.equalsIgnoreCase("chrome")) {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\rodrigo.silva\\Desktop\\driver_selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();

  // If browser is IE, then do this	  

  }else if (browser.equalsIgnoreCase("ie")) { 

	  // Here I am setting up the path for my IEDriver

	  System.setProperty("webdriver.ie.driver", "C:\\Users\\rodrigo.silva\\Desktop\\driver_selenium\\IEDriverServer.exe");

	  driver = new InternetExplorerDriver();

  } 

  // Doesn't the browser type, lauch the Website

  driver.get("http://www.store.demoqa.com"); 

  }

  // Once Before method is completed, Test method will start

  @Test public void login() throws InterruptedException {

	driver.findElement(By.xpath(".//*[@id='account']/a")).click();
   

    driver.findElement(By.id("log")).sendKeys("testuser_1");

    driver.findElement(By.id("pwd")).sendKeys("Test@123");

    driver.findElement(By.id("login")).click();
    
	}  

  @AfterClass public void afterTest() {

		driver.quit();
		
		

	}

}