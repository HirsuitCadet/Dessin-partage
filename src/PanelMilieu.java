import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class PanelMilieu extends JPanel implements MouseListener{

	Controleur ctrl;

	String forme;

	Point posSourisDebut;
	Point posSourisFin;

	ArrayList<ShapeSpec> listeFormes = new ArrayList<ShapeSpec>();
	int nbActif;

	public PanelMilieu(Controleur controleur){
		ctrl = controleur;
		forme = "";
		posSourisDebut = new Point();
		posSourisFin   = new Point();

		this.listeFormes.add(new ShapeSpec(new Rectangle2D.Double(50, 40, 30, 60), Color.RED, true));
		this.listeFormes.add(new ShapeSpec(new Line2D.Double(50, 40, 30, 60), Color.BLUE, false));	
		this.listeFormes.add(new ShapeSpec(new Ellipse2D.Double(80,70,60,100), Color.BLUE, false));
		this.listeFormes.add(new ShapeSpec(new Rectangle2D.Double(100, 40, 30, 60), Color.ORANGE, false));
		this.listeFormes.add(new ShapeSpec(new Rectangle2D.Double(150, 140, 30, 60), Color.CYAN, true));
		this.listeFormes.add(new ShapeSpec(new Rectangle2D.Double(200, 240, 30, 60), Color.BLACK, false));
		this.listeFormes.add(new ShapeSpec(new Rectangle2D.Double(250, 340, 30, 60), Color.MAGENTA, true));
		nbActif = 7;

		this.addMouseListener(this);
	}

	public void adjustNbActif(int nb)
	{
		if (nbActif + nb >= 0 && nbActif + nb <= listeFormes.size())
		{
			nbActif += nb;
			repaint();
		}
		else
		{
			System.out.println("Erreur nb");
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(ctrl.getCouleurActuelle());
		forme = ctrl.getFormeActuelle();

		for(int i=0; i<nbActif; i++)
		{
			ShapeSpec s = (ShapeSpec) listeFormes.get(i);
			g2.setColor(s.getColor());
			
			if (s.isFilled())
				g2.fill(s.getShape());
			else
				g2.draw(s.getShape());
		}

		/*switch(forme){
			case "Carré":
				g.drawRect(posSourisDebut.x, posSourisDebut.y, posSourisFin.x - posSourisDebut.x, posSourisFin.y - posSourisDebut.y);
				break;
			case "Rond":
				g.drawOval(posSourisDebut.x, posSourisDebut.y, posSourisFin.x - posSourisDebut.x, posSourisFin.y - posSourisDebut.y);
				break;
			case "Ligne":
				g.drawLine(posSourisDebut.x, posSourisDebut.y, posSourisFin.x, posSourisFin.y);
				break;
			case "Texte":
				g.drawString("Test", posSourisDebut.x, posSourisDebut.y);
			default:
				break;
		}*/
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//TODO
	}

	@Override
	public void mousePressed(MouseEvent me) {
		posSourisDebut = me.getLocationOnScreen();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		posSourisFin = me.getLocationOnScreen();
	}
	
}
