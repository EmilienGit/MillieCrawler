package com.em.millecrawler.controler;

import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawlerService {
	private final HashSet<String> links = new HashSet<>();
	private final UrlValidator urlValidator = new UrlValidator();
	private final GoogleSearchService googleSearchService = new GoogleSearchService();

	public WebCrawlerService() {
		super();
	}

	public void downloadFromUrl(DownloadImages downloadImages, String url) {
		downloadImagesFromUrl(downloadImages, url);
	}

	public void downloadFromGoogle(DownloadImages downloadImages, String googleWord) {
		googleSearchService.initGoogleSearch(downloadImages, googleWord);
	}

	private void downloadImagesFromUrl(DownloadImages downloadImages, String url) {
		if (urlValidator.isValid(url)) {
			try {
				Connection connection = Jsoup.connect(url);
				connection.userAgent("Mozilla/5.0");
				Document document = connection.get();
				downloadImages.getSrc(document);
			} catch (IOException e) {
				System.err.println("For '" + url + "': " + e.getMessage());
			}
		}
	}

}
