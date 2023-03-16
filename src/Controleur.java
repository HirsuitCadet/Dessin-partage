import java.awt.Color;

public class Controleur {

    FrameDessin frmDessin;

    PanelDessin panelDessin;
    PanelMilieu panelMilieu;

    public Controleur() {
        frmDessin = new FrameDessin(this);
        panelDessin = frmDessin.getPanelDessin();
        panelMilieu = panelDessin.getPanelMilieu();
    }

    public Color getCouleurActuelle() {
        return panelDessin.getCouleurActuelle();
    }

    public String getFormeActuelle(){
        return panelDessin.getFormeActuelle();
    }

    public static void main(String[] args) {
        new Controleur();
    }
}
