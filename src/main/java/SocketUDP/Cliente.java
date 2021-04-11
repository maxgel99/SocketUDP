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
import java.net.UnknownHostException;
/**
 *
 * @author Maxangel
 */
public class Cliente {
    public static void main(String[] args) {
        final int PUERTO_SERVIDOR=5001;
            byte [] buffer=new byte[1024];
           try {
                InetAddress direccionServidor=InetAddress.getByName("localhost");
                DatagramSocket socketUDP=new DatagramSocket();
                String mensaje="Saludo desde el cliente";
                buffer= mensaje.getBytes();
                DatagramPacket pregunta = new DatagramPacket (buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
                System.out.println("ENVIO DATAGRMA");
                socketUDP.send(pregunta);
                DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
                socketUDP.receive(peticion);
                System.out.println("RECIBO LA PETICION");
                mensaje = new String(peticion.getData());
                System.out.println(mensaje);
                socketUDP.close();
                
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch (UnknownHostException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
        }catch (IOException ex){
               Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
}
