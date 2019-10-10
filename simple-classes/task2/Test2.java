/*
 * 4.Simple Classes
 * Task 2
 *
 * Создйте класс Test2 двумя переменными.
 * Добавьте конструктор с входными параметрами.
 * Добавьте конструктор, инициализирующий члены класса по умолчанию.
 * Добавьте set- и get- методы для полей экземпляра класса.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task2;

public class Test2 {

    private String name;
    private int age;

    public Test2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Test2(String name){
        this(name , 18);
    }

    public Test2(int age){
        this("Unknown", age);
    }

    public Test2(){
        this("Unknown" , 18);
    }

    @Override
    public String toString() {
        return "name = " + name  +
                ", age = " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
