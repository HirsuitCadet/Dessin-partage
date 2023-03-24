import javax.swing.BorderFactory;
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

    JPanel panelBoutonsFonctions;

    PanelMilieu panelMilieu;

    String formeActuelle;
    Color  couleurActuelle;

    JButton[] boutonsFonctions = new JButton[7];
    JButtonColor btnCouleur;

    public PanelDessin(Controleur controleur){

        ctrl = controleur;
        formeActuelle = "";
        couleurActuelle = Color.BLACK;

        this.setLayout(new BorderLayout());

        panelBoutonsFonctions = new JPanel();
        panelBoutonsFonctions.setLayout(new GridLayout(1,8));

        panelMilieu = new PanelMilieu(ctrl);

        //Création des boutons
        boutonsFonctions[0] = new JButton("Carré");
        boutonsFonctions[1] = new JButton("Rond");
        boutonsFonctions[2] = new JButton("Ligne");
        boutonsFonctions[3] = new JButton("Texte");
        boutonsFonctions[4] = new JButton("Remplir");
        boutonsFonctions[5] = new JButton("Retour Arriere");
        boutonsFonctions[6] = new JButton("Retour Avant");

        btnCouleur = new JButtonColor("");

        //Ajout des boutons au panel
        panelBoutonsFonctions.add(btnCouleur);

        for(int i=0; i<boutonsFonctions.length; i++){
            panelBoutonsFonctions.add(boutonsFonctions[i]);
        }


        //Ajout des listeners
        btnCouleur.addActionListener(this);

        for(JButton btn : boutonsFonctions){
            btn.addActionListener(this);
        }

        this.add(panelBoutonsFonctions, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
    }

    public String getFormeActuelle(){
        return formeActuelle;
    }

    public Color getCouleurActuelle(){
        return this.btnCouleur.getColor();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == boutonsFonctions[5]) // Retour Arriere
        {
            ctrl.adjustNbActif(-1);
        }

        if (e.getSource() == boutonsFonctions[6]) // Retour Avant
        {
            ctrl.adjustNbActif(1);
        }
    }

    public PanelMilieu getPanelMilieu() {
        return panelMilieu;
    }
    

}
