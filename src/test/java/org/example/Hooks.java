package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class Hooks extends BrowserManager {


    public void setUp() {
        openBrowser();
    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "screenshot");
            } catch (NullPointerException e){
                System.out.println("No website");
            }
        }

    }


}