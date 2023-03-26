import java.awt.Color;

public class Controleur {

    FrameDessin frmDessin;
    Service service;

    public Controleur(Service s) {
        this.service = s;   
        frmDessin = new FrameDessin(this);              
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


    public void dessinerRond(int x, int y, int rayon){
        //client..dessinerRond(x, y, rayon);
    }
}
