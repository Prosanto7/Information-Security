package DeffiehellmanKeyExchange;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class PrimitiveRootChecker 
{
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


    public PrimitiveRootChecker()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Prime Number : ");
        int primeNumber = sc.nextInt();
        System.out.print("Enter Primitve Root : ");
        int primitiveRoot = sc.nextInt();
        System.out.println(checkPrimiteviteRoot(primeNumber, primitiveRoot));
        sc.close();
    }

    public static void main(String[] args) 
    {
        new PrimitiveRootChecker();
    }
}