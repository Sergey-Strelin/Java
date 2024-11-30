/*
    Реализовать алгоритм сортировки слиянием.   
*/

import java.util.Random;


public class Task5 {
    private static Random random = new Random();
    public static void main(String[] args) {
       
        int[] arr = getRandomArray(11, 0, 100); // создаём массим

        printArr(arr, "Сгенерированный массив: "); // выводим созданный массив на экран

        sortArr(arr); //сортируем массив

        printArr(arr, "Отсортированный массив: "); // выводим отсортированный массив на экран

    }


    // формируем массив размера size со случайными значениями от min до max    
    static int[] getRandomArray(int size, int min, int max){
        int[] arr = new int[size];//
        int index = 0;
        while (index < size) {
            arr[index] = random.nextInt(min, max);
            index = index + 1;
        }
        return arr;
    }


    // выводим содержимое массива на экран
    static String printArr(int[] arr, String text){
        System.out.println(text);
        for (int element : arr) System.out.printf("%d ", element);
        System.out.println("");

        return null;
    }


    public static int[] sortArr(int[] array){
        //if (array == null) return null;    
        if (array.length == 1) return array; // заканчиваем делить массив (остался один элемент)

        // создаём первый временный (половинный) массив 
        int firstPartArray[] = new int[array.length/2]; 
        System.arraycopy(array, 0, firstPartArray, 0, array.length/2);//копируем в лев часть
        
        // создаём второй временный массив ( оставшейся длинны)
        int secondPartArray[] = new int[array.length-firstPartArray.length];
        System.arraycopy(array, firstPartArray.length, secondPartArray, 0, array.length-firstPartArray.length);
        
        // сортируем первый и второй временные массивы (рекурсивно вызывая эту же функцию)
        sortArr(firstPartArray);
        sortArr(secondPartArray);

        mergeArr(array, firstPartArray,secondPartArray);  //объединяем отсортированные части массива

        return array;
    }


    // слиние двух отсортированных массивов
    public static void mergeArr(int[] array, int[] firstPartArray, int[] secondPartArray) {
        // задаём начальные значения
        int positionLeftArr = 0;
        int positionRightArr = 0;
        int len = array.length;
       
        // бежим по первому массиву и проверяем кто больше и в случае окончания одного из них добавляем 
        // остальные элементы из другого массива
        for (int i = 0; i < len; i++) {
            if (positionLeftArr == firstPartArray.length){  //элементы первого массива закончились? - переносим оставшиеся из второй части 
                array[i] = secondPartArray[positionRightArr];
                positionRightArr++;
            } else if (positionRightArr == secondPartArray.length) {    //элементы второго массива закончились? - переносим оставшиеся из первой части 
                array[i] = firstPartArray[positionLeftArr];
                positionLeftArr++;
            } else if (firstPartArray[positionLeftArr] < secondPartArray[positionRightArr]) {   //проверяем что элемент меньше и его добавляем в общий массив
                array[i] = firstPartArray[positionLeftArr];     
                positionLeftArr++;      // и переходим к следующему элементу
            } else {    //если элемент второй части меньше элемента первой - добавляем его в результир.массив
                array[i] = secondPartArray[positionRightArr];
                positionRightArr++;     //и берем след элем из второй части
            }
        }
    }

}