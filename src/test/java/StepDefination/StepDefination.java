package StepDefination;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import PageLayer.PimPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefination extends BaseClass {
	PimPage pim = new PimPage();
	String eid;

	@Given("user enter {string} browser and open login url")
	public void user_enter_browser_and_open_login_url(String browsername) {
		BaseClass.initialization(browsername);
	}

	@When("user enter valid credentials and click on login button")
	public void user_enter_valid_credentials_and_click_on_login_button() {
		LoginPage loginPage = new LoginPage();
		loginPage.loingFunctionlity("Admin", "admin123");

	}

	@Then("user validate title")
	public void user_validate_title() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Then("user validate url")
	public void user_validate_url() {
		String url = driver.getCurrentUrl();
		boolean b = url.contains("index");
		Assert.assertEquals(b, true);
	}

	@When("user click on pim link")
	public void user_click_on_pim_link() {
		pim.clickPim();
	}

	@When("user validate url by using url")
	public void user_validate_url_by_using_url(DataTable dataTable) throws InterruptedException {
		List<List<String>> list = dataTable.asLists();
		String val = list.get(0).get(0);
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		boolean b = url.contains(val);
		Assert.assertEquals(b, true);

	}

	@When("user click on addemployee link and enter {string} ,{string} and click on save button")
	public void user_click_on_addemployee_link_and_enter_and_click_on_save_button(String firstname, String lastname) {

		pim.addData(firstname, lastname);
	}

	@When("capture the employee id and click on Employee list")
	public void capture_the_employee_id_and_click_on_employee_list() throws InterruptedException {
		Thread.sleep(5000);
		eid = pim.captureEidandClickOnEmployeeList();
		Thread.sleep(5000);
	}

	@When("enter employee id in employee id and click on search button")
	public void enter_employee_id_in_employee_id_and_click_on_search_button() {
		pim.clickOnSearch(eid);
	}

	@When("select the search employee and click on delete")
	public void select_the_search_employee_and_click_on_delete() throws InterruptedException {
	
		pim.checkElementAndDelete();
		Thread.sleep(5000);
	}

	@When("validate user deleted or not")
	public void validate_user_deleted_or_not() {
		String msg = pim.checkDeleteOrNot(eid);
		Assert.assertEquals(msg, "No Records Found");
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			scenario.attach(f, "image/png", date + scenario.getName());
		} else {
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			scenario.attach(f, "image/png", date + scenario.getName());
		}

	}
}
