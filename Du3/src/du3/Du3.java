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
    /**Vytvoření proměnné vstup - proměnná, která přepíná mezi jednotlivými 
    *  vstupy 
    *  sort - přepíná mezi použitým třídícím algoritmem
    *  k - exponent
    *  pole p - pole do kterého se nahrají inty
    */      
        int vstup = 0;
        int sort = 4;
        int k = 2;
        int p [] = new int [(int) Math.pow(10,k)];
        
        rnd(k,p);
    /** Podmínka přepínající mezi nesetříděnými inty, setříděnými a setříděnými
     * s jedním prohozem mezi náhodnými prvky
     */
        if(vstup == 1){
            Arrays.sort(p);      
        }
        else if(vstup == 2){
            vstupsetina(k,p);
        }
    /** Podmínka, která přepíná třídící algortimy. 
     *  Pro každý algoritmus je volána specifická funkce a dochází ke změření
     * času v nanosekundách
     */        
        if(sort == 1){
            long tStart = System.nanoTime();
            selectsort(p);
            long tEnd = System.nanoTime();
            long tRes = tEnd - tStart;
            System.out.format("%d \n",tRes);
        }
        else if(sort == 2){
            long tStart = System.nanoTime();
            bubblesort(p);
            long tEnd = System.nanoTime();
            long tRes = tEnd - tStart;
            System.out.format("%d \n",tRes);
        }
        else if(sort == 3){
            long tStart = System.nanoTime();
            int heap [] = heapsort(p);        
            long tEnd = System.nanoTime();
            long tRes = tEnd - tStart;
            System.out.format("%d \n",tRes);
        }
        else {
            int l = 0;
            int r = p.length-1;
            long tStart = System.nanoTime();
            quicksort(p,l,r);
            long tEnd = System.nanoTime();
            long tRes = tEnd - tStart;
            System.out.format("%d \n",tRes);
        }      
    }
     /** Funkce pro naplnění pole náhodnými integery
     * @param k - exponent
     * @param p - pole
     */
    public static void rnd(int k, int p[]){
        Random numbers= new Random();
        for(int i =0;i<Math.pow(10,k);i++){
            p[i] = numbers.nextInt();
        }
    }
     /** Funkce, která setřídí pole a náhodně prohodí 1% prvků
     * @param k - exponent
     * @param p - pole
     */
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
     /** Funkce, která provede algoritmus select sort
     * @param p - pole
     * setřídí vstupní pole pomocí hledání minima, které následně vymění s 
     * prvním prvkem
     */
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
    /** Funkce, která provede algoritmus bubble sort
     * @param p - pole
     * setřídí vstupní pole pomocí porovnávání dvou sousedících prvků, nejmenší
     * prvek se dostane na první místo. Začíná porovnávat od konce
     */
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
    /** Funkce, která provede algoritmus heap sort
     * @param p - pole
     * setřídí vstupní pole pomocí porovnávání binárního stromu.
     * funkce volá další 2 funkce, které jsou potřebné pro tento algoritmus
     */
    public static int[] heapsort(int p[]){
        int[] heap = new int [p.length+1];
        int j =0;
//      přidání prvku do pole a volání funkce nahoru - oprava prvku - posun
//      nahoru pokud je větší než jeho rodič
        for(int i = 1;i<p.length+1;i++){
            heap[i] = p[j];
            nahoru(heap,i);
            j++;
        }
//      záměna největšího prvku za list nejvíce vpravo
//      volání funkce dolu - pohyb od kořene (vyměněný prvek) směrem dolu
        for(int k = heap.length-1;k > 1;k--){
            int m = heap[1];
            heap[1] = heap[k];
            heap[k] = m;  
            dolu(heap,k);
        }
        
        return heap;    
    }
     /** Pomocná funkce heap sortu
     * @param heap - pole haldy
     * @param i - index
     * posouvá prvek směrem nahoru - v poli na menší index pokud je větší
     * než jeho rodič 
     */
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
    /** Pomocná funkce heap sortu
     * @param heap - pole haldy
     * @param k - index
     * posouvá prvek směrem dolu - v poli na větší index
     * porovná velikost potomků, následně je ten větší porovnán s jeho rodičem
     * pokud je větší, tak se vymění
     */
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
    /** Funkce, která provede algoritmus quicksortu
     * @param p - pole
     * @param l - reprezentuje levou hranici pole
     * @param r - reprezentuje pravou hranici pole
     * setřídí pole na základě prohazování prvků na velké vzdálenosti.
     * Po zvolení pivota, se prvky přehází tak, aby nalevo od něj byly menší
     * a napravo od něj větší. Následně je každá část rozdělena a znovu
     * setříděna dokud nezbyde jeden prvek.
     */
    public static void quicksort(int p[],int l, int r){
        int pivot = (r+l)/2;
        int i = l;
        int j = r;
        while(i<=j){
//          najde prvek z leva, který je větší než pivot
            for(;i<pivot;i++){
                if(p[i] > p[pivot]){
                    break;
                }
            }
//          najde prvek zprava, který je menší než pivot
            for(;j>pivot;j--) {    
                if(p[j] < p[pivot]){
                    break;
                }
            }
//          prohodí prvky
            if(i<=j){
                int m = p[i];
                p[i] = p[j];
                p[j] = m;
                i++;
                j--;
            }
//          rekurzivní volání pro levou stranu
            if (l<j){
                quicksort(p,l,j);
            }
//          rekurzivní volání pro pravou stranu
            if(i<r){
                quicksort(p,i,r);
            } 
        }
    }
}
