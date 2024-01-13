package PageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilLayer.Wait;

public class PimPage extends BaseClass {

	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[2]")
	WebElement pim;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addElement;

	@FindBy(name="firstName")
	WebElement firstname;

	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	@FindBy(xpath="//a[text()='Employee List']")
	WebElement empList;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement empId;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement employeeId;

	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchButton;

	@FindBy(xpath="//div[text()='Id']/following::input[1]")
	WebElement checkElement;

	@FindBy(xpath="//button[text()=' Delete Selected ']")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	WebElement confirmDelete;

	@FindBy(xpath="//span[text()='No Records Found']")
	WebElement noRecords;
	
	public PimPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickPim()
	{
		Wait.click(pim);
	}
	public void addData(String fname,String lname)
	{
		Wait.click(addElement);
		Wait.sendKeys(firstname,fname);
		Wait.sendKeys(lastname,lname);
		Wait.click(saveButton);
	}

	public String captureEidandClickOnEmployeeList()
	{
		String eid=Wait.getAttribute(empId,"value");
		Wait.click(empList);
		return eid;
	}
	public void  clickOnSearch(String eid)
	{
		Wait.sendKeys(employeeId,eid);		
		Wait.click(searchButton);
		
			
	}
	public void checkElementAndDelete() throws InterruptedException
	{
		Thread.sleep(5000);
//		Wait.click(checkElement);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",checkElement);
		Wait.click(deleteButton);
		Wait.click(confirmDelete);
	}
	public String checkDeleteOrNot(String eid)
	{

		Wait.sendKeys(employeeId,eid);		
		Wait.click(searchButton);
		String msg=Wait.getText(noRecords);
		return msg;
				
		
	}
	




}	
	
	
	

