import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
    private static List<String> shapes = new ArrayList<>();
    private static List<Client> alClients = new ArrayList<Client>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Serveur démarré sur le port 9000");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouveau client connecté: " + clientSocket);
                
                Client c = new Client(clientSocket, demanderNom(clientSocket));                 
                Thread thread = new Thread(c);
                alClients.add(c);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String demanderNom(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Veuillez entrer votre nom");
            String nom = in.readLine();
            System.out.println("Nom du client: " + nom);
            while( !nomLibre(nom) ){
                out.println("Ce nom est déjà utilisé, veuillez en choisir un autre: ");
                nom = in.readLine();
            }
            return nom;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static boolean nomLibre(String nom){
        for(Client c : alClients){
            if(c.getNom().equals(nom)){
                return true;
            }
        }
        return false;
    }

}