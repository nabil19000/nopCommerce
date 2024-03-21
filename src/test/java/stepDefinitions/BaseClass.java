package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;


import java.util.Properties;
import java.util.Random;
 ;

public class BaseClass {

    public LoginPage lp;
    public WebDriver driver ;
    public AddCustomerPage addcust;
    public static Logger logger;
    public Properties configProp;
    public static String randomstring(){
        String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
       return generatedstring1;
    }
    public void selectdrpd(WebElement element, String visibletext){
        Select select = new Select(element);
        select.selectByVisibleText(visibletext);



    }
    public int generatedNumber(int uperbound){

        Random rdn = new Random();
        return rdn.nextInt(uperbound);
    }
}
