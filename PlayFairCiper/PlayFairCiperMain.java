
package PlayFairCiper;

import java.util.Scanner;

/**
 *
 * @author Prosanto Deb (ASH1925005M)
 */
public class PlayFairCiperMain 
{
    public String getCiperText(String plainText)
    {
        String ciperText = "", demoText = "", keyGenerator = "ABCDEFGHIJKLMNOPQRSTUVZXYZ";
        
        StringBuffer sb = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVZXYZ");
       
        
        return ciperText;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("PlainText : ");
        String plainText = sc.next();
        System.out.println("Key : ");
        String key = sc.next();

        System.out.println(new PlayFairCiperMain().getCiperText(plainText));
    }
}
