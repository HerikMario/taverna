package personagem.combatente;

import items.Arma;
import combate.Dano;

public class Guerreiro extends Combatente {
    //Construtores
    public Guerreiro(String nome, int forca, int agilidade, int intelecto) {
        super(nome, forca, agilidade, intelecto, new Arma("Espada", new Dano(1, 8, forca/2)));
    }
}
