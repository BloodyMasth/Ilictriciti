import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/


//Classe 'Terminal' --> pour faciliter les op�rations de saisies � 
//partir de l'entr�e  standard. 
public class Terminal {
 
 private static BufferedReader dis;
 
 
 /* Entr�es -------------------------------------------- */
 public static int lireEntier() {
     int Retour;
     try { 
         Retour = (new Integer(dis.readLine())).intValue();
     }
     catch (Exception e) {
         System.out.println("Entr�e d'entier incorrecte !");
         Retour = 0;
     }
     return Retour;
 }
 
 public static float lireReel() {
     float Retour;
     try { 
         Retour = (new Float(dis.readLine())).floatValue();
     }
     catch (Exception e) {
         System.out.println("Entr�e de r�el incorrecte !");
         Retour = 0;
     }
     return Retour;
 }
 
 
 public static char lireCar() {
     char Retour;
     try { // caract�re <=> 1er caract�re de la cha�ne lue... 
         Retour = (dis.readLine()).charAt(0);
     }
     catch (Exception e) {
         System.out.println("Entr�e de caract�re incorrecte !");
         Retour = 0;
     }
     return Retour;
 }
 
 public static String lireChaine() {
     String Retour;
     try { 
         Retour = dis.readLine();
     }
     catch (Exception e) {
         System.out.println("Entr�e de cha�ne incorrecte !");
         Retour = null;
     }
     return Retour;
 }
 
 /* Sorties -------------------------------------------- */
 public static void efface () {
     System.out.println("\u001b[2J"); 
 }
 
 // sortie format�e d'un entier 'i' avec 'n' caract�res 
 public static void ecrireEntierF(int i, int n) {
     String S = String.valueOf(i);
     int nbsp = n - S.length(); // nombre d'espaces � ajouter
     if (nbsp>0) for (int k=0; k<nbsp; k++) System.out.print(' '); 
     System.out.print(i);
 }


 static {
     try {
         dis = new BufferedReader(new InputStreamReader(System.in));
     } 
     catch (Exception e) {
         System.out.println("Erreur d'ouverture du terminal");
     }
 }


}









