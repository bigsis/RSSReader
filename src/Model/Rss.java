package Model;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model of rss in RSSReader
 * @author Sarit Suriyasangpetch 5510546191
 *
 */
@XmlRootElement
public class Rss {
	private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
}
