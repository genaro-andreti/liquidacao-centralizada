package br.com.sicredi.liquidacao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@Table(name="grupo_movimentos_bilaterais_liquidacao_multilateral_liquid_prodt") 
@XStreamAlias("Grupo_SLC0001_LiquidProdt")
public class GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt implements Serializable {
	private static final long serialVersionUID = -2893297755588627244L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_movimentos_bilaterais_liquidacao_multilateral_liquid_prodt", nullable = false)
    private Long id;

	@XStreamAlias("IdentdLinhaBilat")
    private String identdLinhaBilat;
	
	@XStreamAlias("TpDeb_Cred")
    private String tpDeb_Cred;
	
	@XStreamAlias("ISPBIFCredtd")
    private Long iSPBIFCredtd;
	
	@XStreamAlias("ISPBIFDebtd")
    private Long iSPBIFDebtd;
	
	@XStreamAlias("VlrLanc")
    private Double vlrLanc;
	
	@XStreamAlias("CNPJNLiqdantDebtd")
    private String cNPJNLiqdantDebtd;
	
	@XStreamAlias("NomCliDebtd")
    private String nomCliDebtd;
	
	@XStreamAlias("CNPJNLiqdantCredtd")
    private String cNPJNLiqdantCredtd;
	
	@XStreamAlias("NomCliCredtd")
    private String nomCliCredtd;
	
	@XStreamAlias("TpTranscSLC")
    private String tpTranscSLC;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentdLinhaBilat() {
		return identdLinhaBilat;
	}

	public void setIdentdLinhaBilat(String identdLinhaBilat) {
		this.identdLinhaBilat = identdLinhaBilat;
	}

	public String getTpDeb_Cred() {
		return tpDeb_Cred;
	}

	public void setTpDeb_Cred(String tpDeb_Cred) {
		this.tpDeb_Cred = tpDeb_Cred;
	}

	public Long getiSPBIFCredtd() {
		return iSPBIFCredtd;
	}

	public void setiSPBIFCredtd(Long iSPBIFCredtd) {
		this.iSPBIFCredtd = iSPBIFCredtd;
	}

	public Long getiSPBIFDebtd() {
		return iSPBIFDebtd;
	}

	public void setiSPBIFDebtd(Long iSPBIFDebtd) {
		this.iSPBIFDebtd = iSPBIFDebtd;
	}

	public Double getVlrLanc() {
		return vlrLanc;
	}

	public void setVlrLanc(Double vlrLanc) {
		this.vlrLanc = vlrLanc;
	}

	public String getcNPJNLiqdantDebtd() {
		return cNPJNLiqdantDebtd;
	}

	public void setcNPJNLiqdantDebtd(String cNPJNLiqdantDebtd) {
		this.cNPJNLiqdantDebtd = cNPJNLiqdantDebtd;
	}

	public String getNomCliDebtd() {
		return nomCliDebtd;
	}

	public void setNomCliDebtd(String nomCliDebtd) {
		this.nomCliDebtd = nomCliDebtd;
	}

	public String getcNPJNLiqdantCredtd() {
		return cNPJNLiqdantCredtd;
	}

	public void setcNPJNLiqdantCredtd(String cNPJNLiqdantCredtd) {
		this.cNPJNLiqdantCredtd = cNPJNLiqdantCredtd;
	}

	public String getNomCliCredtd() {
		return nomCliCredtd;
	}

	public void setNomCliCredtd(String nomCliCredtd) {
		this.nomCliCredtd = nomCliCredtd;
	}

	public String getTpTranscSLC() {
		return tpTranscSLC;
	}

	public void setTpTranscSLC(String tpTranscSLC) {
		this.tpTranscSLC = tpTranscSLC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cNPJNLiqdantCredtd == null) ? 0 : cNPJNLiqdantCredtd.hashCode());
		result = prime * result + ((cNPJNLiqdantDebtd == null) ? 0 : cNPJNLiqdantDebtd.hashCode());
		result = prime * result + ((iSPBIFCredtd == null) ? 0 : iSPBIFCredtd.hashCode());
		result = prime * result + ((iSPBIFDebtd == null) ? 0 : iSPBIFDebtd.hashCode());
		result = prime * result + ((identdLinhaBilat == null) ? 0 : identdLinhaBilat.hashCode());
		result = prime * result + ((nomCliCredtd == null) ? 0 : nomCliCredtd.hashCode());
		result = prime * result + ((nomCliDebtd == null) ? 0 : nomCliDebtd.hashCode());
		result = prime * result + ((tpDeb_Cred == null) ? 0 : tpDeb_Cred.hashCode());
		result = prime * result + ((tpTranscSLC == null) ? 0 : tpTranscSLC.hashCode());
		result = prime * result + ((vlrLanc == null) ? 0 : vlrLanc.hashCode());
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
		GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt other = (GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt) obj;
		if (cNPJNLiqdantCredtd == null) {
			if (other.cNPJNLiqdantCredtd != null)
				return false;
		} else if (!cNPJNLiqdantCredtd.equals(other.cNPJNLiqdantCredtd))
			return false;
		if (cNPJNLiqdantDebtd == null) {
			if (other.cNPJNLiqdantDebtd != null)
				return false;
		} else if (!cNPJNLiqdantDebtd.equals(other.cNPJNLiqdantDebtd))
			return false;
		if (iSPBIFCredtd == null) {
			if (other.iSPBIFCredtd != null)
				return false;
		} else if (!iSPBIFCredtd.equals(other.iSPBIFCredtd))
			return false;
		if (iSPBIFDebtd == null) {
			if (other.iSPBIFDebtd != null)
				return false;
		} else if (!iSPBIFDebtd.equals(other.iSPBIFDebtd))
			return false;
		if (identdLinhaBilat == null) {
			if (other.identdLinhaBilat != null)
				return false;
		} else if (!identdLinhaBilat.equals(other.identdLinhaBilat))
			return false;
		if (nomCliCredtd == null) {
			if (other.nomCliCredtd != null)
				return false;
		} else if (!nomCliCredtd.equals(other.nomCliCredtd))
			return false;
		if (nomCliDebtd == null) {
			if (other.nomCliDebtd != null)
				return false;
		} else if (!nomCliDebtd.equals(other.nomCliDebtd))
			return false;
		if (tpDeb_Cred == null) {
			if (other.tpDeb_Cred != null)
				return false;
		} else if (!tpDeb_Cred.equals(other.tpDeb_Cred))
			return false;
		if (tpTranscSLC == null) {
			if (other.tpTranscSLC != null)
				return false;
		} else if (!tpTranscSLC.equals(other.tpTranscSLC))
			return false;
		if (vlrLanc == null) {
			if (other.vlrLanc != null)
				return false;
		} else if (!vlrLanc.equals(other.vlrLanc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt [identdLinhaBilat=" + identdLinhaBilat
				+ ", tpDeb_Cred=" + tpDeb_Cred + ", iSPBIFCredtd=" + iSPBIFCredtd + ", iSPBIFDebtd=" + iSPBIFDebtd
				+ ", vlrLanc=" + vlrLanc + ", cNPJNLiqdantDebtd=" + cNPJNLiqdantDebtd + ", nomCliDebtd=" + nomCliDebtd
				+ ", cNPJNLiqdantCredtd=" + cNPJNLiqdantCredtd + ", nomCliCredtd=" + nomCliCredtd + ", tpTranscSLC="
				+ tpTranscSLC + "]";
	}

}
