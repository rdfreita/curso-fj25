package br.com.idei4.financas.teste;

import javax.persistence.EntityManager;

import br.com.idei4.financas.dao.ContaDao;
import br.com.idei4.financas.modelo.Conta;

import com.br.idei4.financas.util.JPAUtil;

public class TestaPesquisaContaId {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		manager.getTransaction().begin();
		Conta encontrado = dao.busca(1);
		System.out.println(encontrado.getTitular());
		manager.getTransaction().commit();
		manager.close();
	}
}
