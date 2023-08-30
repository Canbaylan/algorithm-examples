package com.canbaylan.dynamicArray;

public class DynamicArray {
    public int size;
    public int capacity = 10;
    Object[] array;
    public DynamicArray(){
        this.array = new Object[capacity];
    }
    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }
    public void add(Object data){
        if(size >= capacity){
            grow();
        }
        array[size]=data;
        size++;
    }
    public void insert(int index, Object data){
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException("Invalid index");
        if(size >= capacity)
            grow();
        for(int i=size;i>index;i--)
            array[i] = array[i-1];
        array[index]=data;
        size++;
    }
    public void delete(Object data){
        int index = search(data);
        if(index != -1){
            for(int i=index;i<size-1;i++)
                array[i]=array[i+1];
        }
        array[size-1]=null;
        size--;
        shrink();
    }
    public int search(Object data){
        for(int i=0;i<size;i++){
            if(array[i].equals(data))
                return i;
        }
        return -1;
    }
    private void grow(){
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;

    }
    private void shrink(){
        if (capacity > 10 && size <= capacity / 3) {
            capacity /= 2;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
        String str = "";
        for(int i=0;i<size;i++)
            str += array[i] + ", ";
        if( str != "")
            str = "["+str.substring(0, str.length()-2)+"]";
        else
            str = "[]";
        return str;
    }
}
