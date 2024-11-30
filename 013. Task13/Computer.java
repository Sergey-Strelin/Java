/*
    Класс компьютер и его методы
*/


public class Computer {
    private String processor;
    private String memory;
    private String hdd;
    private String operationSystem;
    private String color;


    public Computer(String processor, String memory, String hdd, String operationSystem, String color) {
        this.processor = processor;
        this.memory = memory;
        this.hdd = hdd;
        this.operationSystem = operationSystem;
        this.color = color;
    }


    public String getProcessor() {
        return processor;
    }

    public String getMemory() {
        return memory;
    }

    public String getHdd() {
        return hdd;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getColor() {
        return color;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public void setColor(String color) {
        this.color = color;
    }    


    //переопределяем правило сравнения двух компьютеров
    @Override
    public boolean equals(Object o) {
        Computer computer = (Computer) o;
        if (
            this.processor == computer.processor && 
            Integer.parseInt(this.memory) >= Integer.parseInt(computer.memory) && 
            Integer.parseInt(this.hdd) >= Integer.parseInt(computer.hdd) && 
            this.operationSystem == computer.operationSystem && 
            this.color == computer.color
            )
            return true;
        else 
            return false;
    }

    
    @Override
    public String toString() {
        return "Процессор - " + processor + "; " +
               "Объём памяти - " + memory + " Гб; " +
               "Объём диска - " + hdd + " Гб; " +
               "Операционная система - '" + operationSystem + '\'' + " " +
               "Цвет корпуса - '" + color + '\'';
        }
}
