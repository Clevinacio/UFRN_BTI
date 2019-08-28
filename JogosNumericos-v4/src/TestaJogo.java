import ClassesBase.Dado;
import ClassesBase.Jogo;
import ClassesBase.Roleta;

public class TestaJogo {

    public static void main(String[] args) {
        Dado j = new Dado();
        Roleta r = new Roleta();
        j.executaJogo(6);
        j.mostraResultado();
        System.out.println('-');
        r.executaJogo(35);
        r.mostraResultado();
    }
}
