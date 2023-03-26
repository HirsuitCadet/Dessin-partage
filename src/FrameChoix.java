import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class FrameChoix extends JFrame{


    public FrameChoix(Controleur controleur) {
        super("Choix du mode");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(new PanelChoix(controleur), BorderLayout.CENTER);
        this.setVisible(true);
    }


    class PanelChoix extends JPanel{

        public PanelChoix(Controleur controleur) {
            this.setLayout(new GridLayout(2, 1));
            JButton btnServeur = new JButton("Héberger un dessin");
            JButton btnClient = new JButton("Rejoindre un dessin");
            this.add(btnServeur);
            this.add(btnClient);
            btnServeur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*TODO: Nouvelle Instance de serveur*/
                    dispose();
                }
            });
            btnClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*TODO: Nouvelle Instance de client*/
                    dispose();
                }
            });
        }
    }

}