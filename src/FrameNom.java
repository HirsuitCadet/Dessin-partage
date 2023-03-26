import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameNom extends JFrame{

    public FrameNom() {
        this.setTitle("Choix du nom");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        PanelNom pn = new PanelNom();
        this.add(pn, BorderLayout.CENTER);
        this.setVisible(true);
    }

    class PanelNom extends JPanel implements ActionListener{

        JTextField txtNom;
        JButton btnValider;
        //Client c;

        public PanelNom() {            
            this. txtNom = new JTextField();
            this. btnValider = new JButton("Valider");
            this.add(txtNom);
            this.add(btnValider);
            btnValider.addActionListener(this);
            //this.c = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //c.envoyerNom(txtNom.getText());
        }
        
    }
 
}