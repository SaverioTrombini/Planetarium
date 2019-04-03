package it.unibs.programmaarnaldo1;

import java.util.ArrayList;

public class Pianeta extends CorpoCeleste {
	private Stella stella;
	private ArrayList<Luna> lune;
	
	public Pianeta(Id id, int massa, double x, double y, Stella stella) {
		super(id, massa,  x, y);
		this.stella=stella;
		lune= new ArrayList<Luna>();
		}
	
	//Aggiunta di nuove lune, in caso di nuove scoperte	
	public void aggiungiLuna(CorpoCeleste luna) {
		lune.add((Luna) luna);}	
		
	//Rimozione di vecche lune, in caso di “catastrofi naturali”.	
	public boolean rimuoviLuna(Luna cancella) {
		boolean cancellato=false;
		if (lune.contains(cancella)) 
		{int daCancellare=lune.indexOf(cancella);
		lune.remove(daCancellare);
		cancellato=true;}
		return cancellato;}

	//Identificazione di ciascun corpo celeste con un codice univoco.
	public Luna restituisciLunaTramiteId(Id id) {
		Luna presente= null;
		for (Luna i: lune) {
			if (i.getId().equals(id))
				presente= i;}
		return presente;}	

	//Possibilità di capire se è presente nel sistema planetario.		
	public boolean presenzaLuna(Id id) {
		boolean presente=false;
		for (Luna i : lune) {
			if (i.getId().equals(id))
				presente = true;}
			return presente;}


	public Stella getStella() {
		return stella;
	}

	public ArrayList<Luna> getLune() {
		return lune;
	}



	

	
}
