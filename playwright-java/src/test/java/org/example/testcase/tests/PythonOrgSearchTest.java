package org.example.testcase.tests;

import org.example.testcase.pages.MainPage;
import org.example.testcase.pages.SearchResultsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PythonOrgSearchTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.python.org/");

    }

    @Test
    public void testSearchPython() throws InterruptedException {
        MainPage mainPage = new MainPage(page);
        mainPage.inputTextBox();
        mainPage.clickGoButton();
        SearchResultsPage searchResultsPage = new SearchResultsPage(page);
        assertTrue(searchResultsPage.isResultsFound());
        
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        page.close();
        browser.close();
        playwright.close();
       
    }
}
