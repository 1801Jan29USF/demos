package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HONEY_POT")
public class HoneyPot {

	@Id
	@Column(name = "HONEYPOT_ID")
	@SequenceGenerator(name = "HONEYPOTID_SEQ", sequenceName = "HONEYPOTID_SEQ")
	@GeneratedValue(generator = "HONEYPOTID_SEQ", strategy = GenerationType.AUTO)
	private int honeyPotId;

	private double volume;

	private double honeyAmount;

	public HoneyPot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoneyPot(int honeyPotId, double volume, double honeyAmount) {
		super();
		this.honeyPotId = honeyPotId;
		this.volume = volume;
		this.honeyAmount = honeyAmount;
	}

	public int getHoneyPotId() {
		return honeyPotId;
	}

	public void setHoneyPotId(int honeyPotId) {
		this.honeyPotId = honeyPotId;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getHoneyAmount() {
		return honeyAmount;
	}

	public void setHoneyAmount(double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(honeyAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + honeyPotId;
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		HoneyPot other = (HoneyPot) obj;
		if (Double.doubleToLongBits(honeyAmount) != Double.doubleToLongBits(other.honeyAmount))
			return false;
		if (honeyPotId != other.honeyPotId)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoneyPot [honeyPotId=" + honeyPotId + ", volume=" + volume + ", honeyAmount=" + honeyAmount + "]";
	}

}
