package Sorting_Algorythms;

import java.util.Arrays;

/**
 * Created by Artem Konyukhov on 03.07.2017.
 */
public class Example1 {

    public static void main(String[] args) {

        int[] unsortedArray = {2, 1, 4, 8, 7, 5, 6, 3};
        System.out.println(Arrays.toString(unsortedArray));
        choiceSort(unsortedArray);
        bubbleSort(unsortedArray);
        insertSort(unsortedArray);
    }

    public static void choiceSort(int[] arrayToSort) {

        //Проходим по массиву
        //Ищем минимальный элемент
        //Меняем местами первый и минимальный элементы
        //Повторяем, пока не пройдем по всему массиву

        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int indexMin;
        for (int index = 0; index < array.length - 1; index++) {
            indexMin = index;
            for (int indexToScan = index; indexToScan < array.length; indexToScan++) {
                if (array[indexMin] > array[indexToScan]) {
                    indexMin = indexToScan;
                }
            }
            int temp = array[index];
            array[index] = array[indexMin];
            array[indexMin] = temp;
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] arrayToSort) {

        //Проходим по массиву
        //Сравниваем два соседних элемента
        //Повторяем, пока массив не будет отсортирован

        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int changeCounter;
        do {
            changeCounter = 0;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    changeCounter++;
                }
            }
        } while (changeCounter > 0);
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] arrayToSort) {

        //Проходим по массиву
        //Выбираем элемент
        //Устанавливаем элемент на законное место в отсортированном массиве

        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int element;
        int indexToInsert;
        for (int index = 0; index < array.length; index++) {
            element = array[index];
            indexToInsert = index;

            while (indexToInsert > 0 && array[indexToInsert - 1] > element) {
                array[indexToInsert] = array[indexToInsert - 1];
                indexToInsert--;
                array[indexToInsert] = element;
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }
}