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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--silent");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        logger.info("Драйвер поднят");
    }

    @Test
    public void checkTitle(){
        driver.get(cfg.url());
        logger.info("Выполнен переход на " + cfg.url());

        Assert.assertNotNull(driver.getTitle());
        logger.info("Title страницы проверен");
    }

    @After
    public void setDown(){
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }

}
