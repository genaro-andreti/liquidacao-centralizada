package br.com.sicredi.liquidacao.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="grupo_movimentos_bilaterais_liquidacao_multilateral_liquid") 
@XStreamAlias("Grupo_SLC0001_Liquid")
public class GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid implements Serializable {
	private static final long serialVersionUID = -8062422150927150445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_movimentos_bilaterais_liquidacao_multilateral_liquid", nullable = false)
    private Long id;

	@XStreamAlias("DtLiquid")
    private LocalDate dtLiquid;
	
	@XStreamAlias("NumSeqCicloLiquid")
    private Integer numSeqCicloLiquid;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
	@XStreamImplicit(itemFieldName = "Grupo_SLC0001_Prodt")
	private List<GrupoMovimentosBilateraisLiquidacaoMultilateralProdt> grupoMovimentosBilateraisLiquidacaoMultilateralProdt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDtLiquid() {
		return dtLiquid;
	}

	public void setDtLiquid(LocalDate dtLiquid) {
		this.dtLiquid = dtLiquid;
	}

	public Integer getNumSeqCicloLiquid() {
		return numSeqCicloLiquid;
	}

	public void setNumSeqCicloLiquid(Integer numSeqCicloLiquid) {
		this.numSeqCicloLiquid = numSeqCicloLiquid;
	}

	public List<GrupoMovimentosBilateraisLiquidacaoMultilateralProdt> getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt() {
		return grupoMovimentosBilateraisLiquidacaoMultilateralProdt;
	}

	public void setGrupoMovimentosBilateraisLiquidacaoMultilateralProdt(
			List<GrupoMovimentosBilateraisLiquidacaoMultilateralProdt> grupoMovimentosBilateraisLiquidacaoMultilateralProdt) {
		this.grupoMovimentosBilateraisLiquidacaoMultilateralProdt = grupoMovimentosBilateraisLiquidacaoMultilateralProdt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtLiquid == null) ? 0 : dtLiquid.hashCode());
		result = prime * result + ((grupoMovimentosBilateraisLiquidacaoMultilateralProdt == null) ? 0
				: grupoMovimentosBilateraisLiquidacaoMultilateralProdt.hashCode());
		result = prime * result + ((numSeqCicloLiquid == null) ? 0 : numSeqCicloLiquid.hashCode());
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
		GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid other = (GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid) obj;
		if (dtLiquid == null) {
			if (other.dtLiquid != null)
				return false;
		} else if (!dtLiquid.equals(other.dtLiquid))
			return false;
		if (grupoMovimentosBilateraisLiquidacaoMultilateralProdt == null) {
			if (other.grupoMovimentosBilateraisLiquidacaoMultilateralProdt != null)
				return false;
		} else if (!grupoMovimentosBilateraisLiquidacaoMultilateralProdt
				.equals(other.grupoMovimentosBilateraisLiquidacaoMultilateralProdt))
			return false;
		if (numSeqCicloLiquid == null) {
			if (other.numSeqCicloLiquid != null)
				return false;
		} else if (!numSeqCicloLiquid.equals(other.numSeqCicloLiquid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid [dtLiquid=" + dtLiquid + ", numSeqCicloLiquid="
				+ numSeqCicloLiquid + ", grupoMovimentosBilateraisLiquidacaoMultilateralProt="
				+ grupoMovimentosBilateraisLiquidacaoMultilateralProdt + "]";
	}

}
