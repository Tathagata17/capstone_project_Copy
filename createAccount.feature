Feature: create an account

  Scenario Outline: Account creation is suucessful
    Given user is on home page
    When user clicks on my account menu and clicks on register button
    And user enters "<username>", "<email address>" ,"<password>" and clicks register button
    Then user verifies the dashboard and logs out

    Examples: 
      | username | email address | password      |
      | abcd     | xyz@gmail.com | Selenium@1234 |

  Scenario Outline: Account creation is failure
    Given user is on home page
    When user clicks on my account menu and clicks on register button
    And user enters "<username>", "<email address>" ,"<password>" and clicks register button
    Then user verifies the dashboard and logs out

    Examples: 
      | username | email address | password |
      | abcd     | xyz@gmail.com |          |
