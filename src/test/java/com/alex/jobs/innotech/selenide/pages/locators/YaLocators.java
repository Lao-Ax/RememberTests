package com.alex.jobs.innotech.selenide.pages.locators;

import org.openqa.selenium.By;

// In the future it should implement iYaLocators interface
public class YaLocators {

    public static By searchInput(){
        return By.xpath("//input[starts-with(@class, \"search\")]");
    }

    public static By searchSubmitBtn(){
        return By.cssSelector("button[class^=\"search\"][type=\"submit\"]");
    }

    public static By searchTips(){
        return By.cssSelector("li[data-cid='0'] a");
    }

}
