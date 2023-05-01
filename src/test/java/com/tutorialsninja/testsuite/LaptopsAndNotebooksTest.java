package com.tutorialsninja.testsuite;

import com.tutorialsninja.page.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {

    LaptopsAndNotebooksPage page = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        page.mouseHoverOnLaptopAndNotebooksTabAndClick();
        page.clickOnShowAllLaptopsAndNotebooks();
        page.selectSortByHighToLow();
        // Verify the Product price will arrange in High to Low order.
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        page.mouseHoverOnLaptopAndNotebooksTabAndClick();
        page.clickOnShowAllLaptopsAndNotebooks();
        page.selectSortByHighToLow();
        //2.4 Select Product “MacBook
        page.clickOnMacBook();
        // 2.5 Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = page.verifyTextMacBook();
        Assert.assertEquals(actualText, expectedText, "Error found");
        // 2.6 Click on ‘Add To Cart’ button
        page.clickOnAddToCart();
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!"
        String expectedMessage = "Success: You have added MacBook to your shopping cart!";
        String actualMessage = page.getAddedMacBookText();
        boolean message = actualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);
        // 2.8 Click on link “shopping cart” display into success message
        page.clickOnShoppingCart();
        // 2.9 Verify the text "Shopping Cart"
        String expectedCart = "Shopping Cart  (0.00kg)";
        String actualCart = page.verifyTextShoppingCart();
        Assert.assertEquals(actualCart, expectedCart, "Error found");
        // 2.10 Verify the Product name "MacBook"
        String expectedName = "MacBook";
        String actualName = page.verifyProductNameMacBook();
        Assert.assertEquals(actualName, expectedName, "Error found");
        // 2.11 Change Quantity "2"
        page.changeQuantity();
        // 2.12 Click on “Update” Tab
        page.clickOnUpdateTab();
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedMessage1 = "Success: You have modified your shopping cart!";
        String actualMessage1 = page.verifyModifiedYourShoppingCart();
        boolean message1 = actualMessage1.contains(expectedMessage1.trim());
        Assert.assertTrue(message1);
        // 2.14 Verify the Total £737.45
        String expectedTotal = "$1,204.00";
        String actualTotal = page.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Error found");
        // 2.15 Click on “Checkout” button
        page.clickOnCheckoutButton();
        // 2.16 Verify the text “Checkout”
        String expectedText1 = "Checkout";
        String actualText1 = page.verifyTheTextCheckout();
        Assert.assertEquals(actualText1, expectedText1, "Error found");
        // 2.17 Verify the Text “New Customer”
        String expectedText2 = "New Customer";
        String actualText2 = page.verifyTheTextNewCustomer();
        Assert.assertEquals(actualText2, expectedText2, "Error found");
        // 2.18 Click on “Guest Checkout” radio button
        page.clickOnGuestCheckOutRadioButton();
        // 2.19 Click on “Continue” tab
        page.clickOnContinueTab();
        // 2.20 Fill the mandatory fields
        page.enterFirstName();
        page.enterLastName();
        page.enterEmailId();
        page.enterTelephone();
        page.enterAddress();
        page.enterCity();
        page.enterPostCode();
        page.selectCountryFromDropDown();
        page.selectRegionFromDropDown();
        // 2.21 Click on “Continue” Button
        page.clickOnContinueButton();
        // 2.22 Add Comments About your order into text area
        page.addCommentsAboutYourOrder();
        // 2.23 Check the Terms & Conditions check box
        page.clickOnTermsAndConditionsCheckBox();
        // 2.24 Click on “Continue” button
        page.clickOnContinue();
        // 2.25 Verify the message “Warning: Payment method required!"
        String expectedMessage2 = "Warning: Payment method required!";
        String actualMessage2 = page.verifyMessagePaymentMethodRequired();
        boolean message2 = actualMessage2.contains(expectedMessage2.trim());
        Assert.assertTrue(message2);

    }
}
