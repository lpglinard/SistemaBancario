package org.example.stub;

import org.junit.jupiter.api.Test;

import java.security.Provider;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransacaoServiceTest {
    TransacaoService service;

    @Test
    void realizarSaque(){
        VerificacaoSaldoService saldoService = mock(VerificacaoSaldoService.class);
        when(saldoService.verificarSaldoDisponivel(any(Conta.class), anyDouble())).thenReturn(true);
        Conta conta = new Conta("1") {
            @Override
            public void sacar(double valor){

            }
        };
        service = new TransacaoService(saldoService);
        boolean realizred = service.realizarSaque(conta, 10.0);
        assertTrue(realizred);
    }
}
