package com.aventurasGoblin;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {

		// VARIÁVEIS AUXILIARES
		int largTela = 1024;
		int altTela = 768;
		int estado = -1;
		int delay = 17;
		Sequence seq = null;
		Sequencer sequencer = null;

		// INSTANCIANDO ARRAYS
		ArrayList<Fase> fases = new ArrayList<Fase>();
		ArrayList<Cena> cenas = new ArrayList<Cena>();
		ArrayList<Personagem> personagens = new ArrayList<Personagem>();
		ArrayList<MiniGame> minigames = new ArrayList<MiniGame>();

		// INSTANCIANDO OBJETOS
		Random rand = new Random();
		Controle cont = new Controle();
		Jogador jog = new Jogador(3, 0, 0, 0);
		JFrame janela = new JFrame("As Aventuras Épicas de um Goblin no Espaço");
		Fisica fis = new Fisica();

		// JPANELS
		TelaEstatica panTela = new TelaEstatica("titulo");
		TelaEstatica panOver = new TelaEstatica("gameover");
		Painel pan = new Painel(jog, fases);
		PainelCena panCenas = new PainelCena(jog, cenas);

		// INICIALIZANDO JANELA
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setContentPane(pan);
		janela.setBackground(Color.black);
		janela.setSize(largTela, altTela);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.addKeyListener(cont);
		janela.setContentPane(panTela);

		// CARREGANDO SONS

		try {
			seq = MidiSystem.getSequence(new File("res/background.mid"));
		} catch (InvalidMidiDataException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sequencer.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sequencer.setSequence(seq);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CORRIGINDO VARIÁVEIS
		largTela = largTela - janela.getInsets().left
				- janela.getInsets().right;
		altTela = altTela - janela.getInsets().bottom - janela.getInsets().top;

		// LOOP DO JOGO
		while (true) {

			if (estado == -1) {
				// CARREGANDO CENAS
				cenas.add(new Cena(0, personagens, cont, 0, 2, true, 1));
				cenas.add(new Cena(1, personagens, cont, 0, 1, true, 1));
				cenas.add(new Cena(2, personagens, cont, 0, 1, true, 1));
				cenas.add(new Cena(3, personagens, cont, 0, 1, true, 1));
				cenas.add(new Cena(4, personagens, cont, 0, 2, true, 1));
				cenas.add(new Cena(5, personagens, cont, 0, 3, true, 2));
				cenas.add(new Cena(6, personagens, cont, 0, 1, true, 1));
				cenas.add(new Cena(7, personagens, cont, 1, 3, false, 3));
				cenas.add(new Cena(8, personagens, cont, 0, 1, true, 1));
				cenas.add(new Cena(8, personagens, cont, 2, 2, false, 1));
				cenas.add(new Cena(8, personagens, cont, 0, 2, true, 2));
				cenas.add(new Cena(9, personagens, cont, 0, 2, true, 1));
				cenas.add(new Cena(10, personagens, cont, 3, 3, false, 3));
				cenas.add(new Cena(11, personagens, cont, 4, 2, false, 1));
				cenas.add(new Cena(12, personagens, cont, 0, 2, true, 2));
				cenas.add(new Cena(13, personagens, cont, 5, 4, false, -2));

				// CARREGANDO FASES
				fases.add(new Fase(jog, cont, "kalikas", 1, 5, 3, 5));
				fases.add(new Fase(jog, cont, "tubig", 2, 10, 4, 10));
				fases.add(new Fase(jog, cont, "toplina", 3, 15, 8, 15));

				// CARREGANDO PERSONAGENS
				personagens.add(new Personagem("Elfo", "elfo"));
				personagens.add(new Personagem("Mecânico", "mecanico"));
				personagens.add(new Personagem("Capanga", "capanga"));
				personagens.add(new Personagem("Apostador", "apostador"));
				personagens.add(new Personagem("Alguém", "alguem"));
				personagens.add(new Personagem("Narrador", "narrador"));

				// CARREGANDO FALAS
				personagens.get(0).adicionarFala("zZZzzZzzzzzZzzZzzZzzZ");
				personagens.get(0).adicionarFala(
						"Droga... A porta... Coisa boa essa hora não é.");
				personagens.get(0).adicionarFala("Vish! Cobradores!");
				personagens.get(0).adicionarFala("Vou dar o fora...");
				personagens.get(0).adicionarFala("Já tô dando o fora.");
				personagens.get(0).adicionarFala(
						"Olá, você aí, que está lendo isso. ");
				personagens.get(0).adicionarFala(
						"Meu nome é Elfo, e sim, eu sou um Goblin.");
				personagens
						.get(0)
						.adicionarFala(
								"Eu vivo num Sistema Solar maluco, onde existem várias  raças e dois sóis.");
				personagens.get(0).adicionarFala(
						"O Sol 1 e o Sol 2. O Sol 1 veio depois, é o maior.");
				personagens
						.get(0)
						.adicionarFala(
								"Agora, chega de conversa que eu tenho que fugir dos    cobradores. Ou atirar mortalmente neles...");
				personagens.get(0).adicionarFala(" SANTO  GOBLIN!");
				personagens.get(0).adicionarFala(
						" E ai, Sr.Mec, tem como me ajudar com minha nave?");
				personagens.get(0).adicionarFala(
						" POR KIKKI-JIKKI! Eu  vou levar o motor!");
				personagens.get(0).adicionarFala("Uffa, consegui.");
				personagens.get(0).adicionarFala("O que eles estão falando?");
				personagens.get(0).adicionarFala(
						" É melhor eu dar o fora daqui!");
				personagens.get(0).adicionarFala(
						"Esses cobradores de novo, aff.");
				personagens
						.get(0)
						.adicionarFala(
								"Vou me esconder aqui em Tubig, agora que eu conse-       gui fugir...");
				personagens
						.get(0)
						.adicionarFala(
								"Eu sei que alguém aqui pode me dar uma boa arma,       humanos são ótimos em fazê-las.");
				personagens
						.get(0)
						.adicionarFala(
								"E aí, cara, fiquei sabendo que você pode dar um bom     upgrade nas armas da minha nave...");
				personagens.get(0).adicionarFala("Ok! Sou ótimo nisso.");
				personagens
						.get(0)
						.adicionarFala(
								"Agora não tenho mais o que tratar com esse humano      idiota...");
				personagens.get(0).adicionarFala(
						"O quê? Guerra com os Elfos, melhor eu sair daqui.");
				personagens
						.get(0)
						.adicionarFala(
								"Novamente esses cobradores. Vai surgir um terceiro     sol, antes deles desistirem de mim.");
				personagens.get(0).adicionarFala("Nããããããããããããõ");
				personagens.get(0).adicionarFala("Eu tô vivo, caramba. e.e");
				personagens
						.get(1)
						.adicionarFala(
								"Eu posso,se você conseguir levar aquele motor pro re-  frigerador antes dele explodir... Tá na caixa ali.");
				personagens
						.get(2)
						.adicionarFala(
								"Eu sei que você conhece o Escolhido, se não vai falar, não tem utilidade");
				personagens
						.get(3)
						.adicionarFala(
								"Ok.Eu tenho o equipamento, mas você terá que ganhar    de mim no DICE BLACKJACK!");
				personagens.get(4).adicionarFala(
						"Meu Deus, os elfos vão invadir o planeta!!!");
				personagens.get(5).adicionarFala(
						"CONTINUA NO PRÓXIMO EPISÓDIO...");
				personagens.get(5).adicionarFala(
						"... EU DISSE... CONTINUA NO PRÓXIMO EPISÓDIO");

				// CARREGANDO MINIGAMES
				minigames.add(new JogoCaixa(cont, janela));
				minigames.add(new DiceJack(cont, janela));

				// POSICIONANDO NAVE NO CENTRO INFERIOR DA TELA
				for (int i = 0; i < fases.size(); i++) {
					fases.get(i)
							.getVeiculos()
							.get(0)
							.posicionar(
									largTela
											/ 2
											- fases.get(i).getVeiculos().get(0)
													.getLarg() / 2,
									altTela
											- fases.get(i).getVeiculos().get(0)
													.getAlt());
				}

				estado = 0;

			}

			if (jog.isFimJogo() || estado == -2) {
				if (sequencer.isRunning()) {
					sequencer.stop();
					sequencer.setMicrosecondPosition(0);
				}
				janela.setContentPane(panOver);
				janela.revalidate();

				if (cont.getCode() == KeyEvent.VK_ENTER) {
					estado = -1;
					fases.get(jog.getFase()).getVeiculos().clear();
					fases.get(jog.getFase()).getTiros().clear();
					fases.clear();
					cenas.clear();
					personagens.clear();
					minigames.clear();
					janela.setContentPane(panTela);
					janela.revalidate();
					jog.reiniciar();
				}

			}

			// TELA DE TÍTULO
			if (estado == 0) {
				if (cont.getCode() == KeyEvent.VK_ENTER) {
					janela.setContentPane(panCenas);
					janela.revalidate();
					estado++;
				}
				if (cont.isTeclaCim())
					delay++;
				if (cont.isTeclaBai()) {
					delay--;
					if (delay < 0)
						delay = 0;
				}

			}

			// CENA
			if (estado == 1) {
				if (cenas.get(jog.getCena()).isEncerrada()) {
					estado = cenas.get(jog.getCena()).getEstado();
					if (estado == 2) {
						janela.setContentPane(pan);
					}
					janela.revalidate();
					jog.avancarCena();
					if (jog.getCena() >= cenas.size())
						jog.reiniciarCenas();
				}
			}

			// FASE
			if (estado == 2) {
				if (!sequencer.isRunning())
					sequencer.start();
				if (sequencer.getMicrosecondPosition() >= sequencer
						.getMicrosecondLength()) {
					sequencer.stop();
					sequencer.setMicrosecondPosition(0);
				}

				while (fases.get(jog.getFase()).getEstrelas().size() < 60)
					fases.get(jog.getFase()).getEstrelas()
							.add(new Estrela(rand.nextInt(1025), 0));

				{
					fis.calcularColisoes(fases.get(jog.getFase()));
					for (int i = 0; i < fases.get(jog.getFase()).getTiros()
							.size(); i++) {
						fases.get(jog.getFase()).getTiros().get(i).mover();
						if (fases.get(jog.getFase()).getTiros().get(i).getY() < 0
								|| fases.get(jog.getFase()).getTiros().get(i)
										.getY() > largTela + 5)
							fases.get(jog.getFase()).getTiros().remove(i);
					}

					for (int i = 0; i < fases.get(jog.getFase()).getVeiculos()
							.size(); i++) {

						fases.get(jog.getFase()).getVeiculos().get(i)
								.mover(largTela, altTela);
						if (fases.get(jog.getFase()).getVeiculos().get(i)
								.getEnergia() <= 0
								&& fases.get(jog.getFase()).getVeiculos()
										.get(i) instanceof Inimigo
								|| fases.get(jog.getFase()).getVeiculos()
										.get(i).getY() > altTela) {
							fases.get(jog.getFase()).getVeiculos().remove(i);
							break;
						}
						if (fases.get(jog.getFase()).getVeiculos().get(i)
								.getY() < 0
								&& fases.get(jog.getFase()).getVeiculos()
										.get(i) instanceof Inimigo)
							((Inimigo) fases.get(jog.getFase()).getVeiculos()
									.get(i)).descer();

					}

					for (int i = 0; i < fases.get(jog.getFase()).getEstrelas()
							.size(); i++) {
						if (fases.get(jog.getFase()).getP().getY() < 350)
							fases.get(jog.getFase()).getEstrelas().get(i)
									.descer();
						if (fases.get(jog.getFase()).getEstrelas().get(i)
								.getY() > 768)
							fases.get(jog.getFase()).getEstrelas().remove(i);
					}

					if (fases.get(jog.getFase()).getVeiculos().size() == 1) {
						fases.get(jog.getFase()).terminar();
						if (fases.get(jog.getFase()).getP().getY() < 350)
							fases.get(jog.getFase()).getP().descer();
						if (fases.get(jog.getFase()).getVeiculos().get(0)
								.getX() >= fases.get(jog.getFase()).getP()
								.getX()
								&& fases.get(jog.getFase()).getVeiculos()
										.get(0).getX() <= fases
										.get(jog.getFase()).getP().getX() + 100) {
							if (fases.get(jog.getFase()).getVeiculos().get(0)
									.getY() >= fases.get(jog.getFase()).getP()
									.getY()
									&& fases.get(jog.getFase()).getVeiculos()
											.get(0).getY() <= fases
											.get(jog.getFase()).getP().getY() + 100) {
								{
									jog.avancarFase();
									estado = 1;
									if (jog.getFase() >= 3)
										jog.reiniciarFases();
									fis.setFase(fases.get(jog.getFase()));
									janela.setContentPane(panCenas);
									janela.revalidate();
									sequencer.stop();
									sequencer.setMicrosecondPosition(0);
								}
							}
						}
					}

				}

			}

			// MINIGAME
			if (estado == 3) {
				if (!minigames.get(jog.getMinigame()).inicializado)
					minigames.get(jog.getMinigame()).inicializar();
				minigames.get(jog.getMinigame()).rodar();
				if (minigames.get(jog.getMinigame()).terminou()) {

					if (minigames.get(jog.getMinigame()).vitoria()) {
						if (minigames.get(jog.getMinigame()).temBonus())
							jog.subirNivel();
						jog.avancarMinigame();
						estado = 1;
						janela.setContentPane(panCenas);
						janela.revalidate();
					} else {
						if (minigames.get(jog.getMinigame()).temBonus()) {
							estado = 1;
							janela.setContentPane(panCenas);
							janela.revalidate();
						} else {
							jog.perderVida();
							minigames.get(jog.getMinigame()).inicializar();
						}
					}
				}

			}

			janela.repaint();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
