package com.jayadrata;

public class DynamicArray {
    private int[] array;
    private int count;

    /** BIG-O Complexity -> Time: O(1) */
    public DynamicArray(){
        array = new int[5];
    }

    /** BIG-O Complexity -> Time: O(1) */
    public DynamicArray(int initialCapacity){
        if(initialCapacity<=0)
            throw new IllegalArgumentException();
        array = new int[initialCapacity];
    }

    /** BIG-O Time Complexity O(1) */
    public int get(int index){
        if(isInvalidIndex(index))
            throw new IllegalStateException();
        return array[index];
    }

    /** BIG-O Complexity -> Time: O(n) */
    public void set(int index, int data){
        if(isInvalidIndex(index))
            throw new IllegalArgumentException();
        array[index] = data;
    }

    /** BIG-O Complexity -> Time: O(1) */
    public void insert(int data){
        if(isFull())
            increaseCapacity();
        array[count++] = data;
    }

    /** BIG-O Complexity -> Time: O(n) */
    public void reverse(){
        int i = 0;
        int j = count - 1;
        while(i < j){
            var temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }

    /** BIG-O Complexity -> Time: O(n) */
    public void removeAt(int index){
        if(isInvalidIndex(index))
            throw new IllegalArgumentException();
        for(int i=index; i<count; i++)
            array[i] = array[i+1];
        count--;
    }

    /** BIG-O Complexity -> Time: O(n) */
    public int indexOf(int data){
        for(int i=0; i<count; i++)
            if(array[i]==data)
                return i;
        return -1;
    }

    /** BIG-O Complexity -> Time: O(1) */
    private boolean isInvalidIndex(int index){
        return index < 0 || index >= count;
    }


    /** BIG-O Complexity -> Time: O(1) */
    private boolean isFull(){
        return count == array.length;
    }

    /** BIG-O Complexity -> Time: O(1) */
    public int size(){
        return count;
    }

    /** BIG-O Complexity -> Time: O(1) */
    public boolean isEmpty(){
        return count == 0;
    }

    /** BIG-O Complexity -> Time: O(n) */
    private void increaseCapacity(){
        var temp = array;
        array = new int[array.length*2];
        for(int i=0; i<temp.length; i++){
            array[i] = temp[i];
        }
    }

    /** BIG-O Complexity -> Time: O(n) */
    @Override
    public String toString() {
        var str = new StringBuilder();
        str.append("[");
        for(int i=0; i<count; i++) {
            str.append(array[i]);
            if(!(i==(count-1)))
                str.append(", ");
        }
        str.append("]");
        return str.toString();
    }

}
