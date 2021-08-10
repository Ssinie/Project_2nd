package bean.healthy;


public class CrawlingDTO {
	private int num;
	private String naverTitle;
	private String naverUrl;
	private String imageUrl;
	
	
	public int getNum() {
		return num;
	}
	public String getNaverTitle() {
		return naverTitle;
	}
	public String getNaverUrl() {
		return naverUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setNaverTitle(String naverTitle) {
		this.naverTitle = naverTitle;
	}
	public void setNaverUrl(String naverUrl) {
		this.naverUrl = naverUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CrawlingDTO [num=").append(num).append(", naverTitle=").append(naverTitle).append(", naverUrl=")
				.append(naverUrl).append(", imageUrl=").append(imageUrl).append("]");
		return builder.toString();
	}

	
	
}
