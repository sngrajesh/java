package Day05.labs.first.ass2.Excpetions;

public class TransactionLimitExceededException extends Exception {
    public TransactionLimitExceededException(String message) {
        super(message);
    }
}
