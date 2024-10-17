package org.example.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

class TransacaoServiceTest {
    TransacaoService transacaoService;

    @Test
    void realizarSaque_pagamentoNaoAutorizado_returnsFalse() {
        // Arrange
        AutorizacaoPagamentoService pagamentoService = Mockito.mock(AutorizacaoPagamentoService.class);
        when(pagamentoService.autorizarPagamento(anyDouble())).thenReturn(false);

        transacaoService = new TransacaoService(pagamentoService);

        Conta conta = new Conta("1");
        conta.depositar(10);

        // Act
        boolean saqueRealizado = transacaoService.realizarSaque(conta, 9);

        //Assert
        assertFalse(saqueRealizado);
    }

    @Test
    void realizarSaque_pagamentoAutorizado_returnsTrue() {
        // Arrange
        AutorizacaoPagamentoService pagamentoService = Mockito.mock(AutorizacaoPagamentoService.class);
        when(pagamentoService.autorizarPagamento(anyDouble())).thenReturn(true);

        transacaoService = new TransacaoService(pagamentoService);

        Conta conta = new Conta("1");
        conta.depositar(10);

        // Act
        boolean saqueRealizado = transacaoService.realizarSaque(conta, 9);

        // Assert
        assertTrue(saqueRealizado);
        assertEquals(1, conta.getSaldo(), 0.01);
    }

    @Test
    void realizarDeposito_pagamentoAutorizado_depositoTrue() {
        // Arrange
        AutorizacaoPagamentoService pagamentoService = Mockito.mock(AutorizacaoPagamentoService.class);
        when(pagamentoService.autorizarPagamento(anyDouble())).thenReturn(true);

        transacaoService = new TransacaoService(pagamentoService);

        Conta conta = new Conta("1");
        conta.depositar(100);

        // Act
        boolean depositoRealizado = transacaoService.realizarDeposito(conta, 50);

        // Assert
        assertTrue(depositoRealizado);
        assertEquals(150, conta.getSaldo(), 0.01);
    }

    @Test
    void realizarDeposito_pagamentoNaoAutorizado_depositoFalse() {
        // Arrange
        AutorizacaoPagamentoService pagamentoService = Mockito.mock(AutorizacaoPagamentoService.class);
        when(pagamentoService.autorizarPagamento(anyDouble())).thenReturn(false);

        transacaoService = new TransacaoService(pagamentoService);

        Conta conta = new Conta("1");
        conta.depositar(100);  // Saldo inicial

        // Act
        boolean depositoRealizado = transacaoService.realizarDeposito(conta, 50);

        // Assert
        assertFalse(depositoRealizado);
        assertEquals(100, conta.getSaldo(), 0.01);
    }
}