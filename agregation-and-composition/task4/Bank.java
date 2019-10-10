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

import java.util.Arrays;
import java.util.Comparator;

public class Bank {

    private String name;
    private Client[] clients;
    private Account[] accounts;
    private int indexOfClients;
    private int indexOfAccounts;


    public Bank(String name) {
        this.name = name;
        indexOfClients = 0;
        indexOfAccounts = 0;
        clients = new Client[indexOfClients];
        accounts = new Account[indexOfAccounts];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sortAccountsByBalance(){
        Arrays.sort(accounts,Comparator.comparing(Account::getBalance).thenComparing(Account::getId));
    }

    public void sortAccountsByClient(){
        Arrays.sort(accounts,Comparator.comparing(Account::getClientId).thenComparing(Account::getId));
    }

    public void sortClientsByName(){
        Arrays.sort(clients, Comparator.comparing(Client::getName).thenComparing(Client::getId));
    }

    public int getAllPositiveBalance(Client client){
        int result = 0;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i].getClientId() == client.getId() && accounts[i].getBalance() > 0){
                result = result + accounts[i].getBalance();
            }
        }
        return result;
    }

    public int getAllNegativeBalance(Client client){
        int result = 0;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i].getClientId() == client.getId() && accounts[i].getBalance() < 0){
                result = result + accounts[i].getBalance();
            }
        }
        return result;
    }

    public int getBalance(int idAccount){
        int result = 0;
        Account acc = getAccount(idAccount);
        result = acc.getBalance();
        return result;
    }

    public int getAllBalance(Client client){
        int result = 0;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i].getClientId() == client.getId()){
                result = result + accounts[i].getBalance();
            }
        }
        return result;
    }

    public void addMoney(int idAccount , int money){
        Account acc = getAccount(idAccount);
        Client client = getClient(acc.getClientId());
        acc.addBalance(money);
        System.out.println("Поступление средств на счет "+client.getName() +" в размере " + money );
        if (acc.isBlocked()) {
            if (acc.getBalance() > -1000) {
                acc.setBlocked(false);
                System.out.println("Счет "+ client.getName()+" разблокирован.");
            } else {
                System.out.println("Недостаточно средств для разблокировки счета " + client.getName());
            }
        }
    }

    public void takeMoney(int idAccount, int money){
        Account acc = getAccount(idAccount);
        Client client = getClient(acc.getClientId());
        if (!acc.isBlocked()) {
            acc.deductBalance(money);
            System.out.println("Списаны средства со счета "+client.getName()+" в размере " + money);
            if (acc.getBalance() <= -1000) {
                acc.setBlocked(true);
                System.out.println("Счет "+client.getName()+" заблокирован. Для дальнейшего сипользования пополните баланс!");
            }
        } else {
            System.out.println("Счет "+client.getName()+" заблокирован, требуется пополнить баланс!");
        }
    }

    public void createNewAccount(Client client,  int money){
        Account account = new Account(money,client.getId());
        addAccount(account);
        client.addAccount(account.getId());
        System.out.println("Счет клиента " + client.getName()+" на сумму "+ money+ " создан!");
    }

    public Client createClient(String name ,  int money){
        Client client = new Client(name);
        Account account = new Account(money,client.getId());
        addAccount(account);
        addClient(client);
        client.addAccount(account.getId());
        System.out.println("Счет клиента " + client.getName()+" на сумму "+ money+ " создан!");
        return client;
    }

    public void printInformationAboutClient(Client client){
        StringBuilder res = new StringBuilder();
        res.append(client.toString()).append(" имеет счета :\n");
        for (Account acc:accounts) {
            if(acc.getClientId() == client.getId()){
                res.append(acc.toString()).append("\n");
            }
        }
        System.out.println(res.toString());
    }

    public Client[] getClients() {
        return clients;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    private void addClient(Client client) {
        indexOfClients = indexOfClients + 1;
        Client[] result = new Client[indexOfClients];
        System.arraycopy(clients,0,result,0,clients.length);
        result[indexOfClients-1] = client;
        clients = result;
    }

    private void addAccount(Account account) {
        indexOfAccounts = indexOfAccounts + 1;
        Account[] result = new Account[indexOfAccounts];
        System.arraycopy(accounts,0,result,0,accounts.length);
        result[indexOfAccounts-1] = account;
        accounts = result;
    }

    private Client getClient(int clientId){
        Client client = null;
        for (Client c:clients) {
            if(c.getId() == clientId){
                client = c;
            }
        }
        return client;
    }

    private Account getAccount(int idAccount){
        Account account = null;
        for (Account acc:accounts) {
            if(acc.getId() == idAccount){
                account = acc;
            }
        }
        return account;
    }



}
