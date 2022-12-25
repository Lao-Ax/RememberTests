package com.alex.jobs.innotech.selenide;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class InnoTechSelenideTest {

    @Test
    public void example() {
        open("https://ya.ru/"); // TODO: Move to PO Ya
        $(By.xpath("//input[starts-with(@class, \"search\")]")).setValue("gismeteo");
        $("button[class^=\"search\"][type=\"submit\"]").click();
        $$("li[data-cid='0'] a").get(0).click();
        switchTo().window(1);  // TODO: Move to PO Gismeteo
        $("input[type]").sendKeys("Королев МО");
        $$("a.search-item").get(0).click();
        $("div.page-title").shouldHave(text("Погода в Королеве сегодня"));
    }
}
