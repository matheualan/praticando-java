package application.services;

public class PEDeductionService implements DeductionService {
    @Override
    public double deduction(double amount) {
        return amount * 0.12;
    }
}
