import java.awt.*;
import java.awt.geom.*;


public class ShapeSpec implements Shape
{   
    private Shape shape;
    private Color color;
    private boolean filled;   
    
    public ShapeSpec(Shape shape, Color color, boolean filled)
    {
        this.shape = shape;
        this.color = color;
        this.filled = filled;
    }

    public Shape getShape() { return this.shape; }
    public Color getColor() { return this.color; }
    public boolean isFilled() { return this.filled; }

    public void setShape(Shape shape) { this.shape = shape; }
    public void setColor(Color color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }


    public boolean contains(Point2D p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    public boolean contains(Rectangle2D r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    public boolean contains(double arg0, double arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    public boolean contains(double arg0, double arg1, double arg2, double arg3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBounds'");
    }
    public Rectangle2D getBounds2D() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBounds2D'");
    }
    public PathIterator getPathIterator(AffineTransform at) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPathIterator'");
    }
    public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPathIterator'");
    }
    public boolean intersects(Rectangle2D r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersects'");
    }
    public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersects'");
    } 
}
