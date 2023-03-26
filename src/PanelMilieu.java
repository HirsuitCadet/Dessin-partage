import javax.swing.JPanel;

import java.awt.Point;

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

	String formeActuelle;
	Color couleurActuelle;
	boolean isFilled;

	Point posSourisDebut;
	Point posSourisFin;

	ArrayList<ShapeSpec> listeFormes = new ArrayList<ShapeSpec>();
	int nbActif;

	public PanelMilieu(Controleur controleur){
		ctrl = controleur;
		formeActuelle = "Rectangle";
		couleurActuelle = Color.BLACK;
		isFilled = false;
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

	public void setFormeActuelle(String forme){
		formeActuelle = forme;
	}

	public void setCouleurActuelle(Color couleur)
	{
		couleurActuelle = couleur;
	}

	public void setIsFilled(boolean isFilled)
	{
		this.isFilled = isFilled;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for(int i=0; i<nbActif; i++)
		{
			ShapeSpec s = (ShapeSpec) listeFormes.get(i);
			g2.setColor(s.getColor());
			
			if (s.isFilled())
				g2.fill(s.getShape());
			else
				g2.draw(s.getShape());
		}
	}

	public void ajouterShapeSpec()
	{
		double xDebut = 0.0;
		double yDebut = 0.0;
		double xFin = 0.0;
		double yFin = 0.0;

		if(posSourisDebut.x < posSourisFin.x){//si la souris part de gauche et va à droite
			xDebut = posSourisDebut.x;
			xFin   = posSourisFin.x;
		}
		else{//si la souris part de droite et va à gauche
			xDebut = posSourisFin.x;
			xFin   = posSourisDebut.x;
		}

		if(posSourisDebut.y < posSourisFin.y){//si la souris part d'en haut et va vers le bas
			yDebut = posSourisDebut.y;
			yFin   = posSourisFin.y;
		}else{//si la souris part d'en bas et va vers le haut
			yDebut = posSourisFin.y;
			yFin   = posSourisDebut.y;
		}

		switch(formeActuelle){
			case "Rectangle":

				this.listeFormes.add(new ShapeSpec(new Rectangle2D.Double(xDebut, yDebut, xFin - xDebut, yFin - yDebut),
									couleurActuelle, isFilled));
				ctrl.addShape(this.listeFormes.get(nbActif));
				nbActif++;
				break;
		
			case "Cercle":
				this.listeFormes.add(new ShapeSpec(new Ellipse2D.Double(xDebut, yDebut, xFin - xDebut, yFin - yDebut),
									couleurActuelle, isFilled));
				ctrl.addShape(this.listeFormes.get(nbActif));
				nbActif++;
				break;

			case "Ligne":
				this.listeFormes.add(new ShapeSpec(new Line2D.Double(posSourisDebut.x, posSourisDebut.y, posSourisFin.x, posSourisFin.y),
									couleurActuelle, false));
				ctrl.addShape(this.listeFormes.get(nbActif));	
				nbActif++;
				break;

			/*case "Texte":
				g.drawString("Test", xDebut, posSourisDebut.y);
			*/
			
			default:
				break;
		}

		repaint();
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
		posSourisDebut = new Point(me.getX(), me.getY());
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		posSourisFin = new Point(me.getX(),me.getY());
		ajouterShapeSpec();
	}

	public int getNbShapes()
	{
		return nbActif;
	}
	
}
