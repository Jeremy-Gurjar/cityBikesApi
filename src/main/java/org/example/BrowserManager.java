package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserManager extends Utils {
    static LoadProp loadProp = new LoadProp();
    static String browserName = "chrome";
    //Opens preferred browser
    public static void openBrowser() {
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        } else {
            System.out.println("Your browser name is wrong or does not match : " + loadProp.getProperty("browser"));
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
    }

    //Closes browser
    public void closeBrowser() {

        driver.close();
    }

}