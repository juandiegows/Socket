/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.areadina.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mejia
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Servidor conectado por el puerto 6000");

            while (true) {
                Socket cliente = server.accept();
                System.out.println("Se conectado un cliente");
                
                 DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                 var data = flujoEntrada.readUTF();
                 data = data.replace('a', '4').replace('e', '3').replace('o', '0');
                
                
                DataOutputStream flujoOut = new DataOutputStream(cliente.getOutputStream());
                flujoOut.writeUTF(data);
                
               
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
