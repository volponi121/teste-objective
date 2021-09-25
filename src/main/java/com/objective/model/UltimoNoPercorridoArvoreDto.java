package com.objective.model;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class UltimoNoPercorridoArvoreDto extends NoArvoreBinariaDto {

	private String prato;

	public UltimoNoPercorridoArvoreDto(final JFrame instanciaJanelaSwing) {
		super(instanciaJanelaSwing);
	}

	@Override
	public void perguntarUsuario() {
		final boolean respostaSimUsuario = JOptionPane.showConfirmDialog(getInstanciaJanelaSwing(),
				"O prato que você pensou é " + this.prato + "?", "Confirm", JOptionPane.YES_NO_OPTION) == 0;

		if (respostaSimUsuario) {
			JOptionPane.showMessageDialog(this.getInstanciaJanelaSwing(), "Acertei de novo!", "Jogo Gourmet",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			final var novoPratoDesconhecidoNaArvore = new NoArvoreBinariaDto(this.getInstanciaJanelaSwing());

			final var prato = JOptionPane.showInputDialog(getInstanciaJanelaSwing(),
					"Qual prato você pensou?", "Digite o prato", JOptionPane.QUESTION_MESSAGE);

			var respostaPrato = JOptionPane.showInputDialog(getInstanciaJanelaSwing(),
					prato + " é __________, mas " + this.prato + " não.", "Digite a descrição", JOptionPane.QUESTION_MESSAGE);

			respostaPrato = "O prato que você pensou foi " + respostaPrato + "?";

			populandoUltimoNoArvore(novoPratoDesconhecidoNaArvore, prato, respostaPrato);
		}
	}

	private void populandoUltimoNoArvore(NoArvoreBinariaDto novoPratoDesconhecidoNaArvore, String prato, String respostaPrato) {
		final var noFinalDaArvore = new UltimoNoPercorridoArvoreDto(getInstanciaJanelaSwing());
		noFinalDaArvore.setPrato(prato);

		if (usuarioRespondeuSim()) {
			this.getNoVizinho().setUsuarioRespondeuSim(novoPratoDesconhecidoNaArvore);
		} else {
			this.getNoVizinho().setUsuarioRespondeuNao(novoPratoDesconhecidoNaArvore);
		}

		novoPratoDesconhecidoNaArvore.setPergunta(respostaPrato);
		novoPratoDesconhecidoNaArvore.setUsuarioRespondeuSim(noFinalDaArvore);
		novoPratoDesconhecidoNaArvore.setUsuarioRespondeuNao(this);
	}


	public void setPrato(String prato) {
		this.prato = prato;
	}
}
