package Controller;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Model.Rss;


public class RssControl {
	public URL url ;
	public Unmarshaller unmarshaller;
	public Rss rss;
	public Object obj;
	
	public RssControl() throws JAXBException {
		setRss();
	}
	
	public void setRss() throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance( Rss.class );
		unmarshaller = ctx.createUnmarshaller( );
		// the result (obj) is an instance of the XmlRootElement type


	}
	
	public Rss getRss() {
		return rss;
	}
	
	public Rss setUrl( String url ) throws MalformedURLException, JAXBException{
		this.url = new URL(url);
		obj = unmarshaller.unmarshal( this.url );
		rss = (Rss) obj;
		return rss;
		
	}
	
}
