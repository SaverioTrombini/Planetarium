package it.unibs.programmaarnaldo1;

public class PlanetariumMain {

	
	private static final String NUMERO = "inserire il numero del corpo celeste: ";
	private static final String NOME = "inserire il nome del corpo celeste: ";
	private static final String TITOLO = "Elenco operazioni possibili:\n";
	private static final String [] MENU_PRINCIPALE= {"Gestione dei corpi celesti del sistema stellare",
		"Ricerca di un corpo celeste all�interno del sistema","Visualizzazione delle informazioni","Calcolo del centro di massa"};
	private static final String [] MENU1= {"Aggiunta di nuovi pianeti o lune", "Rimozione di vecchi pianeti o lune",
		"Identificazione di ciascun corpo celeste con un codice univoco"};
	private static final String [] MENU2= {"Possibilit� di capire se � presente nel sistema stellare ",
		"Nel caso di lune, identificazione del pianeta attorno a cui gira"};
	private static final String [] MENU3= {"Dato un pianeta, visualizzazione delle lune che gli orbitano intorno ",
		"Data una luna, visualizzazione del percorso [stella > pianeta > luna] necessario per raggiungerla"};
	private static final String COORDINATA_Y = "inserisci la coordinata y del corpo celeste: ";
	private static final String COORDINATA_X = "inserisci la coordinata x del corpo celeste: ";
	private static final String MASSA = "inserisci la massa del corpo celeste: ";
	private static final boolean USCITA = true;
	private static Stella stella;
	private static SistemaStellare sistema;
	private static CorpoCeleste corpoCeleste;
	public static void main(String[] args) {

	MyMenu menuPrincipale= new MyMenu(TITOLO,MENU_PRINCIPALE);
	MyMenu menuCaso1= new MyMenu(TITOLO,MENU1);
	MyMenu menuCaso2= new MyMenu(TITOLO,MENU2);
	MyMenu menuCaso3= new MyMenu(TITOLO,MENU3);
	sistema = new SistemaStellare();
	stella= creaStella();
	do {
	switch(menuPrincipale.scegli()) {
		case 1: 												//GESTIONE CORPI CELESTI DEL SISTEMA STELLARE
				switch(menuCaso1.scegli()) {
					case 1: 									//Aggiunta di nuovi pianeti o lune, in caso di nuove scoperte
								boolean cosaAggiungere = InputDati.yesOrNo("vuoi creare un pianeta? "); 
							if (cosaAggiungere) {Pianeta creato= creaPianeta();
								sistema.aggiungiPianeta(creato);}
							else {Luna creata= creaLuna();
								System.out.println("a che pianeta appartiene la luna che vuoi aggiungere? ");
								Id id = identificaCorpo("inserisci il suo id: ");
								Pianeta pianeta = sistema.restituisciPianetaTramiteId(id);
								pianeta.aggiungiLuna(creata);}
						break;
						
					case 2:										//Rimozione di vecchi pianeti o lune
						boolean cosaRimuovere = InputDati.yesOrNo("vuoi creare un pianeta? "); 
						if (cosaRimuovere) {Id idPianeta = identificaCorpo("inserisci il suo id: ");
							if(sistema.presenzaPianeta(idPianeta)) {
								Pianeta pianetaPresente = sistema.restituisciPianetaTramiteId(idPianeta);
								sistema.rimuoviPianeta(pianetaPresente);}
							else System.out.println("corpo non trovato");}
							
							else {System.out.println("a che pianeta appartiene la luna che vuoi rimuovere? ");
								Id idPianeta = identificaCorpo("inserisci il suo id: ");
								Pianeta pianeta = sistema.restituisciPianetaTramiteId(idPianeta);
								System.out.println("quale luna vuoi rimuovere?? ");
								Id idLuna= identificaCorpo("inserisci il suo id: ");
							if(pianeta.presenzaLuna(idLuna)) {
								Luna lunaPresente= pianeta.restituisciLunaTramiteId(idLuna);
								pianeta.rimuoviLuna(lunaPresente);}
							else System.out.println("corpo non trovato");}
							
						break;
						
					case 3:										//Identificazione di ciascun corpo celeste con un codice univoco
							boolean scelta = InputDati.yesOrNo("il corpo che si vuole identificare � un pianeta?");
							
							if(scelta) {
								Id id= identificaCorpo("inserisci il suo id: ");
								Pianeta	pianetaPresente = sistema.restituisciPianetaTramiteId(id);
								System.out.println("ID: "+ pianetaPresente.getId() + "MASSA:" + pianetaPresente.getMassa() 
								+ "COORDINATE: " + pianetaPresente.getX() + pianetaPresente.getY());}
							
							else if (!scelta) {
							System.out.println("a che pianeta appartiene la luna che si vuole identificare? ");
								Id id= identificaCorpo("inserisci il suo id: ");
								Pianeta pianeta= sistema.restituisciPianetaTramiteId(id);
								Luna lunaPresente= pianeta.restituisciLunaTramiteId(id);
								System.out.println("ID: "+ lunaPresente.getId() + "MASSA:" + lunaPresente.getMassa() 
								+ "COORDINATE: " + lunaPresente.getX() + lunaPresente.getY());
						}
							
							else	{System.out.println("il corpo non � presente");}	
					break;
						
					case 0:break;		 						//torna al menu  
					default: System.out.println("corpo non trovato");}
		break;													//fuori dal caso 1 del men� principale
			
		case 2: 												//RICERCA DI UN CORPO CELESTE ALL'INTERNO DEL SISTEMA
				switch(menuCaso2.scegli()) {
					case 1:										//Possibilit� di capire se � presente nel sistema stellare
							Id idPianeta= identificaCorpo("inserisci il suo id: ");
							if(sistema.presenzaPianeta(idPianeta)) 
								System.out.println("Corpo presente nel sistema stellare");
							else System.out.println("il corpo non � presente");
					break;
						
					case 2:										//Nel caso di lune, identificazione del pianeta attorno a cui gira
					
						
						
								System.out.println("La luna: " + luna.getId() + "� presente nel sistema e ruota attorno al"
										+ " pianeta: " + luna.getPianeta().getId());
							
					break;
						
					case 0:break;		 						//torna al menu  
						
					default: System.out.println("operazione non valida");}
		break;													//fuori dal caso 2 del men� principale
			
		case 3: 												//VISUALIZZAZIONE DELLE INFORMAZIONI
		
					switch(menuCaso3.scegli()) {
						case 1:									//Dato un pianeta, visualizzazione delle lune che gli orbitano intorno.
							
							break;
					
						case 2:									//Data una luna, visualizzazione del percorso [stella > pianeta > luna] necessario per	raggiungerla.
							Id idLuna= identificaCorpo("inserisci il suo id: ");
							if(sistema.presenzaLuna(idLuna)) {
								Luna luna = sistema.restituisciLunaTramiteId(idLuna);
								Pianeta pianeta= luna.getPianeta();
								Stella stella = pianeta.getStella();
								System.out.println("Percorso: " + stella + " > " + pianeta + " > " + luna);
							}
							break;	
						
						case 0:break;		 					//torna al menu  
						
						default: System.out.println("operazione non valida");}	
					break;										//fuori dal caso 3 del men� principale
			
		case 4:													//CALCOLO DEL CENTRO DI MASSA
				
		break;													//fuori dal caso 4 del men� principale	
			
		case 0:  System.exit(0);								//Termina il programma
		break;
			
		default: System.out.println("operazione non valida");	//gestione inserimento errato nel men� principale
		break;}
			
	}while(USCITA);
}
			
