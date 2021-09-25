package com.objective.model;

import javax.swing.*;

public class NoArvoreBinariaDto implements Situacao {

	private final JFrame instanciaJanelaSwing;

	private String pergunta;
	private boolean respostaUsuarioSim;

	private NoArvoreBinariaDto usuarioRespondeuNao;
	private NoArvoreBinariaDto usuarioRespondeuSim;
	private NoArvoreBinariaDto vizinhoNoArvore;

	public NoArvoreBinariaDto(final JFrame instanciaJanelaSwing) {
		this.instanciaJanelaSwing = instanciaJanelaSwing;
	}

	@Override
	public void perguntarUsuario() {
		final var respostaSimUsuario = JOptionPane.showConfirmDialog(this.instanciaJanelaSwing, this.pergunta,
				"Selecione a Opção", JOptionPane.YES_NO_OPTION) == 0;

		if (respostaSimUsuario) {
			usuarioRespondeuSim.perguntarUsuario();
		} else {
			usuarioRespondeuNao.perguntarUsuario();
		}
	}

	public void setUsuarioRespondeuSim(final NoArvoreBinariaDto usuarioRespondeuSim) {
		this.usuarioRespondeuSim = usuarioRespondeuSim;
		this.usuarioRespondeuSim.setNoVizinho(this, Boolean.TRUE);
	}

	public void setUsuarioRespondeuNao(final NoArvoreBinariaDto usuarioRespondeuNao) {
		this.usuarioRespondeuNao = usuarioRespondeuNao;
		this.usuarioRespondeuNao.setNoVizinho(this, Boolean.FALSE);
	}

	public boolean usuarioRespondeuSim() {
		return this.respostaUsuarioSim;
	}

	public void setPergunta(final String pergunta) {
		this.pergunta = pergunta;
	}

	public void setNoVizinho(final NoArvoreBinariaDto vizinhoNoArvore,
							 final boolean respostaUsuarioSim) {
		this.vizinhoNoArvore = vizinhoNoArvore;
		this.respostaUsuarioSim = respostaUsuarioSim;
	}

	public NoArvoreBinariaDto getNoVizinho() {
		return this.vizinhoNoArvore;
	}

	public JFrame getInstanciaJanelaSwing() {
		return this.instanciaJanelaSwing;
	}
}
