package com.revature.entities;

public class Test {

	private int id;
	private boolean swords;
	private double sharpness;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(int id, boolean swords, double sharpness) {
		super();
		this.id = id;
		this.swords = swords;
		this.sharpness = sharpness;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSwords() {
		return swords;
	}

	public void setSwords(boolean swords) {
		this.swords = swords;
	}

	public double getSharpness() {
		return sharpness;
	}

	public void setSharpness(double sharpness) {
		this.sharpness = sharpness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(sharpness);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (swords ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(sharpness) != Double.doubleToLongBits(other.sharpness))
			return false;
		if (swords != other.swords)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", swords=" + swords + ", sharpness=" + sharpness + "]";
	}

}
