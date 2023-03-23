import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameDessin extends JFrame{

    Controleur ctrl;

    PanelDessin panelDessin;

    public FrameDessin(Controleur controleur){
        ctrl = controleur;

        panelDessin = new PanelDessin(ctrl);

        this.setSize(1000, 1000);
        this.setLocation(100, 100);
        this.setTitle("Dessin partagé");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panelDessin);

        this.setVisible(true);
    }

    public PanelDessin getPanelDessin() {
        return panelDessin;
    }
}