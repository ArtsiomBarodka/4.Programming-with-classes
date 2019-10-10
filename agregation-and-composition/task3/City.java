/*
 * 4.Simple Classes
 * Task 3
 *
 * Создать объект класса Государство, используя классы Область,
 * Район, Город. Методы: вывести на консоль столицу, количество областей, площадь, областные центры
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.agregation_and_composition.Task3;

public class City {

    private String name;
    private boolean isCentralCity;
    private boolean isCapital;

    public City(String name,boolean isCentralCity,boolean isCapital) {
        this.isCapital = isCapital;
        this.isCentralCity = isCentralCity;
        this.name = name;
    }

    public City(String name) {
        this.isCapital = false;
        this.isCentralCity = false;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCentralCity() {
        return isCentralCity;
    }

    public void setCentralCity(boolean centralCity) {
        isCentralCity = centralCity;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return  name ;
    }

}
