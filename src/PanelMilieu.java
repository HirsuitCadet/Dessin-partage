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

	ArrayList<Shape> listeFormes = new ArrayList<Shape>();

	public PanelMilieu(Controleur controleur){
		ctrl = controleur;
		forme = "";
		posSourisDebut = new Point();
		posSourisFin   = new Point();

		this.listeFormes.add(new Rectangle2D.Double(50, 40, 
		                                            30, 60));
		this.listeFormes.add(new Ellipse2D.Double(80,70,60,100));
		this.listeFormes.add(new Line2D.Double(150,150,100,120));	
		
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(ctrl.getCouleurActuelle());
		g.drawLine(0,0,200,200);
		forme = ctrl.getFormeActuelle();

		for(Shape s : listeFormes){
			g2.draw(s);
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
