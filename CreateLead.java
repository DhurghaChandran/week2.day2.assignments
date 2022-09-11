package week2.day1;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		String path=System.getProperty("webdriver.chrome.driver");
		System.out.println(path);
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create "
				+ "Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dhurgha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Chandran");
		WebElement eleAt=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd=new Select(eleAt);
		dd.selectByValue("LEAD_COLDCALL");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Computer Science");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("I am a Lead for TestLeaf");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ddchandran@gmail.com");
		WebElement eleState=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ddState=new Select(eleState);
		ddState.selectByVisibleText("New York");
	
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(5000);
		System.out.println("The title is " + driver.getTitle());
		driver.close();
	}

}
