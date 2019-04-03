package it.unibs.programmaarnaldo1;


public class Luna extends CorpoCeleste {

	
	private Pianeta pianeta;

	public Luna(Id id, int massa, double x, double y, Pianeta pianeta) {
		super(id, massa,  x, y);
		this.pianeta=pianeta;
}

	public Pianeta getPianeta() {
		return pianeta;
	}

	
	


	
}
