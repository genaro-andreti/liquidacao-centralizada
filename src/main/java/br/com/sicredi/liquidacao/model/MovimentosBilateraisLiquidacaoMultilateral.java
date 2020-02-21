package br.com.sicredi.liquidacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@Table(name="movimentos_bilaterais_liquidacao_multilateral") 
@XStreamAlias("SLC0001")
public class MovimentosBilateraisLiquidacaoMultilateral implements Serializable {
	private static final long serialVersionUID = -7901212303138902148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimentos_bilaterais_liquidacao_multilateral", nullable = false)
    private Long id;

	@XStreamAlias("CodMsg")
	private String codMsg;
	
	@XStreamAlias("NumCtrlSLC")
	private String numCtrlSLC;
	
	@XStreamAlias("ISPBIF")
	private Long iSPBIF;
	
	@XStreamAlias("TpInf")
	private String tpInf;
	
	@XStreamAlias("DtMovto")
    private LocalDate dtMovto;

	@XStreamAlias("DtHrSLC")
    private LocalDateTime dtHrSLC;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupo_movimentos_bilaterais_liquidacao_multilateral_liquid", referencedColumnName = "id_grupo_movimentos_bilaterais_liquidacao_multilateral_liquid", nullable = false, insertable=true, updatable=true)
	@XStreamAlias("Grupo_SLC0001_Liquid")
	private GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid grupoMovimentosBilateraisLiquidacaoMultilateralLiquid;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodMsg() {
		return codMsg;
	}

	public void setCodMsg(String codMsg) {
		this.codMsg = codMsg;
	}

	public String getNumCtrlSLC() {
		return numCtrlSLC;
	}

	public void setNumCtrlSLC(String numCtrlSLC) {
		this.numCtrlSLC = numCtrlSLC;
	}

	public Long getiSPBIF() {
		return iSPBIF;
	}

	public void setiSPBIF(Long iSPBIF) {
		this.iSPBIF = iSPBIF;
	}

	public String getTpInf() {
		return tpInf;
	}

	public void setTpInf(String tpInf) {
		this.tpInf = tpInf;
	}

	public LocalDate getDtMovto() {
		return dtMovto;
	}

	public void setDtMovto(LocalDate dtMovto) {
		this.dtMovto = dtMovto;
	}

	public LocalDateTime getDtHrSLC() {
		return dtHrSLC;
	}

	public void setDtHrSLC(LocalDateTime dtHrSLC) {
		this.dtHrSLC = dtHrSLC;
	}

	public GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid() {
		return grupoMovimentosBilateraisLiquidacaoMultilateralLiquid;
	}

	public void setGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid(
			GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid grupoMovimentosBilateraisLiquidacaoMultilateralLiquid) {
		this.grupoMovimentosBilateraisLiquidacaoMultilateralLiquid = grupoMovimentosBilateraisLiquidacaoMultilateralLiquid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMsg == null) ? 0 : codMsg.hashCode());
		result = prime * result + ((dtHrSLC == null) ? 0 : dtHrSLC.hashCode());
		result = prime * result + ((dtMovto == null) ? 0 : dtMovto.hashCode());
		result = prime * result + ((grupoMovimentosBilateraisLiquidacaoMultilateralLiquid == null) ? 0
				: grupoMovimentosBilateraisLiquidacaoMultilateralLiquid.hashCode());
		result = prime * result + ((iSPBIF == null) ? 0 : iSPBIF.hashCode());
		result = prime * result + ((numCtrlSLC == null) ? 0 : numCtrlSLC.hashCode());
		result = prime * result + ((tpInf == null) ? 0 : tpInf.hashCode());
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
		MovimentosBilateraisLiquidacaoMultilateral other = (MovimentosBilateraisLiquidacaoMultilateral) obj;
		if (codMsg == null) {
			if (other.codMsg != null)
				return false;
		} else if (!codMsg.equals(other.codMsg))
			return false;
		if (dtHrSLC == null) {
			if (other.dtHrSLC != null)
				return false;
		} else if (!dtHrSLC.equals(other.dtHrSLC))
			return false;
		if (dtMovto == null) {
			if (other.dtMovto != null)
				return false;
		} else if (!dtMovto.equals(other.dtMovto))
			return false;
		if (grupoMovimentosBilateraisLiquidacaoMultilateralLiquid == null) {
			if (other.grupoMovimentosBilateraisLiquidacaoMultilateralLiquid != null)
				return false;
		} else if (!grupoMovimentosBilateraisLiquidacaoMultilateralLiquid
				.equals(other.grupoMovimentosBilateraisLiquidacaoMultilateralLiquid))
			return false;
		if (iSPBIF == null) {
			if (other.iSPBIF != null)
				return false;
		} else if (!iSPBIF.equals(other.iSPBIF))
			return false;
		if (numCtrlSLC == null) {
			if (other.numCtrlSLC != null)
				return false;
		} else if (!numCtrlSLC.equals(other.numCtrlSLC))
			return false;
		if (tpInf == null) {
			if (other.tpInf != null)
				return false;
		} else if (!tpInf.equals(other.tpInf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovimentosBilateraisLiquidacaoMultilateral [codMsg=" + codMsg + ", numCtrlSLC=" + numCtrlSLC
				+ ", iSPBIF=" + iSPBIF + ", tpInf=" + tpInf + ", dtMovto=" + dtMovto + ", dtHrSLC=" + dtHrSLC
				+ ", grupoMovimentosBilateraisLiquidacaoMultilateralLiquid="
				+ grupoMovimentosBilateraisLiquidacaoMultilateralLiquid + "]";
	}

}
