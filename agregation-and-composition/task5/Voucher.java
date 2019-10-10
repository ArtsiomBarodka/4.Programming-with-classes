/*
 * 4.Simple Classes
 * Task 5
 *
 * Туристические путевки. Сформировать набор предложений клиенту по
 * выбору туристической путевки различного типа
 * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
 * Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.agregation_and_composition.Task5;

public class Voucher {
    private int id;
    private int price;
    private Tour tour;
    private Transport transport;
    private Food food;
    private int days;

    public Voucher() {
        id = (int) Math.floor(Math.random() * 9_000) + 1_000;
    }

    public Voucher(int price, Tour tour, Transport transport, Food food, int days) {
        id = (int) Math.floor(Math.random() * 9_000) + 1_000;
        this.price = price;
        this.tour = tour;
        this.transport = transport;
        this.food = food;
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Путевка: Тип тура - ")
                .append(tour)
                .append(" ,транспорт - ")
                .append(transport)
                .append(" ,питание - ")
                .append(food)
                .append(" ,количество дней - ")
                .append(days)
                .append(" ,цена - ")
                .append(price);
        return result.toString();
    }
}
