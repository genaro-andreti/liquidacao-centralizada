package br.com.sicredi.liquidacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@XStreamAlias("Grupo_Seq")
public class GrupoSeq implements Serializable {
	private static final long serialVersionUID = 1027661848375077162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@XStreamAlias("NumSeq")
	private Integer numSeq;

	@XStreamAlias("IndrCont")
	private String indrCont;

	public Integer getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(Integer numSeq) {
		this.numSeq = numSeq;
	}

	public String getIndrCont() {
		return indrCont;
	}

	public void setIndrCont(String indrCont) {
		this.indrCont = indrCont;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indrCont == null) ? 0 : indrCont.hashCode());
		result = prime * result + numSeq;
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
		GrupoSeq other = (GrupoSeq) obj;
		if (indrCont == null) {
			if (other.indrCont != null)
				return false;
		} else if (!indrCont.equals(other.indrCont))
			return false;
		if (numSeq != other.numSeq)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoSeq [numSeq=" + numSeq + ", indrCont=" + indrCont + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
