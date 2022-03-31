/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
public class createTuple {
	/*
	 * Classe qui permet de créer un tuple (couple de coordonée)
	 * Elle prend en attribut un couple de coordoné X et Y
	*/
	
/////////   ATTRIBUTS	
		private int x;
		private int y;
		
////////CONSTRUCTEURS	
		createTuple(int x, int y){
			this.setCoordX(x);
			this.setCoordY(y);
		}

//////  METHODES
		//Permet de récuperer la coord X
		public int getCoordX() {
			return x;
		}

		//Permet de set la coord Y a la valeur de X
		public void setCoordX(int x) {
			this.x = x;
		}

		//Permet de récuperer la coord Y
		public int getCoordY() {
			return y;
		}

		//Permet de set la coord Y a la valeur de Y
		public void setCoordY(int y) {
			this.y = y;
		}
		
		//Permet de récuperer les coord X et Y
		public String getCoordXY() {
			String mavar = "("+x+y+")";
			return mavar;
		}

}


