/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
public class Echequier {
	
/////////   ATTRIBUTS	
	
	private int [][] plateau;
	private int nbCaseOccupe;
	
	
////////   CONSTRUCTEURS	
	
	Echequier(){
		int i,j;
		plateau = new int [14][14] ;
		
		nbCaseOccupe=0;
		
		for (i=3;i<11;i++){
			for (j=3; j<11;j++){
				plateau [i][j] =0;
			}
		}
		
		for (j=0;j<14;j++){
			plateau [0][j] =-1;
			plateau [1][j] =-1;
			plateau [2][j] =-1;
			plateau [11][j] =-1;
			plateau [12][j] =-1;
			plateau [13][j] =-1;
		};
		for (i=0;i<14;i++){
			plateau [i][0] =-1;
			plateau [i][1] =-1;
			plateau [i][2] =-1;
			plateau [i][11] =-1;
			plateau [i][12] =-1;
			plateau [i][13] =-1;
		}
		
	}
	
//////   METHODES
	
	// D�finition d'un �l�ment de l'echequier
	void set(int i, int j, int val){
		this.plateau[i+3][j+3] = val;
		this.nbCaseOccupe=this.nbCaseOccupe+1;
	}
	
	// R�cup�rer valeur d'une case
	int get(int i, int j){
		return this.plateau[i+3][j+3];
	}
	
	// Remise � 0 d'un �l�ment de l'echequier
	void reset (int i, int j){
		this.plateau[i+3][j+3] = 0;
		this.nbCaseOccupe=this.nbCaseOccupe-1;
	}
	
	// Renvoie True si toutes les cases sont occup�s
	boolean fini(){
		return this.nbCaseOccupe==64;
	};
	
	
	
	// Fonction permettant de regarder les choix possibles
	int choixSuivantPossible(int ii, int jj, int choixPrecedent){
		int i,j;
		i=ii+3; j=jj+3;
		
			switch(choixPrecedent) {
				case 0:
					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+3][j] == -3) return 1;
						else if (plateau [i+2][j] == -3) return 2;
						else if (plateau [i+2][j+1] == -3) return 3;
						else if (plateau [i+2][j-1] == -3) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == -3) return 5;
						else if (plateau [i][j+2] == -3) return 6;
						else if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+3][j] == 0) return 1;
						if (plateau [i+2][j] == 0) return 2;
						if (plateau [i+2][j+1] == 0) return 3;
						if (plateau [i+2][j-1] == 0) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == 0) return 5;
						if (plateau [i][j+2] == 0) return 6;
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------
				case 1:
					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+2][j] == -3) return 2;
						else if (plateau [i+2][j+1] == -3) return 3;
						else if (plateau [i+2][j-1] == -3) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == -3) return 5;
						else if (plateau [i][j+2] == -3) return 6;
						else if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+2][j] == 0) return 2;
						if (plateau [i+2][j+1] == 0) return 3;
						if (plateau [i+2][j-1] == 0) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == 0) return 5;
						if (plateau [i][j+2] == 0) return 6;
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------
				case 2:
					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+2][j+1] == -3) return 3;
						else if (plateau [i+2][j-1] == -3) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == -3) return 5;
						else if (plateau [i][j+2] == -3) return 6;
						else if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+2][j+1] == 0) return 3;
						if (plateau [i+2][j-1] == 0) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == 0) return 5;
						if (plateau [i][j+2] == 0) return 6;
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------
				case 3:
					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+2][j-1] == -3) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == -3) return 5;
						else if (plateau [i][j+2] == -3) return 6;
						else if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i+1][j] == 0 && plateau [i+2][j] == 0) {
						if (plateau [i+2][j-1] == 0) return 4;
					}
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == 0) return 5;
						if (plateau [i][j+2] == 0) return 6;
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------					
				case 4:
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == -3) return 5;
						else if (plateau [i][j+2] == -3) return 6;
						else if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+3] == 0) return 5;
						if (plateau [i][j+2] == 0) return 6;
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------					
				case 5:	
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+2] == -3) return 6;
						else if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i][j+2] == 0) return 6;
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------					
				case 6:	
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i+1][j+2] == -3) return 7;
						else if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i+1][j+2] == 0) return 7;
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
//-------------------------------------------------------------------------------					
				case 7:	
					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i-1][j+2] == -3) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j+1] == 0 && plateau [i][j+2] == 0) {
						if (plateau [i-1][j+2] == 0) return 8;
					}
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 8:	
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == -3) return 9;
						else if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-3][j] == 0) return 9;
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 9:
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-2][j] == -3) return 10;
						else if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-2][j] == 0) return 10;
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 10:
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-2][j-1] == -3) return 11;
						else if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-2][j-1] == 0) return 11;
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 11:
					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-2][j+1] == -3) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i-1][j] == 0 && plateau [i-2][j] == 0) {
						if (plateau [i-2][j+1] == 0) return 12;
					}
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 12:
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == -3) return 13;
						else if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-3] == 0) return 13;
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 13:
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-2] == -3) return 14;
						else if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i][j-2] == 0) return 14;
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 14:
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i-1][j-2] == -3) return 15;
						else if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i-1][j-2] == 0) return 15;
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 15:
					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i+1][j+2] == -3) return 16;
					}
					

					if (plateau [i][j-1] == 0 && plateau [i][j-2] == 0) {
						if (plateau [i+1][j+2] == 0) return 16;
					}
					break;
				case 16:
					return -1;	 
		}
	

		return -1;
	}
	
	// Fonction permettant d'afficher l'echequier en temps r�el
	void affiche(){
		int i,j;
		for (i=3;i<11;i++){
			for (j=3; j<11;j++){
				if (plateau [i][j]<11)
				System.out.print(" "+plateau [i][j]+" ");
				else System.out.print(plateau [i][j]+" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
}
