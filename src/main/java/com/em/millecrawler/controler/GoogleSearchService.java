package com.em.millecrawler.controler;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashSet;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchService {
	static HashSet<String> googleResults;
	private UrlValidator urlValidator = new UrlValidator();

	public void initGoogleSearch(DownloadImages downloadImages, String googleSearch) {
		googleResults = new HashSet<>();
		String googleImage = "https://www.google.fr/search?hl=fr&tbm=isch&source=hp&biw=801&bih=559&ei=lud6X7PJHcvIaNumq6gD&q=";
		String url = googleImage + googleSearch;
		search(downloadImages, url);
	}

	private void search(DownloadImages downloadImages, String url) {
		if (!googleResults.contains(url) && urlValidator.isValid(url)) {
			googleResults.add(url);
			try {
				URLEncoder.encode(url, "UTF-8");
				Connection connection = Jsoup.connect(url).ignoreHttpErrors(true);
				connection.userAgent("Mozilla/5.0");
				Document document = connection.get();

				downloadImages.getSrc(document);

				Elements links = document.select("a[href]");

				for (Element link : links) {
					String imgUrl = link.absUrl("href");
					if (imgUrl.contains("https://www.google.fr/url?q=")) {
						imgUrl = imgUrl.replace("https://www.google.fr/url?q=", "");
						search(downloadImages, imgUrl);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}