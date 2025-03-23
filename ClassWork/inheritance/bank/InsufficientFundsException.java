package classwork.inheritance.bank;
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class DailyLimitExceededException extends Exception {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}

public class InvalidTransferException extends Exception {
    public InvalidTransferException(String message) {
        super(message);
    }
}

public class EarlyWithdrawalPenaltyException extends RuntimeException {
    public EarlyWithdrawalPenaltyException(String message) {
        super(message);
    }
}