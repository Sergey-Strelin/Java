/* 
    Пусть дан произвольный список целых чисел. 
    Удалить из него чётные числа.   
*/

 import java.util.ArrayList;
 import java.util.Random;
 import java.util.List;
 
 public class Task6 {
 
     private static Random random = new Random();
     public static void main(String[] args) {
 
         // заполняем список случайными значениями
         List<Integer> listArray = getRandomArray(10, -50, 51);
         
         // выводим список чисел на экран
         System.out.println("Содержимое списка чисел:");
         System.out.println(listArray);
         
         // удаляем чётные числа
         removalEvenElements(listArray);

         // выводим результат на экран
         System.out.println("Список только НЕчётных чисел:");         
         System.out.println(listArray);
         
     }
 
     // формируем массив размера size со случайными значениями от min до max    
     static List<Integer> getRandomArray(int size, int min, int max){
         List<Integer> listArray = new ArrayList<Integer>();
         
         int index = 0;
         while (index < size) {
             listArray.add(random.nextInt(min, max));
             index = index + 1;
         }
         return listArray;
     }

     // удаление чётных чисел
     static List<Integer> removalEvenElements(List<Integer> listAr){
        for (int i = 0; i < listAr.size(); i++) {
            if ((Integer)listAr.get(i) % 2 == 0){
                listAr.remove(i);
                i--;
            }
        }
        return listAr;
    }
 
 }