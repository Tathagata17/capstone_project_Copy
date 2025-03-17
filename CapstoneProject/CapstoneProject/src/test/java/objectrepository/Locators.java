package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	// locators for register page
	public static By gender = By.id("gender-female");
	public static By firstName = By.id("FirstName");
	public static By lastName = By.id("LastName");
	public static By email = By.id("Email");
	public static By password = By.id("Password");
	public static By confirmPassword = By.id("ConfirmPassword");
	public static By registerBtn = By.id("register-button");
	public static By registerCompletedTxt = By.xpath("//div[contains(text(),\"completed\")]");
	public static By registerContinueBtn = By.cssSelector(".register-continue-button");
	public static By gmailValidationTxt = By.xpath("//a[contains(text(),\".com\")]");
	public static By registerPageText = By.xpath("//h1[text()='Register']");
	public static By errorMsgForRegistration = By.xpath("//li[contains(text(),\"email already exists\")]");
	// locators for login page
	public static By loginBtn = By.cssSelector(".login-button");
	public static By logInTextInLoginPage = By.xpath("//h1[text()='Welcome, Please Sign In!']");
	// locators for home page
	public static By computer = By.xpath("(//a[@href='/computers'])[1]");
	public static By desktop = By.xpath("(//a[contains(text(),'Desktops')])[1]");
	public static By logoutlink = By.xpath("//a[text()='Log out']");
	public static By ResultText = By.tagName("h1");
	public static By logInLink = By.xpath("//a[text()='Log in']");
	public static By registerLink = By.xpath("//a[@href='/register']");

	// locators for select product page
	public static By SelectproductXpath = By.xpath("(//div[@class=\"product-item\"])[1]");
	public static By productNameInProductDetailPage = By
			.xpath("//h1[contains(text(),'Build your own cheap computer')]");

	// locators for product details page
	public static By processor = By.id("product_attribute_72_5_18_53");
	public static By ram = By.id("product_attribute_72_6_19_54");
	public static By hdd = By.id("product_attribute_72_3_20_57");
	public static By software = By.id("product_attribute_72_8_30_93");
	public static By addtocartbutton = By.id("add-to-cart-button-72");
	public static By message = By.xpath("//p[contains(text(),\"added to \")]");
	public static By shoppingcartbutton = By.id("topcartlink");
	public static By goToCartBtn = By.xpath("//input[@value=\"Go to cart\"]");
	public static By shoppingCartText = By.tagName("h1");
	// locators for shopping cart page
	public static By countryId = By.id("CountryId");
	public static By zipCode = By.id("ZipPostalCode");
	public static By estimateBtn = By.name("estimateshipping");
	public static By termsCheckBox = By.id("termsofservice");
	public static By checkOutBtn = By.id("checkout");
	// locators for billing address in checkout page
	public static By BillingAddressText = By.xpath("//h2[text()='Billing address']");
	public static By fNameInAddress = By.id("BillingNewAddress_FirstName");
	public static By lNameInAddress = By.id("BillingNewAddress_LastName");
	public static By emailInAddress = By.id("BillingNewAddress_Email");
	public static By companyInAddress = By.id("BillingNewAddress_Company");
	public static By countryInAddress = By.id("BillingNewAddress_CountryId");
	public static By cityInAddress = By.id("BillingNewAddress_City");
	public static By address1 = By.id("BillingNewAddress_Address1");
	public static By address2 = By.id("BillingNewAddress_Address2");
	public static By postalCode = By.id("BillingNewAddress_ZipPostalCode");
	public static By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	public static By continueBtnInAdress = By.cssSelector(".new-address-next-step-button");
	// locators for shipping address in checkout page
	public static By shippingdetail = By
			.xpath("//label[text()='Select a shipping address from your address book or enter a new address.']");
	public static By continueBtnInShipping = By.xpath("(//input[@title='Continue'])[2]");
	// locators for shipping Method in checkout page
	public static By radioButton = By.id("shippingoption_0");
	public static By shipingmethodText = By.xpath("//label[text()='Next Day Air (0.00)']");
	public static By continueBtnInShippingMethod = By.cssSelector(".shipping-method-next-step-button");
	// locators for payment method in checkout page
	public static By codRadioBtn = By.id("paymentmethod_0");
	public static By creditCardRadioBtn = By.id("paymentmethod_2");
	public static By continueBtnInpay = By.cssSelector(".payment-method-next-step-button");
	public static By paymentMethodTextTwo = By.xpath("//p[contains(text(), 'COD')]");
	public static By payemntMethodText = By.xpath("//label[text()='Credit Card']");
	// locators for payment information in checkout page
	public static By creditCardType = By.id("CreditCardType");
	public static By cardHolderName = By.id("CardholderName");
	public static By cardNumber = By.id("CardNumber");
	public static By expiryMonth = By.id("ExpireMonth");
	public static By expiryYear = By.id("ExpireYear");
	public static By cardCode = By.id("CardCode");
	public static By continueBtnInpayInfo = By.cssSelector(".payment-info-next-step-button");
	public static By ErrorCode = By.xpath("//li[text()='Wrong card code']");
	// locators for confirm order in checkout page
	public static By continueBtnInconfirm = By.cssSelector(".confirm-order-next-step-button");
	public static By confirmOrderSectionText = By.xpath("//th[contains(text(),'Product(s)')]");
	public static By PlaceOrderText = By.xpath("//strong[text()='Your order has been successfully processed!']");
	// locators for order placed page
	public static By continueBtnIncompleted = By.cssSelector(".order-completed-continue-button");

	public static By paymentSelector(String paymentType) {
		if (paymentType.equalsIgnoreCase("CashOnDelivery")) {
			return By.id("paymentmethod_0");
		}
		return By.id("paymentmethod_2");
	}

	public static By locatorSelectorForPayemntVerfication(String paymentType) {
		if (paymentType.equalsIgnoreCase("CashOnDelivery")) {

			return By.xpath("//p[contains(text(), 'COD')]");
		}
		return By.xpath("//label[text()='Select credit card']");
	}

}