package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
    private Long idJogador;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private boolean capitao = false;

    public Jogador(Long idJogador, Long idTime, String nome ,LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        setIdJogador(idJogador);
        setIdTime(idTime);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
    }

    public Long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Long idJogador) {
        this.idJogador = idJogador;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean isCapitao() {
        return capitao;
    }

    public void setCapitao() {
        this.capitao = true;
    }

    public void removeCapitao() {
        this.capitao = false;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "idJogador=" + idJogador +
                ", idTime=" + idTime +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nivelHabilidade=" + nivelHabilidade +
                ", salario=" + salario +
                ", capitao=" + capitao +
                '}';
    }
}
