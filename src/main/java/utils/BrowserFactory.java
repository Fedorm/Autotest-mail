package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.MarionetteDriverManager;

public class BrowserFactory {


	public WebDriver getDriver(String name) {


		switch (name) {
			case "firefox":
				MarionetteDriverManager.getInstance().setup();
				return new FirefoxDriver();
			case "chrome":
				ChromeDriverManager.getInstance().setup();
				return new ChromeDriver();
			case "ie":
				InternetExplorerDriverManager.getInstance().setup();
				return new InternetExplorerDriver();
			case "edge":
				EdgeDriverManager.getInstance().setup();
				return new EdgeDriver();
			default:
				return new FirefoxDriver();
		}

	}
}
