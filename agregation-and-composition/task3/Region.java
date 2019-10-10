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

import java.util.ArrayList;
import java.util.Iterator;

public class Region {

    private String name;
    private ArrayList<District> districts;

    public Region(String name) {
        districts = new ArrayList<>();
        this.name = name;
    }

    public Region(String name, ArrayList<District> districts) {
        this.name = name;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts.addAll(districts);
    }

    public void addDistrict(District district){
        districts.add(district);
    }

    public void deleteDistrict(String name){
        Iterator<District> iterator = districts.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getName().equalsIgnoreCase(name)) {
                iterator.remove();
            }
        }
    }

    public City getCentralCity(){
        City city = null;
        for (District d:districts) {
            if(d.getCity().isCentralCity()){
                city = d.getCity();
            }
        }
        return city;
    }

    public int getArea(){
        int result = 0;
        for (District d:districts) {
            result = result + d.getArea();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name)
                .append(" область с областным центром ")
                .append(getCentralCity().toString())
                .append(" и районами:\n");
        for (District d:districts) {
            result.append(d.toString()).append("\n");
        }
        return result.toString();
    }

}
