package com.whatfix.java;

public class PackageDTO {
	

	private int id;
	private double weight;
	private double cost;
	

	public PackageDTO() {
		super();
	}
	public PackageDTO(int id, double weight, double cost) {
		super();
		this.id = id;
		this.weight = weight;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Thing [id=" + id + ", weight=" + weight + ", cost=" + cost
				+ "]";
	}


}
