@Register
Feature: Account Creation

  Scenario Outline: Account creation is sucessful
    Given user is on the home page
    When user clicks on register link and user navigates to register page
    And user selects "<gender>", enters personal details  "<firstName>","<lastName>","<email>","<password>" and "<confirmPassword>" and clicks on register button
    Then user verifies Your registration completed message and clicks on continue button
    Then user logs out

    #Examples: 
     # | gender | firstName | lastName | email                       | password     | confirmPassword |
      #| male   | tathagata | Nayak    | nayak887412190902@gmail.com | Selenium@123 | Selenium@123    |

  Scenario Outline: Account creation is failed
    Given user is on the home page
    When user clicks on register link and user navigates to register page
    And user selects "<gender>", enters personal details  "<firstName>","<lastName>","<email>","<password>" and "<confirmPassword>" and clicks on register button
    Then user validates the error message The specified email already exists

    #Examples: 
     # | gender | firstName  | lastName | email                   | password     | confirmPassword |
      #| female | subhanjana | Banerjee | nayak88741212@gmail.com | Selenium@123 | Selenium@123    |
