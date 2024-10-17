package org.example.fake;

import java.util.List;

public interface BancoDeDados {
    void salvarTransacao(String contaId, Transacao transacao);
    List<Transacao> recuperarTransacoes(String contaId);
}