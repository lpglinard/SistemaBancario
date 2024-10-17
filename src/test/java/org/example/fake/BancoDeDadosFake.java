package org.example.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDeDadosFake implements BancoDeDados {
    private Map<String, List<Transacao>> dados = new HashMap<>();

    @Override
    public void salvarTransacao(String contaId, Transacao transacao) {
        dados.putIfAbsent(contaId, new ArrayList<>());
        dados.get(contaId).add(transacao);
    }

    @Override
    public List<Transacao> recuperarTransacoes(String contaId) {
        return dados.getOrDefault(contaId, new ArrayList<>());
    }
}
