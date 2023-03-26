import java.net.DatagramPacket;
import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class Service extends Thread{

    Socket connexionVersClient;
	BufferedReader brClient;
	PrintWriter pwClient;
    BufferedReader brServeur;
    PrintWriter pwServeur;
	String nom;

    public Service(String nom, Socket clientSocket) {
        this.nom = nom;
        this.connexionVersClient = clientSocket;
        new Controleur(this);
        try{
            brClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));        // réception des données du client
            pwClient = new PrintWriter(clientSocket.getOutputStream(), true);                 // envoie des données vers le client
            brServeur = new BufferedReader(new InputStreamReader(System.in));                  // réception des données du serveur
            pwServeur = new PrintWriter(System.out, true);                                     // envoie des données vers le serveur
            pwClient.println("Service lancé");
            pwServeur.println("Serivce -> Serveur: Service lancé");
            DatagramPacket paquet = new DatagramPacket(new byte[1024], 1024); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        /*String commande = attendreCommande();
        /*
        while (commande.equals("quitter")) {
            commande = attendreCommande();
            switch(commande){
                case "Dessiner":
                    System.out.println("Dessiner");
                    break;
                case "retourArriere":
                    System.out.println("retourArriere");
                    break;
                case "retourAvant":
                    System.out.println("retourAvant");
                    break;
                case "quitter":
                    System.out.println("quitter");
                    try {
                        connexionVersClient.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                default:
                    pwClient.println("Commande inconnue");
            }
        }
        */
    }

    public String attendreCommande(){
        try {
            pwClient.println("Veuillez entrer une commande: ");
            String commande = brClient.readLine();
           pwServeur.println("Commande du client (service): " + commande);
            return commande;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNom(){
        return this.nom;
    }

    public void dessinerRond(int x, int y, int rayon){
        pwServeur.println("DessinerRond " + x + " " + y + " " + rayon);
    }

}
