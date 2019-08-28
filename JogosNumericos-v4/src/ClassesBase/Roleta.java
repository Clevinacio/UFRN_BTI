package ClassesBase;

import java.util.Random;

public class Roleta extends Jogo {
    public void executaJogo() {
        Random rn = new Random();
        setResultado(rn.nextInt(37));
    }
}
