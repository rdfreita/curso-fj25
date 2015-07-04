package br.com.idei4.financas.teste;

import javax.persistence.EntityManager;

import br.com.idei4.financas.dao.ContaDao;
import br.com.idei4.financas.modelo.Conta;

import com.br.idei4.financas.util.JPAUtil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		manager.getTransaction().begin();
		Conta conta = dao.busca(2);
		conta.setTitular("Alice");
		manager.getTransaction().commit();
		manager.close();
	}
}
