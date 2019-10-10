/*
 * 4.Simple Classes
 * Task 7
 *
 * Описать класс, представляющий треугольник.
 * Предусмотреть методы для создания объектов, вычисления площади,
 * периметра и точки пересечения медиан.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task7;

import java.util.ArrayList;

public class Triangle {

    private double sideA;
    private double sideB;
    private double sideC;
    private double height;
    private ArrayList<Double> coords;

    public Triangle() {
    }

    public Triangle(ArrayList<Double> coords) throws Exception {
        if(coords.size() != 6){
            throw new Exception("Введите значения треугольника");
        }
        this.coords = coords;
        sideA = findSide(coords.get(0),coords.get(1),coords.get(2),coords.get(3));
        sideB = findSide(coords.get(2),coords.get(3),coords.get(4),coords.get(5));
        sideC = findSide(coords.get(4),coords.get(5),coords.get(0),coords.get(1));
    }

    public Triangle(double sideA, double sideB, double sideC) throws Exception {
        if(isReal(sideA,sideB,sideC)){
            this.sideA = Math.abs(sideA);
            this.sideB = Math.abs(sideB);
            this.sideC = Math.abs(sideC);
        } else {
            throw new Exception("Такого треугольника не существует");
        }
    }

    public Triangle(double sideA, double height) {
        this.sideA = Math.abs(sideA);
        this.height = Math.abs(height);
    }

    public double findPerimeter() throws Exception {
        if(sideA == 0 || sideB == 0 || sideC == 0){
            throw new Exception("Введите значения треугольника");
        } else if(!isReal(sideA,sideB,sideC)){
            throw new Exception("Такого треугольника не существует");
        }
        return  sideA+sideB+sideC;
    }

    public double findArea() throws Exception {
        double area;
        if(height == 0){
            double p = findPerimeter()/2;
            area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
        } else {
            if(sideA == 0){
                throw new Exception("Введите значения треугольника");
            }
            area = height*sideA/2;
        }
        return area;
    }

    public double[] findMedianIntersection() throws Exception {
        if(!isReal(sideA,sideB,sideC)){
            throw new Exception("Такого треугольника не существует");
        }
        if(coords == null){
            throw new Exception("Координаты вершин треугольника не заданы");
        }
        double[] result = new double[2];
        double x = (coords.get(0)+coords.get(2) + coords.get(4))/3;
        double y = (coords.get(1)+coords.get(3) + coords.get(5))/3;
        result[0] = x;
        result[1] = y;
        return result;
    }

    private boolean isReal(double sideA, double sideB, double sideC){
        if((sideA + sideB) > sideC &&
                (sideB+sideC) > sideA &&
                (sideA+ sideC)> sideB){
            return true;
        }
        return false;

    }

    private double findSide(double x1, double x2,double y1, double y2){
        double result = Math.sqrt(Math.pow((x2 - x1),2)+ Math.pow((y2 - y1),2));
        return result;
    }

    public void setSideA(double sideA) {
        this.sideA = Math.abs(sideA);
    }

    public void setSideB(double sideB) {
        this.sideB = Math.abs(sideB);
    }

    public void setSideC(double sideC) {
        this.sideC = Math.abs(sideC);
    }

    public void setHeight(double height) {
        this.height = Math.abs(height);
    }

    public void setCoords(ArrayList<Double> coords) throws Exception {
        if(coords.size() != 6){
            throw new Exception("Введите значения треугольника");
        }
        this.coords = coords;
        sideA = findSide(coords.get(0),coords.get(1),coords.get(2),coords.get(3));
        sideB = findSide(coords.get(2),coords.get(3),coords.get(4),coords.get(5));
        sideC = findSide(coords.get(4),coords.get(5),coords.get(0),coords.get(1));
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getHeight() {
        return height;
    }
}
