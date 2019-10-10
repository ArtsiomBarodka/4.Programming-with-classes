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

import java.util.ArrayList;
import java.util.Random;

public class BookShop {

    private ArrayList<Book> books;

    public BookShop() {
        books = new ArrayList<>();
        String names[] = {" Ulysses", "The Odyssey", "Absalom, Absalom!","Great Expectations", "Invisible Man"};
        String authors[] = {"Charles Dickens", "Ralph Ellison","George Eliot","George Orwell","Joseph Heller"};
        String publishers[] = {"Hachette Livre","Penguin Books","HarperCollins","Pan Macmillan","Pearson Education"};
        Type types[] = {Type.METALBIND,Type.PREMIUM,Type.WIRE_0};
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName(names[new Random().nextInt(5)]);
            book.setAuthor(authors[new Random().nextInt(5)]);
            book.setCompany(publishers[new Random().nextInt(5)]);
            book.setYear((int) Math.floor(Math.random() * 1_000) + 1_000);
            book.setPage((int) Math.floor(Math.random() * 1000) + 100);
            book.setPrice((int) Math.floor(Math.random() * 90_000) + 10_000);
            book.setType(types[new Random().nextInt(3)]);
            books.add(book);
        }
    }

    public BookShop(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getAuthor().equalsIgnoreCase(author)){
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksByCompany(String company){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getCompany().equalsIgnoreCase(company)){
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksAfterDate(int year){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getYear() > year){
                result.add(b);
            }
        }
        return result;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void deleteBook(Book book){
        books.removeIf((Book b)->b.getId() == book.getId());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books.addAll(books);
    }

}
