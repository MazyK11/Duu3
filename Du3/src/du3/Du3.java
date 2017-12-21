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
        int p [] = new int [(int) Math.pow(10,2)];
        rnd(k,p);     
//      Arrays.sort(p);
//      vstupsetina(k,p);
//        for(int i =0;i<p.length;i++){
//            System.out.format("%d ",p[i]);
//        }
//        System.out.format("\n");
        
//        selectsort(p);
//        for(int i =0;i<p.length;i++){
//            System.out.format("%d ",p[i]);
//        }
//        System.out.format("\n");
        
//        long tStart = System.nanoTime();
        bubblesort(p);
//        long tEnd = System.nanoTime();
//        long tRes = tEnd - tStart;
//        System.out.format("%d \n",tRes);

        for(int i =0;i<p.length;i++){
            System.out.format("%d ",p[i]);
        }
        System.out.format("\n");
        
//        Arrays.sort(p);
//        for(int i =0;i<p.length;i++){
//            System.out.format("%d ",p[i]);
//        }
//        System.out.format("\n");
        
//        int heap[] = heapsort(p);
//        for(int i =1;i<heap.length;i++){
//            System.out.format("%d ",heap[i]);
//        }
//        System.out.format("\n");
        int pivot = p.length/2;
        int left [] =  new int [p.length];
        int right [] = new int [p.length];
        int j= pivot;
        for(int i = 0;i<pivot;i++){
            left[i] = p[i];
            right[j] = p[pivot+i];
            j++;
        }
        for(int i =0;i<left.length;i++){
            System.out.format("%d ",left[i]);
        }
        System.out.format("\n");
        
        for(int i =0;i<right.length;i++){
            System.out.format("%d ",right[i]);
        }
        System.out.format("\n");
        
    }
    public static void rnd(int k, int p[]){
        Random numbers= new Random();
        for(int i =0;i<Math.pow(10,k);i++){
            p[i] = numbers.nextInt(100);
        }
    }
    public static void vstupsetina(int k,int p[]){
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
    public static void selectsort(int p[]){
        int min;
        int h = 0;
        for(int j =0;j < p.length;j++){
            min = p[j];
            for(int i = 0+j;i < p.length;i++){
                if(min >= p[i]){
                   min = p[i];
                   h = i;
                }
            }
            int m  = p[j];
            p[j] = p[h];
            p[h] = m; 
        }
    }
    public static void bubblesort(int p[]){
        for(int k= 0;k<p.length;k++){
            for(int i = p.length-1; i > 0+k;i--){
                if(p[i] < p[i-1]){
                    int m = p[i];
                    p[i] = p[i-1];
                    p[i-1] = m;
                }
            }
        }
    }
    public static int[] heapsort(int p[]){
        int[] heap = new int [p.length+1];
        int j =0;
//        heap[1] = p[0];
        for(int i = 1;i<p.length+1;i++){
            heap[i] = p[j];
            nahoru(heap,i);
            j++;
        }
        for(int k = heap.length-1;k > 1;k--){
            int m = heap[1];
            heap[1] = heap[k];
            heap[k] = m;  
            dolu(heap,k);
        }
        
        return heap;    
    }
    public static void nahoru(int heap [],int i){
        while(i > 1){
            if(heap[i/2] < heap[i]){
                int m = heap[i/2];
                heap[i/2] = heap[i];
                heap[i] = m;
                i = i/2;
            }
            else{
                break;
            }
        }
    }
    public static void dolu(int heap[],int k){
        int index = 0;
        int i = 1;
        while((i*2)+1 < k){    
            if(heap[i*2] < heap[i*2+1]){
                index = (i*2)+1;
            }
            else {
                index = i*2;
            }
            if(heap[i] < heap[index]){
                    int m = heap[index];
                    heap[index] = heap[i];
                    heap[i] = m;
            }
            else {
                break;
            }
            i = index; 
        }
        
    }
    public static void quicksort(int p[], int pivot, int left[], int right[]){
        int indexl = -1;
        int indexr = -1;
        if(left.length == 1){
            return;
        }
        else{
                int j = p.length-1;
                for(int i = 0;i==j;i++){
                    if(left[i] > p[pivot]){
                        indexl = i;
                        if(right[j] < pivot){
                            int m = left[indexl]; 
                            left[indexl] = right[indexr];
                            right[indexr] = m;                            
                        }
                    }
                    
                    
                    j--;
                }
//                for(int j = pivot-1;j>-1;j--){
//                    if(right[j] < p[pivot]){
//                        indexr = j;
//                        break;
//                    }
//                }

                int m = left[indexl]; 
                left[indexl] = right[indexr];
                right[indexr] = m;
        }
        
    }
}
