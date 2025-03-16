Feature: place order

  Scenario Outline: Placing order is successful
    Given user is on home page
    When user clicks on login link
    And user enters "<email>" and "<password>" and click login button
    And user navigates to Computers menu and selects "<item>" from the list and clicks
    And user selects the "<product>"
    And user selects the "<processor>","<ram>","<hdd>","<software>" and clicks on add to cart button
    And user clicks on the shopping cart link
    And user selects "<country>","<zipcode>" , clicks on terms and conditions checkbox and clicks on checkout button
    And user enters Billing address "<firstName>","<lastname>" ,"<email>" ,"<Company>","<country>","<state>","<city>","<address1>","<Zipcode>","<PhoneNo>" and clicks on continue button
    And user verifies default address is selected and clicks on continue button
    And user selects the "<shippingType>" and clicks on continue button
    And user selects the "<paymentType>" and clicks on continue button
    And user verifies cod selected by default and clicks on continue button
    And user verifies the product information clicks on confirm button
    Then user validates the order and clicks on continue button
    Then user Logs out

    Examples: 
      | email                         | password     | item     | product | processor | ram                          | hdd                          | software                     | country | zipcode | firstName | lastname | Company | city | address1 | PhoneNo    | shippingType     | paymentType     |
      | medisettypravallika@gmail.com | Selenium@123 | Desktops |       1 |         3 | product_attribute_72_6_19_54 | product_attribute_72_3_20_58 | product_attribute_72_8_30_94 | India   |  522503 | user1     | abc      | wipro   | hyd  | 7-143    | 1234567890 | shippingoption_1 | paymentmethod_0 |

  Scenario Outline: Placing order is failed
    Given user is on home page
    When user clicks on login link
    And user enters "<email>" and "<password>" and click login button
    And user navigates to Computers menu and selects "<item>" from the list and clicks
    And user selects the "<product>"
    And user selects the "<processor>","<ram>","<hdd>","<software>" and clicks on add to cart button
    And user clicks on the shopping cart link
    And user selects "<country>","<zipcode>" , clicks on terms and conditions checkbox and clicks on checkout button
    And user enters Billing address "<firstName>","<lastname>" ,"<email>" ,"<Company>","<country>","<state>","<city>","<address1>","<Zipcode>","<PhoneNo>" and clicks on continue button
    And user verifies default address is selected and clicks on continue button
    And user selects the "<shippingType>" and clicks on continue button
    And user selects the "<paymentType>" and clicks on continue button
    And user selects "<creditCardType>", enters "<cardHolderName>","<cardNumber>","<expiryMonth>","<expiryYear>" and "<cardCode>" and clicks on continue button
    Then user validates the error message Wrong card code is displayed

    Examples: 
      | email                         | password     | item     | product | processor | ram                          | hdd                          | software                     | country | zipcode | firstName | lastname | Company | city | address1 | PhoneNo    | shippingType     | paymentType     | creditCardType | cardHolderName | cardNumber          | expiryMonth | expiryYear | cardCode |
      | medisettypravallika@gmail.com | Selenium@123 | Desktops |       1 |         3 | product_attribute_72_6_19_54 | product_attribute_72_3_20_58 | product_attribute_72_8_30_94 | India   |  522503 | user1     | abc      | wipro   | hyd  | 7-143    | 1234567890 | shippingoption_1 | paymentmethod_2 | Visa           | user1          | 4111 1111 1111 1111 |          03 |       2028 |       12 |
