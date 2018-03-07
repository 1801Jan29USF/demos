package com.revature.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAVE_ID")
public class Cave {

	@Id
	@Column(name = "CAVE_ID")
	@SequenceGenerator(name = "CAVEID_SEQ", sequenceName = "CAVEID_SEQ")
	@GeneratedValue(generator = "CAVEID_SEQ", strategy = GenerationType.AUTO)
	private int caveId;

	@Column(name = "SQ_FOOTAGE")
	private double squareFootage;

	private String caveType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwelling")
	private Set<Bear> residents = new HashSet<Bear>();

	public Cave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cave(int caveId, double squareFootage, String caveType, Set<Bear> residents) {
		super();
		this.caveId = caveId;
		this.squareFootage = squareFootage;
		this.caveType = caveType;
		this.residents = residents;
	}

	public int getCaveId() {
		return caveId;
	}

	public void setCaveId(int caveId) {
		this.caveId = caveId;
	}

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public String getCaveType() {
		return caveType;
	}

	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}

	public Set<Bear> getResidents() {
		return residents;
	}

	public void setResidents(Set<Bear> residents) {
		this.residents = residents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caveId;
		result = prime * result + ((caveType == null) ? 0 : caveType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(squareFootage);
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
		Cave other = (Cave) obj;
		if (caveId != other.caveId)
			return false;
		if (caveType == null) {
			if (other.caveType != null)
				return false;
		} else if (!caveType.equals(other.caveType))
			return false;
		if (Double.doubleToLongBits(squareFootage) != Double.doubleToLongBits(other.squareFootage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cave [caveId=" + caveId + ", squareFootage=" + squareFootage + ", caveType=" + caveType + "]";
	}

}
