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

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private static final Tour[] tours = {Tour.CRUISE,Tour.BEACH,Tour.EXCURSION,Tour.SHOPPING,Tour.THERAPY};
    private static final Transport[] transports = {Transport.BUS,Transport.PLANE,Transport.SHIP,Transport.TRAIN};
    private static final Food[] food = {Food.HB,Food.AI,Food.BB,Food.FB,Food.RO,Food.UAI};

    public static ArrayList<Voucher> generate(){
        ArrayList<Voucher> result = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            Voucher voucher = new Voucher();
            voucher.setPrice(new Random().nextInt(50)*100+100);
            voucher.setTour(tours[new Random().nextInt(5)]);
            voucher.setTransport(transports[new Random().nextInt(4)]);
            voucher.setFood(food[new Random().nextInt(6)]);
            voucher.setDays(new Random().nextInt(21)+7);
            result.add(voucher);
        }
        return result;
    }
}
