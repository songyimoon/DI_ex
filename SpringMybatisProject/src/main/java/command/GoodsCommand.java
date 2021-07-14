package command;

import org.springframework.web.multipart.MultipartFile;

public class GoodsCommand {

	String ctgr;
	Long prodNum;
	String prodName;
	Long prodPrice;
	String prodCapacity;
	String prodSupplier;
	Long prodDelFee;
	String recommend;
	String prodDetail;
	MultipartFile [] prodImage; // 파일이 여러개 날아감. 이름이 다 동일하므로 배열로 받아주자.
	String fileDel1;
	
	public String getCtgr() {
		return ctgr;
	}
	public void setCtgr(String ctgr) {
		this.ctgr = ctgr;
	}
	public Long getProdNum() {
		return prodNum;
	}
	public void setProdNum(Long prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Long getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdCapacity() {
		return prodCapacity;
	}
	public void setProdCapacity(String prodCapacity) {
		this.prodCapacity = prodCapacity;
	}
	public String getProdSupplier() {
		return prodSupplier;
	}
	public void setProdSupplier(String prodSupplier) {
		this.prodSupplier = prodSupplier;
	}
	public Long getProdDelFee() {
		return prodDelFee;
	}
	public void setProdDelFee(Long prodDelFee) {
		this.prodDelFee = prodDelFee;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	public MultipartFile[] getProdImage() {
		return prodImage;
	}
	public void setProdImage(MultipartFile[] prodImage) {
		this.prodImage = prodImage;
	}
	public String getFileDel1() {
		return fileDel1;
	}
	public void setFileDel1(String fileDel1) {
		this.fileDel1 = fileDel1;
	}


	
}

