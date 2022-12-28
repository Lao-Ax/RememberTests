package com.alex.jobs.innotech.selenide;

import com.alex.jobs.innotech.selenide.pages.YaPage;
import org.testng.annotations.Test;

/*
    To build a beautified Allure report, please:
        1) install allure commandline tool
        2) run from the project root: `allure serve`
 */
public class InnoTechSelenideTest {

    @Test() // Add invocationCount = N, if you want to run it N times. Uncomment @AfterMethod as well.
    public void yaMeteoCityTest() {
        new YaPage()
                .open()
                .setValueForSearchInput("gismeteo")
                .clickSearchBtn()
                .clickFirstTip()
                .sendkeysToSearchInput("Королев МО")
                .waitForFistTipWithText("Королев")
                .clickFirstTip()
                .checkCityTitleTextIs("Погода в Королеве сегодня");
    }

    // Uncomment if you use @Test(invocationCount)
//    @AfterMethod
//    public void after() {
//        Selenide.closeWebDriver();
//    }
}
