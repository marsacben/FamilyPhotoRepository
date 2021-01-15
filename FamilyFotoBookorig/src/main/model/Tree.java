package main.model;

import java.util.LinkedList;

public class Tree {
	Node me;
	
	public void createTree() {
		LinkedList<Node> RozaKids = new LinkedList<>();
		Node Roza = new Node("Rozalia Fart", null,null, RozaKids);
		Node LajosVarga1 = new Node("Lajos Varga", null, null, RozaKids);
		
			LinkedList<Node> LajosKids = new LinkedList<>();
			Node LajosVarga2 = new Node("Lajos Varga II", Roza, LajosVarga1,LajosKids);
		
				LinkedList<Node> PiroskaKids = new LinkedList<>();
				Node PiroskaVarga = new Node("Piroska Varga", null, LajosVarga2, PiroskaKids);
							
					LinkedList<Node> EstebanKids = new LinkedList<>();
					Node EstebanRockVarga = new Node("Esteban Rock Varga", PiroskaVarga, null, EstebanKids);
					PiroskaKids.add(EstebanRockVarga);
						
						
						Node MaureenRock = new Node("Maureen Paty Rock Rech", EstebanRockVarga, null, null);
						EstebanKids.add(MaureenRock);
					
						Node SteveRock = new Node("Steve Rock Rech", EstebanRockVarga, null, null);
						EstebanKids.add(SteveRock);
						
						LinkedList<Node> PriscaKids = new LinkedList<>();
						Node PriscaRock = new Node("Prisca Rock Rech", EstebanRockVarga, null, PriscaKids);
						EstebanKids.add(PriscaRock);
							
							LinkedList<Node> AleKids = new LinkedList<>();
							Node AlejandraContrerasRock = new Node("Alejandra Contreras Rock", null, PriscaRock, null);
							PriscaKids.add(AlejandraContrerasRock);
							
								Node IsabelaLealContreras = new Node("Isabela Leal Contreras", null, AlejandraContrerasRock, null);
								AleKids.add(IsabelaLealContreras);
								
								Node SantiagoLealContreras = new Node("Santiago Leal Contreras", null, AlejandraContrerasRock, null);
								AleKids.add(SantiagoLealContreras);
							
							Node AndresContrerasRock = new Node("Andres Contreras Rock", null, PriscaRock, null);
							PriscaKids.add(AndresContrerasRock);
							
							Node CatyContrerasRock = new Node("Caty Contreras Rock", null, PriscaRock, null);
							PriscaKids.add(CatyContrerasRock);
						
					
					LinkedList<Node> AnitaKids = new LinkedList<>();
					Node AnitaRockVarga = new Node("Anita Rock Varga", PiroskaVarga, null, AnitaKids);
					PiroskaKids.add(AnitaRockVarga);
					
						Node ElisaEatonRock = new Node("Elisa Eaton Rock", AnitaRockVarga, null, null);
						AnitaKids.add(ElisaEatonRock);
					
						Node BradfordEatonRock = new Node("Bradford Eaton Rock", AnitaRockVarga, null, null);
						AnitaKids.add(BradfordEatonRock);
					
						LinkedList<Node> SharonKids = new LinkedList<>();
						Node SharonEatonRock = new Node("Sharon Eaton Rock", AnitaRockVarga, null, SharonKids);
						AnitaKids.add(SharonEatonRock);
					
					LinkedList<Node> CatyKids = new LinkedList<>();
					Node CatarinaRockVarga = new Node("Catarina Rock Varga", PiroskaVarga, null, CatyKids);
					PiroskaKids.add(CatarinaRockVarga);
		
						Node AnaIsabelSacristan = new Node("Ana Isabel Sacristan Sacristan", CatarinaRockVarga, null, null);
						CatyKids.add(AnaIsabelSacristan);
						
						LinkedList<Node>EmilioKids = new LinkedList<>();
						Node EmilioSacristanRock = new Node("Emilio Sacristan Rock", CatarinaRockVarga, null, EmilioKids);
						CatyKids.add(AnaIsabelSacristan);
							
							Node AriSacristan = new Node("Ari Sacristan Benjet", null, EmilioSacristanRock, null);
							Node CarmenSacristan = new Node("Maria del Carmen Sacristan Benjet", null, EmilioSacristanRock, null);
							this.me = CarmenSacristan;
						
						LinkedList<Node> Caty2Kids = new LinkedList<>();
						Node CatarinaSacristan = new Node("Catarina Sacristan Rock", CatarinaRockVarga, null, Caty2Kids);
						CatyKids.add(CatarinaRockVarga);
							
							Node EmiliaRyanSacristan = new Node("Emilia Ryan Sacristan", CatarinaSacristan, null, null);
						
					
					LinkedList<Node> AliciaKids = new LinkedList<>();
					Node AliciaRockVarga = new Node("Alicia Rock Varga", PiroskaVarga, null, AliciaKids);
					PiroskaKids.add(AliciaRockVarga);
					
	}
	
	public Node findPerson(String code) {
		Node n = this.me;
		for(int i=0; i<code.length(); i++) {
			int r =code.charAt(i);
			if(r=='F' || r=='M') {
				if(r=='F') {
					n = n.getDad();
				}
				else {
					n = n.getMom();
				}
			}
			else {
				int num = r;
				n = n.getKid(num);
			}
		}
		return n;
	}
}
