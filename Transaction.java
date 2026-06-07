import java.time.LocalDateTime;

public class Transaction {

    int id;
    String type;
    String category;
    double amount;
    LocalDateTime time;

    public Transaction(int id, String type, String category, double amount) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }
}