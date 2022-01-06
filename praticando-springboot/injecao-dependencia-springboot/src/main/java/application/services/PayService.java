package application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService {
    @Autowired
    TaxService taxService;
    @Autowired
    DeliverService deliverService;

//    public PayService(TaxService taxService, DeliverService deliverService) {
//        this.taxService = taxService;
//        this.deliverService = deliverService;
//    }

    public double finalPrice(double value, String state) {
        return value + deliverService.fee(state) + taxService.tax(value);
    }
}
