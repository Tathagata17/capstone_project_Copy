Feature: place order

  Scenario Outline: Placing order is successful
    Given user is on home page
    When user clicks on login link
    And user enters email "<email>" and password "<password>" and click login button
    And user navigates to Computers menu and selects item "<item>" from the list and clicks
    And user selects the product "<product>"
    And user selects the processor "<processor>",RAM "<ram>",HDD "<hdd>",Software "<software>" and clicks on add to cart button
    And user clicks on the shopping cart link
    And user selects country "<country>",Zipcode "<Zipcode>" , clicks on terms and conditions checkbox and clicks on checkout button
    And user enters Billing address firstname "<firstName>",lastname "<lastname>" ,email "<email>" ,company "<Company>",country "<country>",city "<city>",address1 "<address1>",zipcode "<Zipcode>", Phone no "<PhoneNo>" and clicks on continue button
    And user verifies default address is selected and clicks on continue button
    And user selects the shippingType "<shippingType>" and clicks on continue button
    And user selects the PaymentType "<paymentType>" and clicks on continue button
    And user verifies cod selected by default and clicks on continue button
    And user verifies the product information clicks on confirm button
    Then user validates the order and clicks on continue button
    Then user Logs out

    Examples: 
      | email                         | password     | item     | product                       | processor       | ram            | hdd               | software                | country | Zipcode | firstName | lastname | Company | city | address1 | PhoneNo    | shippingType | paymentType    |
      | medisettypravallika@gmail.com | Selenium@123 | Desktops | Build your own cheap computer | Fast  [+100.00] | 8 GB  [+60.00] | 400 GB  [+100.00] | Office Suite  [+100.00] | India   |  522503 | user1     | abc      | wipro   | hyd  | 7-143    | 1234567890 | Next Day Air | CashOnDelivery |

  Scenario Outline: Placing order is failed
    Given user is on home page
    When user clicks on login link
    And user enters email "<email>" and password "<password>" and click login button
    And user navigates to Computers menu and selects item "<item>" from the list and clicks
    And user selects the product "<product>"
    And user selects the processor "<processor>",RAM "<ram>",HDD "<hdd>",Software "<software>" and clicks on add to cart button
    And user clicks on the shopping cart link
    And user selects country "<country>",Zipcode "<Zipcode>" , clicks on terms and conditions checkbox and clicks on checkout button
    And user enters Billing address firstname "<firstName>",lastname "<lastname>" ,email "<email>" ,company "<Company>",country "<country>",city "<city>",address1 "<address1>",zipcode "<Zipcode>", Phone no "<PhoneNo>" and clicks on continue button
    And user verifies default address is selected and clicks on continue button
    And user selects the shippingType "<shippingType>" and clicks on continue button
    And user selects the PaymentType "<paymentType>" and clicks on continue button
    And user selects credit card Type "<creditCardType>", enters card holder name "<cardHolderName>", card number "<cardNumber>",expiry month "<expiryMonth>",expiry year "<expiryYear>" and cvv "<cardCode>" and clicks on continue button
    Then user validates the error message Wrong card code is displayed

    Examples: 
      | email                    | password       | item     | product                       | processor       | ram            | hdd               | software                | country | Zipcode | firstName | lastname | Company | city    | address1 | PhoneNo    | shippingType | paymentType | creditCardType | cardHolderName | cardNumber       | expiryMonth | expiryYear | cardCode |
      | tathagata14n14@gmail.com | Mypassword@123 | Desktops | Build your own cheap computer | Fast  [+100.00] | 8 GB  [+60.00] | 400 GB  [+100.00] | Office Suite  [+100.00] | India   |  522503 | Tathagata | abc      | wipro   | kolkata | 7-147    | 1234567890 | Next Day Air | Credit Card | Visa           | user1          | 4111111111111111 |          03 |       2028 |       12 |
