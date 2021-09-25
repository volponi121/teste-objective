package com.objective.service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import com.objective.model.NoArvoreBinariaDto;
import com.objective.model.UltimoNoPercorridoArvoreDto;

public class JogoService extends JFrame {

	private transient NoArvoreBinariaDto noRaizArvoreBinaria;

	public JogoService() {

		montaPainelInicialEPopulaInicioDaArvoreBinaria();

		populacaoInicial();
	}

	private void montaPainelInicialEPopulaInicioDaArvoreBinaria() {
		this.setTitle(" Jogo Prato Gourmet ");

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		final JPanel painel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(20, 50, 20, 50);
		painel.setBorder(padding);

		final JButton botao = new JButton("Ok!");

		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JogoService.this.noRaizArvoreBinaria.perguntarUsuario();
			}
		});

		final var texto = new JLabel("Pense em um prato que gosta");
		painel.add(texto);
		painel.add(Box.createRigidArea(new Dimension(0, 15)));
		painel.add(botao);

		this.setContentPane(painel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void populacaoInicial() {
		final var usuarioRespondeuSim = new UltimoNoPercorridoArvoreDto(this);
		usuarioRespondeuSim.setPrato("Lasanha!");

		final var usuarioRespondeuNao = new UltimoNoPercorridoArvoreDto(this);
		usuarioRespondeuNao.setPrato("Bolo de Chocolate!");

		this.noRaizArvoreBinaria = new NoArvoreBinariaDto(this);
		this.noRaizArvoreBinaria.setPergunta("O prato que você pensou é massa?");

		this.noRaizArvoreBinaria.setUsuarioRespondeuSim(usuarioRespondeuSim);
		this.noRaizArvoreBinaria.setUsuarioRespondeuNao(usuarioRespondeuNao);
	}

}
