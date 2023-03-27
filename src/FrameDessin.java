import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class FrameDessin extends JFrame{

    Controleur ctrl;

    PanelDessin panelDessin;

    public FrameDessin(Controleur controleur){
        ctrl = controleur;

        panelDessin = new PanelDessin(ctrl);
        System.out.println("panel créé");

        this.setSize(1000, 750);
        this.setLocation(20, 20);
        this.setTitle("Dessin partagé");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panelDessin);

        this.setVisible(true);
    }

    public PanelDessin getPanelDessin() {
        return panelDessin;
    }

    public int getNbShapes(){
        return panelDessin.getPanelMilieu().getNbShapes();
    }

    public void addShape(ShapeSpec shape) {
        panelDessin.addShape(shape);
    }

    public void setShapes(ArrayList<ShapeSpec> shapes) {
        this.panelDessin.setShapes(shapes);
    }
}