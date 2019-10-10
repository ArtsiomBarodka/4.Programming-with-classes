/*
 * 4.Simple Classes
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
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Bank {

    private ArrayList<Customer> customers;

    public Bank(){
        customers = new ArrayList<>();
        String names[] = {"Artem", "Max", "Julia","Sam", "Anna"};
        String surnames[] = {"Smith", "Johnson","Williams","Jones","Brown"};
        String patronymics[] = {"Mikhailovich","Andresen","Ben-David","Belousov","Antunes"};
        String address[] = {"Indonesia","Batumi","Minsk","Paris","Kiev"};
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setName(names[new Random().nextInt(5)]);
            customer.setSurname(surnames[new Random().nextInt(5)]);
            customer.setPatronymic(patronymics[new Random().nextInt(5)]);
            customer.setAddress(address[new Random().nextInt(5)]);
            customer.setCreditCard((long) Math.floor(Math.random() * 9_000_000_00000L) + 1_000_000_00000L);
            customer.setBankAccount((long) Math.floor(Math.random() * 9_000_000_00L) + 1_000_000_00L);
            customers.add(customer);
        }
    }

    public Bank(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void sortByName(){
        customers.sort(Comparator.comparing(Customer::getName));
    }

    public ArrayList<Customer> getCustomersByCreditCard(long min, long max){
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer c:customers) {
            if(c.getCreditCard()<= max && c.getCreditCard() >= min){
                result.add(c);
            }
        }
        return result;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void deleteCustomer(Customer customer){
        customers.removeIf((Customer c)->c.getId() == customer.getId());
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers.addAll(customers);
    }
}
