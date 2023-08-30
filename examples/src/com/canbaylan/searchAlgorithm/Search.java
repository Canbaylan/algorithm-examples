package com.canbaylan.searchAlgorithm;

public class Search {
    public int linearSearch(int[] array, int value){
        for(int i=0;i<array.length;i++){
            if(array[i] == value)
                return i;
        }
        return -1;
    }
    public int binarySearch(int[] array, int target){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid=low +(high-low)/2;
            int val=array[mid];
            if(val<target)
                low = mid+1;
            else if(val>target)
                high= mid-1;
            else
                return mid;
        }
        return -1;
    }
}
