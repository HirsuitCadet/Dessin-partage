import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class PanelDessin extends JPanel implements ActionListener{

    Controleur ctrl;

    JPanel panelBoutonsCouleur;

    PanelMilieu panelMilieu;

    JPanel panelBoutonsFonctions;

    String formeActuelle;
    Color  couleurActuelle;

    JButton[] boutonsFonctions = new JButton[6];
    JButton[] boutonsCouleurs   = new JButton[6];

    public PanelDessin(Controleur controleur){

        ctrl = controleur;
        formeActuelle = "";
        couleurActuelle = Color.BLACK;

        this.setLayout(new BorderLayout());

        panelBoutonsFonctions = new JPanel();
        panelBoutonsFonctions.setLayout(new GridLayout(1,6));

        panelMilieu = new PanelMilieu(ctrl);

        panelBoutonsCouleur = new JPanel();
        panelBoutonsCouleur.setLayout(new GridLayout(1,6));

        //Création des boutons
        boutonsFonctions[0] = new JButton("Carré");
        boutonsFonctions[1] = new JButton("Rond");
        boutonsFonctions[2] = new JButton("Ligne");
        boutonsFonctions[3] = new JButton("Texte");
        boutonsFonctions[4] = new JButton("Retour");
        boutonsFonctions[5] = new JButton("Remplir");

        for(int i=0; i<boutonsCouleurs.length; i++){
            boutonsCouleurs[i] = new JButton();
        }

        boutonsCouleurs[0].setBackground(java.awt.Color.RED);
        boutonsCouleurs[1].setBackground(java.awt.Color.BLUE);
        boutonsCouleurs[2].setBackground(java.awt.Color.GREEN);
        boutonsCouleurs[3].setBackground(java.awt.Color.YELLOW);
        boutonsCouleurs[4].setBackground(java.awt.Color.BLACK);
        boutonsCouleurs[5].setBackground(java.awt.Color.WHITE);

        for (JButton btn : boutonsCouleurs) {

            btn.setPreferredSize(new Dimension(btn.getPreferredSize().width, 30));
        }

        //Ajout des boutons au panel
        for(int i=0; i<boutonsFonctions.length; i++){
            panelBoutonsFonctions.add(boutonsFonctions[i], BorderLayout.NORTH);
        }

        for(int i=0; i<boutonsCouleurs.length; i++){
            panelBoutonsCouleur.add(boutonsCouleurs[i], BorderLayout.SOUTH);
        }

        //Ajout des listeners
        for(JButton btn : boutonsFonctions){
            btn.addActionListener(this);
        }

        for(JButton btn : boutonsCouleurs){
            btn.addActionListener(this);
        }

        this.add(panelBoutonsFonctions, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
        this.add(panelBoutonsCouleur, BorderLayout.SOUTH);
    }

    public String getFormeActuelle(){
        return formeActuelle;
    }

    public Color getCouleurActuelle(){
        return couleurActuelle;}

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton btn : boutonsFonctions){
            if(e.getSource() == btn){
                formeActuelle = btn.getText();
                System.out.println("Forme actuelle : " + formeActuelle);
            }
        }

        for(JButton btn : boutonsCouleurs){
            if(e.getSource() == btn){
               couleurActuelle = btn.getBackground();
               System.out.println("Couleur actuelle : " + couleurActuelle);
            }
        }
    }

    public PanelMilieu getPanelMilieu() {
        return panelMilieu;
    }
    

}
