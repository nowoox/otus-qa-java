import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    enum Browser {
        chrome,
        firefox
    }

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public DriverFactory(String browser){
        this.browser = browser;
    }

    public WebDriver createDriver(){

        switch (browser){

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--silent");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                driver.set(new ChromeDriver(options));
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;
        }
        return driver.get();
    }

}
