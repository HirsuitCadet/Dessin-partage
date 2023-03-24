import java.awt.*;

public class ShapeSpec
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
}
