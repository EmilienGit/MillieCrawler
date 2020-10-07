package com.em.millecrawler.controler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloadImages {
	private String path;

	public DownloadImages(String path) {
		setPath(path);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void getSrc(Document document) {
		try {
			Elements elements = document.getElementsByTag("img");
			for (Element element : elements) {
				String src = element.absUrl("src");
				String src2 = element.absUrl("data-src");
				getImages(src);
				getImages(src2);
			}
		} catch (IOException ex) {
			Logger.getLogger(DownloadImages.class.getName()).log(Level.SEVERE, "There was an error", ex);
		}
	}

	private void getImages(String src) throws IOException {
		String name = getNameOfImage(src);
		String searchTag = createSearchTag(name, "");
		if (name != null && name.contains(searchTag) && (name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".svg") || name.endsWith(".webp"))) {
			URL url = new URL(src);
			InputStream in = url.openStream();
			OutputStream out = new BufferedOutputStream(new FileOutputStream(this.path + name));
			for (int b; (b = in.read()) != -1; ++b) {
				out.write(b);
			}
			System.out.println("Téléchargement de " + src);
			out.close();
			in.close();

		}
	}

	private static String getNameOfImage(String src) {
		int indexname = src.lastIndexOf("/");
		if (indexname > 0) {
			if (indexname == src.length()) {
				src = src.substring(1, indexname); // Equivalent a tout sauf le nom de l'image
			}
			indexname = src.lastIndexOf("/");
			return src.substring(indexname);
		}
		return null;
	}

	private String createSearchTag(String name, String searchTag) {
		if (searchTag.isEmpty()) {
			searchTag = name;
		}
		return searchTag;
	}

}
