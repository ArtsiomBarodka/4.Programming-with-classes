/*
 * 4.Simple Classes
 * Task 1
 *
 * Создайте класс Test1 двумя переменными.
 *Добавьте метод вывода на экран и методы изменения этих переменных.
 *Добавьте метод, который находит сумму значений этих переменных, и метод,
 *который находит наибольшее значение из этих двух переменных.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task1;

public class Test1 {

    private int width;
    private int length;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int sum() {
        return width+length;
    }

    public int max(){
        return width >= length ? width : length;
    }

    @Override
    public String toString() {
        return "width = " + width +
                ", length = " + length;

    }

}
