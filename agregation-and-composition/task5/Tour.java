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

public enum Tour {
    BEACH("Пляжный"),
    EXCURSION("Экскурсионный"),
    THERAPY("Лечебный"),
    SHOPPING("Шопинг"),
    CRUISE("Круиз");

    private String title;

    Tour(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
