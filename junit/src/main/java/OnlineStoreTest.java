import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineStoreTest extends BaseTest{

    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public void OpenPage(){
        driver.get(cfg.url_online_store());
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select2-selection__arrow")));
    }

    public void SelectMark(){

        WebElement zubrCheckBox = (new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#producer_16"))));
        zubrCheckBox.click();

        WebElement makitaCheckBox = (new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#producer_473"))));
        makitaCheckBox.click();

        driver.findElement(By.cssSelector("#filterSubm")).click();
    }

    public void Order(){
        WebElement orderArrowDown = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select2-selection__arrow")));
        orderArrowDown.click();

        driver.findElement(By.cssSelector(".select2-results > ul > li:nth-child(1)")).click();
    }

    public void FindFirstItem(String ItemMark){



        //driver.findElement(By.cssSelector(".new-item-list-name:contains('ЗУБР')"));
        driver.findElement(By.xpath("//div[@class='new-item-list-name']//*[text()[contains(.,'" + ItemMark + "')]]/ancestor::li/div/div[contains(@class, 'new-item-list-compare')]/span"))
                .click();

    }

    public void CloseModalCompare(){

        WebElement elemen = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#modal-content-placeholder")));



        driver.findElement(By.xpath("//*[text()[contains(., 'Продолжить просмотр')]]")).click(); //text()[contains(.,'" + ItemMark + "')]

        WebElement elemeyn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select2-selection__arrow")));
    }

}
