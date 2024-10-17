package org.example.stub;

public class TransacaoService {
    private VerificacaoSaldoService saldoService;

    public TransacaoService(VerificacaoSaldoService saldoService) {
        this.saldoService = saldoService;
    }

    // Método para realizar uma transação de saque
    public boolean realizarSaque(Conta conta, double valor) {
        if (saldoService.verificarSaldoDisponivel(conta, valor)) {
            conta.sacar(valor);
            System.out.println("Saque de " + valor + " realizado na conta: " + conta.getNumero());
            return true;
        } else {
            System.out.println("Saldo insuficiente para o saque.");
            return false;
        }
    }
}