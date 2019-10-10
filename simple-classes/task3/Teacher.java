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

import java.util.Random;

public class Teacher {

    private Student students[] ;
    private String names[];
    private String initial[] = {"S. ", "T. ","A. ", "P. ", "D. " , "S. ", "N."};

    public Teacher(){
        students = new Student[10];
        for (int i = 0; i < 10; i++) {
            students[i] = new Student();
            students[i].setGroup(new Random().nextInt(4)+1);
            students[i].setInitial(initial[new Random().nextInt(7)] + initial[new Random().nextInt(7)]);
            students[i].setSurname(names[new Random().nextInt(7)]);
            students[i].setMarks(new int[]{new Random().nextInt(5)+5,
                    new Random().nextInt(2)+9,
                    new Random().nextInt(2)+9,
                    new Random().nextInt(2)+9,
                    new Random().nextInt(2)+9});
        }
    }

    public void findTheBestStudent(int mark){
        for (Student student : students) {
            if(student.isTheBestStudent(mark)){
                System.out.println(student);
            }
        }
    }
}
