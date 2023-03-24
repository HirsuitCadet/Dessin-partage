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

    JButton[] boutonsFonctions = new JButton[7];
    JButtonColor btnCouleur;

    public PanelDessin(Controleur controleur){

        ctrl = controleur;

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

    public void setCouleurActuelle(Color couleur)
    {
        this.panelMilieu.setCouleurActuelle(couleur);
    }

    public void setFormeActuelle(String forme)
    {
        this.panelMilieu.setFormeActuelle(forme);
    }

    public void adjustNbActif(int nb)
    {
        this.panelMilieu.adjustNbActif(nb);
    }

    public Color getCouleurActuelle(){
        return this.btnCouleur.getColor();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == boutonsFonctions[0]) // Carré
        {
            this.ctrl.setFormeActuelle("Carré");
        }

        if(e.getSource() == boutonsFonctions[1]) // Rond
        {
            this.ctrl.setFormeActuelle("Rond");
        }

        if(e.getSource() == boutonsFonctions[2]) // Ligne
        {
            this.ctrl.setFormeActuelle("Ligne");
        }

        if(e.getSource() == boutonsFonctions[3]) // Texte
        {
            this.ctrl.setFormeActuelle("Texte");
        }

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
