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

public class Customer {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private long creditCard;
    private long bankAccount;

    public Customer() {
        this.id = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    public Customer( String name, String surname, String patronymic, String address, long creditCard, long bankAccount) {
        this.id = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCard = creditCard;
        this.bankAccount = bankAccount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return  name + " " +
                surname + " " +
                patronymic + " from " +
                address + "\n";
    }
}
