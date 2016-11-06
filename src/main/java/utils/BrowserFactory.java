package utils;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory{


    public WebDriver getDriver(String name){

        WebDriver driver = null;

        if("FIREFOX".equalsIgnoreCase(name)){
            MarionetteDriverManager.getInstance().setup();
            driver= new FirefoxDriver();
        }
        else if("CHROME".equalsIgnoreCase(name)){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        else if("IE".equalsIgnoreCase(name)){
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();

        } else if ("EDGE".equalsIgnoreCase(name)) {
            EdgeDriverManager.getInstance().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("PLEASE WRITE THE CORRECT BROWSER NAME");
        }
        return driver;
    }}