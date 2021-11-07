package application;

import application.services.PEDeductionService;
import application.services.PayService;

public class Program {
    public static void main(String[] args) {

        PayService payService = new PayService(new PEDeductionService());
        double tax = payService.tax(1000.0);
        System.out.println(tax);

    }
}
