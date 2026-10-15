package org.example.testcase.pages;

import org.example.testcase.locators.MainPageLocators;
import com.microsoft.playwright.Locator;
import org.example.testcase.base.BasePage;
import com.microsoft.playwright.Page;

public class MainPage extends BasePage{
    public MainPage(Page page) {
        super(page);
    }
    
    public void inputTextBox() throws InterruptedException {
        Locator locator = page.locator(MainPageLocators.TEXT_BOX);
        Thread.sleep(5000);
        locator.fill("unit test");


    }

    public void clickGoButton() throws InterruptedException {
        Locator locator = page.locator(MainPageLocators.GO_BUTTON);
        Thread.sleep(5000);
        locator.click();

    }

}
