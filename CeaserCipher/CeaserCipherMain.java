package CeaserCipher;

import java.util.Scanner;

/**
 *
 * @author Prosanto Deb (ASH1925005M)
 */
public class CeaserCipherMain 
{
    public String getCiperText(String plainText,int shift)
    {
        String ciperText = "";

        for (int i=0; i<plainText.length(); i++)
        {
            if (Character.isUpperCase(plainText.charAt(i)))
            {
                char ch = (char)(((int)plainText.charAt(i) + shift - 65) % 26 + 65);   
                ciperText = ciperText + ch;
            }
            else
            {
                char ch = (char)(((int)plainText.charAt(i) + shift - 97) % 26 + 97);
                ciperText = ciperText + ch;
            }
        }

        return ciperText;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Plaintext : ");
        String inputString = sc.next();
        System.out.print("Shift : ");
        int shift = sc.nextInt();
        System.out.println("Ciper Text = "+new CeaserCipherMain().getCiperText(inputString, shift));
        sc.close();       
    }
}
