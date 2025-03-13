Feature: Place order for book

  Scenario Outline: Placing order for book is successful
    Given user is on home page
    When user selects cpr menu and selects books option
    And user selects the "<book>"
    And user clicks on add to cart button and clicks on view cart option
    And user selects "<state>" enters "<town>" , "<zipcode>" , clicks update and then clicks proceed to checkout button
    And user enters billing details like "<FirstName>","<LastName>","<CompanyName>","<StreetAddress>","<town>","<State>","<zipcode>","<phone>","<EmailAddress>" and clicks on continue button
    And user enters "<notes>" and clicks continue
    And enters credit card details like "<CardNumber>","<Expirydate>","<CardCode>"and clicks place order
    Then user verifies product information and logs out

    Examples: 
      | book               | town   | zipcode | FirstName  | LastName  | CompanyName | StreetAddress | State          | phone      | EmailAddress          | notes      | CardNumber          | Expirydate | CardCode |
      | Instructor Package | guntur |  522503 | Pravallika | Medisetty | wipro       | 22nd street   | Andhra Pradesh | 9676261596 | mpravallika@gmail.com | be careful | 4111 1111 1111 1111 | 02/27      |      123 |

  Scenario Outline: Placing order for book is failure
    Given user is on home page
    When user selects cpr menu and selects books option
    And user selects the "<book>"
    And user clicks on add to cart button and clicks on view cart option
    And user enters "<town>" , "<zipcode>" , clicks update and then clicks proceed to checkout button
    And user enters billing details like "<FirstName>","<LastName>","<CompanyName>","<StreetAddress>","<town>","<State>","<zipcode>","<phone>","<EmailAddress>" and clicks on continue button
    And user enters "<notes>" and clicks continue
    And enters credit card details like "<CardNumber>","<Expirydate>","<CardCode>"and clicks place order
    Then user verifies product information and logs out

    Examples: 
      | book               | town   | zipcode | FirstName  | LastName  | CompanyName | StreetAddress | State          | phone      | EmailAddress          | notes      | CardNumber          | Expirydate | CardCode |
      | Instructor Package | guntur |  522503 | Pravallika | Medisetty | wipro       | 22nd street   | Andhra Pradesh | 9676261596 | mpravallika@gmail.com | be careful | 4111 1111 1111 1111 | 02/27      |       12 |
