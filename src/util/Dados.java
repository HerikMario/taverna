package util;

public class Dados {
    public static int rolarDado(int lados) {
        return new java.util.Random().nextInt(lados) + 1;
    }

    public static int rolar(int quantidade, int lados) {
        int soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += rolarDado(lados);
        }
        return soma;
    }
}
