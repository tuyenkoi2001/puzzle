package level;

import java.io.*;
import java.util.Random;

public class boardLevel{
    int level;
    int[] arrayOfImageCode;
    int size;

    public boardLevel(int level){
        this.level = level;
        size = level*level;

        arrayOfImageCode = Shuffle(size);

    }

    public int[] getBoard(){
        return arrayOfImageCode; 
        }

    public int BoardSize(){
        return level*level;
    }

    int[] Shuffle(int size){
        int[] arrayOfImageCode = new int[size];
        for(int i=0;i<size;i++) arrayOfImageCode[i] = i;
        Random random = new Random();
        int n = random.nextInt(size-1);
        int time = size * 2;
        int i = random.nextInt(size-1);
        while(time-- > 0){
            int t = arrayOfImageCode[i];
            arrayOfImageCode[i] = arrayOfImageCode[n];
            arrayOfImageCode[n] = t;
            n = random.nextInt(size-1);
            i = random.nextInt(size-1);
        }
        System.out.println("swap");
        return arrayOfImageCode;
    }
}
