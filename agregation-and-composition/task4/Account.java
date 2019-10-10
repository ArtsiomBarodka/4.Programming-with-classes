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

public class Account {

    private int id;
    private boolean isBlocked;
    private int balance;
    private int clientId;

    public Account(int balance, int clientId) {
        this.balance = balance;
        this.clientId = clientId;
        isBlocked = false;
        id = (int) Math.floor(Math.random() * 9_000) + 1_000;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getBalance() {
        return balance;
    }

    public void deductBalance(int balance) {
        this.balance = this.balance - balance;
    }

    public void addBalance(int balance) {
        this.balance = this.balance + balance;
    }

    public int getClientId() {
        return clientId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Счет с балансом ").append(balance);
        if(isBlocked()){
            res.append("- заблокирован!");

        }
        return res.toString();
    }
}
