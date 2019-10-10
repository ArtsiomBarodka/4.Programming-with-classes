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

public class State {

    private String name;
    private ArrayList<Region> regions;

    public State(String name) {
        regions = new ArrayList<>();
        this.name = name;
    }

    public State(String name, ArrayList<Region> regions) {
        this.name = name;
        this.regions = regions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions.addAll(regions);
    }

    public void addRegion(Region region){
        regions.add(region);
    }

    public void deleteRegion(String name){
        regions.removeIf((Region r)->r.getName().equalsIgnoreCase(name));
    }

    public int countRegions(){
        return regions.size();
    }

    public int getArea(){
        int result = 0;
        for (Region r:regions) {
            result = result + r.getArea();
        }
        return result;
    }

    public City getCapital(){
        City city = null;
        for (Region r:regions) {
            if (r.getCentralCity().isCapital()){
                city = r.getCentralCity();
            }
        }
        return city;
    }

    public ArrayList<City> getCentralCities(){
        ArrayList<City> result = new ArrayList<>();
        for (Region r:regions) {
            result.add(r.getCentralCity());
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Государство ")
                .append(name)
                .append(" со столицей ")
                .append(getCapital())
                .append(" и областями:\n");
        for (Region r:regions) {
            result.append(r.toString()).append("\n");
        }
        return result.toString();
    }
}
