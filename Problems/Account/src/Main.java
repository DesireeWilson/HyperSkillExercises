// write your class here
public class Main{
    public static void main(String[] args) {
        Account account = new Account(100000000, "philip", true);
    }
}
class Account{
    long balance;
    String ownerName;
    boolean locked;

    Account(long bal, String name, boolean locked){
        this.balance = bal;
        this.ownerName = name;
        this.locked = locked;
    }
}