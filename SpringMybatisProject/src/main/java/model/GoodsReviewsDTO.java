package model;

import java.util.List;

public class GoodsReviewsDTO {
	GoodsDTO goods; // 1 : 부모글 1개
	List<ReviewDTO> reviews; // 2 : 댓글 여러개 // 댓글 알고리즘
		
	public GoodsDTO getGoods() {
		return goods;
	}
	public void setGoods(GoodsDTO goods) {
		this.goods = goods;
	}
	public List<ReviewDTO> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
}
