package org.example.mock;

public class TransacaoService {
    private AutorizacaoPagamentoService autorizacaoService;

    public TransacaoService(AutorizacaoPagamentoService autorizacaoService) {
        this.autorizacaoService = autorizacaoService;
    }

    public boolean realizarSaque(Conta conta, double valor) {
        if (autorizacaoService.autorizarPagamento(valor) && conta.getSaldo() >= valor) {
            conta.sacar(valor);
            System.out.println("Saque de " + valor + " realizado com sucesso na conta: " + conta.getNumero());
            return true;
        } else {
            System.out.println("Saque não autorizado ou saldo insuficiente.");
            return false;
        }
    }

    public boolean realizarDeposito(Conta conta, double valor) {
        if (autorizacaoService.autorizarPagamento(valor)) {
            conta.depositar(valor);
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta: " + conta.getNumero());
            return true;
        } else {
            System.out.println("Depósito não autorizado.");
            return false;
        }
    }
}