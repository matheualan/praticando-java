package application.services2;

public class PayService {
    TaxService taxService;
    DeliverService deliverService;

    public PayService() {
    }

    public PayService(TaxService taxService, DeliverService deliverService) {
        this.taxService = taxService;
        this.deliverService = deliverService;
    }

    public double finalPrice(double cost, String state) {
        return cost + deliverService.fee(state) + taxService.tax(cost);
    }
}
