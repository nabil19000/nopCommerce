package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver = rdriver ;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(id = "Email")@CacheLookup WebElement txtEmail;
    @FindBy(id = "Password")@CacheLookup WebElement txtPassword;
    @FindBy(xpath = "//button[@type='submit']")@CacheLookup WebElement btnLogin;
    @FindBy(xpath = "//a[normalize-space()='Logout']")@CacheLookup WebElement linkLogout;

    public void setUserName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd) {
         txtPassword.clear();
         txtPassword.sendKeys(pwd);
    }

    public void setBtnLogin() {
          btnLogin.click();
    }

    public void setLinkLogout() {
          linkLogout.click();
    }
}
