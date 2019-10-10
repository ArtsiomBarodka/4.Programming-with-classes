package programming_with_classes.simple_classes;

import programming_with_classes.simple_classes.Task1.Test1;
import programming_with_classes.simple_classes.Task10.Airport;
import programming_with_classes.simple_classes.Task10.Day;
import programming_with_classes.simple_classes.Task2.Test2;
import programming_with_classes.simple_classes.Task3.Teacher;
import programming_with_classes.simple_classes.Task4.RailwayStation;
import programming_with_classes.simple_classes.Task5.Counter;
import programming_with_classes.simple_classes.Task6.Time;
import programming_with_classes.simple_classes.Task7.Triangle;
import programming_with_classes.simple_classes.Task8.Bank;
import programming_with_classes.simple_classes.Task9.Book;
import programming_with_classes.simple_classes.Task9.BookShop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        /*
         * Task 1
         *
         * Создайте класс Test1 двумя переменными.
         *Добавьте метод вывода на экран и методы изменения этих переменных.
         *Добавьте метод, который находит сумму значений этих переменных, и метод,
         *который находит наибольшее значение из этих двух переменных.
         *
         */
        Test1 test1 = new Test1();
        test1.setLength(22);
        test1.setWidth(24);
        System.out.println(test1);
        System.out.println(test1.sum());
        System.out.println(test1.max());

        /*
         * Task 2
         *
         * Создйте класс Test2 двумя переменными.
         * Добавьте конструктор с входными параметрами.
         * Добавьте конструктор, инициализирующий члены класса по умолчанию.
         * Добавьте set- и get- методы для полей экземпляра класса.
         *
         */
        Test2 test2 = new Test2();
        System.out.println(test2);
        test2 = new Test2(20);
        System.out.println(test2);
        test2 = new Test2("Artsiom");
        System.out.println(test2);
        test2 = new Test2("Bob", 27);
        System.out.println(test2);


        /*
         * Task 3
         *
         * Создайте класс с именем Student, содержащий поля:
         * фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов).
         * Создайте массив из десяти элементов такого типа. Добавьте возможность вывода
         * фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
         *
         */
        Teacher teacher = new Teacher();
        teacher.findTheBestStudent(9);

        /*
         * Task 4
         *
         * Создайте класс Train, содержащий поля: название пункта назначения,
         * номер поезда, время отправления. Создайте данные в массив из пяти элементов типа Train,
         * добавьте возможность сортировки элементов массива по номерам поездов.
         * Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
         * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми
         * пунктами назначения должны быть упорядочены по времени отправления.
         *
         */
        RailwayStation station = new RailwayStation();
        System.out.println(station.information(2));
        System.out.println(station);
        station.sortByAddress();
        System.out.println(station);
        station.sortByNumbers();
        System.out.println(station);


        /*
         * Task 5
         *
         * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
         * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по
         * умолчанию и произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния,
         * и метод позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
         *
         */

        try {
            Counter counter = new Counter(15, 5, 7);
            System.out.println(counter.getState());
            counter.increase();
            counter.increase();
            System.out.println(counter.getState());
            counter.decrease();
            System.out.println(counter.getState());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        /*
         * Task 6
         *
         * Составьте описание класса для представления времени. Предусмотрте возможности установки времени
         * и изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений.
         * В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения
         * времени на заданное количество часов, минут и секунд.
         *
         */

        Time time = new Time(23, 36, 44);
        System.out.println(time);
        System.out.println(time.getMinutes());
        time.addSeconds(18);
        System.out.println(time);
        time.deductMinutes(147);
        System.out.println(time);
        time.addHours(1);
        System.out.println(time);
        time.deductSeconds(4202);
        System.out.println(time);



        /*
         * Task 7
         *
         * Описать класс, представляющий треугольник.
         * Предусмотреть методы для создания объектов, вычисления площади,
         * периметра и точки пересечения медиан.
         *
         */
        Triangle tr = new Triangle();
        tr.setSideA(12);
        tr.setSideB(12);
        tr.setSideC(-1);

        ArrayList<Double> coords = new ArrayList<>();
        Collections.addAll(coords, 0D, 3D, 4D, 5D, 3D, 1D);

        try {
            Triangle tr2 = new Triangle(coords);
            System.out.println(Arrays.toString(tr2.findMedianIntersection()));
            System.out.println(tr2.findArea());
            System.out.println(Arrays.toString(tr.findMedianIntersection()));
            System.out.println(tr.findArea());
        } catch (Exception ex) {
            ex.printStackTrace();
        }



        /*
         * Task 8
         *
         * Создать класс Customer, спецификация которого приведена ниже.
         * Определить конструкторы, set- и get- методы и метод toString().
         * Создать второй класс, агрегирующий массив типа Customer,
         * с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.
         * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
         * Найти и вывести:
         * a) список покупателей в алфавитном порядке;
         * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
         *
         */

        Bank bank = new Bank();
        System.out.println(bank.getCustomers());
        System.out.println(bank.getCustomersByCreditCard(2_000_000_00000L, 6_000_000_00000L));
        bank.sortByName();
        System.out.println(bank.getCustomers());



        /*
         * Task 9
         *
         * Создать класс Book, спецификация которого приведена ниже. Определить конструкторы,
         * set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа Book,
         * с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.
         * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
         * Найти и вывести:
         * a) список книг заданного автора;
         * b) список книг, выпущенных заданным издательством;
         * c) список книг, выпущенных после заданного года.
         *
         */

        BookShop shop = new BookShop();
        for (Book b : shop.getBooks()) {
            System.out.println(b);
        }
        System.out.println("\n");
        for (Book b : shop.getBooksAfterDate(1500)) {
            System.out.println(b);
        }
        System.out.println("\n");
        for (Book b : shop.getBooksByAuthor("George Eliot")) {
            System.out.println(b);
        }
        System.out.println("\n");
        for (Book b : shop.getBooksByCompany("Pan Macmillan")) {
            System.out.println(b);
        }


        /*
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
         */

        Airport airport = new Airport();
        System.out.println(airport);
        System.out.println(Arrays.toString(airport.getAirlines("Kiev")) + "\n");
        System.out.println(Arrays.toString(airport.getAirlines(Day.MONDAY)) + "\n");
        System.out.println(Arrays.toString(airport.getAirlines(Day.FRIDAY, 800)) + "\n");
    }

}
