import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.Control;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends Thread{

    private Socket clientSocket;
    private String nom;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Controleur ctrl;

    public Client(String nom, String Ip) {     
        ctrl = new Controleur(this);
        System.out.println("Valeur IP : " + Ip);
        try {
            this.clientSocket = new Socket(Ip, 9000);
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.nom = nom;

        try
        {
            this.envoyerNom(nom);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }  

    public void run() {
        try {
            while(this.clientSocket.isConnected()) {
                System.out.println("----------");
                String message = this.ois.readUTF();
                System.out.println("Reçu : " + message);
                switch(message) {
                    case "nom":
                        String nom = this.ois.readUTF();
                        System.out.println("Nom reçu : " + nom);
                        if(nom.equals("false")) {
                            JOptionPane.showMessageDialog(null, "Ce nom est déjà pris");
                            System.out.println("Ce nom est déjà pris");
                        } else {
                            System.out.println("On demande les formes");
                            this.oos.writeUTF("formes");
                            this.oos.flush();
                        }
                        break;
                    case "shape":
                        ShapeSpec shape = (ShapeSpec)ois.readObject();
                        ctrl.addShape(shape, false);
                        break;

                    case "sendAutreShape":
                        ShapeSpec shape2 = (ShapeSpec)ois.readObject();
                        ctrl.addShape(shape2, false);
                        break;
                    
                    case "formes":
                        ArrayList<ShapeSpec> shapes = (ArrayList<ShapeSpec>)ois.readObject();
                        ctrl.setShapes(shapes);
                        break;
                }
            }
        } catch(Exception ex) {
            System.out.println("Client fermé");
            this.ctrl.closeFrame();
            ex.printStackTrace();
        }
    }

    public void envoyerNom(String nom) throws IOException{
        this.oos.writeUTF("nom");
        this.oos.writeUTF(nom);
        this.oos.flush();
    }

    public void addShape(ShapeSpec shapeSpec) throws IOException {
        this.oos.writeUTF("shape");
        this.oos.writeObject(shapeSpec);
        this.oos.flush();
    }

}
    