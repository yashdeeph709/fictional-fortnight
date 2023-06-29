package com.fortnight.cmdline;

public class Option {
	private int index;
	private String description;
	public Option(int index, String description) {
		super();
		this.index = index;
		this.description = description;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
