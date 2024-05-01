/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.areadina.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author mejia
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner inputT = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Conectando el servidor ");
                Socket client = new Socket("localhost", 6000);

                DataOutputStream flujoSalida = new DataOutputStream(client.getOutputStream());
                System.out.print("Ingrese la palabra : ");
                flujoSalida.writeUTF(inputT.nextLine());

                DataInputStream flujoInput = new DataInputStream(client.getInputStream());
                System.out.println("Palabra convertida " + flujoInput.readUTF());

                client.close();
            }

        } catch (Exception e) {
            System.out.println("No se pudo conectar el servidor");
        }
    }

}
