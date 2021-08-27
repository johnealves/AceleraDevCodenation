package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estacionamento {

    List<Carro> parking = new ArrayList<>();
    int vagas = 10;

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null) {
            throw new EstacionamentoException("driver is required");
        } else if (carro.getMotorista().getIdade() < 18 || carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("age under 18 or more than 20 points");
        }
        else {
            if (parking.size() >= vagas) {
                for (int i = 0; i < vagas; i++) {
                   if (parking.get(i).getMotorista().getIdade() < 55) {
                       parking.remove(i);
                       parking.add(carro);
                       break;
                   }
                }
                Optional<Carro> result = parking.stream().filter(car -> car.getMotorista().getIdade() < 55).findFirst();
                if (!result.isPresent()) {
                    throw new EstacionamentoException("não ha vagas disponiveis");
                }

            } else {
                parking.add(carro);
            }
        }
    }

    public int carrosEstacionados() {
        return parking.size();
    }

    public boolean carroEstacionado(Carro carro) {
        Optional<Carro> result = parking.stream().filter(car -> car.equals(carro)).findAny();
        return result.isPresent();
    }
}
