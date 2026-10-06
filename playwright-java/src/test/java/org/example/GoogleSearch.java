package org.example;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException{
        Playwright playwright = Playwright.create();
        //Platwrightを起動し初期化
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //Headless modeをfaiseにして画面を表示させる
        Page page = browser.newPage();
        //ブラウザ内に新しいタブを作成
        page.navigate("https://www.google.com/");
        //指定したGoogleのWebサイトにアクセス

        //このまま
        Locator searchBox = page.locator(".gLFyf");
        Thread.sleep(5000);
        searchBox.fill("Playwright");
        searchBox.press("Enter");
        //検索ボックスにPlaywrightを入力して検索をかける処理

        Thread.sleep(10000);
        //画面を10秒間待機する処理。指定していないとすぐブラウザーが閉じる。
        page.close();
        browser.close();
        playwright.close();
        //表示したタブ、ブラウザ、Playwrightの順番で処理を終了

    }
}
