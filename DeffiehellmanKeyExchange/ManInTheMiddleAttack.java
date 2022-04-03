package DeffiehellmanKeyExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class ManInTheMiddleAttack
{
    public int getKey(int primeNumber,int primitiveRoot,int privateKey)
    {
        return (int) Math.pow(primitiveRoot, privateKey) % primeNumber;
    }

    public boolean checkPrimiteviteRoot(int primeNumber,int primitiveRoot)
    {
        List<Integer> numberList = new ArrayList<>();
        

        for(int i=1;i<primeNumber;i++)
        {
            numberList.add(i);
        }

        for(int i=1;i<primeNumber;i++)
        {
            int value = (int)(Math.pow(primitiveRoot, i) % primeNumber);

            if(numberList.contains(value))
            {
                numberList.remove(numberList.indexOf(value));
            }
        }

        if(numberList.size()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ManInTheMiddleAttack()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Prime Number : ");
        int primeNumber = sc.nextInt();
        System.out.print("Enter Primitive Root : ");
        int primitiveRoot = sc.nextInt();

        if(!checkPrimiteviteRoot(primeNumber, primitiveRoot))
        {
            System.out.println("Invalid Primitive Root for Prime Number "+primeNumber);
            System.exit(0);
        }

        System.out.print("Enter Private Key of Alice : ");
        int privateKeyAlice = sc.nextInt();
        System.out.print("Enter Private Key of Bob : ");
        int privateKeyBob = sc.nextInt();

        int publicKeyAlice = getKey(primeNumber, primitiveRoot, privateKeyAlice);
        int publicKeyBob = getKey(primeNumber, primitiveRoot, privateKeyBob);
       
        System.out.println("Public Key for Alice "+publicKeyAlice);
        System.out.println("Public Key for Bob "+publicKeyBob);


        System.out.print("For Darth (Private Key of Alice) : ");
        int xD1 = sc.nextInt();
        System.out.print("For Darth (Private Key of Bob) : ");
        int xD2 = sc.nextInt();

        int yD1 = getKey(primeNumber, primitiveRoot, xD1);
        int yD2 = getKey(primeNumber, primitiveRoot, xD2);

        System.out.println("Secret Key for Alice "+getKey(primeNumber, yD2, privateKeyAlice));
        System.out.println("Secret Key By Darth for Alice "+getKey(primeNumber, publicKeyAlice, xD2));

        System.out.println("Secret Key for Bob "+getKey(primeNumber, yD1, privateKeyBob));
        System.out.println("Secret Key By Darth for Bob "+getKey(primeNumber, publicKeyBob, xD1));

        sc.close();
    }

    public static void main(String[] args) 
    {
        new ManInTheMiddleAttack();
    }
}