package OneTimePad;

import java.util.ArrayList;
import java.util.Scanner;

public class OneTimePadMain
{
    public OneTimePadMain()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Character : ");
        int n = sc.nextInt();
        
        ArrayList<Element> elementList = new ArrayList<Element>();

        System.out.println("Enter Character and Decimal Value");
        for(int i=0;i<n;i++)
        {
            elementList.add(new Element(sc.next(), sc.nextInt()));
        }

        sc.nextLine();

        System.out.println("Enter Plain Text");
        String plainText = sc.nextLine();

        System.out.println("Enter Key");
        String key = sc.nextLine();

        
        if(plainText.length()!=key.length())
        {
            System.out.println("Plaintext And Key Must Be Same Length");
            System.exit(0);
        }

        ArrayList<Element> plainTextList = new ArrayList<Element>();
        ArrayList<Element> keyList = new ArrayList<Element>();

        for(int i=0;i<plainText.length();i++)
        {
            String plainTextCh = String.valueOf(plainText.charAt(i));
            String keyCh = String.valueOf(key.charAt(i));
            plainTextList.add(new Element(plainTextCh,getIntValue(elementList,plainTextCh)));
            keyList.add(new Element(keyCh,getIntValue(elementList,keyCh)));
        }

        ArrayList<Element> cipherTextList = new ArrayList<Element>();

        for(int i=0;i<plainTextList.size();i++)
        {
            int operationResult = plainTextList.get(i).binValue^keyList.get(i).binValue;
            cipherTextList.add(new Element(getStringValue(elementList, operationResult), operationResult));
        }

        ArrayList<Element> decryptPlaintextList = new ArrayList<Element>();

        for(int i=0;i<plainTextList.size();i++)
        {
            int operationResult = cipherTextList.get(i).binValue^keyList.get(i).binValue;
            decryptPlaintextList.add(new Element(getStringValue(elementList, operationResult), operationResult));
        }

        printList(elementList);
        printList(plainTextList);
        printList(keyList);
        printList(cipherTextList);
        printList(decryptPlaintextList);

        sc.close();
    }  
    
    public int getIntValue(ArrayList<Element> inputList,String ch)
    {
        int value=0;

        for(int i=0;i<inputList.size();i++)
        {
            if(inputList.get(i).ch.equals(ch))
            {
                value=(i+1);
                break;
            }
        }

        return value;
    }

    public String getStringValue(ArrayList<Element> inputList,int binValue)
    {
        String value="";

        for(int i=0;i<inputList.size();i++)
        {
            if(inputList.get(i).binValue==binValue)
            {
                value=inputList.get(i).ch;
                break;
            }
        }

        return value;
    }

    public void printList(ArrayList<Element> inputList)
    {
        for(int i=0;i<inputList.size();i++)
        {
            //System.out.println(inputList.get(i).ch+" "+inputList.get(i).binValue);
            System.out.print(inputList.get(i).ch);
        }
        System.out.println();
    }


    public static void main(String[] args) 
    {
        new OneTimePadMain();
    }
}

class Element
{
    String ch;
    int binValue;

    public Element(String ch,int binValue)
    {
        this.ch = ch;
        this.binValue = binValue;
    }
}