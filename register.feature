Feature: Register user

  Scenario Outline: Registering user successfully
    Given User is on the Home page
    And User navigates to the My Account Tab and clicks it
    And User clicks on register
    Then User is taken to the register page
    When User enter username "<UserName>" , EmailId "<EmailId>", Password "<Password>" and clicks Register button
    Then User is navigated to dashboard Page
    Then verifies the registration

    Examples: 
      | UserName      | EmailId                   | Password    |
      | UserTathagata | UserTathagata12@gmail.com | Tathagata12 |

  Scenario Outline: Registering user Failure
    Given User is on the Home page
    And User navigates to the My Account Tab and clicks it
    And User clicks on register
    Then User is taken to the register page
    When User enter username "<UserName>" , EmailId "<EmailId>", Password "<Password>" and clicks Register button
    Then User remains on the registration page
    And User sees an error message

    Examples: 
      | UserName        | EmailId                  | Password    |
      | UserSubhanajana | UserSubhanjana@gmail.com | Tathagata12 |
