package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.BaseClass;

public class AddCustomerPage extends BaseClass {
  String gender;
    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }
    By searchButton = By.xpath("//button[@id='search-customers']");
    By linkCustomer_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By linkCustomer_menuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
    By btnAddNew = By.xpath("//a[@class='btn btn-primary']");
    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");
    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");
    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");
    By Dob = By.xpath("//input[@id='DateOfBirth']");
    By txtCompanyName = By.xpath("//input[@id='Company']");
    By rdTaxExempt = By.xpath("//*[@id=\"IsTaxExempt\"]");
    By txtNewsLetter = By.xpath("\"listbox\"");
    By txtCustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
    By drmngOfVendor = By.xpath("//select[@id='VendorId']");
    By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
    By btnSave = By.xpath("//button[@name='save']");
    By delete = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");
    By guestlist = By.xpath("//li[normalize-space()='Guests']");
    By Registred = By.xpath("//li[normalize-space()='Registered']");
    By Vendors = By.xpath("//li[contains(text(),'Vendors')]");
    By Administrators = By.xpath("//li[@id='7f16bb6e-dc01-4f42-bb02-9305ae6e0a2e']");
    // Action methods
    public String getPageTitle(){
       return ldriver.getTitle();
    }

    public void clickOnCustomersMenu(){
        ldriver.findElement(linkCustomer_menu).click();
    }
    public void clickOnCustomersMenuItem(){
        ldriver.findElement(linkCustomer_menuItem).click();
    }
    public void clickOnAddNew(){
        ldriver.findElement(btnAddNew).click();
    }
    public void enterEmail(String email){
        ldriver.findElement(txtEmail).sendKeys(email);
    }
    public void enterPassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);


    }
    public void enterFirstName(String fname){
        ldriver.findElement(txtFirstName).sendKeys(fname);

    }
    public void enterLastName(String lname){
         ldriver.findElement(txtLastName).sendKeys(lname);

    }
    public void clickOnMaleGender (String gender){
        ldriver.findElement(rdMaleGender).click();
        if(gender.equals("Male")){
            ldriver.findElement(rdMaleGender).click();
        }else if (gender.equals("Female")){
            ldriver.findElement(rdFemaleGender).click();
        }else{
            ldriver.findElement(rdMaleGender).click();
        }

    }

    public void selectDOB(String dob){
        ldriver.findElement(Dob).sendKeys(dob);


    }
    public void EnterCompanyname(String company){
        ldriver.findElement(txtCompanyName).sendKeys(company);


    }
    public void clickOnTax(){
        ldriver.findElement(rdTaxExempt).click();


    }
    public void enterNewsLetter(String newsletter){
        ldriver.findElement(txtNewsLetter).sendKeys(newsletter);


    }
    public void enterCustomerroles(String role){
        ldriver.findElement(delete).click();
        ldriver.findElement(txtCustomerRoles).click();
        ldriver.findElement(Registred).click();



    }
    public void delete(){
        ldriver.findElement(delete).click();
    }
    public void selectManageOfVendor(String value){
        Select drp = new Select(ldriver.findElement(drmngOfVendor));
        drp.selectByVisibleText(value);


    }
    public void clickOnSearchButton(){
          ldriver.findElement(searchButton).click();
    }
    public void enterAdminComment(String admincomment){
            ldriver.findElement(txtAdminComment).sendKeys(admincomment);
    }
    public void clickOnSaveButton() throws InterruptedException {
        ldriver.findElement(btnSave).click();
        Thread.sleep(2000);


    }
}
