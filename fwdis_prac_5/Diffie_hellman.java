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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author cse
 */
public class Diffie_hellman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
       ServerSocket socket = new ServerSocket(9999,100);
        System.out.println("Server running....");
        Socket connect = socket.accept();
        System.out.println("Connected to:" + socket.getInetAddress().getHostName());
        ObjectOutputStream op = new ObjectOutputStream(connect.getOutputStream());
        ObjectInputStream ip = new ObjectInputStream(connect.getInputStream());
        /*String message = "hi";
        op.flush();
        op.writeObject(message);
        op.flush();
         */
        Random random = new Random();
        BigInteger P = BigInteger.probablePrime(10, random);
        BigInteger G = BigInteger.probablePrime(4, random);
        System.out.println("Prime Number: " + P);
        System.out.println("Generator: " + G);
        op.writeObject(P);
        op.flush();
        op.writeObject(G);
        op.flush();
        BigInteger K = new BigInteger(4, random);
        System.out.println("Random Key: " + K);
        BigInteger Res = G.modPow(K,P);
        System.out.println("Passing Value to Client: " + Res);
        op.writeObject(Res);
        op.flush();
        
        BigInteger CK = (BigInteger) ip.readObject();
        BigInteger secret = CK.modPow(K,P);
        System.out.println("Secret Key:" + secret);
    }
    
}


/*
Server running....
Connected to:0.0.0.0
Prime Number: 643
Generator: 13
Random Key: 9
Passing Value to Client: 627
Secret Key:215


*/
