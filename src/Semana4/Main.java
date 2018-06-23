
package Semana4;

import java.util.Collections;

public class Main{

    public static void main(String[] args) {
        /*
        Bubble sort
        Selection sort
        Insertion sort
        Merge sort
        Heapsort
        Counting sort
        Quick sort
        */
        long inicio, fim, tempo;
        int N = 10000;
        Tipos_Sort master = new Tipos_Sort();
        
        
        int vetBubbleAleatorio[] = new int[N];

        //[INICIO] Criação dos Aleatórios
        for(int i=0; i<N; i++)
            vetBubbleAleatorio[i] = ((int) (Math.random()*N*N))+1;
        int[] vetSelectionAleatorio = vetBubbleAleatorio.clone();
        int[] vetInsertionAleatorio = vetBubbleAleatorio.clone(); 
        int[] vetMergeAleatorio  = vetBubbleAleatorio.clone();
        int[] vetHeapAleatorio = vetBubbleAleatorio.clone();
        int[] vetCountingAleatorio = vetBubbleAleatorio.clone();
        int[] vetQuickAleatorio = vetBubbleAleatorio.clone();
        //[FIM] Criação dos Aleatórios
        
        
        //[INICIO] Criação dos Já Ordenados
        int[] vetBubbleOrdenado = vetBubbleAleatorio.clone();
        int[] vetSelectionOrdenado = vetBubbleAleatorio.clone();
        int[] vetInsertionOrdenado = vetBubbleAleatorio.clone(); 
        int[] vetMergeOrdenado  = vetBubbleAleatorio.clone();
        int[] vetHeapOrdenado = vetBubbleAleatorio.clone();
        int[] vetCountingOrdenado = vetBubbleAleatorio.clone();
        int[] vetQuickOrdenado = vetBubbleAleatorio.clone();
        master.quickSort(vetBubbleOrdenado, 0, N-1);
        master.quickSort(vetSelectionOrdenado, 0, N-1);
        master.quickSort(vetInsertionOrdenado, 0, N-1);
        master.quickSort(vetMergeOrdenado, 0, N-1);
        master.quickSort(vetHeapOrdenado, 0, N-1);
        master.quickSort(vetCountingOrdenado, 0, N-1);
        master.quickSort(vetQuickOrdenado, 0, N-1);
        //[FIM] Criação dos Já Ordenados
        
        
        //[INICIO] Criação dos Inversos
        int[] vetBubbleInverso = vetBubbleAleatorio.clone();
        int[] vetSelectionInverso = vetBubbleAleatorio.clone();
        int[] vetInsertionInverso = vetBubbleAleatorio.clone(); 
        int[] vetMergeInverso  = vetBubbleAleatorio.clone();
        int[] vetHeapInverso = vetBubbleAleatorio.clone();
        int[] vetCountingInverso = vetBubbleAleatorio.clone();
        int[] vetQuickInverso = vetBubbleAleatorio.clone();
        master.inverte(vetBubbleInverso);
        master.inverte(vetSelectionInverso);
        master.inverte(vetInsertionInverso);
        master.inverte(vetMergeInverso);
        master.inverte(vetHeapInverso);
        master.inverte(vetCountingInverso);
        master.inverte(vetQuickInverso);
        //[FIM] Criação dos Inversos    
        
        
        
        
        //[INICIO]      DEMONSTRAÇÕES DOS ALEATÓRIOS!
        System.out.println("INICIO DAS DEMONSTRAÇÕES DOS ALEATÓRIOS!");
        
        inicio = System.currentTimeMillis();
        master.BubbleSort(vetBubbleAleatorio, N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO BUBBLESORT ALEATÓRIO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.SelectionSort(vetSelectionAleatorio, N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO SELECTIONSORT ALEATÓRIO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.InsertionSort(vetInsertionAleatorio);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO INSERTIONSORT ALEATÓRIO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.sortt(vetMergeAleatorio);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO MERGESORT ALEATÓRIO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.sort(vetHeapAleatorio);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO HEAPSORT ALEATÓRIO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.CountingSort(vetCountingAleatorio);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO COUNTINGSORT ALEATÓRIO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.quickSort(vetQuickAleatorio, 0, N-1);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO QUICKSORT ALEATÓRIO É: "+tempo);
       
        
        System.out.println("FIM DAS DEMONSTRAÇÕES DOS ALEATÓRIOS!");
        //[FIM]         DEMONSTRAÇÕES DOS ALEATÓRIOS!   
        
        System.out.println("----- \n");
        System.out.println("----- \n");
        System.out.println("----- \n");
        
        //[INICIO]      DEMONSTRAÇÕES DOS JÁ ORDENADOS!
        System.out.println("INICIO DAS DEMONSTRAÇÕES DOS JÁ ORDENADOS!");
        
        inicio = System.currentTimeMillis();
        master.BubbleSort(vetBubbleOrdenado, N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO BUBBLESORT ORDENADO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.SelectionSort(vetSelectionOrdenado, N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO SELECTIONSORT ORDENADO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.InsertionSort(vetInsertionOrdenado);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO INSERTIONSORT ORDENADO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.sortt(vetMergeOrdenado);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO MERGESORT ORDENADO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.sort(vetHeapOrdenado);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO HEAPSORT ORDENADO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.CountingSort(vetCountingOrdenado);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO COUNTINGSORT ORDENADO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.quickSort(vetQuickOrdenado, 0, N-1);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO QUICKSORT ORDENADO É: "+tempo);
       
        
        System.out.println("FIM DAS DEMONSTRAÇÕES DOS JÁ ORDENADOS!");
        //[FIM]         DEMONSTRAÇÕES DOS ORDENADOS!          
        
        System.out.println("----- \n");
        System.out.println("----- \n");
        System.out.println("----- \n");
        
        //[INICIO]      DEMONSTRAÇÕES DOS INVERSOS!
        System.out.println("INICIO DAS DEMONSTRAÇÕES DOS INVERSOS!");
        
        inicio = System.currentTimeMillis();
        master.BubbleSort(vetBubbleInverso, N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO BUBBLESORT INVERSO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.SelectionSort(vetSelectionInverso, N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO SELECTIONSORT INVERSO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.InsertionSort(vetInsertionInverso);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO INSERTIONSORT INVERSO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.sortt(vetMergeInverso);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO MERGESORT INVERSO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.sort(vetHeapInverso);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO HEAPSORT INVERSO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.CountingSort(vetCountingInverso);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO COUNTINGSORT INVERSO É: "+tempo);
        
        inicio = System.currentTimeMillis();
        master.quickSort(vetQuickInverso, 0, N-1);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("TEMPO DO QUICKSORT INVERSO É: "+tempo);
       
        
        System.out.println("FIM DAS DEMONSTRAÇÕES DOS INVERSOS!");
        //[FIM]         DEMONSTRAÇÕES DOS INVERSOS!             
        
        
    }
}
