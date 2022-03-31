/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
public class main {

	public static Echequier create_tab(int [][] tab) {
		/*
		 * Fonction qui créer un objet de type echequier (plateau de resolution)
		*/
		Echequier game = new Echequier();
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				if (tab[i][j] != 0) {
					game.set(i, j, tab[i][j]);
				}
			}
		}
		return game;
	}
	
	public static int[] get_pos_source(int [][] tab) {
		/*
		 * Fonction qui recup la position de la source de lumière
		*/
		int [] r = new int[2];
		
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				if (tab[i][j] == -2) {
					r[0] = i;
					r[1] = j;
				}
			}
		}		
		
		return r;
	} 
	
	public static void back_track(int [][] tab) {
		/*
		 * Fonction qui va réaliser la résolution du paterne récupérer
		*/
		Pile <Euler> Pile = new Pile<Euler>();
		int i = get_pos_source(tab)[0],j = get_pos_source(tab)[1], found = 0;
		
		Euler coupPrecedent;
		int  choixPrecedent, nouveauChoix, numeroCoup;

		Echequier jeu=create_tab(tab);
		//jeu.affiche();
		choixPrecedent=0;
		numeroCoup=1;
		
		while (true){   
			
			nouveauChoix = jeu.choixSuivantPossible(i, j, choixPrecedent); 
			
			if (nouveauChoix!=-1){ 						
				Pile.Empile(new Euler(i,j,nouveauChoix)); 
				switch (nouveauChoix) {
				case 1:
					jeu.set(i+1, j,10);
					jeu.set(i+2, j,10);
					if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 16);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 17);}
					i=i+3;
					break;
				case 2:
					jeu.set(i+1, j,10);
					if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 16);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 17);}
					i=i+2;
					break;
				case 3:
					jeu.set(i+1, j,10);
					jeu.set(i+2, j,14);
					if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 16);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 17);}
					i=i+2;
					j=j+1;
					break;
				case 4:
					jeu.set(i+1, j,10);
					jeu.set(i+2, j,15);
					if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 16);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 17);}
					i=i+2;
					j=j-1;
					break;
					
					
				case 5:
					jeu.set(i, j+1,11);
					jeu.set(i, j+2,11);
					if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 14);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 17);}
					j=j+3;
					break;
				case 6:
					jeu.set(i, j+1,11);
					if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 14);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 17);}
					j=j+2;
					break;
				case 7:
					jeu.set(i, j+1,11);
					jeu.set(i, j+2,12);
					if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 17);}
					i=i+1;
					j=j+2;
					break;
				case 8:
					jeu.set(i, j+1,11);
					jeu.set(i, j+2,13);
					if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 17);}
					i=i-1;
					j=j+2;
					break;
					
					
				case 9:
					jeu.set(i-1, j,10);
					jeu.set(i-2, j,10);
					if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 15);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 14);}
					i=i-3;
					break;
				case 10:
					jeu.set(i-1, j,10);
					if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 15);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 14);}
					i=i-2;
					break;
				case 11:
					jeu.set(i-1, j,10);
					jeu.set(i-2, j,16);
					if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 15);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 14);}
					i=i-2;
					j=j-1;
					break;
				case 12:
					jeu.set(i-1, j,10);
					jeu.set(i-2, j,17);
					if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 10);}
					else if (jeu.get(i, j-1) == 11) {jeu.set(i, j, 15);}
					else if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 14);}
					i=i-2;
					j=j+1;
					break;
					
					
				case 13:
					jeu.set(i, j-1,11);
					jeu.set(i, j-2,11);
					if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 15);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 12);}
					j=j-3;
					break;
				case 14:
					jeu.set(i, j-1,11);
					if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i-1, j) == 10) {jeu.set(i, j, 15);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 12);}
					j=j-2;
					break;
				case 15:
					jeu.set(i, j-1,11);
					jeu.set(i, j-2,14);
					if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 12);}
					i=i-1;
					j=j-2;
					break;
				case 16:
					jeu.set(i, j-1,11);
					jeu.set(i, j-2,17);
					if (jeu.get(i, j+1) == 11) {jeu.set(i, j, 11);}
					else if (jeu.get(i+1, j) == 10) {jeu.set(i, j, 12);}
					i=i+1;
					j=j-2;
					break;
			}
				numeroCoup=numeroCoup+1;
				if (jeu.get(i, j) == -3) {
					found = 1;
					break;
				}
				//jeu.set(i, j,1);					
				choixPrecedent=0;		
				//jeu.affiche();
			}
			else { 	
				//System.out.println("DEPILE");
				coupPrecedent = Pile.SommetPile();			
				Pile.Depile();								
				jeu.reset(i,j);                        
				i=coupPrecedent.posPrecedentX;
				j=coupPrecedent.posPrecedentY;			
				choixPrecedent=coupPrecedent.choixPrecedent; 
				numeroCoup=numeroCoup-1;						
			}
		}
		
		if (found == 1) {
			/*
			 * Si solution trouver envoie du nb de coup et du paterne de résolution dans interface
			*/
			//System.out.println("Calcul terminer");
			//System.out.println("Nombre de coups effectue : " + numeroCoup);
			Interface.showMessage(1, numeroCoup);
			Interface.recup_case(jeu);
		}
		
	}
	
	public static void reset_sol(Echequier jeu) {
		/*
		 * Fonction qui reset la résolution en enlevant tout les cables éléctriques
		*/
		for (int i=0;i<8;i++){
			for (int j=0; j<8;j++){
				
				if (jeu.get(i,j) == 10 || jeu.get(i,j) == 11 || jeu.get(i,j) == 12 || jeu.get(i,j) == 13 || jeu.get(i,j) == 14 || jeu.get(i,j) == 15 || jeu.get(i,j) == 16 || jeu.get(i,j) == 17) {
					jeu.reset(i,j);
				}
			}
		}
		Interface.recup_case(jeu);
	}
	
	public static void main(String[] args) {
		/*
		 * Fonction main qui créer l'interface
		*/
		Interface gui = new Interface();
		gui.run();
	}

}
