package com.revature.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@NamedQueries({ @NamedQuery(name = "findByHoneyAmountGreaterThan", query = "FROM Bear WHERE honeyPot.honeyAmount > :amount") })

@Entity
public class Bear {

	@Id
	@Column(name = "BEAR_ID")
	@SequenceGenerator(name = "BEARID_SEQ", sequenceName = "BEARID_SEQ")
	@GeneratedValue(generator = "BEARID_SEQ", strategy = GenerationType.AUTO)
	private int bearId;

	@Column(name = "BEAR_COLOR")
	private String bearColor;
	private String breed;
	private double weight;
	private double height;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cave_id")
	private Cave dwelling;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "HONEYPOT_ID")
	private HoneyPot honeyPot;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "PARENT_CUB", joinColumns = @JoinColumn(name = "PARENT_ID"), inverseJoinColumns = @JoinColumn(name = "CUB_ID"))
	private Set<Bear> cubs;

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(int bearId, String bearColor, String breed, double weight, double height, Cave dwelling,
			HoneyPot honeyPot, Set<Bear> cubs) {
		super();
		this.bearId = bearId;
		this.bearColor = bearColor;
		this.breed = breed;
		this.weight = weight;
		this.height = height;
		this.dwelling = dwelling;
		this.honeyPot = honeyPot;
		this.cubs = cubs;
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getBearColor() {
		return bearColor;
	}

	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Cave getDwelling() {
		return dwelling;
	}

	public void setDwelling(Cave dwelling) {
		this.dwelling = dwelling;
	}

	public HoneyPot getHoneyPot() {
		return honeyPot;
	}

	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}

	public Set<Bear> getCubs() {
		return cubs;
	}

	public void setCubs(Set<Bear> cubs) {
		this.cubs = cubs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bearColor == null) ? 0 : bearColor.hashCode());
		result = prime * result + bearId;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((cubs == null) ? 0 : cubs.hashCode());
		result = prime * result + ((dwelling == null) ? 0 : dwelling.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((honeyPot == null) ? 0 : honeyPot.hashCode());
		temp = Double.doubleToLongBits(weight);
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
		Bear other = (Bear) obj;
		if (bearColor == null) {
			if (other.bearColor != null)
				return false;
		} else if (!bearColor.equals(other.bearColor))
			return false;
		if (bearId != other.bearId)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (cubs == null) {
			if (other.cubs != null)
				return false;
		} else if (!cubs.equals(other.cubs))
			return false;
		if (dwelling == null) {
			if (other.dwelling != null)
				return false;
		} else if (!dwelling.equals(other.dwelling))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (honeyPot == null) {
			if (other.honeyPot != null)
				return false;
		} else if (!honeyPot.equals(other.honeyPot))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", bearColor=" + bearColor + ", breed=" + breed + ", weight=" + weight
				+ ", height=" + height + ", dwelling=" + dwelling + ", honeyPot=" + honeyPot + ", cubs=" + cubs + "]";
	}

}
