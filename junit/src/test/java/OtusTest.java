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

public class OtusTest extends OnlineStoreTest{

    @Test
    public void test() throws InterruptedException {

        OpenPage();

        SelectMark();

        Order();

        Thread.sleep(5000);

        FindFirstItem("ЗУБР");

        CloseModalCompare();

        Thread.sleep(5000);

        FindFirstItem("MAKITA");

        CloseModalCompare();

        Thread.sleep(5000);
    }

}
