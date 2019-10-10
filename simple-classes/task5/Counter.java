/*
 * 4.Simple Classes
 * Task 5
 *
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по
 * умолчанию и произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния,
 * и метод позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task5;

public class Counter {

    private int upLimit;
    private int downLimit;
    private int state;

    public Counter(){
        upLimit = 10;
        downLimit = 0;
        state = 0;
    }

    public void increase() throws Exception {
        if(state == upLimit) {
            throw new Exception("Превышен верхний лимит счетчика ");
        }
        state++;
    }

    public void decrease() throws Exception{
        if(state == downLimit) {
            throw new Exception("Превышен нижний лимит счетчика ");
        }
        state--;
    }

    public Counter(int upLimit, int downLimit, int state) throws Exception {
        if(upLimit <= downLimit || state > upLimit || state < downLimit){
            throw new Exception("Значения заданы не коректно");
        }
        this.upLimit = upLimit;
        this.downLimit = downLimit;
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
