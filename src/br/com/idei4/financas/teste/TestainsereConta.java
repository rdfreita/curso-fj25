package br.com.idei4.financas.teste;

import javax.persistence.EntityManager;

import br.com.idei4.financas.dao.ContaDao;
import br.com.idei4.financas.modelo.Conta;

import com.br.idei4.financas.util.JPAUtil;

public class TestainsereConta {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager); //o manager entra aqui porque o dao precisa do EntityManager
		
		Conta conta = new Conta();
		conta.setAgencia("0310");
		conta.setBanco("Itau");
		conta.setNumero("39868-0");
		conta.setTitular("Rodrigo Dias de Freitas");
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("conta adicionada com sucesso!");
	}
}
