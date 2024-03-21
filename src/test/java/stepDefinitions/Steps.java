package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.apache.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;


import java.io.IOException;

import java.util.concurrent.TimeUnit;



import static org.junit.Assert.assertTrue;

public class Steps extends BaseClass{

   @Before
    public void setup() throws IOException {

        logger = Logger.getLogger("nopCommerce");
        System.setProperty("webdriver.chrome.driver","/Users/nabil/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        logger.info("***********************Launching browser**********************");

    }
    String firstName ="bonjour";
    String lastName ="bonsoir";
    AddCustomerPage addCustomerPage;


    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {

        lp = new LoginPage(driver);
    }
    @When("user opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("*************** Opening URL *********************");
         driver.get(url);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
          lp.setUserName(email);
          lp.setPassword(password);
    }
    @When("click on Login")
    public void click_on_login() {
         lp.setBtnLogin();
    }
    @Then("page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.fail();
        }else{
            Assert.assertEquals(title , driver.getTitle());
        }
    }
    @When("user click on log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.setLinkLogout();
        Thread.sleep(3000);

    }
    @Then("user can view Dashboard")
    public void user_can_view_dashboard() {
        addCustomerPage = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCustomerPage.getPageTitle());
    }

    @When("user click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(2000);
       addCustomerPage.clickOnCustomersMenu();
    }

    @When("click on customers menu item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(2000);
        addCustomerPage.clickOnCustomersMenuItem();
    }

    @When("click on add new button")
    public void click_on_add_new_button() throws InterruptedException {
        Thread.sleep(2000);
        addCustomerPage.clickOnAddNew();
    }

    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCustomerPage.getPageTitle());

    }

    @When("user enter customer info")
    public void user_enter_customer_info() {
       String email = randomstring()+"@gmail.com";
       addCustomerPage.enterEmail(email);
       addCustomerPage.enterPassword("test123");
       addCustomerPage.enterCustomerroles("Registered");
       addCustomerPage.enterFirstName(firstName );
       addCustomerPage.enterLastName(lastName );
       addCustomerPage.clickOnMaleGender("Male");
       addCustomerPage.selectDOB("7/05/1985");
       addCustomerPage.EnterCompanyname("dell");
       addCustomerPage.clickOnTax();
       addCustomerPage.selectManageOfVendor("Vendor 1");
       addCustomerPage.enterAdminComment("hello");
    }

    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
         addCustomerPage.clickOnSaveButton();
    }

    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));

        String expected = firstName+" "+lastName;

        String beforePath = "//tbody/tr[";
        String afterPath = "]/td[3]";

        for(int i = 1 ; i<=10 ; i++) {
            String actualName = driver.findElement(By.xpath(beforePath+i+afterPath)).getText();

            assertTrue(actualName.contains(expected));
            if(actualName.contains(expected)) {
                System.out.println(actualName);
                break;
            }
        }
    }







    @Then("close browser")
    public void close_browser() {

         driver.quit();
    }


}
