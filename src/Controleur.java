import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

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

    public void setIsFilled(boolean isFilled)
    {
        frmDessin.setIsFilled(isFilled);
    }

    public int getNbshapes(){
        return frmDessin.getNbShapes();
    }

    public void addShape(ShapeSpec shape, boolean envoyerReseau) {
        frmDessin.addShape(shape);
        if(envoyerReseau) {
            try
            {
                client.addShape(shape);
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // MAJ IHM

    }

    public void setShapes(ArrayList<ShapeSpec> shapes) {
        frmDessin.setShapes(shapes);
    }
}
