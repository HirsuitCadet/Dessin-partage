public class UILauncher extends Thread{


    public Client client;
    public Controleur controleur;

    public UILauncher(Client c){
        this.client = c;
    }
    
    public void run(){
        new FrameDessin();
    }
}