/*
 * 4.Simple Classes
 * Task 4
 *
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.agregation_and_composition.Task4;

public class Client {

    private int id;
    private String name;
    private int indexOfAccounts;
    private int[] accounts;

    public Client(String name) {
        this.name = name;
        id = (int) Math.floor(Math.random() * 9_000) + 1_000;
        indexOfAccounts = 0;
        accounts = new int[indexOfAccounts];
    }

    public void addAccount(int idOfAccount){
        indexOfAccounts = indexOfAccounts + 1;
        int[] result = new int[indexOfAccounts];
        System.arraycopy(accounts,0,result,0,accounts.length);
        result[indexOfAccounts -1] = idOfAccount;
        accounts = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int[] getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return name;
    }
}
