package utils;
import java.security.SecureRandom;
import java.util.Random;
public class GenerateRandom {

    public static void main (String args[])
    {
        System.out.println("generatedString is " +randomString(6) );
    }

    public static String randomString(int length) {
        final String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom  secureRnd  = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length()))); return sb.toString();
    }

    final  static String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static Random rand= new Random();
    public static String s(int length) {
        int i = 8;
        String uid="";
            uid+=alpha.charAt(rand.nextInt(26));
        return uid;
    }
}