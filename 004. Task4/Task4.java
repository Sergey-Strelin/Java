/*  
    В файле содержится строка с данными:
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
*/


import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class task4 {
    public static void main(String[] args){

        String stroka = fileRead("data_task4.txt");                     // считываем из файла
        String[] result = resultStr(parsRawString(stroka)).split(",");     // формируем нужную строку
        printStr(result);

    }


    // читаем строку из файла
    static String fileRead(String fileName){
        String strInFile = "";
        try {
            BufferedReader str = new BufferedReader(new FileReader(fileName));
            strInFile = str.readLine();
            str.close();
        } catch (IOException ex){
            System.out.println("Не удалось прочитать файл " + fileName + " !");
        }
        return strInFile;
    }


    // из заданной строки формируем вида Фамилия, оценка, предмет
    static String parsRawString(String str){
        StringBuilder rezult = new StringBuilder();
        str = str.substring(1, str.length()-1);     // отрезаем [ и ]
        String[] strArr = str.split(", ");               // ормируем массив из элементов в { }
        for (String el : strArr){
            rezult.append(String.join(",", stringPars(el)));
            rezult.append(",");
        }
        return rezult.toString();                                   // возвращаем строку вида Фамилия, оценка, предмет
    }


    // формируем итоговую строку
    static String resultStr(String str){ 
        StringBuilder rezult = new StringBuilder();
        String[] arr = str.split(",");
        for (int i = 0; i <arr.length ; i+=3) {
            if (arr[i].endsWith("а")) {
                rezult.append("Студентка ");
                rezult.append(arr[i]);
                rezult.append(" получила ");
            } 
            else {
                rezult.append("Студент ");
                rezult.append(arr[i]);                
                rezult.append(" получил ");
            }
            rezult.append(arr[i+1]);
            rezult.append(" по предмету ");
            rezult.append(arr[i+2]);
            rezult.append(".\n");
        }
        return rezult.toString();
    }



    // разбираем исходную строку
    static String[] stringPars(String str){
        int index = 0;
        str = str.substring(1, str.length()-1);        // отрезаем {}
        String[] strArr = str.split(",");                   // собираем в массив, с элементами вида "ключ":"значение" (нарезаем по запятой)
        int len = strArr.length;
        String[] strSQL = new String[len];
        for (String elem : strArr){
            int ind = elem.indexOf(':');                          // каждый элемент разрезаем по ":"
            strSQL[index] = elem.substring(ind+2, elem.length()-1);    // и сохраняем полученные значения
            index++;
        }
        return strSQL;
    }

    
     // выводим результат на экран
     static String printStr(String[] text){
        for (String el : text){          
            System.out.println(el);
        }
        return null;
    }   
}