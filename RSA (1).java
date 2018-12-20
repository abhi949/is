package rsa;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
 
public class RSA
{
    private BigInteger p1,p2,N,phi,e,d;
    private int        bitl = 1024;
    private Random     random;
 
    public RSA()
    {
        random = new Random();
        p1 = BigInteger.probablePrime(bitl, random);
        p2 = BigInteger.probablePrime(bitl, random);
        N = p1.multiply(p2);
        phi = p1.subtract(BigInteger.ONE).multiply(p2.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitl / 2, random);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
                  e.add(BigInteger.ONE);
        d = e.modInverse(phi);
    }
 
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException
    {
        RSA rsa = new RSA();
        DataInputStream in = new DataInputStream(System.in);
        String test;
        System.out.println("PT: ");
        test = in.readLine();
        System.out.println("Bytes Repn: " + bts(test.getBytes()));
        //System.out.println(Arrays.toString(test.getBytes()));
        byte[] encrypted = rsa.encrypt(test.getBytes());
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decryting: " + bts(decrypted));
        System.out.println("Decrypted String: " + new String(decrypted));
    }
 
    private static String bts(byte[] encrypted)
    {
        String test = "";
            for (byte by : encrypted)
            {
                test = test + Byte.toString(by);
            }
        return test;
    }

    public byte[] encrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
    public byte[] decrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}