package com.claro.ecommerce.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BasePage {

    private WebDriver driver;
    private static final String CONFIG_PROPERTIES = "./src/main/resources/config.properties";

    /**
     * To Define.
     */
    public BasePage() {
        this.initializeDriver();
    }

    /**
     * To Define.
     */
    @SuppressWarnings("ConstantConditions")
    private void initializeDriver() {
        System.setProperty(getProperty("DRIVER_FIREFOX_KEY"), getProperty("DRIVER_FIREFOX_VALUE"));
        this.setDriver(new FirefoxDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(getProperty("IMPLICITLY_WAIT_SECONDS")), TimeUnit.SECONDS);
    }

    /**
     * To Define.
     */
    protected final void openPage() {
        driver.get(getProperty("BASE_URL"));
    }

    /**
     * To Define.
     */
    @SuppressWarnings("ConstantConditions")
    private void sleepFor() {
        try {
            sleep(Integer.parseInt(getProperty("WAIT_MILLISECONDS")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * To Define.
     *
     * @param driver To Define.
     */
    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * To Define.
     */
    protected final WebDriver getDriver() {
        return driver;
    }

    /**
     * To Define.
     */
    protected final void closePage() {
        this.sleepFor();
        this.getDriver().quit();
    }

    /**
     * This method allows get the properties of the config file
     *
     * @param property To Define.
     * @return a property To Define.
     */
    private static String getProperty(String property) {
        Properties config = new Properties();
        FileInputStream file;
        try {
            file = new FileInputStream(CONFIG_PROPERTIES);
            config.load(file);
            return config.getProperty(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
