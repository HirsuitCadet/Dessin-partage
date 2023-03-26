import java.awt.Color;

public class Controleur {

    FrameDessin frmDessin;
    Client client;

    public Controleur(Client client) {   
        this.client = client;    
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
