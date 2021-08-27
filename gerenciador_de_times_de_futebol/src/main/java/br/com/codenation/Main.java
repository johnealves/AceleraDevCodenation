package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication times = new DesafioMeuTimeApplication();

        times.incluirTime(1L, "real madrid", LocalDate.now(), "branco", "azul");
        times.incluirTime(2L, "sevilla", LocalDate.now(), "vermelho", "marron");

        times.incluirJogador(3L,1L,"João Pedro", LocalDate.parse("2000-05-07"),5, BigDecimal.valueOf(150.00));
        times.incluirJogador(2L,1L,"Samu Costa",LocalDate.parse("1998-09-25"), 3, BigDecimal.valueOf(100.00));
        times.incluirJogador(1L,1L,"Willian Freire",LocalDate.parse("1999-10-05"), 4, BigDecimal.valueOf(90.00));

        times.definirCapitao(2L);

        System.out.println(times.buscarTopJogadores(2));
//
//        final List<Time> listaDeTimes = times.listaDeTimes;
//        List<Jogador> listaDeJogadores = times.listaDeJogadores;
//        System.out.println("Times");
//        System.out.println(listaDeTimes);
//        System.out.println("-------------------------------------------");
//        System.out.println("  ");
//        System.out.println("Jogadores");
//        System.out.println(listaDeJogadores);
    }
}
