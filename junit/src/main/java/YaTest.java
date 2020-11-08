import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YaTest extends BaseTest{

    public void GoToMarket(){
        driver.get("https://market.yandex.ru/");
        logger.info("Выполнен переход на Маркет");
    }

    public void GoToPhones(){

        WebElement electronicsLink = (new WebDriverWait(driver, 4))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Электроника']")));
        electronicsLink.click();
        logger.info("Выполнен переход в раздел Электроника");

        WebElement phonesLink = (new WebDriverWait(driver, 4))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Смартфоны']")));
        phonesLink.click();
        logger.info("Выполнен переход в раздел Смартфоны");

    }

    public void SelectMark(String[] mark){

        for (String item : mark ){

            WebElement markCheckBox = (new WebDriverWait(driver, 4))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='Производитель " + item + "']/parent::label")));
            markCheckBox.click();
            logger.info("Выбран производитель " + item);

        }
    }

    public void Sort(){
        driver.findElement(By.xpath("//*[text()='по цене']")).click();
        logger.info("Выполнена сортировка по возрастанию цены");
    }

    public void AddToCompare(String[] mark){

        for (String item : mark){
            Actions builder = new Actions(driver);
            builder.moveToElement(driver.findElement(By.xpath("//article//span[text()[contains(., '" + item + "')]]")))
                    .build()
                    .perform();

            WebElement addToCompareElement = (new WebDriverWait(driver, 4))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//article//span[text()[contains(., '" + item + "')]]/ancestor::article/div[2]/div[1]")));
            addToCompareElement.click();
            logger.info("Первый телефон " + item + " добавлен к сравнению");

            WebElement popup = (new WebDriverWait(driver, 4))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-apiary-widget-name='@market/PopupInformer']/div")));

            Assert.assertEquals(true, popup.isDisplayed());
            logger.info("Всплывающее окно открылось");

        }

    }

    public void GoToCompare(){
        driver.get("https://market.yandex.ru/compare");
        logger.info("Выполнен переход в раздел сравнения");
    }

    public void CheckNumberOfCompareItems(String[] mark) {
        driver.findElement(By.xpath("//div[@data-apiary-widget-name='@MarketNode/CompareContent']/div/div[2]"));

        List<WebElement> listOfItems = driver.findElements(By.xpath("//a[text()[contains(., '"+ mark[0] +"')]]/parent::div/parent::div/div"));

        Assert.assertEquals(mark.length, listOfItems.size());

        logger.info("Количество элементов в списке сравнения верное (" + mark.length + ")");

    }

}
