import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class Service extends Thread{

    Socket connexionVersClient;
	BufferedReader br = null;
	PrintWriter pw = null;
	String nom;

    public Service(String nom, Socket clientSocket) {
        this.nom = nom;
        this.connexionVersClient = clientSocket;
        try{
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(clientSocket.getOutputStream(), true);    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            String commande = attendreCommande();
            switch(commande){
                case "Dessiner":
                    break;
                case "retourArriere":
                    break;
                case "retourAvant":
                    break;
                case "quitter":
                    try {
                        connexionVersClient.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                default:
                    pw.println("Commande inconnue");
            }
        }
    }

    private String attendreCommande(){
        try {
            pw.println("Veuillez entrer une commande: ");
            String commande = br.readLine();
            System.out.println("Commande du client: " + commande);
            return commande;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNom(){
        return this.nom;
    }
}
