package org.example.testcase.pages;

import org.example.testcase.base.BasePage;
import com.microsoft.playwright.Page;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(Page page) {
        super(page);
    }

    public boolean isResultsFound() {
        return !page.content().contains("No results found.");
    }

}
