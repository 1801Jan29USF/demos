package com.revature.beans;

public class WallImpl implements Wall {

	private String material;

	public WallImpl(String material) {
		super();
		this.material = material;
	}

	public WallImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String mat) {
		System.out.println("setter called");
		this.material = mat;
	}

	@Override
	public String toString() {
		return "WallImpl [material=" + material + "]";
	}

}
