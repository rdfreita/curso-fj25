package br.com.idei4.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.idei4.financas.dao.ContaDao;
import br.com.idei4.financas.modelo.Conta;

import com.br.idei4.financas.util.JPAUtil;

public class TestaListagemConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		manager.getTransaction().begin();
		List<Conta> lista = dao.lista();
		for(Conta conta : lista){
			System.out.println(conta.getNumero());
		}
		manager.getTransaction().commit();
		manager.close();
	}
}
