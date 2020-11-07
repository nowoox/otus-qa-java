import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class YaTest extends BaseTest{

    public void GoToPhones(){
        driver.get("https://market.yandex.ru/");

        WebElement electronicsLink = (new WebDriverWait(driver, 4))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Электроника']")));
        electronicsLink.click();

        //driver.findElement(By.xpath("//span[text()='Электроника']/parent::a")).click();

        WebElement phonesLink = (new WebDriverWait(driver, 4))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Смартфоны']")));
        phonesLink.click();

        //driver.findElement(By.xpath("//*[text()='Смартфоны']")).click();

    }

    public void SelectMark(String[] mark){

        for (String item : mark ){
            driver.findElement(By.xpath("//*[@name='Производитель " + item + "']/parent::label")).click();
        }
    }

    public void Sort(){
        driver.findElement(By.xpath("//*[text()='по цене']")).click();
    }

    public void AddToCompare(String[] mark){

        for (String item : mark){
            Actions builder = new Actions(driver);
            builder.moveToElement(driver.findElement(By.xpath("//article//span[text()[contains(., '" + item + "')]]")))
                    .build()
                    .perform();

            WebElement addToCompareElement = (new WebDriverWait(driver, 4))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//article//span[text()[contains(., 'Samsung')]]/ancestor::article/div[2]/div[1]")));
            addToCompareElement.click();

            WebElement popup = (new WebDriverWait(driver, 4))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-apiary-widget-name='@market/PopupInformer']/div")));

            Assert.assertEquals(true, popup.isDisplayed());

            driver.findElement(By.cssSelector("button._3rzhojG-YQ")).click();
        }

    }

}
//<div tabindex="0" class="_2IwbFpEZn7 _3YfPcv73Wj _1rDffWmsUY" aria-label='Добавить&nbsp;к&nbsp;сравнению' data-tid="dc1632ca 1badb8e1 cbc788aa" data-tid-prop="dc1632ca 1badb8e1 cbc788aa"><div class="_1CXljk9rtd" data-tid="64a067c1"></div></div>