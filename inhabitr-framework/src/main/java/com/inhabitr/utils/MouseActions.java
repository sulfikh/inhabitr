package com.inhabitr.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	private Actions actions;

    public MouseActions(WebDriver driver) {
        this.actions = new Actions(driver);
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void click(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }


}
