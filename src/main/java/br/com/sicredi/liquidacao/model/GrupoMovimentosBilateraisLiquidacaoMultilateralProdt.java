package br.com.sicredi.liquidacao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@Entity
@Table(name="grupo_movimentos_bilaterais_liquidacao_multilateral_prodt") 
@XStreamAlias("Grupo_SLC0001_Prodt")
public class GrupoMovimentosBilateraisLiquidacaoMultilateralProdt implements Serializable {
	private static final long serialVersionUID = -858695731992886683L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_movimentos_bilaterais_liquidacao_multilateral_prodt", nullable = false)
    private Long id;

	@XStreamAlias("CodProdt")
	private String codProdt;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
	@XStreamImplicit(itemFieldName = "Grupo_SLC0001_LiquidProdt")
    private List<GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt> grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodProdt() {
		return codProdt;
	}

	public void setCodProdt(String codProdt) {
		this.codProdt = codProdt;
	}

	public List<GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt> getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt() {
		return grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt;
	}

	public void setGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt(
			List<GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt> grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt) {
		this.grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt = grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProdt == null) ? 0 : codProdt.hashCode());
		result = prime * result + ((grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt == null) ? 0
				: grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt.hashCode());
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
		GrupoMovimentosBilateraisLiquidacaoMultilateralProdt other = (GrupoMovimentosBilateraisLiquidacaoMultilateralProdt) obj;
		if (codProdt == null) {
			if (other.codProdt != null)
				return false;
		} else if (!codProdt.equals(other.codProdt))
			return false;
		if (grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt == null) {
			if (other.grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt != null)
				return false;
		} else if (!grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt
				.equals(other.grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoMovimentosBilateraisLiquidacaoMultilateralProt [codProdt=" + codProdt
				+ ", grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt="
				+ grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt + "]";
	}

}
