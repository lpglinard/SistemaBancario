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
}