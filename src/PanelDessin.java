import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.Color;

public class PanelDessin extends JPanel implements ActionListener, ItemListener, ChangeListener{

    Controleur ctrl;

    JPanel panelBoutonsFonctions;
    PanelMilieu panelMilieu;

    JButton[] boutonsFonctions;
    CheckboxGroup cbg;
    JCheckBox[] cbFonctions;
    ButtonGroup group;
    JCheckBox cbFilled;

    JSlider slider;

    public PanelDessin(Controleur controleur){

        ctrl = controleur;

        this.setLayout(new BorderLayout());

        panelBoutonsFonctions = new JPanel();
        panelBoutonsFonctions.setLayout(new GridLayout(9,1));
        System.out.println("PanelBouton créé");

        panelMilieu = new PanelMilieu(ctrl);

        this.boutonsFonctions = new JButton[3];
        this.cbg = new CheckboxGroup();
        this.cbFonctions = new JCheckBox[4];
        this.group = new ButtonGroup();

        //Création des boutons
        boutonsFonctions[0] = new JButton();
        boutonsFonctions[0].setBackground(Color.BLACK);
        boutonsFonctions[1] = new JButton(new ImageIcon("./img/retour.png"));
        boutonsFonctions[2] = new JButton("Retour Avant");
        boutonsFonctions[2].setEnabled(false);

        cbFonctions[0] = new JCheckBox("Rectangle",new ImageIcon("./img/rectangle.png"));
        cbFonctions[0].setBackground(new Color(140,140,140));
        cbFonctions[1] = new JCheckBox("Cercle", new ImageIcon("./img/cercle.png"));
        cbFonctions[2] = new JCheckBox("Ligne", new ImageIcon("./img/ligne.png"));
        cbFonctions[3] = new JCheckBox("Texte");
        cbFonctions[3].setEnabled(false);

        for (JCheckBox cb : cbFonctions){
            group.add(cb);
        }

        cbFilled = new JCheckBox("Remplir");
        boutonsFonctions[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.retour(true);
            }
        });

        slider = new JSlider(1,30,1);

        //Ajout des boutons au panel
        for(int i=0; i<boutonsFonctions.length; i++){
            panelBoutonsFonctions.add(boutonsFonctions[i]);
        }

        for (int i=0; i<cbFonctions.length; i++){
            panelBoutonsFonctions.add(cbFonctions[i]);
        }
        panelBoutonsFonctions.add(cbFilled);
        panelBoutonsFonctions.add(slider);


        //Ajout des listeners
        for(JButton btn : boutonsFonctions){
            btn.addActionListener(this);
        }
        for(JCheckBox cb : cbFonctions){
            cb.addItemListener(this);
        }
        cbFilled.addItemListener(this);
        slider.addChangeListener(this);

        this.add(panelBoutonsFonctions, BorderLayout.WEST);
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
            this.panelMilieu.setCouleurActuelle(color);
        }

        if(e.getSource() == boutonsFonctions[1]) // Retour Arriere
        {
            this.panelMilieu.adjustNbActif(-1);
        }

        if (e.getSource() == boutonsFonctions[2]) // Retour Avant
        {
            this.panelMilieu.adjustNbActif(1);
        }
    }
    
    public void itemStateChanged(ItemEvent e){
        for (int i=0; i<cbFonctions.length; i++)
        {
            if (e.getSource() == cbFonctions[i])
            {
                cbFonctions[i].setBackground(new Color(140,140,140));
                this.panelMilieu.setFormeActuelle(cbFonctions[i].getText());
            }
            else
            {
                cbFonctions[i].setBackground(new JPanel().getBackground());
            }
        }

        if (e.getSource() == this.cbFilled)
        {
            this.panelMilieu.setIsFilled(cbFilled.isSelected());
        }
    }

    public void stateChanged(ChangeEvent e)
    {
        this.panelMilieu.setStrokeSize(slider.getValue());
    }

    public PanelMilieu getPanelMilieu() {
        return panelMilieu;
    }

    public void addShape(ShapeSpec shape) {
        this.panelMilieu.addShape(shape);
    }

    public void setShapes(ArrayList<ShapeSpec> shapes) {
        this.panelMilieu.setShapes(shapes);
    }

    public void retour(){
        this.panelMilieu.retour();
    }
}