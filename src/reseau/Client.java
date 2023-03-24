import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.Shape;

public class Client implements Runnable {
    private Socket clientSocket;
    private String nom;
    private Socket serveur;

    public Client(Socket clientSocket, String nom) {
        this.clientSocket = clientSocket;
        this.nom = nom;
    }

    public void run() {
        try {
            serveur = new Socket(InetAddress.getLocalHost(),9000);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String message = in.readLine();
                if (message == null) {
                    System.out.println("Client deconnecté: " + clientSocket);
                    return;
                }
                String commande = this.attendreCommande();
                switch(commande){
                    case "Dessiner":
                        break;
                    case "retourArriere":
                        break;
                    case "retourAvant":
                        break;
                    case "quitter":
                        clientSocket.close();
                        break;
                    default:
                        out.println("Commande inconnue");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String attendreCommande(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Veuillez entrer une commande: ");
            String commande = in.readLine();
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