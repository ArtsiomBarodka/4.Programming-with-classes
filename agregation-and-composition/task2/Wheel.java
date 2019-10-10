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

import java.util.Random;

public class Wheel {

    private int id;
    private String name;
    private int state;

    public Wheel(String name,int id) {
        this.name = name;
        this.id = id;
        state = new Random().nextInt(5)+1;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void wear() throws Exception {
        if(state == 0){
            throw new Exception("Сломалось колесо номер " + id);
        }
        state--;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
