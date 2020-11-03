import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class OtusTest {

    protected WebDriver driver;
    private Logger logger = LogManager.getLogger(OtusTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory(DriverFactory.Browser.chrome.toString().toLowerCase());
        try {
            WebDriverManager.chromedriver().setup();
            driver = driverFactory.createDriver();
        } catch (Exception e){

        }
    }

//    @Test
//    public void checkTitle(){
//        driver.get(cfg.url());
//        logger.info("Выполнен переход на " + cfg.url());
//
//        Assert.assertNotNull(driver.getTitle());
//        logger.info("Title страницы проверен");
//    }





    @After
    public void setDown(){
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }

}
