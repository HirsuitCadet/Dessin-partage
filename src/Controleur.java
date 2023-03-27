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
        this.frmDessin.repaint();

    }

    public void setShapes(ArrayList<ShapeSpec> shapes) {
        frmDessin.setShapes(shapes);
    }

    public void retour(boolean envoyerReseau){
        frmDessin.retour();
        if(envoyerReseau) {        
            client.retour();            
        }
        this.frmDessin.repaint();
         
    }

    public void closeFrame(){
        frmDessin.dispose();
    }


}
