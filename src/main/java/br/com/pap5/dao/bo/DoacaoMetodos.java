package br.com.pap5.dao.bo;

import br.com.pap5.bo.Doacao;
import br.com.pap5.dao.CRUD;
import java.util.List;

public interface DoacaoMetodos extends CRUD<Doacao>{
    public List<Doacao> consultarDoacaoPorUsuario(Long id);
}
