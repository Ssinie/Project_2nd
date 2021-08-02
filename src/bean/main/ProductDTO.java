package bean.main;

public class ProductDTO {

	private String id;
	private int num;
	private String name;
	private String imgurl;
//	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
//	public String getUrl() {
//		return url;
//	}
//	public void setUrl(String url) {
//		this.url = url;
//	}
	
}
