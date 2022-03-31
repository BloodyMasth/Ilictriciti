import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
public class manipFold {
	/*
	 * Classe qui permet manipuler des fichier texte
	*/
	//Création de l'objet file avec pour path exemple.txt
	static File file = new File("src/exemple.txt");
	
    public static void main(String[] args){
    //TODO code application logic here
    	//Check si le fichier est existant
    	if(!file.exists()) {
    		try {
    			file.createNewFile();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public static void write_file(int [][] tableau_entre) {
    	/*
    	 * Fonction qui permet de stocker une matrice de 2 dimension dans un fichier texte
    	*/
    	try {
			FileWriter writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			int i,j;
			for (i=0;i<8;i++){
				for (j=0; j<8;j++){
					bw.write(Integer.toString(tableau_entre [i][j]) + " ");
				}
				//System.out.println(" ");
				bw.newLine();
		    }
			bw.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static int[][] read_file(File file) {
    	/*
    	 * Fonction qui permet de lire et récupérer une matrice 2 dimension stocké dans un fichier texte
    	*/
    	int [][] tableau = new int [8][8];
    	try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = reader.readLine();
			String[] splited_line = line.split(" ");
			int i,j;

			while(line != null) {
				//System.out.println(line);
				for (i=0;i<8;i++){
					for (j=0; j<8;j++){
						tableau [i][j] = Integer.parseInt(splited_line[j]);
						//System.out.print(" "+tableau [i][j]+" ");
					}
					//System.out.println(" ");
					line = reader.readLine();
					if(line != null) {
						splited_line = line.split(" ");
			    	}
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return tableau;
    }
}