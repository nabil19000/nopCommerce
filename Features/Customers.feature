Feature: Customers
  @regression
  Scenario: Add New Customer
    Given user launch chrome browser
    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then user can view Dashboard
    When user click on customers Menu
    And click on customers menu item
    And click on add new button
    Then user can view add new customer page
    When  user enter customer info
    When click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close browser
     @smoke
  Scenario: Search Custumer By EmailId
    Given user launch chrome browser
    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then user can view Dashboard
    When user click on customers Menu
    And click on customers menu item

    And close browser