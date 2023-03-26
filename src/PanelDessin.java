import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;

public class PanelDessin extends JPanel implements ActionListener, ItemListener{

    Controleur ctrl;

    JPanel panelBoutonsFonctions;
    PanelMilieu panelMilieu;

    JButton[] boutonsFonctions;
    CheckboxGroup cbg;
    Checkbox[] cbFonctions;
    JCheckBox cbFilled;

    public PanelDessin(Controleur controleur){

        ctrl = controleur;

        this.setLayout(new BorderLayout());

        panelBoutonsFonctions = new JPanel();
        panelBoutonsFonctions.setLayout(new GridLayout(1,8));
        System.out.println("PanelBouton créé");

        panelMilieu = new PanelMilieu(ctrl);

        this.boutonsFonctions = new JButton[3];
        this.cbg = new CheckboxGroup();
        this.cbFonctions = new Checkbox[4];

        //Création des boutons
        boutonsFonctions[0] = new JButton();
        boutonsFonctions[0].setBackground(Color.BLACK);
        boutonsFonctions[1] = new JButton("Retour Arriere");
        boutonsFonctions[2] = new JButton("Retour Avant");

        cbFonctions[0] = new Checkbox("Rectangle", cbg, true);
        cbFonctions[1] = new Checkbox("Cercle", cbg, false);
        cbFonctions[2] = new Checkbox("Ligne", cbg, false);
        cbFonctions[3] = new Checkbox("Texte", cbg, false);
        cbFonctions[3].setEnabled(false);

        cbFilled = new JCheckBox("Remplir");

        //Ajout des boutons au panel
        for(int i=0; i<boutonsFonctions.length; i++){
            panelBoutonsFonctions.add(boutonsFonctions[i]);
        }

        for (int i=0; i<cbFonctions.length; i++){
            panelBoutonsFonctions.add(cbFonctions[i]);
        }
        panelBoutonsFonctions.add(cbFilled);


        //Ajout des listeners
        for(JButton btn : boutonsFonctions){
            btn.addActionListener(this);
        }
        for(Checkbox cb : cbFonctions){
            cb.addItemListener(this);
        }
        cbFilled.addItemListener(this);

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

    public void setIsFilled(boolean isFilled)
    {
        this.panelMilieu.setIsFilled(isFilled);
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

        if(e.getSource() == boutonsFonctions[1]) // Retour Arriere
        {
            ctrl.adjustNbActif(-1);
        }

        if (e.getSource() == boutonsFonctions[2]) // Retour Avant
        {
            ctrl.adjustNbActif(1);
        }
    }
    
    public void itemStateChanged(ItemEvent e){
        for (int i=0; i<cbFonctions.length; i++)
        {
            if (e.getSource() == cbFonctions[i])
            {
                this.ctrl.setFormeActuelle(cbFonctions[i].getLabel());
            }
        }

        if (e.getSource() == this.cbFilled)
        {
            this.ctrl.setIsFilled(cbFilled.isSelected());
        }
    }

    public PanelMilieu getPanelMilieu() {
        return panelMilieu;
    }
}