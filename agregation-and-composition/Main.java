package programming_with_classes.agregation_and_composition;

import programming_with_classes.agregation_and_composition.Task1.Sentence;
import programming_with_classes.agregation_and_composition.Task1.Text;
import programming_with_classes.agregation_and_composition.Task1.Word;
import programming_with_classes.agregation_and_composition.Task2.Car;
import programming_with_classes.agregation_and_composition.Task3.City;
import programming_with_classes.agregation_and_composition.Task3.District;
import programming_with_classes.agregation_and_composition.Task3.Region;
import programming_with_classes.agregation_and_composition.Task3.State;
import programming_with_classes.agregation_and_composition.Task4.Bank;
import programming_with_classes.agregation_and_composition.Task4.Client;
import programming_with_classes.agregation_and_composition.Task5.Food;
import programming_with_classes.agregation_and_composition.Task5.Tour;
import programming_with_classes.agregation_and_composition.Task5.TravelCompany;
import programming_with_classes.agregation_and_composition.Task5.Voucher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        /*
         * Task 1
         *
         * Создать объект класса Текст, используя классы Предложение,
         * Слово. Методы: дополнить текст, вывести на консоль текст, заголовок текста.
         *
         */

        Word word = new Word("Артем");
        Word word2 = new Word("пошел");
        Word word3 = new Word();
        word3.setWord("в");
        Word word4 = new Word("магазин");

        ArrayList<Word> words = new ArrayList<>();
        words.add(word);
        words.add(word2);
        words.add(word3);
        words.add(word4);

        Sentence sentence1 = new Sentence(words);
        Sentence sentence2 = new Sentence();
        sentence2.setWords(words);

        Text text = new Text(sentence1);
        text.addSentence(sentence2);
        text.setHeader(new Word("Батя"));

        System.out.println(text);
        System.out.println(text.getHeader());

        text.deleteSentence(sentence1);
        System.out.println(text);

        /*
         * Task 2
         *
         * Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
         * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
         *
         */

        Car car = new Car("Audi");
        int index = 0;
        while (index <= 10){
            try {
                car.drive();
            }catch (Exception ex){
                if(car.getFuel() == 0){
                    car.refuel();
                } else {
                    int state[] = car.getWheelsState();
                    for (int i = 0; i < state.length; i++) {
                        if(state[i] == 0){
                            car.changeWheel(i+1);
                        }
                    }
                }
            }
            index++;
        }





        /*
         * Task 3
         *
         * Создать объект класса Государство, используя классы Область,
         * Район, Город. Методы: вывести на консоль столицу, количество областей, площадь, областные центры
         *
         */

        District d1 = new District("Пуховичский",400,new City("Пуховичи"));
        District d2 = new District("Логойский",600,new City("Логойск"));
        District d3 = new District("Минский",700,new City("Минск",true,true));
        ArrayList<District> districts1 = new ArrayList<>();
        Collections.addAll(districts1,d1,d2,d3);
        Region region1 = new Region("Минская",districts1);

        District d4 = new District("Ивьевский",200,new City("Ивье"));
        District d5 = new District("Новогрудский",450,new City("Новогрудок"));
        District d6 = new District("Гродненский",555,new City("Гродно",true,false));
        ArrayList<District> districts2 = new ArrayList<>();
        Collections.addAll(districts2,d4,d5,d6);
        Region region2 = new Region("Гродненская");
        region2.setDistricts(districts2);

        District d7 = new District("Кобренский",600,new City("Кобрин"));
        District d8 = new District("Пружанский",390,new City("Пружаны"));
        District d9 = new District("Брестский",605,new City("Брест",true,false));
        Region region3 = new Region("Брестская");
        region3.addDistrict(d7);
        region3.addDistrict(d8);
        region3.addDistrict(d9);

        State state = new State("Беларусь");
        state.addRegion(region1);
        state.addRegion(region2);
        state.addRegion(region3);

        System.out.println(state);

        System.out.println("Областные центры "+state.getCentralCities());

        System.out.println("Столица "+state.getCapital());

        System.out.println("Общая площадь "+state.getArea() + " км2");

        System.out.println("Количество областей "+state.countRegions());

        state.deleteRegion("Брестская");


        System.out.println(state);




        /*
         * Task 4
         *
         * Счета. Клиент может иметь несколько счетов в банке.
         * Учитывать возможность блокировки/разблокировки счета.
         * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
         * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
         *
         */
        Bank bank = new Bank("Альфа-банк");
        Client client1 = bank.createClient("Рома", 5000);
        Client client2 = bank.createClient("Юля", 2400);
        Client client3 = bank.createClient("Артем", 9000);
        System.out.println(bank.getBalance(client2.getAccounts()[0]));
        bank.createNewAccount(client3,4000);
        bank.createNewAccount(client3,2000);
        bank.addMoney(client2.getAccounts()[0],2000);
        System.out.println(bank.getBalance(client2.getAccounts()[0]));
        System.out.println(bank.getAllBalance(client3));
        bank.takeMoney(client1.getAccounts()[0],10000);
        bank.createNewAccount(client1,2000);
        System.out.println(bank.getAllNegativeBalance(client1));
        System.out.println(bank.getAllPositiveBalance(client1));
        bank.getBalance(client1.getAccounts()[0]);
        bank.printInformationAboutClient(client3);
        bank.printInformationAboutClient(client2);
        bank.printInformationAboutClient(client1);
        System.out.println(Arrays.toString(bank.getAccounts()));
        System.out.println(Arrays.toString(bank.getClients()));
        bank.sortAccountsByBalance();
        System.out.println(Arrays.toString(bank.getAccounts()));
        bank.sortAccountsByClient();
        System.out.println(Arrays.toString(bank.getAccounts()));
        bank.sortClientsByName();
        System.out.println(Arrays.toString(bank.getClients()));



        /*
         * Task 5
         *
         * Туристические путевки. Сформировать набор предложений клиенту по
         * выбору туристической путевки различного типа
         * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
         * Учитывать возможность выбора транспорта, питания и числа дней.
         * Реализовать выбор и сортировку путевок.
         *
         */
        TravelCompany company = new TravelCompany("Тез-Тур");
        company.printVouchers();
        company.sortVouchersByDays();
        ArrayList<Voucher> vouchers1 = company.findVouchers(600,2500);
        company.generateClient("Артем", vouchers1.get(0));
        ArrayList<Voucher> vouchers2 = company.findVouchers(900,1500,Tour.SHOPPING);
        company.generateClient("Таня", vouchers2.get(0));
        ArrayList<Voucher> vouchers3 = company.findVouchers(500,5000, Tour.CRUISE, Food.AI);
        company.generateClient("Женя", vouchers3.get(0));
        System.out.println(company);
    }

}
