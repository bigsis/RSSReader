package View;

import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import Controller.RssControl;
import Model.Rss;

public class Main {
	public static RssControl rss;
	public static RssReaderView rrv;
	
	public static void main(String[] args) throws JAXBException, MalformedURLException {
		rss = new RssControl();
		rrv = new RssReaderView(rss);
	}
}
