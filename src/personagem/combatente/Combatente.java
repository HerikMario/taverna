package personagem.combatente;

import combate.ResultadoAcerto;
import itens.Arma;
import personagem.Personagem;

public abstract class Combatente extends Personagem {
    //Construtores
    public Combatente(String nome, int forca, int agilidade, int intelecto, Arma arma) {
        super(nome, forca, agilidade, intelecto, arma);
    }

    //Métodos Públicos
    @Override
    public int atacar(Personagem alvo) {
        if (!estaVivo()) {
            return 0;
        }
        ResultadoAcerto resultado = testarAcerto(alvo);
        if (resultado == ResultadoAcerto.ERRO) {
            return 0;
        }
        int dano = getArma().getDano().rolar();
        if (resultado == ResultadoAcerto.CRITICO) {
            dano *= 2;
        }
        return dano;
    }
}
