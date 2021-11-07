package application.services2;

public class DeliverService {
    public double fee(String state) {
        if ("SP".equalsIgnoreCase(state)) {
            return 10.0;
        }
        return 20.0;
    }
}
