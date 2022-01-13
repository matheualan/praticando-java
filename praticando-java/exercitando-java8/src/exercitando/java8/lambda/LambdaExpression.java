package exercitando.java8.lambda;

public class LambdaExpression {
    public static void main(String[] args) {

        Car car = (carro, ano) -> {
            System.out.println("Carro comprado: " + carro +
                    "\nAno: " + ano);
            return 70000.00;
        };

        double valorCompra = car.comprar("Honda Civic", 2020);
        System.out.println("Valor da compra: " + valorCompra);

    }
}
