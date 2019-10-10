/*
 * 4.Simple Classes
 * Task 4
 *
 * Создайте класс Train, содержащий поля: название пункта назначения,
 * номер поезда, время отправления. Создайте данные в массив из пяти элементов типа Train,
 * добавьте возможность сортировки элементов массива по номерам поездов.
 * Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми
 * пунктами назначения должны быть упорядочены по времени отправления.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RailwayStation {

    private ArrayList<Train> trains;
    private String address[] = {"Minsk", " Moscow", "Kiev", "Warszawa","Paris"};

    public RailwayStation() {
        trains = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Train train = new Train();
            train.setNumber(i+1);
            train.setAddress(address[new Random().nextInt(5)]);
            train.setDate(new Random().nextInt(1441));
            trains.add(train);
        }
    }

    public String information(int number){
        for (Train train:trains) {
            if(train.getNumber() == number){
                return train.toString();
            }
        }
        return "Такого номера поезда нет";
    }

    public void sortByNumbers(){
        Collections.sort(trains);
    }

    public void sortByAddress(){
        trains.sort((t1,t2)->{
            int result = t1.getAddress().compareTo(t2.getAddress());
            if (result == 0){
                return t1.getDate() - t2.getDate();
            }
            return result;
        });
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Поезда: \n");
        for (Train train:trains) {
            result.append(train.toString()).append("\n");
        }
        return result.toString();
    }
}
