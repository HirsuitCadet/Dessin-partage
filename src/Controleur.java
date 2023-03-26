import java.awt.Color;

import com.formdev.flatlaf.FlatLightLaf;

public class Controleur {

    FrameDessin frmDessin;

    public Controleur() {
        //frmDessin = new FrameDessin(this);
        new FrameChoix(this);
    }

    public void setCouleurActuelle(Color couleur) {
        frmDessin.setCouleurActuelle(couleur);
    }

    public void setFormeActuelle(String forme){
        frmDessin.setFormeActuelle(forme);
    }

    public void adjustNbActif(int nb)
    {
        frmDessin.adjustNbActif(nb);
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Controleur();
    }
}
