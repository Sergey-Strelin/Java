/*  
    В файле содержится строка с исходными данными в такой форме:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
    SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
    Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
    Значения null не включаются в запрос.
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class task2 {
    public static void main(String[] args)  {

        String str = fileRead("data_task2.txt");                // читаем строку из файла
        String[] sqlVal = stringPars(str);                                // отбираем в массив нужные данные из строки
        System.out.println(stringSQL(sqlVal[0],sqlVal[1],sqlVal[2]));     // формируем и выводим строку с запросом

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


    // формируем строку - SQL запрос
    static String stringSQL(String name, String country, String city){
        StringBuilder strSQL = new StringBuilder();

        strSQL.append("SELECT * FROM students WHERE name = \"");
        strSQL.append(name);

        strSQL.append("\" AND country = \"");
        strSQL.append(country);

        strSQL.append("\" AND city = \"");
        strSQL.append(city);
        strSQL.append("\";");

        return strSQL.toString();
    }

}