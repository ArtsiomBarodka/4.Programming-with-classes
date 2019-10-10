/*
 * 4.Simple Classes
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
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task9;

public class Book {

    private int id;
    private String name;
    private String author;
    private String company;
    private int year;
    private int page;
    private int price;
    private Type type;

    public Book() {
        this.id = (int) Math.floor(Math.random() * 9_000_000) + 1_000_000;
    }

    public Book(String name, String author, String company, int year, int page, int price, Type type) {
        this.id = (int) Math.floor(Math.random() * 9_000_000) + 1_000_000;
        this.name = name;
        this.author = author;
        this.company = company;
        this.year = year;
        this.page = page;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Название - " + name  +
                ", автор - " + author +
                ", издательство - " + company  +
                ", год издания - " + year +
                ", количество страниц - " + page +
                ", цена - " + price +
                ", тип переплета " + type;
    }
}
