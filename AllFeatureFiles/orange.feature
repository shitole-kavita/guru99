Feature: Test Orange HRM Application

  Scenario: Test Browser Functionlity
    Given user enter "chrome" browser and open login url

  Scenario: Testing login functionlity
    When user enter valid credentials and click on login button
    Then user validate title
    And user validate url

  Scenario Outline: Pim Page Functionlity
    When user click on pim link
    And user validate url by using url
      | pim |
    And user click on addemployee link and enter "<firstname>" ,"<lastname>" and click on save button
    And capture the employee id and click on Employee list
    And enter employee id in employee id and click on search button
    And select the search employee and click on delete
    And validate user deleted or not

    Examples: 
      | firstname | lastname |
      | Anita     | Walke    |
      | Ravi      | Shinde   |
      | janhavi   | Walke    |
