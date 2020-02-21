package br.com.sicredi.liquidacao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DOC")
@Entity
@Table(name="doc") 
public class Doc implements Serializable {
	private static final long serialVersionUID = 4937773001342606277L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "id_segmento_controle", referencedColumnName = "id_segmento_controle", nullable = false, insertable=true, updatable=false)
	@XStreamAlias("BCMSG")
	private SegmentoControle segmentoControle;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "id_segmento_sistema", referencedColumnName = "id_segmento_sistema", nullable = false, insertable=true, updatable=false)
	@XStreamAlias("SISMSG")
	private SegmentoSistema segmentoSistema;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SegmentoControle getSegmentoControle() {
		return segmentoControle;
	}

	public void setSegmentoControle(SegmentoControle segmentoControle) {
		this.segmentoControle = segmentoControle;
	}

	public SegmentoSistema getSegmentoSistema() {
		return segmentoSistema;
	}

	public void setSegmentoSistema(SegmentoSistema segmentoSistema) {
		this.segmentoSistema = segmentoSistema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((segmentoControle == null) ? 0 : segmentoControle.hashCode());
		result = prime * result + ((segmentoSistema == null) ? 0 : segmentoSistema.hashCode());
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
		Doc other = (Doc) obj;
		if (segmentoControle == null) {
			if (other.segmentoControle != null)
				return false;
		} else if (!segmentoControle.equals(other.segmentoControle))
			return false;
		if (segmentoSistema == null) {
			if (other.segmentoSistema != null)
				return false;
		} else if (!segmentoSistema.equals(other.segmentoSistema))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doc [segmentoControle=" + segmentoControle + ", segmentoSistema=" + segmentoSistema + "]";
	}

}
