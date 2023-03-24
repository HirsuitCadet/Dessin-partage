import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonColor extends JButton implements ActionListener
{
    private Color color;
    private JColorChooser colorChooser;
    private JDialog dialog;

    public JButtonColor(String text)
    {
        super(text);
        this.color = Color.BLACK;
        this.setBackground(color);
        this.colorChooser = new JColorChooser();
        this.dialog = JColorChooser.createDialog(this, "Choisir une couleur", true, this.colorChooser, this, null);
        this.addActionListener(this);
    }

    public Color getColor() { return this.color; }

    public void setColor(Color color) { this.color = color; }

    public void actionPerformed(ActionEvent e)
    {
        this.dialog.setVisible(true);
        this.color = this.colorChooser.getColor();
        this.setBackground(this.color);
    }
}