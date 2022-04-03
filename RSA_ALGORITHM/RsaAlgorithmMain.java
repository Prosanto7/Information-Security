package RSA_ALGORITHM;

import java.math.BigInteger;
import java.util.Scanner;

public class RsaAlgorithmMain
{
    public int getGCD(int a,int b)
    {
        int gcd=0,greater;

        if(a>b)
        {
            greater = a;
        }
        else
        {
            greater = b;
        }

        for(int i=1;i<greater;i++)
        {
            if((a%i==0)&&(b%i==0))
            {
                gcd = i;
            }
        }

        return gcd;
    }


    public RsaAlgorithmMain()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Prime Number 1 : ");
        int p = sc.nextInt();
        System.out.print("Enter Prime Number 2 : ");
        int q = sc.nextInt();
        System.out.print("Enter PlainText : ");
        int Ms = sc.nextInt();

        int n = p * q;

        int z = (p-1)*(q-1);

        int e=0;

        for(int i=2;i<z;i++)
        {
            if(getGCD(i, z)==1)
            {
                e = i;
                break;
            }
        }

        //e = 7;

        int d=1;

        while(true)
        {
            if((e*d)%z==1)
            {
                break;
            }
            d++;
        }

        //System.out.println(n);
        //System.out.println(z);
        //System.out.println(e);
        //System.out.println(d);

        BigInteger Message = new BigInteger(String.valueOf(Ms));
        BigInteger expotential = new BigInteger(String.valueOf(e));
        BigInteger D = new BigInteger(String.valueOf(d));
        BigInteger N = new BigInteger(String.valueOf(n));
        BigInteger C = Message.modPow(expotential, N);
        BigInteger M = C.modPow(D, N);

        System.out.println("Encrypted Message "+C);
        System.out.println("Decrypted Message "+M);


        sc.close();
    }


    public static void main(String[] args) 
    {
        new RsaAlgorithmMain();
    }
}