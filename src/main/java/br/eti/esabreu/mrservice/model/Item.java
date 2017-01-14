package br.eti.esabreu.mrservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer qtdMinima;
	private Integer qtdEstoque;
	private Tipo tipo;
	private Condicao condicao;
	@ManyToMany(mappedBy = "itens")
	private List<OrdemServico> ordensServico;
	@OneToMany(mappedBy = "item", cascade = CascadeType.MERGE)
	private List<Entrada> entradas;
	@OneToMany(mappedBy = "item", cascade = CascadeType.MERGE)
	private List<Saida> saidas;
	
	public enum Tipo {
		PECA("Peça"), MATERIAL("Material");
		private String descricao;
		private Tipo(String descricao) {
			this.descricao = descricao;
		}
		public String getDescricao() {
			return descricao;
		}
	}
	
	public enum Condicao {
		NOVO("Novo"), USADO("Usado");
		private String descricao;
		private Condicao(String descricao) {
			this.descricao = descricao;
		}
		public String getDescricao() {
			return descricao;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Integer qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Condicao getCondicao() {
		return condicao;
	}

	public void setCondicao(Condicao condicao) {
		this.condicao = condicao;
	}

	public List<OrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
