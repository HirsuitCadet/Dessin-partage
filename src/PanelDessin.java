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

    public PanelDessin(Controleur controleur){

        ctrl = controleur;
        formeActuelle = "";
        couleurActuelle = Color.BLACK;

        this.setLayout(new BorderLayout());

        panelBoutonsFonctions = new JPanel();
        panelBoutonsFonctions.setLayout(new GridLayout(1,7));

        panelMilieu = new PanelMilieu(ctrl);

        //Création des boutons
        boutonsFonctions[0] = new JButton("Carré");
        boutonsFonctions[1] = new JButton("Rond");
        boutonsFonctions[2] = new JButton("Ligne");
        boutonsFonctions[3] = new JButton("Texte");
        boutonsFonctions[4] = new JButtonColor("");
        boutonsFonctions[5] = new JButton("Remplir");
        boutonsFonctions[6] = new JButton("Retour");

        //Ajout des boutons au panel
        for(int i=0; i<boutonsFonctions.length; i++){
            panelBoutonsFonctions.add(boutonsFonctions[i], BorderLayout.NORTH);
        }


        //Ajout des listeners
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
        return couleurActuelle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton btn : boutonsFonctions){
            if(e.getSource() == btn){
                formeActuelle = btn.getText();
                System.out.println("Forme actuelle : " + formeActuelle);
            }
        }
    }

    public PanelMilieu getPanelMilieu() {
        return panelMilieu;
    }
    

}
