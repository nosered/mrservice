package br.eti.esabreu.mrservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	@Enumerated(EnumType.STRING)
	private Bairro bairro;
	private String pontoReferencia;
	private String telefone;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	public List<Maquina> maquinas;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	public List<OrdemServico> ordensServico;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Maquina> getMaquinas() {
		return maquinas;
	}
	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	public List<OrdemServico> getOrdensServico() {
		return ordensServico;
	}
	public void setOrdensServico(List<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}
	
	public enum Bairro {
		
		CENTRO("Centro"), ALVAROWEYNE("Álvaro Weyne"), BARRA("Barra do Ceará"), CARLITO("Carlito Pamplona"), CRISTOREDENTOR("Cristo Redentor"),
		FARIASBRITO("Farias Brito"), FLORESTA("Floresta"), JACARECANGA("Jacarecanga"), J_GUANABARA("Jardim Guanabara"), J_IRACEMA("Jardim Iracema"),
		MONTECASTELO("Monte Castelo"), MOURABRASIL("Moura Brasil"), PIRAMBU("Pirambú"), SAOGERARDO("São Gerardo"), V_ELLERY("Vila Ellery"), V_VELHA("Vila Velha"),
		ALDEOTA("Aldeota"), CAISPORTO("Cais do Porto"), CIDADE2000("Cidade 2000"), COCO("Cocó"), LOURDES("De Lourdes"), DIONISIOTORRES("Dionísio Torres"),
		LUCIANOCAVALCANTE("Engenheiro Luciano Cavalcante"), GUARARAPES("Guararapes"), JOAQUIMTAVORA("Joaquim Távora"), DIASBRANCO("Manuel Dias Branco"),
		MEIRELES("Meireles"), MUCURIPE("Mucuripe"), PAPICU("Papicu"), PRAIAIRACEMA("Praia de Iracema"), PRAIAFUTURO1("Praia do Futuro 1"),
		PRAIAFUTURO2("Praia do Futuro 2"), SALINAS("Salinas"), SAOJOAO("São João do Tauape"), VARJOTA("Varjota"), VICENTEPINZON("Vicente Pinzon"),
		AMADEUFURTADO("Amadeu Furtado"), ANTBEZERRA("Antônio Bezerra"), AUTRANNUNES("Autran Nunes"), BELAVISTA("Bela Vista"), BONSUCESSO("Bonsucesso"),
		D_LUSTOSA("Dom Lustosa"), H_JORGE("Henrique Jorge"), JOAO23("João XXIII"), JOQUEICLUBE("Jóquei Clube"), OLAVOOLIVEIRA("Olavo Oliveira"),
		PADREANDRADE("Padre Andrade"), PARQUEARAXA("Parque Araxá"), PARQUELANDIA("Parquelândia"), PICI("Pici"), P_KENNEDY("Presidente Kennedy"),
		QUINTINOCUNHA("Quintino Cunha"), RODOLFOTEOFILO("Rodolfo Teófilo"), AEROPORTO("Aeroporto"), BENFICA("Benfica"), BOMFUTURO("Bom Futuro"),
		COUTOFERNANDES("Couto Fernandes"), DAMAS("Damas"), DEMOCRITOROCHA("Demócrito Rocha"), DENDE("Dendê"), FATIMA("Fátima"), ITAOCA("Itaoca"),
		ITAPERI("Itaperi"), J_AMERICA("Jardim América"), JOSEBONIFACIO("José Bonifácio"), MONTESE("Montese"), PANAMERICANO("Panamericano"),
		PARANGABA("Parangaba"), PARREAO("Parreão"), SERRINHA("Serrinha"), V_PERI("Vila Peri"), V_UNIAO("Vila União"), BOMJARDIM("Bom Jardim"),
		CANINDEZINHO("Canindezinho"), CONJ_CEARA1("Conjunto Ceará I"), CONJ_CEARA2("Conjunto Ceará II"), CONJ_ESPERANCA("Conjunto Esperança"),
		GENIBAU("Genibaú"), GRANJALISBOA("Granja Lisboa"), GRANJAPORTUGAL("Granja Portugual"), J_CEARENSE("Jardim Cearense"), MANOELSATIRO("Vila Manoel Sátiro"),
		MARAPONGA("Maraponga"), MONDUBIM("Mondubim"), AYRTONSENNA("Planalto Ayrton Senna"), JOSEWALTER("Prefeito José Walter"), PRESIDENTEVARGAS("Presidente Vargas"),
		SAOJOSE("São José"), SANTAROSA("Santa Rosa"), SIQUEIRA("Siqueira"), AEROLANDIA("Aerolândia"), BALANCA("Alto da Balança"), ANCURI("Ancuri"),
		BARROSO("Barroso"), BOAVISTA("Boa Vista"), CAJAZEIRAS("Cajazeiras"), CAMBEBA("Cambeba"), CIDADEFUNCIONARIOS("Cidade dos Funcionários"),
		COACU("Coaçu"), CURIO("Curió"), CONJ_PALMEIRAS("Conjunto Palmeiras"), DIASMACEDO("Dias Macedo"), EDSONQUEIROZ("Edson Queiroz"),
		GUAJERU("Guajeru"), JANGURUSSU("Jangurussu"), JOSEALENCAR("José de Alencar"), J_OLIVEIRAS("Jardim das Oliveiras"), LAGOAREDONDA("Lagoa Redonda"),
		MESSEJANA("Messejana"), DOISIRMAOS("Parque Dois Irmãos"), PARQUEIRACEMA("Parque Iracema"), MANIBURA("Parque Manibura"), PASSARE("Passaré"),
		PAUPINA("Paupina"), PEDRAS("Pedras"), SABIAGUABA("Sabiaguaba"), SAOBENTO("São Bento"), SANTAMARIA("Santa Maria"), SAPIRANGA("Sapiranga/Coité");
		
		private String nome;
		
		private Bairro(String nome) {
			this.nome = nome;
		}
		public String getNome() {
			return nome;
		}
		
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
