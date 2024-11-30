/*
    Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите
    в лог-файл.
*/

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task3 {
    private static Random random = new Random();
    public  static void main(String[] args){

        int[] arr = getRandomArray(10, 0, 100); // создаём массим

        printArr(arr, "Сгенерированный массив: "); // выводим созданный массив на экран

        bubleSortArr(arr); //сортируем массив + ведём журнал сортировки

        printArr(arr, "Отсортированный массив: "); // выводим отсортированный массив на экран
    }
    static void bubleSortArr(int[] arr){
        try { 
            // запускаем журналирование
            Logger logger = Logger.getLogger(task3.class.getName());
            FileHandler fh = new FileHandler("logging_task3.txt");
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            //отключаем вывод на экран
            logger.setUseParentHandlers(false);

            // начинаем сортироваку
            int len =  arr.length;
            int el = 0;
            String str = "";
            for (int i = 0; i < len-1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] > arr[j]) {
                        el = arr[i];
                        arr[i] = arr[j];
                        arr[j] = el;
                        str = "Число " + el + " перемещено c позиции " + i + " на позицию " + j;
                        logger.info(str);
                    }
                }
                str = "";
            }
            } catch (IOException ex){
                System.out.println("Что-то с файлом...");
            }
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
}
