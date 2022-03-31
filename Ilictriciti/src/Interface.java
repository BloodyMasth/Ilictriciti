/*
 *Ouriet Mathys / Damien Lagrange
 *Projet Java 1404
 *31/03/2022 
*/
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



class Interface implements ActionListener{
	/*
	 * Creation des frames, objet JFrame
	*/
	static JFrame frame_intro = new JFrame("Ilictriciti");
	JButton button_home = new JButton("Lancer le jeu");
	static JFrame frame = new JFrame("Ilictriciti");
	JButton button_start = new JButton("Resoudre");
	JButton button_reset = new JButton("Reset la solution");
	JMenuItem file_open = new JMenuItem("Ouvrir");
	JMenuItem file_save = new JMenuItem("Sauvegarder");
	/*
	 * Initialisation des listes et variables 
	*/
	List<Object> sourceList = new ArrayList<Object>();
	List<Integer> timeList = new ArrayList<Integer>();
	static List<createTuple> coordList = new ArrayList<createTuple>();
	static List<JButton> buttonList = new ArrayList<JButton>();
	createTuple monTuple;
	int width = 8; int length = 8 ; int button_lenght = 50;
	static int [][] tab = new int [8][8];
	int [][] tab_to_start = new int [8][8];
	static JLabel jLabel_Title = new JLabel();
	static JLabel jLabel_text = new JLabel();
	static JLabel jLabel_text2 = new JLabel();
	
	
	public void run () {	
		/*
		 * Fonction qui creer les frames 
		*/
		//Frame d'acceuil
		URL iconURL = getClass().getResource("/ressources/ampoule.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame_intro.setIconImage(icon.getImage()); 
		frame_intro.setSize(800, 600);
		frame_intro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame_intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_intro.setLocationRelativeTo(null);
		frame_intro.setVisible(true);
		frame.setVisible(false);
		frame_intro.setLayout(null);
		show_frame_home();
		//Frame principale
		frame.setIconImage(icon.getImage()); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setResizable(false);
		menu_bar();
		button (frame, width, length, button_lenght);
		legende_bar(frame);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	}
	
	public void show_frame_home() {
		/*
		 * Fonction qui met en place les elements visuelle de la page d'acceuil 
		*/
		//Bouton du milien
		button_home.setBounds(300, 225, 200, 100);
		button_home.setBackground(Color.WHITE);
		frame_intro.add(button_home);
		button_home.addActionListener(this);
		//Label de la fenetre
		JLabel jLabel_text = new JLabel("Projet réaliser par :");
		JLabel jLabel_text2 = new JLabel("Mathys Ouriet et Damien Lagrange");
		JLabel jLabel_text3 = new JLabel("UE Inf 1404");
		JLabel jLabel_text4 = new JLabel("Bienvenue sur");
		JLabel jLabel_text5 = new JLabel("Ilictriciti");
		//Police et taille des labels 
		Font jLabel_textFont = jLabel_text.getFont();
		jLabel_text.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 16));
		jLabel_text2.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 16));
		jLabel_text3.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 16));
		jLabel_text4.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 20));
		jLabel_text5.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 20));
		//Placement des labels
        jLabel_text.setBounds(10, 490, 250, 50);
        jLabel_text2.setBounds(10, 510, 300, 50);
        jLabel_text3.setBounds(675, 510, 300, 50);
        jLabel_text4.setBounds(330, 150, 300, 50);
        jLabel_text5.setBounds(360, 175, 300, 50);
        //Ajout des labels à la frame
        frame_intro.add(jLabel_text);
        frame_intro.add(jLabel_text2);
        frame_intro.add(jLabel_text3);
        frame_intro.add(jLabel_text4);
        frame_intro.add(jLabel_text5);
        //Update des composant graphique
        SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void button(JFrame frame, int width, int length, int button_lenght){
		/*
		 * Fonction qui creer et affiche la grille de button dans la frame 
		*/
		int x_pos = 50;
		int y_pos = 50;
		for(int x=0; x<length; x++){
			for(int y=0; y<width; y++){
				//création du bouton
				JButton button_grid = new JButton("("+x+y+")"); 
				//placement du bouton carré, position x et y taille longueur et largeur 
				button_grid.setBounds(x_pos, y_pos, button_lenght, button_lenght);
				try {
					//chargement de l'image situé dans le dossier ressources
					Image img = ImageIO.read(getClass().getResource("/ressources/blanc.png"));
					//mise de l'image dans le bouton
					button_grid.setIcon(new ImageIcon(img));
				}catch (Exception ex) {
					 //si erreur afficher erreur
				    System.out.println(ex);
				}

				createTuple button_coord = new createTuple(x,y);
				coordList.add(button_coord);
				buttonList.add(button_grid);
				//ajout du bouton dans la frame initialiser plus tôt
		        frame.add(button_grid);

		        button_grid.addActionListener(this);
		        x_pos = x_pos + button_lenght;
			}

			y_pos = y_pos + button_lenght;
			x_pos = 50;
			
		}
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
    	/*
    	 * Fonction appeler lorsqu'un des boutons enregistrer est appuyé
    	*/
    	Object source = e.getSource();
    	boolean isEmpty = true;
    	int time = 0;
    	int index = 0;
    	int i,j;
    	//Bouton start resolution de la grille
    	if(source == button_start) {
    		showMessage(0,0);
    		for (i=0;i<8;i++){
				for (j=0; j<8;j++){
					//System.out.print(tab_to_start [i][j]);
					if(tab_to_start [i][j] !=0) {
						isEmpty = false;
			    	}
				}
				//System.out.println(" ");
			}
    		//System.out.println(isEmpty);
    		if(isEmpty == true) {
    			tab_to_start = send_case(); 
    		}
    		//int value = valide_schema(tab_to_start);
    		//System.out.println(value);
    		/*for (i=0;i<8;i++){
				for (j=0; j<8;j++){
					System.out.print(" " + tab_to_start [i][j] + " ");
				}
				System.out.println(" ");
			}*/
    		if (valide_schema(tab_to_start) == 0) {
                main.back_track(tab_to_start);
    		}
    		for (i=0;i<8;i++){
				for (j=0; j<8;j++){
					tab_to_start [i][j]=0;
				}
			}
    	}
    	//Bouton de reset de la résolution de la grille
    	else if(source == button_reset) {
    		showMessage(0,0);
            main.reset_sol(main.create_tab(send_case()));
    	}
    	else if(source == button_home){
    		frame_intro.setVisible(false);
    		frame.setVisible(true);
    	}
    	//Bouton dans le menu pour ouvrir un fichier
    	else if(source == file_open){
    		int [][] tableau_sortie = new int [8][8];
    		JFileChooser chooser = new JFileChooser();
    		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files", "txt");
    		chooser.setFileFilter(filter);
    		int returnVal = chooser.showOpenDialog(chooser);
    		if(returnVal == JFileChooser.APPROVE_OPTION) {
    			//System.out.println(chooser.getSelectedFile().getName());
    			tableau_sortie = manipFold.read_file(chooser.getSelectedFile());
    			show_case(tableau_sortie);
    			tab_to_start = tableau_sortie;
    		}
    	} 
    	//Bouton dans le menu pour sauvegarder le parterne de la grille
    	else if(source == file_save){
    		int [][] tableau_entre = new int [8][8];
    		tableau_entre = send_case();
    		manipFold.write_file(tableau_entre);
    	}
    	//Grille de bouton
    	else {
    		try {
    			if(!sourceList.contains(source)) {
    				sourceList.add(source);
    				timeList.add(time);
    				index = sourceList.indexOf(source);
					if(timeList.get(index) == 0) {
						set_button_to_black(source, index);
					}
					else if(timeList.get(index) == -1) {
						set_button_to_yellow(source, index);
					}
					else if(timeList.get(index) == -3) {
						set_button_to_green(source, index);
					}
					else if(timeList.get(index) == -2) {
						set_button_to_white(source, index);
					}
				}
					
				else {
	    			index = sourceList.indexOf(source);
					if(timeList.get(index) == 0) {
						set_button_to_black(source, index);
					}
					else if(timeList.get(index) == -1) {
						set_button_to_yellow(source, index);
					}
					else if(timeList.get(index) == -3) {
						set_button_to_green(source, index);
					}
					else if(timeList.get(index) == -2) {
						set_button_to_white(source, index);
					}
				}
				
			
			} catch (Exception ex) {
			    System.out.println(ex);
			}
    	}
    }
    
    /*
     * Blanc -> 0
     * Noir -> -1
     * Vert -> -2
     * Jaune -> -3 
    */

    
	private void set_button_to_black(Object source, int index) {
		/*
    	 * Fonction qui met la couleur noir dans le bouton et incrémente l'état du bouton
    	*/
		Image img;
		try {
			img = ImageIO.read(getClass().getResource("/ressources/noir.png"));
			((AbstractButton) source).setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		timeList.set(index, -1);
	}
	
	
	private void set_button_to_yellow(Object source, int index) {
		/*
    	 * Fonction qui met la couleur jaune dans le bouton et incrémente l'état du bouton
    	*/
		Image img;
		try {
			img = ImageIO.read(getClass().getResource("/ressources/jaune.png"));
			((AbstractButton) source).setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		timeList.set(index, -3);
	}
	
	private void set_button_to_green(Object source, int index) {
		/*
    	 * Fonction qui met la couleur vert dans le bouton et incrémente l'état du bouton
    	*/
		Image img;
		try {
			img = ImageIO.read(getClass().getResource("/ressources/vert.png"));
			((AbstractButton) source).setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		timeList.set(index, -2);
	}
	
	
	private void set_button_to_white(Object source, int index) {
		/*
    	 * Fonction qui met la couleur blanc dans le bouton et incrémente l'état du bouton
    	*/
		Image img;
		try {
			img = ImageIO.read(getClass().getResource("/ressources/blanc.png"));
			((AbstractButton) source).setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		timeList.set(index, 0);
	}
	
	
	public void legende_bar(JFrame frame) {
		/*
    	 * Fonction qui gere l'affichage de la legende a coté de la grille de bouton
    	*/
		//Les carrés de couleurs + legende associer
		Image img;
		try {
			img = ImageIO.read(getClass().getResource("/ressources/blanc.png"));
			JLabel jLabel_color = new JLabel();
			JLabel jLabel_text = new JLabel("Case Vide");
			jLabel_color.setIcon(new ImageIcon(img));
			jLabel_color.setBounds(525, 50, 50, 50);
			jLabel_text.setBounds(520, 85, 100, 50);
	        frame.add(jLabel_color);
	        frame.add(jLabel_text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			img = ImageIO.read(getClass().getResource("/ressources/noir.png"));
			JLabel jLabel = new JLabel();
			JLabel jLabel_text = new JLabel("Obstacle");
	        jLabel.setIcon(new ImageIcon(img));
	        jLabel.setBounds(525, 150, 50, 50);
	        jLabel_text.setBounds(525, 185, 100, 50);
	        frame.add(jLabel);
	        frame.add(jLabel_text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			img = ImageIO.read(getClass().getResource("/ressources/jaune.png"));
			JLabel jLabel = new JLabel();
			JLabel jLabel_text = new JLabel("Lumière à allumer");
	        jLabel.setIcon(new ImageIcon(img));
	        jLabel.setBounds(625, 50, 50, 50);
	        jLabel_text.setBounds(600, 85, 150, 50);
	        frame.add(jLabel);
	        frame.add(jLabel_text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			img = ImageIO.read(getClass().getResource("/ressources/vert.png"));
			JLabel jLabel = new JLabel();
			JLabel jLabel_text = new JLabel("Source de lumière");
	        jLabel.setIcon(new ImageIcon(img));
	        jLabel.setBounds(625, 150, 50, 50);
	        jLabel_text.setBounds(600, 185, 150, 50);
	        frame.add(jLabel);
	        frame.add(jLabel_text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			img = ImageIO.read(getClass().getResource("/ressources/gris.png"));
			JLabel jLabel = new JLabel();
			JLabel jLabel_text = new JLabel("Cable conducteur");
	        jLabel.setIcon(new ImageIcon(img));
	        jLabel.setBounds(500, 325, 50, 50);
	        jLabel_text.setBounds(570, 325, 150, 50);
	        frame.add(jLabel);
	        frame.add(jLabel_text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Les boutons start et reset
		try {
			button_start.setBounds(75, 470, 150, 50);
			button_start.setBackground(Color.WHITE);
			button_start.setBorder(new RoundedBorder(20));
			button_start.addActionListener(this);
	        frame.add(button_start);
		}catch (Exception ex) {
		    System.out.println(ex);
		}	
		
		try {
			button_reset.setBounds(275, 470, 150, 50);
			button_reset.addActionListener(this);
			button_reset.setBackground(Color.WHITE);
			button_reset.setBorder(new RoundedBorder(20));
	        frame.add(button_reset);
		}catch (Exception ex) {
		    System.out.println(ex);
		}	
	}
	
	public void menu_bar() {
		/*
    	 * Fonction qui gere la bar de menu avec les boutons open et save
    	*/
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Fichier");

		menu.add(file_open);
		menu.add(file_save);
		menubar.add(menu);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		frame.setJMenuBar(menubar);
	}
	
	public int[][] send_case() {
		/*
    	 * Fonction qui récupere l'état des boutons de la grille pour les stockés dans un tableau de 8x8 et return le tableau
    	*/
		int [][] send_tab = new int [8][8];
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				send_tab[i][j] = 0;
			}
		}
		for(int i=0; i<sourceList.size(); i++){
			if(buttonList.contains(sourceList.get(i))) {
				int etat = timeList.get(i);
				int index_button = buttonList.indexOf(sourceList.get(i));
				createTuple couple = coordList.get(index_button);
				send_tab[couple.getCoordX()][couple.getCoordY()] = etat;
			}
		}
		return send_tab;
	}
	
	private static void set_color_button(String color, JButton button) {
		/*
		 * Fonction qui set la couleur des boutons 
		*/
		try {
			Image img;
			img = ImageIO.read(Interface.class.getResource("/ressources/" +  color + ".png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void show_case(int[][]  tableau) {
		/*
		 * Fonction qui affiche le parterne de boutons en fonction de l'état récuperer après la résolution
		*/
		int etat = 9;
		JButton button = null;
		for(int x=0; x<8; x++){
			for(int y=0; y<8; y++){
				for(int z=0; z<coordList.size(); z++) {
					if(x==coordList.get(z).getCoordX() && y == coordList.get(z).getCoordY()) {
						etat = tableau[x][y];
						//System.out.println("x "+x+" y "+y+" etat "+etat);
						button = buttonList.get(z);
					}
					if (etat == 1) {
						set_color_button("gris", button);
					} else if (etat == -1) {
						set_color_button("noir", button);
					} else if (etat == -2) {
						set_color_button("vert", button);
					} else if (etat == -3) {
						set_color_button("jaune", button);
					} else if (etat == 0) {
						set_color_button("blanc", button);
					} else if (etat == 10) {
						set_color_button("cableDroitVertical", button);
					} else if (etat == 11) {
						set_color_button("cableDroitHorizontal", button);
					} else if (etat == 12) {
						set_color_button("coudeGaucheBas", button);
					} else if (etat == 13) {
						set_color_button("coudeHautGauche", button);
					} else if (etat == 14) {
						set_color_button("coudeHautDroite", button);
					} else if (etat == 15) {
						set_color_button("coudeGaucheHaut", button);
					} else if (etat == 16) {
						set_color_button("coudeGaucheBas", button);
					} else if (etat == 17) {
						set_color_button("coudeBasDroite", button);
					}
				}
			}
		}
	}

	public static void recup_case(Echequier jeu) {
		// TODO Auto-generated method stub
		/*
		 * Fonction qui recupere la matrice de 8x8 après résolution du paterne
		*/
		int [][] tableau = new int [8][8];
		int i,j;
		for (i=0;i<8;i++){
			for (j=0; j<8;j++){
				tableau[i][j]=jeu.get(i,j);
				//System.out.print(" "+tableau [i][j]+" ");
			}
			//System.out.println(" ");
		}
		show_case(tableau);
	}
	
	private int valide_schema(int [][] tab) {
		/*
		 * Fonction qui vérifie que le paterne envoyer à résoudre est valide et traite les différentes erreur
		*/
		boolean generator = false, light = false;
		for (int i=0;i<8;i++) {
			for (int j=0; j<8;j++) {
				if (tab[i][j] == -2) {
					if (generator == true) {
						showMessage(2,0);
						return 1;
					} else {
						generator = true;
						if (tab[i+1][j] == -1 && tab[i-1][j] == -1 && tab[i][j-1] == -1 && tab[i][j+1] == -1) {
							showMessage(6,0);
							return 1;
						}
						;
						if (tab[i+1][j] == -3 || tab[i-1][j] == -3 || tab[i][j-1] == -3 || tab[i][j+1] == -3) {
							showMessage(7,0);
							return 1;
						}
					}
				} else if (tab[i][j] == -3) {
					if (light == true) {
						showMessage(3,0);
						return 1;
					} else {
						light = true;
					}
				}
			}
			
		}
		if (!generator) {
			showMessage(4,0); 
			return 1;
		}
		if (!light) {
			showMessage(5,0); 
			return 1;
		}
		return 0;
		
		
	}
	
	public static void showMessage(int type, int numeroCoup) {
		/*
		 * Fonction qui affiche le message final (erreur ou réussite)
		*/
		if (type == 0) {
	        jLabel_Title.setVisible(false);
	        jLabel_text.setVisible(false);
	        jLabel_text2.setVisible(false);
		} else if (type == 1) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(true);
	        jLabel_Title.setText("Bravo !");
	        jLabel_text.setText("Chemin trouvé et affiché !");
	        jLabel_text2.setText("Nombre de coups : " + numeroCoup);
	        jLabel_Title.setForeground(new Color(0,153,0));
		} else if (type == 2) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(false);
	        jLabel_Title.setText("Erreur !");
	        jLabel_text.setText("Vous avez placé plusieurs source de lumière");
	        jLabel_Title.setForeground(Color.RED);
		} else if (type == 3) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(false);
	        jLabel_Title.setText("Erreur !");
	        jLabel_text.setText("Vous avez placé plusieurs lumière à allumer");
	        jLabel_Title.setForeground(Color.RED);
		} else if (type == 4) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(false);
	        jLabel_Title.setText("Erreur !");
	        jLabel_text.setText("Vous n'avez pas placé de source de lumière");
	        jLabel_Title.setForeground(Color.RED);
		} else if (type == 5) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(false);
	        jLabel_Title.setText("Erreur !");
	        jLabel_text.setText("Vous n'avez pas placé de lumière à allumer");
	        jLabel_Title.setForeground(Color.RED);
		} else if (type == 6) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(false);
	        jLabel_Title.setText("Erreur !");
	        jLabel_text.setText("Vous avez bloqué la source");
	        jLabel_Title.setForeground(Color.RED);
		} else if (type == 7) {
			jLabel_Title.setVisible(true);
	        jLabel_text.setVisible(true);
	        jLabel_text2.setVisible(false);
	        jLabel_Title.setText("Bravo !");
	        jLabel_text.setText("La lumière est déjà connécté !");
	        jLabel_Title.setForeground(new Color(0,153,0));
		}
		
        Font jLabel_textFont = jLabel_text.getFont();
        jLabel_Title.setFont(new Font(jLabel_textFont.getName(), Font.BOLD,  14));
        jLabel_text.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 12));
        jLabel_text2.setFont(new Font(jLabel_textFont.getName(), Font.BOLD, 12));
        jLabel_text2.setPreferredSize(new Dimension(350, 200));
        jLabel_Title.setBounds(520, 425, 150, 50);
        jLabel_text.setBounds(520, 445, 250, 50);
        jLabel_text2.setBounds(520, 465, 150, 50);
        frame.add(jLabel_Title);
        frame.add(jLabel_text);
        frame.add(jLabel_text2);
        SwingUtilities.updateComponentTreeUI(frame);
        
        
    }
}