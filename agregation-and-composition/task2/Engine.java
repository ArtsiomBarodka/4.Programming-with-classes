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

public class Engine {

    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
