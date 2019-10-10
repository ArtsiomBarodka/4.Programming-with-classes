/*
 * 4.Simple Classes
 * Task 3
 *
 * Создайте класс с именем Student, содержащий поля:
 * фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов).
 * Создайте массив из десяти элементов такого типа. Добавьте возможность вывода
 * фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task3;

public class Student {

    private String surname;
    private String initial;
    private int group;
    private int marks[];
    private int count;

    public Student() {
        this.marks = new int[5];
        count = 0;
    }

    public boolean isTheBestStudent(int mark){
        for (int i = 0; i < marks.length; i++) {
            if(marks[i] < mark){
                return false;
            }
        }
        return true;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
       if(marks.length != 5){
           System.out.println("Пожалуйста введите 5 оценок");
       } else {
           this.marks = marks;
           count = 0;
       }
    }

    public int getMark(int index){
        if(index > 4 || index < 0 ){
            return -1;
        } else {
            return marks[index];
        }
    }

    public void setMark(int mark){
        if(mark == 5){
            count = 0;
        }
        marks[count] = mark;
        count++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", initial='" + initial + '\'' +
                ", group=" + group +
                '}';
    }
}
