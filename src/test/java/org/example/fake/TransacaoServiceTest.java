//Leonardo Sousa Alves, Vítor Hugo Alves, Erick da Costa Franco, Pedro H Jaber

package org.example.fake;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TransacaoServiceTest {

    @Test
    void realizarSaque_SaldoIgualSaque() {
        BancoDeDados bancoFake = new BancoDeDadosFake();

        Conta conta = new Conta("1");
        conta.depositar(10);

        TransacaoService transacaoServiceFake = new TransacaoService(bancoFake);
        transacaoServiceFake.realizarSaque(conta, 10);

        assertEquals(0, conta.getSaldo());
    }

    @Test
    void recuperarTransacoes_semTransacoes() {
        BancoDeDados bancoFake = new BancoDeDadosFake();
        TransacaoService transacaoServiceFake = new TransacaoService(bancoFake);
        Conta conta = new Conta("2");

        List<Transacao> transacoes = transacaoServiceFake.recuperarTransacoes(conta.getNumero());

        assertEquals(Collections.emptyList(), transacoes);
    }
}