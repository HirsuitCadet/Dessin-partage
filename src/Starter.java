import com.formdev.flatlaf.FlatLightLaf;

public class Starter{

    public Starter()
    {
        new FrameChoix();
    }

    public static void main(String[] args){
        FlatLightLaf.setup();
        new Starter();
    }
}