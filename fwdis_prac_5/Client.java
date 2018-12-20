/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie_hellman;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Math.random;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author cse
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        Socket connect = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        System.out.println("Connected to:" + connect.getInetAddress().getHostName());
        ObjectOutputStream op = new ObjectOutputStream(connect.getOutputStream());
        ObjectInputStream ip = new ObjectInputStream(connect.getInputStream());
        /*String message = (String) ip.readObject();
        System.out.println(message);
        */
        Random random = new Random();
        BigInteger P,G;
        P = (BigInteger) ip.readObject();
        G = (BigInteger) ip.readObject();
         System.out.println("Prime Number: " + P);
        System.out.println("Generator: " + G);
        BigInteger K = new BigInteger(4, random);
        System.out.println("Random Key: " + K);
        BigInteger Res = G.modPow(K,P);
        System.out.println("Passing Value to Server: " + Res);
        op.writeObject(Res);
        op.flush();
        BigInteger SK = (BigInteger) ip.readObject();
         BigInteger secret = SK.modPow(K,P);
         System.out.println("Secret Key:" + secret);
    }
    
}

/*
Connected to:127.0.0.1
Prime Number: 643
Generator: 13
Random Key: 10
Passing Value to Server: 435
Secret Key:215

*/