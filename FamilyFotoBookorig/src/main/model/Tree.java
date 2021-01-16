package main.model;

import java.util.LinkedList;

public class Tree {
	Node me;
	
	public void createTree() {
		LinkedList<Node> AntonioKids = new LinkedList<>();

		Node Antonio = new Node("Antonio Sacristan Colas", null,null, AntonioKids);

		Node Lola = new Node("Dolores Roy Gonzalo", null, null, AntonioKids);

		

			LinkedList<Node> Lola2Kids = new LinkedList<>();

			Node Lola2 = new Node("Dolores Sacristan Roy", Lola, Antonio, AntonioKids);

			AntonioKids.add(Lola2);


				LinkedList<Node> JulioBKids = new LinkedList<>();

				Node JulioB = new Node("Julio Berdegue Sacristan", Lola2, null, JulioBKids);
				Lola2Kids.add(JulioB);
	

					Node JulioB2 = new Node("Julio Berdegue Pelizzari", null, JulioB, null);

					JulioBKids.add(JulioB2);

					Node Daniela = new Node("Daniela Berdegue Pelizzari", null, JulioB, null);

					JulioBKids.add(Daniela);

				LinkedList<Node> FernandoBKids = new LinkedList<>();

				Node FernandoB = new Node("Fernando Berdegue Sacristan", Lola2, null, FernandoBKids);

				Lola2Kids.add(FernandoB);
			

					Node FernandoB2 = new Node("Fernando Berdegue DeCima", null, FernandoB, null);

					FernandoBKids.add(FernandoB2);

					Node DanielB = new Node("Daniel Berdegue DeCima", null, FernandoB, null);

					FernandoBKids.add(DanielB);

					Node NicolasB = new Node("Nicolas Berdegue DeCima", null, FernandoB, null);

					FernandoBKids.add(NicolasB);

				LinkedList<Node> CarlosBKids = new LinkedList<>();

				Node CarlosB = new Node("Carlos Berdegue Sacristan", Lola2, null, CarlosBKids);

				Lola2Kids.add(CarlosB);
			

					Node CarolinaB = new Node("Carolina Berdegue Zapata", null, CarlosB, null);

					CarlosBKids.add(CarolinaB);

					Node CarlosB2 = new Node("Carlos Berdegue Zapata", null, CarlosB, null);

					CarlosBKids.add(CarlosB2);

					Node AlejandraB = new Node("Alejandra Berdegue Zapata", null, CarlosB, null);

					CarlosBKids.add(AlejandraB);

				LinkedList<Node> MarianoBKids = new LinkedList<>();

				Node MarianoB = new Node("Mariano Berdegue Sacristan", Lola2, null, MarianoBKids);

				Lola2Kids.add(MarianoB);
			

					Node SantiagoB = new Node("Santiago Berdegue Saenz", null, MarianoB, null);

					MarianoBKids.add(SantiagoB);

					Node EmilioB = new Node("Emilio Berdegue Saenz", null, MarianoB, null);

					MarianoBKids.add(EmilioB);

					Node LolaB = new Node("Dolores Berdegue Saenz", null, MarianoB, null);

					MarianoBKids.add(LolaB);

					Node ValeB = new Node("Valentina Berdegue Saenz", null, MarianoB, null);

					MarianoBKids.add(ValeB);

			LinkedList<Node> PepaKids = new LinkedList<>();

			Node Pepa = new Node("Maria Josefa Sacristan Roy", Lola, Antonio, AntonioKids);

			AntonioKids.add(Pepa);


				LinkedList<Node> ImanolKids = new LinkedList<>();

				Node Imanol = new Node("Imanol Ordorika Sacristan", Pepa, null, ImanolKids);

				PepaKids.add(Imanol);
			

					Node Amaya = new Node("Amaya Ordorika Imaz", null, Imanol, null);

					ImanolKids.add(Amaya);

					Node Imanol2 = new Node("Imanol Ordorika Imaz", null, Imanol, null);

					ImanolKids.add(Imanol2);

				LinkedList<Node> MaJoseKids = new LinkedList<>();

				Node MaJose = new Node("Maria Jose Ordorika Sacristan", Pepa, null, MaJoseKids);

				PepaKids.add(MaJose);
			

					Node MariaA = new Node("Maria Anton Ordorika ", MaJose, null, null);

					MaJoseKids.add(MariaA);

					Node SantiagoA = new Node("Santiago Anton Ordorika", MaJose, null, null);

					MaJoseKids.add(SantiagoA);
					
				Node Tere = new Node("Teresa Ordorika Sacristan", Pepa, null, null);

				MaJoseKids.add(SantiagoA);
				PepaKids.add(Tere);
	
			LinkedList<Node> Antonio2Kids = new LinkedList<>();

			Node Antonio2 = new Node("Antonio Sacristan Roy", Lola, Antonio, AntonioKids);

			AntonioKids.add(Antonio2);


				LinkedList<Node> MonicaKids = new LinkedList<>();

				Node Monica = new Node("Monica Sacristan Fanjul", null, Antonio2, Antonio2Kids);

				Antonio2Kids.add(Monica);
			

					Node Jimena = new Node("Jimean Arguelles Sacristan", Monica, null, null);

					MonicaKids.add(Jimena);

				LinkedList<Node> Antonio3Kids = new LinkedList<>();

				Node Antonio3 = new Node("Antonio Sacristan Fanjul", null, Antonio2, Antonio3Kids);

				Antonio2Kids.add(Antonio3);
			

					Node Antonio4 = new Node("Antonio Sacristan Medeiros", null, Antonio3, null);

					Antonio3Kids.add(Antonio4);

				LinkedList<Node> AnaMariKids = new LinkedList<>();

				Node AnaMari = new Node("Ana Maria Sacristan Fanjul", null, Antonio2, AnaMariKids);

				Antonio2Kids.add(AnaMari);
			

					Node NicolasG = new Node("Nicolas Garcia Sacristan", AnaMari, null, null);

					AnaMariKids.add(NicolasG);

					Node OlivierG = new Node("Olivier Garcia Sacristan", AnaMari, null, null);

					AnaMariKids.add(OlivierG);


			LinkedList<Node> CatyKids = new LinkedList<>();

			Node Emilio = new Node("Emilio Sacristan Roy", Lola, Antonio, CatyKids);

			AntonioKids.add(Emilio);


			LinkedList<Node> MaruKids = new LinkedList<>();

			Node Maru = new Node("Maria Concepcion Sacristan Roy", Lola, Antonio, MaruKids);

			AntonioKids.add(Maru);


				LinkedList<Node> JulioGKids = new LinkedList<>();

				Node julioG = new Node("Julio Garcia Sacristan", Maru, null, JulioGKids);

				MaruKids.add(julioG);
			

					Node LorenaG = new Node("Lorena Garcia Straub", null, julioG, null);

					JulioGKids.add(LorenaG);

					Node DiegoG = new Node("Diego Garcia Straub", null, julioG, null);

					JulioGKids.add(DiegoG);

					Node DanielG = new Node("Daniel Garcia Straub", null, julioG, null);

					JulioGKids.add(DanielG);

				LinkedList<Node> IsabelGKids = new LinkedList<>();

				Node IsabelG = new Node("Isabel Garcia Sacristan", Maru, null, IsabelGKids);

				MaruKids.add(IsabelG);
			

					Node CarlosR = new Node("Carlos Ruano Garcia", IsabelG, null, null);

					IsabelGKids.add(CarlosR);

					Node FernandoR = new Node("Fernando Ruano Garcia", IsabelG, null, null);

					IsabelGKids.add(FernandoR);

				LinkedList<Node> RafaelGKids = new LinkedList<>();

				Node RafaelG = new Node("Rafael Garcia Sacristan", Maru, null, RafaelGKids);

				MaruKids.add(RafaelG);
			

					Node Camila = new Node("Camila Garcia Delgado", null, RafaelG, null);

					RafaelGKids.add(Camila);

					Node AriG = new Node("Arantxa Garcia Delgado", null, RafaelG, null);

					RafaelGKids.add(AriG);


		LinkedList<Node> RozaKids = new LinkedList<>();

		Node Roza = new Node("Rozalia Fart", null,null, RozaKids);

		Node LajosVarga1 = new Node("Lajos Varga", null, null, RozaKids);

		RozaKids.add(LajosVarga1);


			LinkedList<Node> LajosVarga2Kids = new LinkedList<>();

			Node LajosVarga2 = new Node("Lajos Varga II", Roza, null,LajosVarga2Kids);

			LajosVarga2Kids.add(LajosVarga2);


				LinkedList<Node> PiroskaKids = new LinkedList<>();

				Node PiroskaVarga = new Node("Piroska Varga", null, LajosVarga2, PiroskaKids);
				Node EstebanRock = new Node("Esteban Rock", null, null, PiroskaKids);
				LajosVarga2Kids.add(PiroskaVarga);
				

					LinkedList<Node> EstebanKids = new LinkedList<>();

					Node EstebanRockVarga = new Node("Esteban Rock Varga", PiroskaVarga, EstebanRock, EstebanKids);

					PiroskaKids.add(EstebanRockVarga);

						
						Node SteveRock = new Node("Steve Rock Rech", EstebanRockVarga, null, null);

						EstebanKids.add(SteveRock);

						

						LinkedList<Node> PriscaKids = new LinkedList<>();

						Node PriscaRock = new Node("Prisca Rock Rech", EstebanRockVarga, null, PriscaKids);

						EstebanKids.add(PriscaRock);

							

							LinkedList<Node> AleKids = new LinkedList<>();

							Node AlejandraContrerasRock = new Node("Alejandra Contreras Rock", PriscaRock, null, null);

							PriscaKids.add(AlejandraContrerasRock);

							

								Node IsabelaLealContreras = new Node("Isabela Leal Contreras", AlejandraContrerasRock, null, null);

								AleKids.add(IsabelaLealContreras);

								

								Node SantiagoLealContreras = new Node("Santiago Leal Contreras", AlejandraContrerasRock, null, null);

								AleKids.add(SantiagoLealContreras);

							

							Node AndresContrerasRock = new Node("Andres Contreras Rock", PriscaRock, null, null);

							PriscaKids.add(AndresContrerasRock);

							

							Node CatyContrerasRock = new Node("Caty Contreras Rock", PriscaRock, null, null);

							PriscaKids.add(CatyContrerasRock);

												

						Node MaureenRock = new Node("Maureen Paty Rock Rech", EstebanRockVarga, null, null);

						EstebanKids.add(MaureenRock);

					



					LinkedList<Node> AnitaKids = new LinkedList<>();

					Node AnitaRockVarga = new Node("Anita Rock Varga", PiroskaVarga, EstebanRock, AnitaKids);

					PiroskaKids.add(AnitaRockVarga);

					

						Node ElisaEatonRock = new Node("Elisa Eaton Rock", AnitaRockVarga, null, null);

						AnitaKids.add(ElisaEatonRock);

					
						LinkedList<Node> BradfordKids = new LinkedList<>();
						Node BradfordEatonRock = new Node("Bradford Eaton Rock", AnitaRockVarga, null, BradfordKids);

						AnitaKids.add(BradfordEatonRock);
							
							Node BarbaraEaton = new Node("BarbaraEaton", null, BradfordEatonRock, null);

							BradfordKids.add(BarbaraEaton);

							



					

						LinkedList<Node> SharonKids = new LinkedList<>();

						Node SharonEatonRock = new Node("Sharon Eaton Rock", AnitaRockVarga, null, SharonKids);

						AnitaKids.add(SharonEatonRock);
							
							Node DanielEaton = new Node("DanielEaton", SharonEatonRock, null, null);

							SharonKids.add(DanielEaton);

							

							Node EricEaton = new Node("EricEaton", SharonEatonRock, null, null);

							SharonKids.add(EricEaton);

							



	



					

					

					Node CatarinaRockVarga = new Node("Catarina Rock Varga", PiroskaVarga, EstebanRock, CatyKids);

					PiroskaKids.add(CatarinaRockVarga);

		

						Node AnaIsabelSacristan = new Node("Ana Isabel Sacristan Sacristan", CatarinaRockVarga, Emilio, null);

						CatyKids.add(AnaIsabelSacristan);

						

						LinkedList<Node>Emilio2Kids = new LinkedList<>();

						Node Emilio2 = new Node("Emilio Sacristan Rock", CatarinaRockVarga, Emilio, Emilio2Kids);

						CatyKids.add(Emilio2);

							

							Node AriSacristan = new Node("Ari Sacristan Benjet", null, Emilio2, null);
							Emilio2Kids.add(AriSacristan);

							Node CarmenSacristan = new Node("Maria del Carmen Sacristan Benjet", null, Emilio2, null);

							Emilio2Kids.add(CarmenSacristan);
							this.me = CarmenSacristan;

						

						LinkedList<Node> Caty2Kids = new LinkedList<>();

						Node CatarinaSacristan = new Node("Catarina Sacristan Rock", CatarinaRockVarga, Emilio, Caty2Kids);

						CatyKids.add(CatarinaSacristan);

							

							Node EmiliaRyanSacristan = new Node("Emilia Ryan Sacristan", CatarinaSacristan, null, null);

							Caty2Kids.add(EmiliaRyanSacristan);

					

					LinkedList<Node> AliciaKids = new LinkedList<>();

					Node AliciaRockVarga = new Node("Alicia Rock Varga", PiroskaVarga, EstebanRock, AliciaKids);

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
