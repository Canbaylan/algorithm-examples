package com.canbaylan.sortAlgorithm;

public class Sort {
    public void bubbleSort(int array[]){//O(n^2)
        int len= array.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    public void selectionSort(int[] array){
        int len = array.length;
        for(int i=0;i<len-1;i++){
            int minIndex=i;
            for(int j=i+1;j<len;j++){
                if(array[minIndex]>array[j])
                    minIndex=j;
            }
            int temp= array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
    }
    public void insertionSort(int[] array){//O(n^2)
        int len = array.length;
        for(int i=1;i<len;i++){
            int temp = array[i];
            int j= i-1;

            while(j>=0 && array[j]>temp){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }
    public void mergeSort(int[] array){
        int length=array.length;
        if(length <= 1) return;
        int middle = length /2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];
        int i=0; // left arr
        int j=0; // right arr

        for(;i<length;i++){
            if(i<middle)
                leftArray[i]=array[i];
            else{
                rightArray[j]=array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,array);
    }
    private void merge(int[] left,int[] right,int[] array){
        int leftSize = array.length/2;
        int rightSize=array.length-leftSize;
        int i=0,l=0,r=0;//indices
        while(l<leftSize && r< rightSize){
            if(left[l] < right[r]){
                array[i] = left[l];
                i++;
                l++;
            }
            else{
                array[i]=right[r];
                i++;
                r++;
            }
        }
        while(l< leftSize){
            array[i]=left[l];
            i++;
            l++;
        }
        while(r<rightSize){
            array[i]=right[r];
            i++;
            r++;
        }
    }
    public void quickSort(int[] array, int start, int end){
        if(end<=start) return;
        int pivot = partition(array,start,end);
        quickSort(array,start,pivot-1);
        quickSort(array,pivot+1,end);

    }
    private int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i= start -1 ;
        for(int j=start;j<=end-1;j++){
            if(array[j]<pivot){
                i++;
                int temp= array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        i++;
        int temp= array[i];
        array[i]=array[end];
        array[end]=temp;
        return i;

    }

}
