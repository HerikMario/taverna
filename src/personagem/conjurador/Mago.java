package personagem.conjurador;

import itens.Arma;
import combate.Dano;

public class Mago extends Conjurador{
    public Mago(String nome, int forca, int agilidade, int intelecto) {
        super(nome, forca, agilidade, intelecto, new Arma("Cajado", new Dano(1, 4, forca/2)));
    }
}
