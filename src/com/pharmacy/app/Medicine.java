package com.pharmacy.app;

import java.io.*;

public class Medicine implements Comparable<Medicine>, Serializable{

	private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private int available;
    
	public Medicine(String name, String type, int available) {
		super();
		this.name = name;
		this.type = type;
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Medicine [name=" + name + ", type=" + type + ", available=" + available + "]";
	}

	@Override
	public int compareTo(Medicine otherMedicine) {
		return this.name.compareTo(otherMedicine.getName());
	}

}
