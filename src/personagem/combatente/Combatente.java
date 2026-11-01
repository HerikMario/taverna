package personagem.combatente;

import items.Arma;
import personagem.Personagem;
import util.Dados;

public abstract class Combatente extends Personagem {
    //Construtores
    public Combatente(String nome, int forca, int agilidade, int intelecto, Arma arma) {
        super(nome, forca, agilidade, intelecto, arma);
    }

    //Métodos Públicos
    @Override
    public int atacar(Personagem alvo) {
        if ((Dados.rolar(1, 20) +  < alvo.getDefesa()) || !estaVivo()){
            return 0;
        }
        return Dados.rolar(getArma().getDano().getQuantidade(), getArma().getDano().getLados()) + getArma().getDano().getModificador();
    }
}
