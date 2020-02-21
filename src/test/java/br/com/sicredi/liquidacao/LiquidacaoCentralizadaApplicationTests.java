package br.com.sicredi.liquidacao;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sicredi.liquidacao.model.Doc;
import br.com.sicredi.liquidacao.model.GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid;
import br.com.sicredi.liquidacao.model.GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt;
import br.com.sicredi.liquidacao.model.GrupoMovimentosBilateraisLiquidacaoMultilateralProdt;
import br.com.sicredi.liquidacao.model.GrupoSeq;
import br.com.sicredi.liquidacao.model.MovimentosBilateraisLiquidacaoMultilateral;
import br.com.sicredi.liquidacao.model.SegmentoControle;
import br.com.sicredi.liquidacao.model.SegmentoSistema;
import br.com.sicredi.liquidacao.repository.DocRepository;

@SpringBootTest
class LiquidacaoCentralizadaApplicationTests {

	@Mock
	private DocRepository docRepository;

	@Test
	public void returnCustomerWhenValidLine() {
		Doc docMock = new Doc();
		docMock.setId(1L);
		docMock.setSegmentoControle(criaSegmentoControle());
		docMock.setSegmentoSistema(criaSegmentoSistema());

		when(docRepository.save(docMock)).thenReturn(docMock);

		Doc doc = docRepository.save(docMock);

		Assertions.assertNotNull(doc);
		Assertions.assertEquals(doc.getId(), 1L);

		Assertions.assertNotNull(doc.getSegmentoControle());
		Assertions.assertEquals(doc.getSegmentoControle().getId(), 1L);
		Assertions.assertEquals(doc.getSegmentoControle().getIdentdDestinatario(), 12345678L);
		Assertions.assertEquals(doc.getSegmentoControle().getIdentdEmissor(), 99999999L);
		Assertions.assertEquals(doc.getSegmentoControle().getDomSist(), "SPB01");
		Assertions.assertEquals(doc.getSegmentoControle().getnUOp(), "12345678912345678912345");

		Assertions.assertNotNull(doc.getSegmentoControle().getGrupoSeq());
		Assertions.assertEquals(doc.getSegmentoControle().getGrupoSeq().getId(), 1L);
		Assertions.assertEquals(doc.getSegmentoControle().getGrupoSeq().getNumSeq(), 1);
		Assertions.assertEquals(doc.getSegmentoControle().getGrupoSeq().getIndrCont(), "N");

		Assertions.assertNotNull(doc.getSegmentoSistema());
		Assertions.assertEquals(doc.getSegmentoSistema().getId(), 1L);

		Assertions.assertNotNull(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral());
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getId(), 1L);
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getiSPBIF(),
				12345678L);
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getCodMsg(),
				"SLC0001");
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getDtHrSLC(),
				LocalDateTime.parse("2019-01-01T08:40:21"));
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getDtMovto(),
				LocalDate.parse("2019-01-01"));
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getNumCtrlSLC(),
				"12345678912345678912");
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral().getTpInf(),
				"P");

		Assertions.assertNotNull(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid());
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid().getId(), 1L);
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid().getNumSeqCicloLiquid(), 1);
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid().getDtLiquid(),
				LocalDate.parse("2019-01-01"));

		Assertions.assertNotNull(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt());
		Assertions.assertNotNull(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0));
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0).getId(), 1L);

		Assertions.assertNotNull(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt());
		Assertions.assertNotNull(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0));
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getId(), 1L);
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getiSPBIFCredtd(),
				99999999L);
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getiSPBIFDebtd(),
				99999999L);
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getVlrLanc(),
				new Double("4000.0"));
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getcNPJNLiqdantCredtd(),
				"17061147000194");
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getcNPJNLiqdantDebtd(),
				"99929009000149");
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getIdentdLinhaBilat(),
				"12345678ACC3456789");
		Assertions.assertEquals(
				doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
						.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getNomCliCredtd(),
				"BANCO");
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getNomCliDebtd(), "JET");
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getTpDeb_Cred(), "D");
		Assertions.assertEquals(doc.getSegmentoSistema().getMovimentosBilateraisLiquidacaoMultilateral()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid()
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralProdt().get(0)
				.getGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt().get(0).getTpTranscSLC(), "02");

	}

	private SegmentoSistema criaSegmentoSistema() {
		SegmentoSistema segmentoSistema = new SegmentoSistema();
		segmentoSistema.setId(1L);
		segmentoSistema.setMovimentosBilateraisLiquidacaoMultilateral(criaMovimentosBilateraisLiquidacaoMultilateral());
		return segmentoSistema;
	}

	private MovimentosBilateraisLiquidacaoMultilateral criaMovimentosBilateraisLiquidacaoMultilateral() {
		MovimentosBilateraisLiquidacaoMultilateral movimentosBilateraisLiquidacaoMultilateral = new MovimentosBilateraisLiquidacaoMultilateral();
		movimentosBilateraisLiquidacaoMultilateral.setId(1L);
		movimentosBilateraisLiquidacaoMultilateral.setCodMsg("SLC0001");
		movimentosBilateraisLiquidacaoMultilateral.setDtHrSLC(LocalDateTime.parse("2019-01-01T08:40:21"));
		movimentosBilateraisLiquidacaoMultilateral.setDtMovto(LocalDate.parse("2019-01-01"));
		movimentosBilateraisLiquidacaoMultilateral.setGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid(
				criaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid());
		movimentosBilateraisLiquidacaoMultilateral.setiSPBIF(12345678L);
		movimentosBilateraisLiquidacaoMultilateral.setNumCtrlSLC("12345678912345678912");
		movimentosBilateraisLiquidacaoMultilateral.setTpInf("P");

		return movimentosBilateraisLiquidacaoMultilateral;
	}

	private GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid criaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquid() {
		GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid grupoMovimentosBilateraisLiquidacaoMultilateralLiquid = new GrupoMovimentosBilateraisLiquidacaoMultilateralLiquid();
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquid.setId(1L);
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquid.setDtLiquid(LocalDate.parse("2019-01-01"));
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquid.setGrupoMovimentosBilateraisLiquidacaoMultilateralProdt(
				criaListaGrupoMovimentosBilateraisLiquidacaoMultilateralProdt());
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquid.setNumSeqCicloLiquid(1);

		return grupoMovimentosBilateraisLiquidacaoMultilateralLiquid;
	}

	private List<GrupoMovimentosBilateraisLiquidacaoMultilateralProdt> criaListaGrupoMovimentosBilateraisLiquidacaoMultilateralProdt() {
		List<GrupoMovimentosBilateraisLiquidacaoMultilateralProdt> listaGrupoMovimentosBilateraisLiquidacaoMultilateralProdt = new ArrayList<GrupoMovimentosBilateraisLiquidacaoMultilateralProdt>();

		GrupoMovimentosBilateraisLiquidacaoMultilateralProdt grupoMovimentosBilateraisLiquidacaoMultilateralProdt = new GrupoMovimentosBilateraisLiquidacaoMultilateralProdt();
		grupoMovimentosBilateraisLiquidacaoMultilateralProdt.setId(1L);
		grupoMovimentosBilateraisLiquidacaoMultilateralProdt.setCodProdt("ACC");
		grupoMovimentosBilateraisLiquidacaoMultilateralProdt
				.setGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProt(
						criaListaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt());
		listaGrupoMovimentosBilateraisLiquidacaoMultilateralProdt
				.add(grupoMovimentosBilateraisLiquidacaoMultilateralProdt);

		return listaGrupoMovimentosBilateraisLiquidacaoMultilateralProdt;
	}

	private List<GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt> criaListaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt() {
		List<GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt> listaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt = new ArrayList<GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt>();

		GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt = new GrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt();
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setId(1L);
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setcNPJNLiqdantCredtd("17061147000194");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setcNPJNLiqdantDebtd("99929009000149");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setIdentdLinhaBilat("12345678ACC3456789");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setiSPBIFCredtd(99999999L);
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setiSPBIFDebtd(99999999L);
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setNomCliCredtd("BANCO");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setNomCliDebtd("JET");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setTpDeb_Cred("D");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setTpTranscSLC("02");
		grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt.setVlrLanc(new Double("4000.0"));

		listaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt
				.add(grupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt);
		return listaGrupoMovimentosBilateraisLiquidacaoMultilateralLiquidProdt;
	}

	private SegmentoControle criaSegmentoControle() {
		SegmentoControle segmentoControle = new SegmentoControle();
		segmentoControle.setId(1L);
		segmentoControle.setDomSist("SPB01");

		GrupoSeq grupoSeq = new GrupoSeq();
		grupoSeq.setId(1L);
		grupoSeq.setIndrCont("N");
		grupoSeq.setNumSeq(1);

		segmentoControle.setGrupoSeq(grupoSeq);
		segmentoControle.setIdentdDestinatario(12345678L);
		segmentoControle.setIdentdEmissor(99999999L);
		segmentoControle.setnUOp("12345678912345678912345");
		return segmentoControle;
	}

}
