package application.services;

public class CEDeductionService implements DeductionService {
    @Override
    public double deduction(double amount) {
        return amount * 0.10;
    }
}
