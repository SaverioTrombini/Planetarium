package it.unibs.programmaarnaldo1;

import java.util.ArrayList;

public class CorpoCeleste {
	private Id id;
	private int massa;
	private double[] coordinate= new double[2];
	
	public CorpoCeleste(Id id, int massa, double x, double y) {
		this.id = id;
		this.massa= massa;
		coordinate[0]=x;
		coordinate[1]=y;
	}
	
	//getter 
	public ArrayList<Luna> getLune() {
		return getLune();
	}
	public Id getId() {
		return id;
	}
	public int getMassa() {
		return massa;
	}
	public double getX() {
		return coordinate[0];
	}
	public double getY() {
		return coordinate[1];
	}
	
}
