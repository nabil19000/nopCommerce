Feature: Login

  Scenario: Successful Login WithValid Credentials
    Given user launch chrome browser
    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then page Title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then page Title should be "Your store. Login"
    And close browser

  Scenario Outline: Login Data Driven
    Given user launch chrome browser
    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And click on Login
    Then page Title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then page Title should be "Your store. Login"
    And close browser

    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin1@yourstore.com |admin123 |