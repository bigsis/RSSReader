package Model;
import java.util.List;


public class Channel {
	private String title;
	private String link;
	private String description;
	private String language;
	private String lbd;
	private String copryRight;
	private Image img;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLbd() {
		return lbd;
	}
	public void setLbd(String lbd) {
		this.lbd = lbd;
	}
	public String getCopryRight() {
		return copryRight;
	}
	public void setCopryRight(String copryRight) {
		this.copryRight = copryRight;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	private String ttl;
	private List<Item> item;
	
}
