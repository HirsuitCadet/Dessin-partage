import java.awt.Color;

import javax.swing.JFrame;

public class FrameDessin extends JFrame{

    Controleur ctrl;
    Service service;

    PanelDessin panelDessin;

    public FrameDessin(Controleur controleur){
        ctrl = controleur;
        service = service;

        panelDessin = new PanelDessin(ctrl);

        this.setSize(1000, 750);
        this.setLocation(20, 20);
        this.setTitle("Dessin partagé");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panelDessin);

        this.setVisible(true);
    }

    public void setCouleurActuelle(Color couleur)
    {
        panelDessin.setCouleurActuelle(couleur);
    }

    public void setFormeActuelle(String forme)
    {
        panelDessin.setFormeActuelle(forme);
    }

    public void adjustNbActif(int nb)
    {
        panelDessin.adjustNbActif(nb);
    }

    public PanelDessin getPanelDessin() {
        return panelDessin;
    }
}