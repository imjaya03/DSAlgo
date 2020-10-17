package com.jayadrata;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {
    private T[] array;
    private int count;

    /** BIG-O Complexity -> Time: O(1) */
    public DynamicArray(){
        array = (T[])new Object[5];
    }

    /** BIG-O Complexity -> Time: O(1) */
    public DynamicArray(int initialCapacity){
        if(initialCapacity<=0)
            throw new IllegalArgumentException();
        array = (T[])new Object[initialCapacity];
    }


    /** BIG-O Complexity -> Time: O(1) */
    public T get(int index){
        if(isInvalidIndex(index))
            throw new IllegalArgumentException();
        return array[index];
    }

    /** BIG-O Complexity -> Time: O(n) */
    public void set(int index, T data){
        if(isInvalidIndex(index))
            throw new IllegalArgumentException();
        array[index] = data;
    }

    /** BIG-O Complexity -> Time: O(n) */
    public boolean contains(T data){
        for(int i=0; i<count; i++){
            if(array[i] == data)
                return true;
        }
        return false;
    }

    /** BIG-O Complexity -> Time: O(1) */
    public void insert(T data){
        if(isFull())
            increaseCapacity();
        array[count++] = data;
    }

    /** BIG-O Complexity -> Time: O(n) */
    public void insertAt(int index, T data){
        count++;
       if(isInvalidIndex(index))
           throw new IllegalArgumentException();
       if(isFull())
           increaseCapacity();
       var right = new int[count - index];
       var newArray = (T[])new Object[count];
       int x=0;
       for(int i=0; i<count; i++){
           if(i==index){
               newArray[i] = data;
               x=1;
               continue;
           }
           newArray[i] = array[i-x];
       }
       array = newArray;
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
    public int indexOf(T data){
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
        array = (T[])new Object[array.length*2];
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
