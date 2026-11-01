package main;

import personagem.Personagem;
import personagem.combatente.Guerreiro;
import personagem.combatente.Ladino;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo à Taverna!");

        Personagem lyra = new Ladino("Lyra", 3, 10, 5);
        Personagem kriv = new Guerreiro("Kriv", 10, 4, 4);

        int iniciativaKriv;
        int iniciativaLyra;
        do {
            iniciativaKriv = kriv.rolarIniciativa();
            iniciativaLyra = lyra.rolarIniciativa();
            System.out.printf("Iniciativa: %s tirou %d, %s tirou %d%n",
                    kriv.getNome(), iniciativaKriv, lyra.getNome(), iniciativaLyra);
        } while (iniciativaKriv == iniciativaLyra);

        Personagem atacante;
        Personagem defensor;
        if (iniciativaKriv > iniciativaLyra) {
            atacante = kriv;
            defensor = lyra;
        } else {
            atacante = lyra;
            defensor = kriv;
        }
        System.out.printf("%s começa!%n%n", atacante.getNome());

        int turno = 1;
        while (atacante.estaVivo() && defensor.estaVivo()) {
            int dano = atacante.atacar(defensor);
            defensor.receberDano(dano);

            if (dano == 0) {
                System.out.printf("Turno %d: %s atacou %s e errou.%n",
                        turno, atacante.getNome(), defensor.getNome());
            } else {
                System.out.printf("Turno %d: %s acertou %s e causou %d de dano. %s está com %d de vida.%n",
                        turno, atacante.getNome(), defensor.getNome(), dano,
                        defensor.getNome(), defensor.getVidaAtual());
            }

            Personagem temporario = atacante;
            atacante = defensor;
            defensor = temporario;
            turno++;
        }

        Personagem vencedor;
        if (atacante.estaVivo()) {
            vencedor = atacante;
        } else {
            vencedor = defensor;
        }
        System.out.printf("%n%s venceu o duelo!%n", vencedor.getNome());
    }
}