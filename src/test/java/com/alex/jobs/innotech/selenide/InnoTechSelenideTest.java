package com.alex.jobs.innotech.selenide;

import com.alex.jobs.innotech.selenide.pages.YaPage;
import org.testng.annotations.Test;

public class InnoTechSelenideTest {

    @Test
    public void yaMeteoCityTest() {
        new YaPage()
                .open()
                .setValueForSearchInput("gismeteo")
                .clickSearchBtn()
                .clickFirstTip()
                .setValueForSearchInput("Королев МО")
                .clickFirstTip()
                .checkCityTitleText("Погода в Королеве сегодня");
    }
}
