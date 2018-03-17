package week4;

public class Tipos_Sort {

    
    public void BubbleSort(int vet[], int N){
       boolean t = true;
       int i = N-1;
       while(t){
           t=false;
           for(int j = 0 ; j<i ; j++){
               if(vet[j]>vet[j+1]){
                   int aux = vet[i];
                   vet[i] = vet[j];
                   vet[j] = aux;
                   t=true;
               }               
           }
           i--;
       } 
    }  
    
    
    
    public void SelectionSort(int num[], int tam) { 
        int i, j, min, aux;
        for (i = 0; i < (tam-1); i++) {
            min = i;
            for (j = (i+1); j < tam; j++) {
                if(num[j] < num[min]) 
                min = j;
            }
            if (num[i] != num[min]) {
            aux = num[i];
            num[i] = num[min];
            num[min] = aux;
            }
        }
    }
    
    public void InsertionSort(int[] vetor){
		
		for (int i = 1; i < vetor.length; i++){
			
			int aux = vetor[i];
			int j = i;
			
			while ((j > 0) && (vetor[j-1] > aux)){
				vetor[j] = vetor[j-1];
				j -= 1;
			}
			vetor[j] = aux;
                
		}
	
	}
    
    
    private int[] numbers;
    private int[] helper;

    private int number;
    
    public void sortt(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
    
    public void sort(int arr[]){
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    public void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
  public void CountingSort(int[] array) {
 
    // array to be sorted in, this array is necessary
    // when we sort object datatypes, if we don't, 
    // we can sort directly into the input array     
    int[] aux = new int[array.length];
 
    // find the smallest and the largest value
    int min = array[0];
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      } else if (array[i] > max) {
        max = array[i];
      }
    }
 
    // init array of frequencies
    int[] counts = new int[max - min + 1];
 
    // init the frequencies
    for (int i = 0;  i < array.length; i++) {
      counts[array[i] - min]++;
    }
 
    // recalculate the array - create the array of occurences
    counts[0]--;
    for (int i = 1; i < counts.length; i++) {
      counts[i] = counts[i] + counts[i-1];
    }
 
    /*
      Sort the array right to the left
      1) Look up in the array of occurences the last occurence of the given value
      2) Place it into the sorted array
      3) Decrement the index of the last occurence of the given value
      4) Continue with the previous value of the input array (goto set1), 
         terminate if all values were already sorted
    */ 
    for (int i = array.length - 1; i >= 0; i--) {
        aux[counts[array[i] - min]--] = array[i];
    }
}
  
    public void quickSort(int v[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int pivo = v[(esq + dir) / 2];
        int troca;
        while (esq <= dir) {
            while (v[esq] < pivo) {
                esq = esq + 1;
            }
            while (v[dir] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = v[esq];
                v[esq] = v[dir];
                v[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda) {
            quickSort(v, esquerda, dir);
        }
        if (esq < direita) {
            quickSort(v, esq, direita);
        }
    }
 
    
        public void inverte( int[] v){
            for (int i = 1; i < v.length; i++){
                for (int j = 0; j < i; j++) {
                    if (v[i] > v[j]) {
                        int temp = v[i];
                        v[i] = v[j];
                        v[j] = temp;
                    }
                }
            }
        }
}
        

