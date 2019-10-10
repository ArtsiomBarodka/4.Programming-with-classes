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

import java.util.*;

public class TravelCompany {

    private String name;
    private TreeMap<Client,Voucher> journal;
    private ArrayList<Voucher> vouchers;

    public TravelCompany(String name) {
        this.name = name;
        journal = new TreeMap<>(Comparator.comparing(Client::getName).thenComparing(Client::getId));
        vouchers = Generator.generate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void addClient(Client client, Voucher voucher){
        journal.put(client,voucher);
    }

    public void addVoucher(Voucher voucher){
        vouchers.add(voucher);
    }

    private void deleteVoucher(Voucher voucher){
        vouchers.removeIf((Voucher v) ->v.getId() == voucher.getId());
    }

    public void setVouchers(ArrayList<Voucher> vouchers) {
        this.vouchers.addAll(vouchers);
    }

    public Client generateClient(String name,Voucher voucher){
        Client client = new Client(name,voucher.getId());
        addClient(client,voucher);
        deleteVoucher(voucher);
        return client;
    }


    public void sortVouchersByPrice(){
        Collections.sort(vouchers,Comparator.comparing(Voucher::getPrice).thenComparing(Voucher::getId));
    }

    public void sortVouchersByTour(){
        Collections.sort(vouchers,Comparator.comparing(Voucher::getTour).thenComparing(Voucher::getId));
    }

    public void sortVouchersByTransport(){
        Collections.sort(vouchers,Comparator.comparing(Voucher::getTransport).thenComparing(Voucher::getId));
    }

    public void sortVouchersByFood(){
        Collections.sort(vouchers,Comparator.comparing(Voucher::getFood).thenComparing(Voucher::getId));
    }

    public void sortVouchersByDays(){
        Collections.sort(vouchers,Comparator.comparing(Voucher::getDays).thenComparing(Voucher::getId));
    }

    private ArrayList<Voucher> searchVouchers(int minPrice,int maxPrice, Tour tour, Transport transport, Food food, int days){
        ArrayList<Voucher> result = new ArrayList<>();
        for (Voucher v:vouchers) {
            if(v.getPrice() >= minPrice && v.getPrice() < maxPrice){
                result.add(v);
            }
        }
        if (tour != null){
            result.removeIf((Voucher v)-> !v.getTour().equals(tour));
        }
        if(transport != null){
            result.removeIf((Voucher v)-> !v.getTransport().equals(transport));
        }
        if(food != null){
            result.removeIf((Voucher v)-> !v.getFood().equals(food));
        }
        if(days != 0){
            result.removeIf((Voucher v)->v.getDays() != days);
        }
        return result;
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,null,null,0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Tour tour){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,tour,null,null,0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Transport transport){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,transport,null,0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Food food){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,null,food,0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,int days){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,null,null, days);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Tour tour, Transport transport){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,tour,transport,null, 0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Tour tour, Food food){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,tour,null,food, 0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Tour tour, int days){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,tour,null,null, days);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Transport transport, Food food){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,transport,food, 0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Transport transport, int days){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,transport,null, days);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Food food, int days){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,null,null,food, days);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Tour tour,Transport transport, Food food){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,tour,transport,food, 0);
    }

    public ArrayList<Voucher> findVouchers(int minPrice,int maxPrice,Tour tour,Transport transport, Food food, int days){
        System.out.println("Подбор тура...");
        return searchVouchers(minPrice,maxPrice,tour,transport,food, days);
    }

    public void printVouchers(){
        StringBuilder res = new StringBuilder();
        for (Voucher v:vouchers) {
            res.append(v.toString()).append("\n");
        }
        System.out.println(res.toString());
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Client,Voucher> j: journal.entrySet()) {
            result.append("Клиент - ")
                    .append(j.getKey().toString())
                    .append(": ")
                    .append(j.getValue().toString())
                    .append("\n");
        }

        return result.toString();
    }
}
