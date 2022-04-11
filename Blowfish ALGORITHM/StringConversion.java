import java.util.Scanner;

public class StringConversion
{
    public static String stringToHex(String input)
    {
        StringBuffer sb = new StringBuffer();
        char charArray[] = input.toCharArray();

        for(int i=0;i<charArray.length;i++)
        {
            String s = Integer.toHexString(charArray[i]);
            sb.append(s);
        }

        return sb.toString();
    }

    public static String hexToString(String hex)
    {
        StringBuffer sb = new StringBuffer();
        char charArray[] = hex.toCharArray();

        for(int i=0;i<charArray.length;i=i+2)
        {
            String s = ""+charArray[i]+charArray[i+1];
            char ch = (char) Integer.parseInt(s,16);
            sb.append(ch);
        }

        return sb.toString();
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(stringToHex(input));
        System.out.println(hexToString(stringToHex(input)));
        sc.close();
    }
}