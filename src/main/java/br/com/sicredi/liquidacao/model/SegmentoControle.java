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
@Table(name="segmento_controle") 
@XStreamAlias("BCMSG")
public class SegmentoControle implements Serializable {
	private static final long serialVersionUID = 2414903235709185990L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_segmento_controle", nullable = false)
    private Long id;

	@XStreamAlias("IdentdEmissor")
	private Long identdEmissor;

	@XStreamAlias("IdentdDestinatario")
	private Long identdDestinatario;

	@XStreamAlias("Grupo_Seq")
	private GrupoSeq grupoSeq;

	@XStreamAlias("DomSist")
	private String domSist;

	@XStreamAlias("NUOp")
	private String nUOp;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdentdEmissor() {
		return identdEmissor;
	}

	public void setIdentdEmissor(Long identdEmissor) {
		this.identdEmissor = identdEmissor;
	}

	public Long getIdentdDestinatario() {
		return identdDestinatario;
	}

	public void setIdentdDestinatario(Long identdDestinatario) {
		this.identdDestinatario = identdDestinatario;
	}

	public GrupoSeq getGrupoSeq() {
		return grupoSeq;
	}

	public void setGrupoSeq(GrupoSeq grupoSeq) {
		this.grupoSeq = grupoSeq;
	}

	public String getDomSist() {
		return domSist;
	}

	public void setDomSist(String domSist) {
		this.domSist = domSist;
	}

	public String getnUOp() {
		return nUOp;
	}

	public void setnUOp(String nUOp) {
		this.nUOp = nUOp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domSist == null) ? 0 : domSist.hashCode());
		result = prime * result + ((grupoSeq == null) ? 0 : grupoSeq.hashCode());
		result = prime * result + ((identdDestinatario == null) ? 0 : identdDestinatario.hashCode());
		result = prime * result + ((identdEmissor == null) ? 0 : identdEmissor.hashCode());
		result = prime * result + ((nUOp == null) ? 0 : nUOp.hashCode());
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
		SegmentoControle other = (SegmentoControle) obj;
		if (domSist == null) {
			if (other.domSist != null)
				return false;
		} else if (!domSist.equals(other.domSist))
			return false;
		if (grupoSeq == null) {
			if (other.grupoSeq != null)
				return false;
		} else if (!grupoSeq.equals(other.grupoSeq))
			return false;
		if (identdDestinatario == null) {
			if (other.identdDestinatario != null)
				return false;
		} else if (!identdDestinatario.equals(other.identdDestinatario))
			return false;
		if (identdEmissor == null) {
			if (other.identdEmissor != null)
				return false;
		} else if (!identdEmissor.equals(other.identdEmissor))
			return false;
		if (nUOp == null) {
			if (other.nUOp != null)
				return false;
		} else if (!nUOp.equals(other.nUOp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SegmentoControle [identdEmissor=" + identdEmissor + ", identdDestinatario=" + identdDestinatario
				+ ", grupoSeq=" + grupoSeq + ", domSist=" + domSist + ", nUOp=" + nUOp + "]";
	}

}
