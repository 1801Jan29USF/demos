package com.revature.beans;

public class CoolWall implements Wall {

	private String material;

	public CoolWall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoolWall(String material) {
		super();
		this.material = "HOT" + material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = "COOL" + material;
	}

	@Override
	public String toString() {
		return "CoolWall [material=" + material + "]";
	}

}
