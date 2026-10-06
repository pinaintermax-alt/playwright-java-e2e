package org.example;
 
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
 
public class PythonOrgSearch {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();
        // Python.orgサイトにアクセス
        page.navigate("https://www.python.org/");
 
        // 検索ボックスに入力（セレクターをPython.org用に変更）
        Locator searchBox = page.locator("#id-search-field");
        Thread.sleep(5000);
        searchBox.fill("Python 3.10");
        searchBox.press("Enter");
 
        // 検索結果の最初のリンクをクリック
        Locator pythonLink = page.locator("a:has-text('Python 3.10')").first();
        Thread.sleep(5000);
        pythonLink.click();
 
        Thread.sleep(10000);
        page.close();
        browser.close();
        playwright.close();
    }
}