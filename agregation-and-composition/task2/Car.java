/*
 * 4.Simple Classes
 * Task 2
 *
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.agregation_and_composition.Task2;

public class Car {
    private int id;
    private String name;
    private Engine engine;
    private Wheel[] wheels;
    private int fuel;

    public Car(String name) {
        this.name = name;
        id = (int) Math.floor(Math.random() * 9_000_000) + 1_000_000;
        engine = new Engine(name+"-engine");
        Wheel wheel1 = new Wheel(name+"-wear-1",1);
        Wheel wheel2 = new Wheel(name+"-wear-2",2);
        Wheel wheel3 = new Wheel(name+"-wear-3",3);
        Wheel wheel4 = new Wheel(name+"-wear-4",4);
        wheels = new Wheel[4];
        wheels[0] = wheel1;
        wheels[1] = wheel2;
        wheels[2] = wheel3;
        wheels[3] = wheel4;
        fuel = 5;
    }

    public String getName() {
        return name;
    }

    public int getFuel() {
        return fuel;
    }

    public void drive() throws Exception {
        decreaseFuel();
        for (int i = 0; i < wheels.length; i++) {
            wheels[i].wear();
        }
        System.out.println("Едем \n");
    }

    private void decreaseFuel()throws Exception{
        if(fuel == 0){
            throw new Exception("Нету топлива, нужно заправиться!\n");
        }
        fuel--;
    }

    public void refuel(){
        fuel = 5;
        System.out.println("Заправились\n");
    }

    public void changeWheel(int id){
        for (int i = 0; i < wheels.length; i++) {
            int newId = wheels[i].getId();
            if(newId == id){
                wheels[i] = new Wheel(name+"-wear-"+newId,newId);
                System.out.println("Заменено колесо "+  wheels[i].getName());
            }
        }
    }

    public int[] getWheelsState(){
        int result[] = new int[4];
        for (int i = 0; i < result.length; i++) {
            result[i] = wheels[i].getState();
        }
        return result;
    }
}
