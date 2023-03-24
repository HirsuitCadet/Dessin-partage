import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
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

    JButton[] boutonsFonctions = new JButton[8];

    public PanelDessin(Controleur controleur){

        ctrl = controleur;

        this.setLayout(new BorderLayout());

        panelBoutonsFonctions = new JPanel();
        panelBoutonsFonctions.setLayout(new GridLayout(1,8));

        panelMilieu = new PanelMilieu(ctrl);

        //Création des boutons
        boutonsFonctions[0] = new JButton("Couleur");
        boutonsFonctions[1] = new JButton("Rectangle");
        boutonsFonctions[2] = new JButton("Cercle");
        boutonsFonctions[3] = new JButton("Ligne");
        boutonsFonctions[4] = new JButton("Texte");
        boutonsFonctions[5] = new JButton("Remplir");
        boutonsFonctions[6] = new JButton("Retour Arriere");
        boutonsFonctions[7] = new JButton("Retour Avant");

        //Ajout des boutons au panel
        for(int i=0; i<boutonsFonctions.length; i++){
            panelBoutonsFonctions.add(boutonsFonctions[i]);
        }

        //Ajout des listeners
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
        return this.boutonsFonctions[0].getBackground();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == boutonsFonctions[0]) // Couleur
        {
            JColorChooser colorChooser = new JColorChooser();
            JDialog dialog =  JColorChooser.createDialog(this, "Choix de la couleur", true, colorChooser, this, null);
            dialog.setVisible(true);
            Color color = colorChooser.getColor();
            this.boutonsFonctions[0].setBackground(color);
            this.ctrl.setCouleurActuelle(color);
        }

        if(e.getSource() == boutonsFonctions[1]) // Carré
        {
            this.ctrl.setFormeActuelle("Carré");
        }

        if(e.getSource() == boutonsFonctions[2]) // Rond
        {
            this.ctrl.setFormeActuelle("Rond");
        }

        if(e.getSource() == boutonsFonctions[3]) // Ligne
        {
            this.ctrl.setFormeActuelle("Ligne");
        }

        if(e.getSource() == boutonsFonctions[4]) // Texte
        {
            this.ctrl.setFormeActuelle("Texte");
        }

        if(e.getSource() == boutonsFonctions[6]) // Retour Arriere
        {
            ctrl.adjustNbActif(-1);
        }

        if (e.getSource() == boutonsFonctions[7]) // Retour Avant
        {
            ctrl.adjustNbActif(1);
        }
    }

    public PanelMilieu getPanelMilieu() {
        return panelMilieu;
    }
    

}
