package br.com.idei4.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.idei4.financas.modelo.Conta;

public class ContaDao {
	private EntityManager manager;
	
	public ContaDao(EntityManager manager){
		this.manager = manager;
	}
	
	public Conta busca(int id){
		return this.manager.find(Conta.class,id);
	}
	public List<Conta> lista(){
		return this.manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}
	public void adiciona(Conta conta){
		manager.persist(conta);
	}
	public void remove(Conta conta){
		manager.remove(conta);
	}
}
