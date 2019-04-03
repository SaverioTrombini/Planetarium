package it.unibs.programmaarnaldo1;

import java.util.ArrayList;

public class SistemaStellare {

	public SistemaStellare() {
	}

	private ArrayList<Pianeta> pianeti = new ArrayList<Pianeta>();

	// Aggiunta di nuovi pianeti, in caso di nuove scoperte CASO 1.1 MAIN
	public void aggiungiPianeta(Pianeta pianeta) {
		pianeti.add(pianeta);
	}

	// Rimozione di vecchi pianeti, in caso di “catastrofi naturali”. CASO 1.2 MAIN
	public boolean rimuoviPianeta(Pianeta cancella) {
		boolean cancellato = false;
		if (pianeti.contains(cancella)) {
			int daCancellare = pianeti.indexOf(cancella);
			pianeti.remove(daCancellare);
			cancellato = true;
		}
		return cancellato;
	}

	// Identificazione di ciascun corpo celeste con un codice univoco. CASO 1.3 MAIN
	public Pianeta restituisciPianetaTramiteId(Id id) {
		Pianeta presente = null;
		for (Pianeta i : pianeti) {
			if (i.getId().getNome().equals(id.getNome()))
				presente = i;
		}
		return presente;
	}

	// Possibilità di capire se è presente nel sistema stellare. CASO 2.1 MAIN
	public boolean presenzaPianeta(Id id) {
		boolean presente = false;
		for (Pianeta i : pianeti) {
			if (i.getId().getNome().equals(id.getNome()))
				presente = true;
		}
		return presente;
	}

	// Dato un id come input restituisce una luna se è presente nel sistema
	public Luna getLuna(Id id) {
		for (Pianeta p : pianeti)
			for (Luna l : p.getLune())
				if (l.getId().getNome().equals(id.getNome())) {
					return l;
		}

		return null;
	}

	// Calcola la massa di tutti i pianeti del sistema solare
	public int getMassaPianeti() {
		int massa = 0;
		for (Pianeta p : pianeti) {
			massa += p.getMassa();
		}
		return massa;
	}

	// Calcola la massa di tutte le lune del sistema solare
	public int getMassaLune() {
		int massa = 0;
		for (Pianeta p : pianeti)
			for (Luna l : p.getLune()) {
				massa += l.getMassa();
		}
		return massa;
	}

	// Calcolo tot X
	public int getCoordinataXPianeti() {
		int x = 0;
		for (Pianeta p : pianeti) {
			x += p.getX();
		}
		return x;
	}

	public int getCoordinataXLune() {
		int x = 0;
		for (Pianeta p : pianeti) {
			for (Luna l : p.getLune())
				x += l.getX();
		}
		return x;
	}

	// Calcolo tot Y
	public int getCoordinataYPianeti() {
		int y = 0;
		for (Pianeta p : pianeti) {
			y += p.getY();
		}
		return y;
	}

	public int getCoordinataYLune() {
		int y = 0;
		for (Pianeta p : pianeti) {
			for (Luna l : p.getLune())
				y += l.getY();
		}
		return y;
	}

}
