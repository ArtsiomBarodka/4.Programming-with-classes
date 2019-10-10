/*
 * 4.Simple Classes
 * Task 6
 *
 * Составьте описание класса для представления времени. Предусмотрте возможности установки времени
 * и изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений.
 * В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения
 * времени на заданное количество часов, минут и секунд.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.simple_classes.Task6;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int seconds){
        this(0,0,0);
        addSeconds(seconds);
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours >= 24 ? 0 : hours;
        this.minutes = minutes >= 60 ? 0 : minutes;
        this.seconds = seconds >= 60 ? 0 : seconds;
    }

    public void addHours(int hours) {
        int newHours = this.hours + hours;
        this.hours = newHours >= 24 ? 0 : newHours;
    }

    public void addMinutes(int minutes) {
        int newMinutes = this.minutes + minutes;
        if(newMinutes >= 60){
            int h = newMinutes/60;
            addHours(h);
            newMinutes = newMinutes - h*60;
        }
        this.minutes = newMinutes;
    }

    public void addSeconds(int seconds) {
        int newSeconds = this.seconds + seconds;
        if(newSeconds >= 60){
            int min =  newSeconds/60;
            addMinutes(min);
            newSeconds = newSeconds - min*60;
        }
        this.seconds = newSeconds;
    }

    public void deductHours(int hours){
        int newHours = this.hours - hours;
        this.hours = newHours < 0 ? 0 : newHours;
    }

    public void deductMinutes(int minutes) {
        int newMinutes = this.minutes - minutes;
        if(newMinutes < 0){
            int h = minutes/60;
            deductHours(h);
            newMinutes = this.minutes - (minutes - h*60);
        }
        this.minutes = newMinutes > 0 ? newMinutes : 0;
    }

    public void deductSeconds(int seconds) {
        int newSeconds = this.seconds - seconds;
        if(newSeconds < 0){
            int min = seconds/60;
            deductMinutes(min);
            newSeconds = this.seconds - (seconds - min*60);
        }
        this.seconds = newSeconds > 0 ? newSeconds : 0;

    }

    public void setHours(int hours) {
        this.hours = hours >= 24 ? 0 : hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes >= 60 ? 0 : minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds >= 60 ? 0 : seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        String h = String.valueOf(hours);
        String m = String.valueOf(minutes);
        String s = String.valueOf(seconds);
        if(hours < 10){
            h = "0".concat(h);
        }
        if(minutes < 10){
            m = "0".concat(m);
        }
        if(seconds < 10){
            s = "0".concat(s);
        }
        return h+"."+m+"."+s;
    }
}
