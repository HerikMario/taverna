package personagem.combatente;

import itens.Arma;
import combate.Dano;

public class Ladino extends Combatente {
    //Construtores
    public Ladino(String nome, int forca, int agilidade, int intelecto) {
        super(nome, forca, agilidade, intelecto, new Arma("Adagas", new Dano(1, 6, agilidade/2)));
    }

    //Métodos Protegidos
    @Override
    protected int getAtributoPrincipal() {
        return getAgilidade();
    }

    @Override
    protected int getMargemCritico() {
        return 19;
    }
}
