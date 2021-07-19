package bean.healthy;


public class CrawlingDTO {
	private int num;
	private String naverTitle;
	private String naverUrl;

	
	public int getNum() {
		return num;
	}


	public String getNaverTitle() {
		return naverTitle;
	}


	public String getNaverUrl() {
		return naverUrl;
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


	@Override
	public String toString() {
		return "CrawlingDTO [num=" + num + ", naverTitle=" + naverTitle + ", naverUrl="
				+ naverUrl + "]";
	}
	
	
}