	public static Stella creaStella() {							//Questo metodo serve per far creare la stella all'utente 
		String nome= InputDati.leggiStringa("Inserisci il nome della stella: ");
		int numero= InputDati.leggiIntero("Inserisci il numero della stella: ");
		Id id= new Id(nome, numero);
		int massa= InputDati.leggiIntero(MASSA);
				
		return new Stella(id,massa);
	}
	
	public static Pianeta creaPianeta() {						//Questo metodo serve per far creare i pianeti all'utente 
		
		String nome= InputDati.leggiStringa(NOME);
		int numero= InputDati.leggiIntero(NUMERO);
		Id id= new Id(nome, numero);
		int massa= InputDati.leggiIntero(MASSA);
		double x=InputDati.leggiDouble(COORDINATA_X);
		double y=InputDati.leggiDouble(COORDINATA_Y);

	return new Pianeta(id,massa,x,y, stella);}
	
	public static Luna creaLuna() {								//Questo metodo serve per far creare le lune all'utente 
		Pianeta aCuiAppartieneLaStella= null;
		boolean trovato= false;
		Id idPianeta =identificaCorpo("a che pianeta appartiene la luna che vuoi creare?");
		while (sistema.presenzaPianeta(idPianeta)&& trovato) {
			aCuiAppartieneLaStella= sistema.restituisciPianetaTramiteId(idPianeta);
			trovato=true;}
		
	String nome= InputDati.leggiStringa(NOME);
	int numero= InputDati.leggiIntero(NUMERO);
	Id id= new Id(nome, numero);
	int massa= InputDati.leggiIntero(MASSA);
	double x=InputDati.leggiDouble(COORDINATA_X);
	double y=InputDati.leggiDouble(COORDINATA_Y);
	
	
	return new Luna(id,massa,x,y, aCuiAppartieneLaStella);
	}
	
	public static Id identificaCorpo(String messaggio) {		//Questo metodo serve per far inserire l'id del corpo celeste all'utente 
		System.out.println(messaggio);
		String nome= InputDati.leggiStringa(NOME);
		int numero= InputDati.leggiIntero(NUMERO);
		
		return new Id(nome, numero);
	}
	
}