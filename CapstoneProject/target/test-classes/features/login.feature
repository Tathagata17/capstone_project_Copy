Feature: login User

  Scenario Outline: Login user successful
    Given User is on the Home page
    And User navigates to the My Account Tab and clicks it
    And User clicks on register
    Then User is taken to the login page
    When User enter username or Email  "<UserNameOrEmail>" , Password "<Password>" and clicks Login button
    Then User is navigated to dashboard Page
    Then verifies the Login

    Examples: 
      | EmailId                   | Password    |
      | UserTathagata12@gmail.com | Tathagata12 |

  Scenario Outline: Login user Failure
    Given User is on the Home page
    And User navigates to the My Account Tab and clicks it
    And User clicks on register
    Then User is taken to the login page
    When User enter username or Email  "<UserNameOrEmail>" , Password "<Password>" and clicks Login button
    Then User remains on the login page
    And User sees an error message

    Examples: 
      | EmailId                   | Password    |
      | UserSubhanajana@gmail.com | Tathagata10 |
