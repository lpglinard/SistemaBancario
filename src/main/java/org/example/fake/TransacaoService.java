package org.example.fake;

import java.util.List;

public class TransacaoService {
    private BancoDeDados bancoDeDados;

    public TransacaoService(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void realizarDeposito(Conta conta, double valor) {
        conta.depositar(valor);
        Transacao transacao = new Transacao(valor, "DEPOSITO");
        bancoDeDados.salvarTransacao(conta.getNumero(), transacao);
        System.out.println("Depósito de " + valor + " realizado na conta: " + conta.getNumero());
    }

    public void realizarSaque(Conta conta, double valor) {
        conta.sacar(valor);
        Transacao transacao = new Transacao(valor, "SAQUE");
        bancoDeDados.salvarTransacao(conta.getNumero(), transacao);
        System.out.println("Saque de " + valor + " realizado na conta: " + conta.getNumero());
    }

    public List<Transacao> recuperarTransacoes(String contaId) {
        return bancoDeDados.recuperarTransacoes(contaId);
    }
}