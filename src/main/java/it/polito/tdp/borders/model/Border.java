package it.polito.tdp.borders.model;

public class Border {
	
	int s1;
	int s2;
	public Border(int s1, int s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}
	/**
	 * @return the s1
	 */
	public int getS1() {
		return s1;
	}
	/**
	 * @return the s2
	 */
	public int getS2() {
		return s2;
	}
	@Override
	public String toString() {
		return "Border [s1=" + s1 + ", s2=" + s2 + "]";
	}
	
	
}
