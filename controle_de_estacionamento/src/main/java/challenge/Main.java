package challenge;

public class Main {
    public static void main(String[] args) {
//        try {
            Estacionamento parking = new Estacionamento();

            Motorista ada = Motorista.builder()
                    .withNome("Ada")
                    .withIdade(-1)
                    .withPontos(3)
                    .withHabilitacao("1231")
                    .build();

        System.out.println(ada);

            Carro carAda = Carro.builder()
                    .withCor(Cor.BRANCO)
                    .withPlaca("123")
                    .withMotorista(ada)
                    .build();

            parking.estacionar(carAda);

//            for (int i = 0; i < 10; i++) {
//                Motorista motorista = Motorista.builder()
//                        .withNome("John")
//                        .withIdade(50)
//                        .withPontos(7)
//                        .withHabilitacao("12345")
//                        .build();
//
//                Carro car = Carro.builder().withCor(Cor.BRANCO)
//                        .withPlaca("123")
//                        .withMotorista(motorista)
//                        .build();
//
//                parking.estacionar(car);
//            }

            System.out.println("Numero de carros estacionados: " + parking.carrosEstacionados());
//        } catch (IllegalArgumentException | NullPointerException e) {
//            throw new Error();
//        } catch (Exception e) {
//            throw new Error();
//        }
    }
}
