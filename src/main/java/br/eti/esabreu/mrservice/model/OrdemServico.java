package br.eti.esabreu.mrservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	@ManyToOne(optional = false)
	private Cliente cliente;
	@ManyToOne(optional = false)
	private Tecnico tecnico;
	@ManyToOne(optional = false)
	private Maquina maquina;
	private String defeito;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "servico_os",
		joinColumns = @JoinColumn(name = "os_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"))
	private List<Servico> servicos;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "itens_os",
		joinColumns = @JoinColumn(name = "os_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
	private List<Item> itens;
	
	public enum Tipo {
		INTERNO("Serviço Interno"), VISITA("Visita Técnica"), EXTERNO("Serviço Externo");
		private String descricao;
		private Tipo(String descricao) {
			this.descricao = descricao;
		}
		public String getDescricao() {
			return descricao;
		}
	}
	
	public enum Status {
		ABERTA("Orçamento"), ANDAMENTO("Serviço em andamento"), FINALIZADA("Serviço finalizado"), FATURADA("Pagamento recebido");
		private String descricao;
		private Status(String descricao) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setResponsavel(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
