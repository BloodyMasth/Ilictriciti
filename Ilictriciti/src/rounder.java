/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

class RoundedBorder implements Border {
	/*
	 * Classe qui permet d'arrondir les bords des boutons 
	 * Prend en attribus une valeur de raduis pour l'arrondis de l'angle 
	*/
	
/////////   ATTRIBUTS
    private int radius;

////////CONSTRUCTEURS	
    RoundedBorder(int radius) {
        this.radius = radius;
    }

//////METHODES
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
