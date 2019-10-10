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

public class Train implements Comparable<Train>{

    private String address;
    private int number;
    private int date;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    private String toStringDate(){
        int hours = date/60;
        int minutes = date - hours*60;
        return hours + " часов " + minutes + " минут ";
    }

    @Override
    public String toString() {
        return "Поезд номер "+ number +
                ". Пункт назначения = " + address +
                ", время отправления = " + toStringDate();
    }

    @Override
    public int compareTo(Train train) {
        return number - train.number;
    }
}
