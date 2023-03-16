import javax.swing.JPanel;

import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Graphics;

public class PanelMilieu extends JPanel implements MouseListener{

	Controleur ctrl;

	String forme;

	Point posSourisDebut;
	Point posSourisFin;

	public PanelMilieu(Controleur controleur){
		ctrl = controleur;
		forme = "";
		posSourisDebut = new Point();
		posSourisFin   = new Point();
		
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(ctrl.getCouleurActuelle());
		g.drawLine(0,0,200,200);
		forme = ctrl.getFormeActuelle();
		switch(forme){
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
		}
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
