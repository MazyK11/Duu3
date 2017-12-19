/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du3;

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
        int exponent = 2;
        int p [] = new int [ (int) Math.pow(10,exponent)];
        rnd(exponent,p);
        for(int i =0;i<p.length;i++){
            System.out.format("%d ",p[i]);
        }

        
      

        
        
    }
    public static void rnd(int exponent, int p[]){
        Random numbers= new Random();
        for(int i =0;i<Math.pow(10,exponent);i++){
            p[i] = numbers.nextInt();
        }
    }
}
