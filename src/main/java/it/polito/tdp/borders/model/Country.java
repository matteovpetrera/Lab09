package it.polito.tdp.borders.model;

public class Country {
	
	String stateAbb;
	int CCode;
	String stateNme;
	public Country(String stateAbb, int cCode, String stateNme) {
		super();
		this.stateAbb = stateAbb;
		CCode = cCode;
		this.stateNme = stateNme;
	}
	/**
	 * @return the stateAbb
	 */
	public String getStateAbb() {
		return stateAbb;
	}
	/**
	 * @return the cCode
	 */
	public int getCCode() {
		return CCode;
	}
	/**
	 * @return the stateNme
	 */
	public String getStateNme() {
		return stateNme;
	}
	@Override
	public String toString() {
		return "stato: " + stateAbb + ", codice: " + CCode + ", stateNme: " + stateNme;
	}
	
	
	
}
