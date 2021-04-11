/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketUDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxangel
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            final int PUERTO=5001;
            byte[] buffer=new byte[1024];
            System.out.println("Iniciando el Servidor");
            while (true){
                DatagramSocket socketUDP= new DatagramSocket(PUERTO);
                
                DatagramPacket peticion = new DatagramPacket (buffer, buffer.length);
                socketUDP.receive(peticion);
                String mensaje=new String(peticion.getData());
                System.out.println (mensaje);
                
                int puertoCliente =peticion.getPort();
                InetAddress direccion=peticion.getAddress();
                
                mensaje ="Saludos desde el servidor";
                buffer =mensaje.getBytes();
                
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                socketUDP.send(respuesta);
                
            }
        } catch (SocketException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO code application logic here
    }
    
}
