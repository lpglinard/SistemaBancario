package org.example.dummy;

public class ContaService {

    // Método para criar uma conta
    public void criarConta(Conta conta, Cliente cliente) {
        // No cenário real, poderíamos associar o cliente à conta
        // Aqui, estamos apenas simulando o processo de criação da conta
        System.out.println("Conta criada com sucesso para o número: " + conta.getNumero());
    }

    // Método para depositar dinheiro em uma conta
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depositado " + valor + " na conta: " + conta.getNumero());
    }

    // Método para consultar saldo de uma conta
    public double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }
}