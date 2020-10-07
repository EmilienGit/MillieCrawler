package com.em.millecrawler.controler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadImages2 {
	private WebDriver driver;

	public DownloadImages2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Shared\\Tools\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}


	public void saveImages(String url) {
		driver.navigate().to(url);

		//Maximize the browser
		driver.manage().window().maximize();

		// Click on the Search button
		WebElement elementLocator = driver.findElement(By.cssSelector(".magnifier-image"));
		String j = elementLocator.getAttribute("src");
		URL imageURL = null;
		try {
			imageURL = new URL(j);
			BufferedImage saveImage = ImageIO.read(imageURL);

			ImageIO.write(saveImage, "jpg", new File("C:\\Users\\e.mamalet\\Downloads\\Crawler\\image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
