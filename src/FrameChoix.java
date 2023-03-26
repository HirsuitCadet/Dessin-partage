import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class FrameChoix extends JFrame{


    public FrameChoix() {
        super("Choix du mode");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(new PanelChoix(), BorderLayout.CENTER);
        this.setVisible(true);
    }


    class PanelChoix extends JPanel{

        public PanelChoix() {
            this.setLayout(new GridLayout(2, 1));
            JButton btnServeur = new JButton("Héberger un dessin");
            JButton btnClient = new JButton("Rejoindre un dessin");
            JTextField txtNom = new JTextField();
            JTextField txtIp = new JTextField();
            this.add(btnServeur);
            this.add(btnClient);
            this.add(txtNom);
            this.add(txtIp);
            btnServeur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*TODO: Nouvelle Instance de serveur*/
                    new Serveur();
                    dispose();
                }
            });
            btnClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*TODO: Nouvelle Instance de client*/
                    String nom = txtNom.getText();
                    String ip = txtIp.getText();
                    System.out.println(nom);
                    System.out.println(ip);
                    Client c = new Client(nom, ip);
                    c.start();
                    dispose();
                }
            });
        }
    }

}