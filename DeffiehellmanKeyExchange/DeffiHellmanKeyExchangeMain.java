package DeffiehellmanKeyExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class DeffiHellmanKeyExchangeMain 
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


    public DeffiHellmanKeyExchangeMain()
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

        System.out.println("Public Key Alice : "+publicKeyAlice);
        System.out.println("Public Key Bob : "+publicKeyBob);


        System.out.println("Secret Key for Alice : "+getKey(primeNumber, publicKeyBob, privateKeyAlice));
        System.out.println("Secret Key for Bob : "+getKey(primeNumber, publicKeyAlice, privateKeyBob));

        sc.close();
    }

    public static void main(String[] args) 
    {
        new DeffiHellmanKeyExchangeMain();
    }
}
