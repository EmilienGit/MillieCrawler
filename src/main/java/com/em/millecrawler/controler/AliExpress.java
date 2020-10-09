package com.em.millecrawler.controler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AliExpress {
	private WebDriver driver;
	private String savePath;

	public AliExpress(String pathChromeDriver, String savePath) {
		setSavePath(savePath);
		setDriverPath(pathChromeDriver);
		driver = new ChromeDriver();
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setDriverPath(String pathChromeDriver) {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
	}

	public void saveImages(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();

		List<WebElement> elements = driver.findElements(By.cssSelector(".images-view-item"));
		for (WebElement element : elements) {
			element.click();
			save(this.savePath);
		}
		driver.quit();
	}

	public void save(String savePath) {
		WebElement elementLocator = driver.findElement(By.cssSelector(".magnifier-image"));
		String imgSrc = elementLocator.getAttribute("src");
		URL imageURL = null;
		try {
			imageURL = new URL(imgSrc);
			BufferedImage saveImage = ImageIO.read(imageURL);
			int i = 1;
			File file = new File(savePath + "image" + i + ".jpg");
			while (file.exists()) {
				i++;
				file = new File(savePath + "image" + i + ".jpg");
			}
			ImageIO.write(saveImage, "jpg", new File(savePath + "image" + i + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
