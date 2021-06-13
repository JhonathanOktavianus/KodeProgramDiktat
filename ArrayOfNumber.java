/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */

package com.jhonathan.data;

import com.jhonathan.exceptions.ArrayException;

import java.util.Arrays;

public class ArrayOfNumber {
    private Integer[] numbers;

    public void constructArray() throws ArrayException {
        if (numbers == null){
            numbers = new Integer[0];
            System.out.println("Creating new Array");
        }
        else {
            throw new ArrayException("Array sudah dibuat");
        }
    }

    public void increaseArrayIndex() throws ArrayException {
        if (numbers == null){
            throw new ArrayException("Array belum dibuat");
        }
        else {
            numbers = Arrays.copyOf(numbers, numbers.length + 1);
            System.out.println("Array berhasil ditambah");
        }
    }

    public void addValueToArray(int index, Integer value) throws ArrayException {
        if (numbers == null ){
            throw new ArrayException("Array belum dibuat");
        }
        else if (numbers.length-1<index  ){
            throw new ArrayException("Index yang dimasukkan tidak ada pada array");
        }
        else{
            numbers[index]=value;
        }
    }

    public void showArray() throws ArrayException {
        if (numbers == null ){
            throw new ArrayException("Array belum dibuat");
        }
        else {
            System.out.print("Isian array: [");
            for (int i = 0; i < numbers.length; i++) {
                if (i<numbers.length-1) {
                    if (numbers[i] == null) {
                        System.out.print("0");
                        System.out.print(", ");
                    }
                }
                else{
                    System.out.print(numbers[i]);
                    System.out.println("]");
                }
            }
            System.out.println();
        }
    }
}