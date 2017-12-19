/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author MazyK
 */
public class Du3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k = 2;
        int p [] = new int [(int) Math.pow(10,k)];
        rnd(k,p);     
//      Arrays.sort(p);
//      sortsetina(k,p);
        for(int i =0;i<p.length;i++){
            System.out.format("%d ",p[i]);
        }
        System.out.format("\n");
        
    }
    public static void rnd(int k, int p[]){
        Random numbers= new Random();
        for(int i =0;i<Math.pow(10,k);i++){
            p[i] = numbers.nextInt();
        }
    }
    public static void sortsetina(int k,int p[]){
        Arrays.sort(p);
        Random index = new Random();
        for(int i =0;i<p.length/100;i++){
            int in1 = index.nextInt(p.length-1);
            int in2 = index.nextInt(p.length-1);
            int a = p[in1];
            p[in1] = p[in2];
            p[in2] = a;
        }
    }
}
