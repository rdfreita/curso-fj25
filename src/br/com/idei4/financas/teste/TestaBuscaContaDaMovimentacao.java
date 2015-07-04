package br.com.idei4.financas.teste;

import javax.persistence.EntityManager;

import br.com.idei4.financas.dao.MovimentacaoDao;
import br.com.idei4.financas.modelo.Movimentacao;

import com.br.idei4.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Movimentacao movimentacao = manager.getReference(Movimentacao.class, 1);
		System.out.println(movimentacao.getConta().getTitular());
		manager.getTransaction().commit();
		manager.close();
		
	}
}
