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

import java.util.Random;

public class Airport {

    private int index;
    private Airline[] airlines;

    public Airport() {
        String destination[] = {"Indonesia","Batumi","Minsk","Paris","Kiev"};
        TypeOfAircraft[] types = {TypeOfAircraft.AIRBUS,TypeOfAircraft.BOEING,TypeOfAircraft.TY_144};
        Day calendar[] = {Day.MONDAY,Day.TUESDAY,Day.WEDNESDAY,Day.THURSDAY,Day.FRIDAY,Day.SATURDAY,Day.SUNDAY};
        index = 10;
        airlines = new Airline[index];
        for (int i = 0; i < airlines.length; i++) {
            Airline airline = new Airline();
            airline.setDestination(destination[new Random().nextInt(5)]);
            airline.setFlightNumber((int) Math.floor(Math.random() * 9000) + 1000);
            airline.setType(types[new Random().nextInt(3)]);
            Day []days = new Day[new Random().nextInt(5)+1];
            for (int j = 0; j < days.length; j++) {
                days[j]=calendar[new Random().nextInt(7)];
            }
            airline.setDayOfWeek(days);
            airline.setTime((int) Math.floor(Math.random() * 1000) + 100);
            airlines[i] = airline;
        }
    }

    public Airport(Airline[] airlines) {
        this.airlines = airlines;
        index = airlines.length;
    }


    public void setAirlines(Airline[] airlines) {
        index = index + airlines.length;
        Airline[] res = new Airline[index];
        for (int i = 0; i < this.airlines.length; i++) {
            res[i] = this.airlines[i];
        }
        for (int i = this.airlines.length; i < res.length; i++) {
            res[i] = airlines[i];
        }
        this.airlines = res;
    }

    public void addAirline(Airline airline){
        index = index + 1;
        Airline[] res = new Airline[index];
        for (int i = 0; i < airlines.length; i++) {
            res[i] = airlines[i];
        }
        res[index-1] = airline;
        airlines = res;
    }

    public void deleteAirline(Airline airline){
        Airline[] res;
        for (int i = 0; i < airlines.length; i++) {
            if(airlines[i].getFlightNumber() == airline.getFlightNumber()){
                index--;
            }
        }
        res = new Airline[index];
        int j = 0;
        for (int i = 0; i < airlines.length; i++) {
            if(airlines[i].getFlightNumber() != airline.getFlightNumber()){
                res[j] = airlines[i];
                j++;
            }
        }
        airlines = res;
    }

    public Airline[] getAirlines(String destination){
        Airline[] result;
        int index = 0;
        for (int i = 0; i < airlines.length; i++) {
            if(airlines[i].getDestination().equalsIgnoreCase(destination)){
                index++;
            }
        }
        result = new Airline[index];
        index = 0;
        for (int i = 0; i < airlines.length; i++) {
            if(airlines[i].getDestination().equalsIgnoreCase(destination)){
                result[index] = airlines[i];
                index++;
            }
        }
        return result;
    }

    public Airline[] getAirlines(Day dayOfWeek){
        Airline[] result;
        int index = 0;
        for (int i = 0; i < airlines.length; i++) {
            Day []daysOfWeek = airlines[i].getDaysOfWeek();
            for (int j = 0; j < daysOfWeek.length; j++) {
                if(daysOfWeek[j].equals(dayOfWeek)){
                    index++;
                }
            }
        }
        result = new Airline[index];
        index = 0;
        for (int i = 0; i < airlines.length; i++) {
            Day []daysOfWeek = airlines[i].getDaysOfWeek();
            for (int j = 0; j < daysOfWeek.length; j++) {
                if(daysOfWeek[j].equals(dayOfWeek)){
                    result[index] = airlines[i];
                    index++;
                }
            }
        }
        return result;
    }

    public Airline[] getAirlines(Day dayOfWeek, int time){
        Airline[] result;
        int index = 0;

        for (int i = 0; i < airlines.length; i++) {
            if(airlines[i].getTime() <= time){
                continue;
            }
            Day []daysOfWeek = airlines[i].getDaysOfWeek();
            for (int j = 0; j < daysOfWeek.length; j++) {
                if(daysOfWeek[j].equals(dayOfWeek)){
                    index++;
                }
            }
        }
        result = new Airline[index];
        index = 0;

        for (int i = 0; i < airlines.length; i++) {
            if(airlines[i].getTime() <= time){
                continue;
            }
            Day []daysOfWeek = airlines[i].getDaysOfWeek();
            for (int j = 0; j < daysOfWeek.length; j++) {
                if(daysOfWeek[j].equals(dayOfWeek)){
                    result[index] = airlines[i];
                    index++;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Airline a:airlines) {
            result.append(a).append("\n");
        }
        return result.toString();
    }
}
