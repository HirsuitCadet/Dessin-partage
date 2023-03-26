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
	BufferedReader brClient;
	PrintWriter pwClient;
    BufferedReader brServeur;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    PrintWriter pwServeur;
	String nom;

    public Service(String nom, Socket clientSocket) {
        this.nom = nom;
        this.connexionVersClient = clientSocket;  
        try{
            brClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));        // réception des données du client
            pwClient = new PrintWriter(clientSocket.getOutputStream(), true);                 // envoie des données vers le client

            brServeur = new BufferedReader(new InputStreamReader(System.in));                           // réception des données du serveur
            pwServeur = new PrintWriter(System.out, true);                                    // envoie des données vers le serveur

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

            pwServeur.println("Serivce -> Serveur: Service lancé");
            DatagramPacket paquet = new DatagramPacket(new byte[1024], 1024); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){    
        String commande = attendreCommande();
        try {
            oos.writeObject(ois.readObject());
            System.out.println("Objet envoyé");
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (!commande.equals("quitter")) {
            commande = attendreCommande();
            switch(commande){
                case "Dessiner":
                    pwClient.println("Dessiner");
                    break;
                case "retourArriere":
                    pwClient.println("retourArriere");
                    break;
                case "retourAvant":
                    pwClient.println("retourAvant");
                    break;
                case "quitter":
                    pwClient.println("quitter");
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

    }

    public void sendShape(ShapeSpec shape){
      
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

    public int getNbshapes(){
        pwServeur.println("getNbshapes");
        int nb=-1;
        try{
             nb = Integer.parseInt(brServeur.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nb;
    }

    public void removeLastShape(){
        pwClient.println("removeLastShape");
    }

}
