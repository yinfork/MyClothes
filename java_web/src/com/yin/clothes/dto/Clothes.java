package com.yin.clothes.dto;

public class Clothes extends IdEntity {

	private long userId;
	private String clothesName;
	private String clothesImgPath;
	
	

	public Clothes(long userId, String clothesName, String clothesImgPath) {
		super();
		this.userId = userId;
		this.clothesName = clothesName;
		this.clothesImgPath = clothesImgPath;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getClothesName() {
		return clothesName;
	}

	public void setClothesName(String clothesName) {
		this.clothesName = clothesName;
	}

	public String getClothesImgPath() {
		return clothesImgPath;
	}

	public void setClothesImgPath(String clothesImgPath) {
		this.clothesImgPath = clothesImgPath;
	}

}
