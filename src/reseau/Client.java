import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.sound.sampled.Control;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends Thread{

    private Socket clientSocket;
    private String nom;
    private Socket serveur;
    PrintWriter pw;
    BufferedReader brService;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Controleur ctrl;

    public Client(String nom, String Ip) {     
        ctrl = new Controleur(this);
        System.out.println("Valeur IP : " + Ip);
        try {
            this.clientSocket = new Socket(Ip, 9000);
            //oos = new ObjectOutputStream(clientSocket.getOutputStream());
            //ois = new ObjectInputStream(clientSocket.getInputStream());
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.nom = nom;

    }  

    public void run(){
        try{
            pw = new PrintWriter(clientSocket.getOutputStream(), true);
            brService = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        
            String msgDepuisService = brService.readLine();
            System.out.println(msgDepuisService);
            Scanner clavier = new Scanner(System.in);
            String msgVersService = clavier.nextLine();
            while(!msgVersService.equalsIgnoreCase("quit")) {
                pw.println(msgVersService);
                System.out.println(brService.readLine());
                pw.flush();
                msgVersService = clavier.nextLine();               
            }
            pw.println("quitter");
            pw.flush();
            clientSocket.close();
          
		} catch(UnknownHostException uhe) { 
		} catch(IOException ioe) {}
    }
    
    

    public void  afficherFrameNom() {
       FrameNom frameNom = new FrameNom();
    }

    public void envoyerNom(String nom){
        pw.println(nom);
    }

    public void addShape(ShapeSpec shapeSpec) {
        /*
        try {
            oos.writeObject(shapeSpec);
            System.out.println("Objet envoyé (client)");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
        */  
    }

}
    