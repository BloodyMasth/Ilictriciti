/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
import java.util.Calendar;


public class EulerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pile <Euler> P = new Pile<Euler>();
		int i,j;
		Euler coupPrecedent;
		Echequier jeu;
		int  choixPrecedent,nouveauChoix, numeroCoup;
		Calendar calDebut = Calendar.getInstance();
        Calendar calFin;
		
		System.out.print("Position Ligne ?=");
		i=Terminal.lireEntier();
		System.out.println("");
		System.out.print("Colonne ?=");
		j=Terminal.lireEntier();
		
		jeu=new Echequier();
		jeu.set(i, j, 1);
		jeu.affiche();
		choixPrecedent=0;
		numeroCoup=1;
		while (!jeu.fini()){    // le jeu est fini quand l'echiquier est plein
			
			nouveauChoix=jeu.choixSuivantPossible(i, j, choixPrecedent); 
														// cherche un nouveau deplacement
			
			if (nouveauChoix!=-1){ 						// il en existe un d�placement 
				P.Empile(new Euler(i,j,nouveauChoix)); 	//on empile de d�placement
				if (nouveauChoix==1){i=i-2;j=j+1;};  	// on va sur la nouvelle case 
				if (nouveauChoix==2){i=i-1;j=j+2;};
				if (nouveauChoix==3){i=i+1;j=j+2;};
				if (nouveauChoix==4){i=i+2;j=j+1;};
				if (nouveauChoix==5){i=i+2;j=j-1;};
				if (nouveauChoix==6){i=i+1;j=j-2;};
				if (nouveauChoix==7){i=i-1;j=j-2;};
				if (nouveauChoix==8){i=i-2;j=j-1;};
				numeroCoup=numeroCoup+1;						// on a fait un pas de plus
				jeu.set(i, j, numeroCoup);					// on marque l'echequier
				choixPrecedent=0;		
				//jeu.affiche();
				//System.out.println(" ");
				//iii=Terminal.lireEntier(); // on prepare le prochain coup
				
			}
			else { 										//depile
				coupPrecedent = P.SommetPile();			// on recupere le coup precedent
				P.Depile();								// on le supprime
				jeu.reset(i,j);                         // on libere l'echiquier
				i=coupPrecedent.posPrecedentX;
				j=coupPrecedent.posPrecedentY;			// on revient sur le case d'avant
				choixPrecedent=coupPrecedent.choixPrecedent; // on se replace dans le choix Precedent
				numeroCoup=numeroCoup-1;						// un coup de moins
			}
		}// while
		
		
		System.out.println("Fin");
		  calFin = Calendar.getInstance();
	        int tempsCalcul;
	        tempsCalcul = (calFin.get(Calendar.HOUR_OF_DAY)*60+calFin.get(Calendar.MINUTE))-(calDebut.get(Calendar.HOUR_OF_DAY)*60+calDebut.get(Calendar.MINUTE));
	        System.out.println("Calcul en "+tempsCalcul); 
		jeu.affiche();
	}
	
}
