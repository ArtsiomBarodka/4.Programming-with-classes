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

import java.util.Objects;

public class District {

    private String name;
    private int area;
    private City city;

    public District(String name, int area, City city) {
        this.name = name;
        this.area = area;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Район ").append(name)
                .append(" с городом ").append(city.toString());
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return name.equalsIgnoreCase(district.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
