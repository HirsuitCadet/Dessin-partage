import java.awt.*;
import java.io.Serializable;

public class ShapeSpec implements Serializable
{   
    private Shape shape;
    private Color color;
    private boolean filled; 
    private int stroke;  
    
    public ShapeSpec(Shape shape, Color color, boolean filled, int stroke)
    {
        this.shape = shape;
        this.color = color;
        this.filled = filled;
        this.stroke = stroke;
    }

    public Shape getShape() { return this.shape; }
    public Color getColor() { return this.color; }
    public boolean isFilled() { return this.filled; }
    public int getStroke() { return this.stroke; }

    public void setShape(Shape shape) { this.shape = shape; }
    public void setColor(Color color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }
    public void setStroke(int stroke) { this.stroke = stroke; }
}
