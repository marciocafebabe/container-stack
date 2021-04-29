import java.util.Scanner;

public class Executavel {

	public static int contMoveGlobal = 0;
	
	public static void main(String[] args) {
		
		// Criando um leitor de inputs.
		Scanner leitor = new Scanner(System.in);
		
		// Criando 2 pilhas de conteineres.
		TipoPilhaConteiner pilha1 = new TipoPilhaConteiner();
		pilha1.init();
		
		TipoPilhaConteiner pilha2 = new TipoPilhaConteiner();
		pilha2.init();
		
		// Criando 2 vetores que armazenam os IDs dos conteineres dentro das pilhas
		int IDsPilha1[] = new int[TipoPilhaConteiner.N];
		int IDsPilha2[] = new int[TipoPilhaConteiner.N];
		
		// Colocando conteineres nas pilhas e armazenando os IDs nos vetores.
		pilha1.push(new Conteiner(123, 0));
		IDsPilha1[pilha1.topo - 1] = 123;
		
		pilha2.push(new Conteiner(234, 0));
		IDsPilha2[pilha1.topo - 1] = 234;
		
		pilha1.push(new Conteiner(345, 0));
		IDsPilha1[pilha1.topo - 1] = 345;
		
		// Criando variáveis auxiliares.
		int x = -1;
		
		// Menu do programa
		while (x != 0) {
			System.out.println("\nPátio de Contêineres do Porto de Santos:");
			System.out.println("0 - Encerrar programa");
			System.out.println("1 - Insere contêiner no pátio");
			System.out.println("2 - Retira contêiner do pátio");
			System.out.println("3 - Cálculo do custo da movimentação dos contêineres");
			System.out.println("4 - Apresenta os contêineres em cada pilha do pátio");
			System.out.println("5 - Apresenta planilhas de contêineres de cada pilha do pátio");
			
			// Lendo a opção do usuário.
			x = leitor.nextInt(); 
			
			// Encerrar programa
			if (x == 0) {
				System.out.println("- Programa Encerrado -");
			
			// Inserir conteiner no pátio
			} else if (x == 1) {
				System.out.println("Digite o ID do contêiner que será inserido: ");
				x = leitor.nextInt();
				
				// Procura na pilha 1 se já há um conteiner com o mesmo ID que o que será adicionado.
				for (int i = 0; i < pilha1.topo; i++) {
					if (x == IDsPilha1[i]) {
						x = -1;
					}
				}
				
				if (x != -1) {
					// Procura na pilha 2 se já há um conteiner com o mesmo ID que o que será adicionado.
					for (int i = 0; i < pilha2.topo; i++) {
						if (x == IDsPilha2[i]) {
							x = -1;
						}
					}
				}
				// Cria um objeto Conteiner com o ID fornecido pelo usuário e o adiciona na pilha 1.
				if (pilha1.topo <= pilha2.topo && !pilha1.isFull() && x != -1) {
					pilha1.push(new Conteiner(x, 1));
					contMoveGlobal += 1;
					IDsPilha1[(pilha1.topo - 1)] = x;
					System.out.println("O contêiner foi adicionado à Pilha 1.");
				
					// Cria um objeto Conteiner com o ID fornecido pelo usuário e o adiciona na pilha 2.
				} else if (!pilha2.isFull() && x != -1) {
					pilha2.push(new Conteiner(x, 1));
					contMoveGlobal += 1;
					IDsPilha2[(pilha2.topo - 1)] = x;
					System.out.println("O contêiner foi adicionado à Pilha 2.");
				
				
				} else if (x != -1) {
					System.out.println("O pátio está cheio!");
				
				} else {
					System.out.println("Já há um contêiner com esse ID no pátio!");
				}
				
				x = -1; // Reiniciando a variável x.
			
			// Retirar conteiner do pátio
			} else if (x == 2) {
				if (!pilha1.isEmpty() && !pilha2.isEmpty()) {
					System.out.println("Digite o ID do conteiner que será retirado: ");
					x = leitor.nextInt();
					
					// Procura pelo Conteiner na pilha 1.
					for (int i = 0; i < (pilha1.topo); i++) {
						
						if (IDsPilha1[i] == x) {
							
							// O algoritmo abaixo compara o valor do topo da pilha 1 com a posição do Conteiner
							// contido nela para as devidas movimentações dentro da pilha 1 acontecerem.
							for (int i2 = i; i2 < pilha1.topo; i2++) {
								
								if ((i2 + 1) != pilha1.topo) {
									pilha1.vagas[i2] = pilha1.vagas[(i2 + 1)];
									pilha1.vagas[i2].addContMove();
									pilha1.vagas[i2].addContMove();
									contMoveGlobal += 2;
									IDsPilha1[i2] = IDsPilha1[(i2 + 1)];
								
								} else {
									pilha1.pop();
									contMoveGlobal += 1;
									IDsPilha1[i2] = -1;
								}
							}
							x = -1;
							i = IDsPilha1.length;
							System.out.println("O conteiner foi para seu destino.");
						}
					}
					
					if (x != -1) {
						// Procura pelo Conteiner na pilha 2.
						for (int i = 0; i < (pilha2.topo); i++) {
							
							if (IDsPilha2[i] == x) {
								
								// O algoritmo abaixo compara o valor do topo da pilha 2 com a posição do Conteiner
								// contido nela para as devidas movimentações dentro da pilha 2 acontecerem.
								for (int i2 = i; i2 < pilha2.topo; i2++) {
									
									if ((i2 + 1) != pilha2.topo) {
										pilha2.vagas[i2] = pilha2.vagas[(i2 + 1)];
										pilha2.vagas[i2].addContMove();
										pilha2.vagas[i2].addContMove();
										contMoveGlobal += 2;
										IDsPilha2[i2] = IDsPilha2[(i2 + 1)];
									
									} else {
										pilha2.pop();
										contMoveGlobal += 1;
										IDsPilha2[i2] = -1;
									}
								}
								x = -1;
								i = IDsPilha2.length;
								System.out.println("O conteiner foi para seu destino.");
							}
						}
						if (x != -1) {
							System.out.println("Não há um contêiner com esse ID no pátio.");
						}
					}
					
				} else {
					System.out.println("O pátio está vazio!");
				} x = -1;
			
			// Cálculo do custo da movimentação dos contêineres
			} else if (x == 3) {
				System.out.println("Soma de movimentações dos contêineres: " + contMoveGlobal);
			
			// Apresenta os contêineres em cada pilha do pátio, utilizando getters, inclusive.
			} else if (x == 4) {
				System.out.println("************* Ocupação das pilhas de contêineres ******************\n");
				System.out.println("        PILHA 1");
				System.out.println("topo -> " + pilha1.topo + "]:");
				for (int i = pilha1.topo - 1; i >= 0; i--) {
					System.out.println("        " + i + "]: Contêiner [ contMove = " + pilha1.vagas[i].getContMove() + ", ID = " + pilha1.vagas[i].getID() + "]");
				}
				System.out.println("\n        PILHA 2");
				System.out.println("topo -> " + pilha2.topo + "]:");
				for (int i = pilha2.topo - 1; i >= 0; i--) {
					System.out.println("        " + i + "]: Contêiner [ contMove = " + pilha2.vagas[i].getContMove() + ", ID = " + pilha2.vagas[i].getID() + "]");
				}
			// Apresenta planilhas de conteineres de cada pilha do pátio, por meio dos vetores dos IDs dos contêineres
			} else if (x == 5) {
				System.out.println("********** Planilhas de contêineres **************\n");
				System.out.println("PILHA 1");
				for (int i = pilha1.topo - 1; i >= 0; i--) {
					System.out.println(IDsPilha1[i]);
				}
				System.out.println("\nPILHA 2");
				for (int i = pilha2.topo - 1; i >= 0; i--) {
					System.out.println(IDsPilha2[i]);
				}
			}
		}
		leitor.close();
	}

}
