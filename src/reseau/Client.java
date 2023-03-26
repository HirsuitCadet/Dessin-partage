import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.sound.sampled.Control;

public class Client{

    private Socket clientSocket;
    private String nom;
    private Socket serveur;

    public Client(String Ip, String nom) {
        try {
            this.clientSocket = new Socket(Ip, 9000);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.nom = nom;

        try{
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader brService = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        
            String msgDepuisService = brService.readLine();
            System.out.println("reçu du service : "+msgDepuisService);
            Scanner clavier = new Scanner(System.in);
            String msgVersService = clavier.nextLine();
            while(!msgVersService.equalsIgnoreCase("quit")) {
                pw.println(msgVersService);
                System.out.println("a"+brService.readLine());
                pw.flush();
                msgVersService = clavier.nextLine();
               
            }
            pw.println("quitter");
            pw.flush();
            clientSocket.close();
          
		} catch(UnknownHostException uhe) { 
		} catch(IOException ioe) {}
    }    

    public void lancer(){
        new Controleur(this);
    }
}
    