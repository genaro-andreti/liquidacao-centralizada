package br.com.sicredi.liquidacao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@Table(name="segmento_sistema") 
@XStreamAlias("SISMSG")
public class SegmentoSistema implements Serializable{
	private static final long serialVersionUID = -1033759863409961451L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_segmento_sistema", nullable = false)
    private Long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "id_movimentos_bilaterais_liquidacao_multilateral", referencedColumnName = "id_movimentos_bilaterais_liquidacao_multilateral", nullable = false, insertable=true, updatable=true)
	@XStreamAlias("SLC0001")
	private MovimentosBilateraisLiquidacaoMultilateral movimentosBilateraisLiquidacaoMultilateral;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MovimentosBilateraisLiquidacaoMultilateral getMovimentosBilateraisLiquidacaoMultilateral() {
		return movimentosBilateraisLiquidacaoMultilateral;
	}

	public void setMovimentosBilateraisLiquidacaoMultilateral(
			MovimentosBilateraisLiquidacaoMultilateral movimentosBilateraisLiquidacaoMultilateral) {
		this.movimentosBilateraisLiquidacaoMultilateral = movimentosBilateraisLiquidacaoMultilateral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movimentosBilateraisLiquidacaoMultilateral == null) ? 0
				: movimentosBilateraisLiquidacaoMultilateral.hashCode());
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
		SegmentoSistema other = (SegmentoSistema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movimentosBilateraisLiquidacaoMultilateral == null) {
			if (other.movimentosBilateraisLiquidacaoMultilateral != null)
				return false;
		} else if (!movimentosBilateraisLiquidacaoMultilateral.equals(other.movimentosBilateraisLiquidacaoMultilateral))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SegmentoSistema [id=" + id + ", movimentosBilateraisLiquidacaoMultilateral="
				+ movimentosBilateraisLiquidacaoMultilateral + "]";
	}
	
	

}
