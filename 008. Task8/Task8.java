/*
    Пусть дан LinkedList с несколькими элементами. 
    Реализуйте метод, который вернет “перевернутый” список.
*/

import java.util.LinkedList;
import java.util.Random;

public class Task8 {
    private static Random random = new Random();
    
    public static void main(String[] args) {
        
        //формируем и выводим на экран LinkedList
        LinkedList<Integer> list = getRandomLinkedList(11,0,100);
        System.out.println( "Сгенерированный LinkedList: ");
        System.out.println(list);
        
        // переворачиваем и выводим на экран LinkedList
        LinkedList<Integer> list1 = reversLinkedList(list);
        System.out.println( "\nПеревёрнутый LinkedList: ");
        System.out.println(list1);
    }


    // переворачивалка LinkedList
    static LinkedList reversLinkedList(LinkedList<Integer> list){
        LinkedList<Integer> listTemp = new LinkedList<Integer>();
        for (int i = 1; i <= list.size(); i++) {
            listTemp.add(list.get(list.size()-i));
        }
        return listTemp;
    }


    // формируем массив размера size со случайными значениями от min до max    
    static LinkedList getRandomLinkedList(int size, int min, int max){
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        while (index < size) {
            list.add(random.nextInt(min, max));
            index = index + 1;
        }
        return list;
    }

}