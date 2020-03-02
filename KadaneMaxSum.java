import java.io.File;
import java.util.Scanner;

public class KadaneMaxSum
{
    public static void main(String[] args)
    {
        int[] givenArray = new int[1000];
        int i = 0;
        try
        {
            Scanner scan = new Scanner(new File("demo.txt"));
            while (scan.hasNextInt())
            {
                givenArray[i]  = scan.nextInt();
                ++i;
            }
        }
        catch (Exception e)
        {
            System.out.println("File Error");
            System.exit(1);
        }

        int arraySize = i;
        long start, end;
        int result;
        start = System.nanoTime();
        result = kadanesMethod(givenArray,arraySize);
        end = System.nanoTime();
        System.out.println("Max sequence sum: " + result);
        System.out.println("Time taken in Milliseconds: " + (end-start)/1e6 + "ms");


    }
    public static int kadanesMethod(int[] arr, int n)
    {
        int meh = 0;
        int bi = 0;
        int ei = 0;
        int currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            meh = meh + arr[i];
            if(meh < 0) {
                meh = 0;
                bi = bi + 1;
            }
            if(meh > currentMax) {
                currentMax = meh;
                ei = i;
            }
        }
        return currentMax;
    }

}
