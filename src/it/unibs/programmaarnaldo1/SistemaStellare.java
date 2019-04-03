package it.unibs.programmaarnaldo1;

import java.util.ArrayList;

public class SistemaStellare {

	public SistemaStellare() {}
	private ArrayList<Pianeta> pianeti=new ArrayList<Pianeta>();
	
	
	//Aggiunta di nuovi pianeti, in caso di nuove scoperte										CASO 1.1 MAIN
	public void aggiungiPianeta(Pianeta pianeta) {
		pianeti.add(pianeta);
		}
	
	//Rimozione di vecchi pianeti, in caso di “catastrofi naturali”.								CASO 1.2 MAIN
	public boolean rimuoviPianeta(Pianeta cancella) {
		boolean cancellato=false;
		if (pianeti.contains(cancella)) 
		{int daCancellare=pianeti.indexOf(cancella);
		pianeti.remove(daCancellare);
		cancellato=true;}
		return cancellato;}
	
	//Identificazione di ciascun corpo celeste con un codice univoco.									CASO 1.3 MAIN
	public Pianeta restituisciPianetaTramiteId(Id id) {
		Pianeta presente= null;
		for (Pianeta i: pianeti) {
			if (i.getId().equals(id))
				presente= i;}
		return presente;}	

	//Possibilità di capire se è presente nel sistema stellare.											CASO 2.1 MAIN
	public boolean presenzaPianeta(Id id) {
		boolean presente=false;
		for (Pianeta i : pianeti) {
			if (i.getId().equals(id))
				presente = true;}
			return presente;}
	

	}

	
