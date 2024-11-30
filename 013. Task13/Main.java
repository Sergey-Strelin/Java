import java.util.*;


public class Main {
    private static Scanner input = new Scanner(System.in, "Cp866");
    public static void main(String[] args) {
        List<Computer> computers = Comuters();

        //меню и его обработка
        boolean stopWhile = true;
        while (stopWhile){
            System.out.println(menu());
            int whatDo = input.nextInt();
            switch(whatDo) {
                case 1: 
                    viewAllComp(computers);
                    break;
                case 2:
                    Map<String,String> parametrMap = findParam(computers);
                    findComp(parametrMap, computers);
                    break;
                case 3:
                    stopWhile = false;
                    break;
                default:
                    System.out.println((char) 27 + "[31mНет такого пункта меню!"+ (char)27 + "[0m");
            }        
        }
    }

    // наполняем список компьютеров
    private static List<Computer> Comuters() {
        List<Computer> computers = new ArrayList<>();
        computers.add(new Computer("Core 2 Duo", "1", "64", "DOS 6.22", "Белый"));
        computers.add(new Computer("Core 2 Duo", "2", "128", "Windows 95", "Серый"));
        computers.add(new Computer("Core 2 Duo", "4", "256", "Windows Milenium", "Чёрный"));
        computers.add(new Computer("Core 2 Duo", "8", "512", "Windows 7", "Красный"));
        computers.add(new Computer("Core 2 Duo", "16", "1024", "Windows 8.1", "Стальной"));
        computers.add(new Computer("Pentium 4", "1", "64", "DOS 6.22", "Белый"));
        computers.add(new Computer("Pentium 4", "2", "128", "Windows 95", "Серый"));
        computers.add(new Computer("Pentium 4", "4", "256", "Windows Milenium", "Чёрный"));
        computers.add(new Computer("Pentium 4", "8", "512", "Windows 8.1", "Красный"));
        computers.add(new Computer("Pentium 4", "16", "1024", "DOS 6.22", "Стальной"));
        computers.add(new Computer("AMD FX 2800", "1", "64", "DOS 6.22", "Белый"));
        computers.add(new Computer("AMD FX 2800", "2", "128", "Windows 95", "Серый"));
        computers.add(new Computer("AMD FX 2800", "4", "256", "Windows Milenium", "Чёрный"));
        computers.add(new Computer("AMD FX 2800", "8", "512", "Windows 7", "Красный"));
        computers.add(new Computer("AMD FX 2800", "16", "1024", "Windows 8.1", "Стальной"));
        computers.add(new Computer("Core Quadro", "1", "64", "DOS 6.22", "Белый"));
        computers.add(new Computer("Core Quadro", "2", "128", "Windows 95", "Серый"));        
        computers.add(new Computer("Core Quadro", "4", "256", "Windows Milenium", "Чёрный"));
        computers.add(new Computer("Core Quadro", "8", "512", "Windows 7", "Красный"));
        computers.add(new Computer("Core Quadro", "16", "1024", "Windows 8.1", "Стальной"));
        computers.add(new Computer("Intel i3", "1", "64", "DOS 6.22", "Белый"));
        computers.add(new Computer("Intel i3", "2", "128", "Windows 95", "Серый"));
        computers.add(new Computer("Intel i3", "4", "256", "Windows Milenium", "Чёрный"));
        computers.add(new Computer("Intel i3", "8", "512", "Windows 7", "Красный"));
        computers.add(new Computer("Intel i3", "16", "1024", "Windows 8.1", "Стальной"));
        computers.add(new Computer("AMD Ryzen 3", "1", "64", "DOS 6.22", "Белый"));
        computers.add(new Computer("AMD Ryzen 3", "2", "128", "Windows 95", "Серый"));
        computers.add(new Computer("AMD Ryzen 3", "4", "256", "Windows Milenium", "Чёрный"));
        computers.add(new Computer("AMD Ryzen 3", "8", "512", "Windows 7", "Красный"));
        computers.add(new Computer("AMD Ryzen 3", "16", "1024", "Windows 8.1", "Стальной"));
        
        return computers;        
    }


    // создаём меню 
    private static String menu() {
        String menuStr = new StringBuilder()
        .append((char) 27 + "[34m\nВыберите действие: \n"+ (char)27 + "[0m")
        .append("1 - Посмотреть все компьютеры \n")
        .append("2 - Выбрать по параметрам \n")
        .append("3 - Выход ")
        .toString();

        return menuStr;
    }


