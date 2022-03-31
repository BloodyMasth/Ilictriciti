/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
import java.util.Vector;

public class Pile <T> {
	
////// ATTRIBUTS	
	
	private Vector <T> table;
	
////// CONSTRUCTEURS	
	
	Pile (){
		this.table = new Vector<T>();
	}
	
///// METHODES
	
	void Empile (T x){
		this.table.add(this.table.size(), x);
	}
	
	T SommetPile(){
		return this.table.elementAt(this.table.size()-1);
	}
	
	void Depile(){
		this.table.remove(this.table.size()-1);
	}
	
	int Taille() {
		return this.table.size();
	}

}













