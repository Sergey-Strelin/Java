/* 
    Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
    Отсортировать по убыванию популярности.
*/



import java.util.*;


public class Task11 {
    
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Денис", "Александр", "Александра", "Евгений", "Александра", "Юлия", "Денис", "Юлия", "Александра"));
        Map<String, Integer> countNames = countNames(names);
        printCountNames(countNames);
    }

    private static Map<String, Integer> countNames(ArrayList<String> names) {
        Map<String, Integer> count = new HashMap<>();
        for (String name : names) {
            if (count.containsKey(name)) {
                int value = count.get(name) + 1;
                count.put(name, value);
            }
            else {
                count.put(name, 1);
            }
        }
        return count;
    }

    private static void printCountNames(Map<String, Integer> countNames) {

        countNames.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
    }
}