    // показываем все компьютеры
    private static void viewAllComp(List<Computer> computers) {
        System.out.println((char) 27 + "[32m\nПеречень имеющихся компьютеров"+ (char)27 + "[0m");
        for (Computer elem: computers) {
            System.out.println(elem);        
        }
    }


    // выбор параметров для поиска компьютера
    private static Map<String, String> findParam(List<Computer> computers) {
        Map<String, String> findParam = new LinkedHashMap<String, String>();
        ArrayList<String> tmpSelect = new ArrayList<String>();
        
        // формируем список процессоров
        int count = 0;
        for (Computer elem: computers){
            if (!tmpSelect.contains(elem.getProcessor())) {
                tmpSelect.add(count, elem.getProcessor());
                count += 1;
            }
        }
        Collections.sort(tmpSelect);
        String selectionProcessor = selectElement(tmpSelect, "модель процессора");
        
        // формируем список памяти
        tmpSelect.clear();
        count = 0;
        for (Computer elem: computers){
            if (!tmpSelect.contains(elem.getMemory())) {
                tmpSelect.add(count, elem.getMemory());
                count += 1;
            }
        }
        Collections.sort(tmpSelect);
        String selectionMemory = selectElement(tmpSelect, "объём оперативной памяти");

        // формируем список жёстких дисков
        tmpSelect.clear();
        count = 0;
        for (Computer elem: computers){
            if (!tmpSelect.contains(elem.getHdd())) {
                tmpSelect.add(count, elem.getHdd());
                count += 1;
            }
        }
        Collections.sort(tmpSelect);
        String selectionHDD = selectElement(tmpSelect, "объём жёсткого диска");
        
        // формируем список операционных систем
        tmpSelect.clear();
        count = 0;
        for (Computer elem: computers){
            if (!tmpSelect.contains(elem.getOperationSystem())) {
                tmpSelect.add(count, elem.getOperationSystem());
                count += 1;
            }
        }
        Collections.sort(tmpSelect);
        String selectionOs = selectElement(tmpSelect, "операционную систему");
       
        // формируем список жёстких дисков
        tmpSelect.clear();
        count = 0;
        for (Computer elem: computers){
            if (!tmpSelect.contains(elem.getColor())) {
                tmpSelect.add(count, elem.getColor());
                count += 1;
            }
        }
        Collections.sort(tmpSelect);
        String selectionColor = selectElement(tmpSelect, "цвет системного блока");

        //собираем параметры для поиска в Мар (findParam)
        findParam.put("processor", selectionProcessor);
        findParam.put("memory", selectionMemory);
        findParam.put("hdd", selectionHDD);
        findParam.put("operationSystem", selectionOs);
        findParam.put("color", selectionColor);
        System.out.println((char) 27 + "[33m\nВы выбрали следующую конфигурацию компьютера: \n"  + (char)27 + "[0m" + 
                        "Процессор - " + selectionProcessor + "; " +
                        "Объём оперативной памяти - " + selectionMemory + " Гб; " +
                        "Объём жёсткого диска - " + selectionHDD + "Гб; " +
                        "Операционная система - " + selectionOs + "; " + 
                        "Цвет корпуса - " + selectionColor);
        return findParam;
    }


    // формирование меню и выбор элемента
    private static String selectElement(ArrayList<String> tmpSelect, String whatSelect) {
        String selection = "";
        System.out.println((char) 27 + "[33mВыбенрите" + whatSelect + ": " + (char)27 + "[0m");
        Integer count = 1;
        for (Object tmp : tmpSelect){
            System.out.println(count + " - " + tmp + ";" );
            count += 1;
        }
       
        selection = tmpSelect.get(input.nextInt()-1);

        return selection;
        
    }


    // поиск компьютера по параметрам
    private static void findComp(Map<String, String> parametrMap, List<Computer>computers) {
        List<Computer> computer = new ArrayList<>();
        computer.add(new Computer(parametrMap.get("processor"),parametrMap.get("memory"), parametrMap.get("hdd"),parametrMap.get("operationSystem"), parametrMap.get("color")));
        List<Computer> selectComputers = new ArrayList<>();
        for (Computer elem: computers){
            if (elem.equals(computer.get(0)) ) {
                selectComputers.add(elem);
            }
        }
        if (selectComputers.size() == 0){
            System.out.println((char) 27 + "[31m \nКомпьютеров с заданными параметрами нет!" + (char)27 + "[0m");
        }
        else {
            System.out.println((char) 27 + "[32m \nСписок имеющихся компьютеров" + (char)27 + "[0m");
            for (Computer elem: selectComputers) {
                System.out.println(elem);        
            }
        }

        return;
    }
}