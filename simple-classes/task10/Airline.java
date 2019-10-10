/*
 * 4.Simple Classes
 * Task 10
 *
 * Создать класс Airline, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task10;

public class Airline {

    private String destination;
    private int flightNumber;
    private TypeOfAircraft type;
    private int time;
    private Day []daysOfWeek;

    public Airline() {
    }

    public Airline(String destination, int flightNumber, TypeOfAircraft type, int time, Day daysOfWeek[]) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.type = type;
        this.time = time;
        this.daysOfWeek = daysOfWeek;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public TypeOfAircraft getType() {
        return type;
    }

    public void setType(TypeOfAircraft type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Day []getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDayOfWeek(Day dayOfWeek[]) {
        this.daysOfWeek = dayOfWeek;
    }

    private String toStringDate(){
        int h = time/60;
        int m = time - h*60;
        String hours = String.valueOf(h);
        String minutes = String.valueOf(m);
        if(h < 10){
            hours = "0".concat(hours);
        }
        if(m < 10){
            minutes = "0".concat(minutes);
        }
        return hours+"."+minutes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Рейс номер " +flightNumber+
                " до " + destination +
                " , вермя вылета " + toStringDate() +
                ", дни недели: ");
        for (Day c:daysOfWeek) {
            result.append(c+", ");
        }
        result.deleteCharAt(result.lastIndexOf(","));
        return result.toString();
    }
}
