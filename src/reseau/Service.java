import java.net.DatagramPacket;
import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;
import java.awt.Shape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Service extends Thread{

    Socket connexionVersClient;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Serveur serveur;
	String nom;

    public Service(Socket clientSocket, Serveur sv) {
        this.serveur = sv;
        this.connexionVersClient = clientSocket;  
        try{
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {  
        try {
            String commande = attendreCommande();
            while (!commande.equals("quitter")) {
                switch(commande){
                    case "shape":
                        serveur.addShape(this, (ShapeSpec)ois.readObject());
                        break;
                    case "nom":
                        this.nom = ois.readUTF();

                        this.oos.writeUTF("nom");
                        this.oos.writeUTF("true");
                        this.oos.flush();

                        break;
                    case "formes":
                        this.oos.writeUTF("formes");
                        this.oos.writeObject(Serveur.getShapes());
                        this.oos.flush();
                        break;
                    case "retourAvant":
                        break;
                    case "quitter":
                        connexionVersClient.close();
                        break;
                }
                commande = attendreCommande();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendShape(ShapeSpec shape) throws IOException{
      this.oos.writeUTF("shape");
      this.oos.writeObject(shape);
    }

    public void sendAutreShape(ShapeSpec shapes) throws IOException{
      this.oos.writeUTF("sendAutreShape");
      this.oos.writeObject(shapes);
    }

    public String attendreCommande() throws IOException {
        String commande = this.ois.readUTF();
        return commande;
    }

    public String getNom(){
        return this.nom;
    }

    public void dessinerRond(int x, int y, int rayon){
        
    }

    public int getNbshapes(){
        return 0;
    }

    public void removeLastShape(){
        
    }

}
