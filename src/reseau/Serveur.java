import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
    private static List<String> shapes = new ArrayList<>();
    private static List<Service> alClients = new ArrayList<Service>();
 

    public Serveur(){
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Serveur démarré sur le port 9000");
            int nb = 0;
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté: " + clientSocket);
                String nom = demanderNom(clientSocket);
                Service s = new Service(nom, clientSocket);
                System.out.println("Lancement du service");
                s.start();
                alClients.add(s);   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String demanderNom(Socket clientSocket) {
        System.out.println("Demande du nom du client");
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
            System.out.println("Erreur lors de la demande du nom du client");
            e.printStackTrace();
        }

        return null;
    }

    private static boolean nomLibre(String nom){
        if(alClients.isEmpty()){
            return true;
        }
        for(Service s : alClients){
            if(s.getNom().equals(nom)){
                return false;
            }
        }
        return true;
    }

    public void retourArriere(){
        if(!shapes.isEmpty()){
            shapes.remove(shapes.size()-1);
        }
        for (Service s : alClients) {
            s.removeLastShape();
        }
    }

    public void receive(DatagramPacket dp){

    }

}