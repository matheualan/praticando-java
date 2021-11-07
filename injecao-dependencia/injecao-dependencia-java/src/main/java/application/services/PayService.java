package application.services;

public class PayService {

    private DeductionService deductionService;

    public PayService(DeductionService deductionService) {
        this.deductionService = deductionService;
    }

    public double tax(double amount) {
        amount = amount - deductionService.deduction(amount);
        return amount * 0.2;
    }
}
