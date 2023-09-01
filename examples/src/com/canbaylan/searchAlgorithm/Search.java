package com.canbaylan.searchAlgorithm;

public class Search {
    public int linearSearch(int[] array, int value){//O(n)
        for(int i=0;i<array.length;i++){
            if(array[i] == value)
                return i;
        }
        return -1;
    }
    public int binarySearch(int[] array, int target){//O(log n)
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
    public int interpolationSearch(int[] array, int value){//O(log log n)
        int high =array.length-1;
        int low =0;
        while(value>=array[low] && value <=array[high] && low<=high){
            int probe = low + (high-low) * (value-array[low]) / (array[high]-array[low]);
            if(array[probe] == value)
                return probe;
            else if(array[probe]<value)
                low = probe+1;
            else
                high = probe-1;
        }
        return -1;
    }
}
