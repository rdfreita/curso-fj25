package br.com.idei4.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.idei4.financas.dao.MovimentacaoDao;
import br.com.idei4.financas.modelo.Conta;
import br.com.idei4.financas.modelo.Movimentacao;
import br.com.idei4.financas.modelo.TipoMovimentacao;

import com.br.idei4.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setBanco("Itau");
		conta.setAgencia("0306");
		conta.setNumero("03754-0");
		conta.setTitular("Idei4");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Hostgator");
		movimentacao.setValor(new BigDecimal("51.30"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		manager.persist(conta);
		dao.adiciona(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
}
