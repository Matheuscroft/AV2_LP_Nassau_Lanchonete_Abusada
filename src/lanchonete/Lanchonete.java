package lanchonete;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lanchonete {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		ArrayList<Lanche> lanches = new ArrayList<Lanche>();

		MenuPrincipal(in, lanches);

		in.close();

	}

	public static void MenuPrincipal(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;

		System.out.println("## LANCHONETE ABUSADA ##\n"
				+ "# 1 - INSERIR PEDIDO   #\n# 2 - ATENDER PEDIDO   #\n# 3 - LISTAR PEDIDOS   #\n# 4 - PESQUISAR PEDIDO #\n# 5 - ENCERRAR         #\n"
				+ "########################");

		int opcaoMenu = 0;

		try {
			opcaoMenu = in.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("\nLetra não é número! Aprenda a diferença!\n");
			in.next();
			MenuPrincipal(in, lanches);
		}

		switch (opcaoMenu) {
		case 1:
			lanches = inserirPedido(in, lanches);
			MenuPrincipal(in, lanches);
			break;
		case 2:
			lanches = atenderPedido(in, lanches);
			MenuPrincipal(in, lanches);
			break;
		case 3:
			listarPedidos(in, lanches);
			break;
		case 4:
			pesquisarPedido(in, lanches);
			break;
		case 5:
			encerrarAtendimento(in, lanches);
			break;
		default:
			System.out.println("\nÉ pra colocar opção de 1 a 5! Tá difícil de entender?\n");
			MenuPrincipal(in, lanches);
			break;
		}
	}

	public static ArrayList<Lanche> inserirPedido(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;
		Lanche lanche = null;
		int opcaoMenuPedido = 0;
		int numeroPedido = 0;

		if (lanches.size() < 10) {

			System.out.println("\n### ESCOLHA O LANCHE ###\n"
					+ "# 1 - COXINHA          #\n# 2 - PIZZA            #\n# 3 - HAMBURGUER       #\n# 4 - PASTEL           #\n# 5 - SUCO             #\n# 6 - SORVETE          #\n# 7 - BOLO             #\n# 8 - CACHORRO QUENTE  #\n# 9 - BATATA FRITA     #\n# 10 - CALDO DE CANA   #\n"
					+ "########################");

			try {
				opcaoMenuPedido = in.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("\nVocê sabe o que é um número? Letra é outra coisa!\n");
				in.next();
				lanches = inserirPedido(in, lanches);
				return lanches;
			}

			switch (opcaoMenuPedido) {
			case 1:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Coxinha(numeroPedido);
				lanches.add(lanche);
				break;
			case 2:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Pizza(numeroPedido);
				lanches.add(lanche);
				break;
			case 3:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Hamburguer(numeroPedido);
				lanches.add(lanche);
				break;
			case 4:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Pastel(numeroPedido);
				lanches.add(lanche);
				break;
			case 5:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Suco(numeroPedido);
				lanches.add(lanche);
				break;
			case 6:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Sorvete(numeroPedido);
				lanches.add(lanche);
				break;
			case 7:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new Bolo(numeroPedido);
				lanches.add(lanche);
				break;
			case 8:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new CachorroQuente(numeroPedido);
				lanches.add(lanche);
				break;
			case 9:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new BatataFrita(numeroPedido);
				lanches.add(lanche);
				break;
			case 10:
				numeroPedido = defineNumeroPedido(in, lanches);
				lanche = new CaldoDeCana(numeroPedido);
				lanches.add(lanche);
				break;
			default:
				System.out.println("\nÉ pra colocar opção de 1 a 10! Tá difícil de entender?\n");
				MenuPrincipal(in, lanches);
				break;
			}

		}

		else {
			System.out.println(
					"\nSó podemos acolher 10 pedidos por vez. Resolva trabalhar para poder adicionar mais pedidos.\n");
		}

		return lanches;

	}

	public static int defineNumeroPedido(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;
		int numeroPedido = 0;
		boolean repetido = false;

		System.out.println("\nDigite o número do pedido\n");

		try {
			numeroPedido = in.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("\nVocê sabe o que é um número? Letra é outra coisa!\n");
			in.next();
			numeroPedido = defineNumeroPedido(in, lanches);
			return numeroPedido;
		}

		if (lanches.size() == 0) {
			
			return numeroPedido;

		}

		else {

			for (Lanche l : lanches) {

				if (l.getNumeroPedido() == numeroPedido) {
					repetido = true;
					break;
				}

			}

			if (!repetido) {
				return numeroPedido;
			}

			else {
				System.out.println("\nRepetido. Quer me bugar e botar 2 pedidos com mesmo número?\n");
				numeroPedido = defineNumeroPedido(in, _lanches);
			}

		}

		return numeroPedido;
	}

	public static ArrayList<Lanche> atenderPedido(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;

		if (lanches.size() == 0) {
			System.out.println("\nVai atender o que se tu nem inseriu pedido nenhum??\n");
		} else {

			System.out.println("\nAtendendo pedido de número " + lanches.get(0).getNumeroPedido() + ". Lanche: " + lanches.get(0).getNome());
			lanches.get(0).preparar();
			lanches.remove(0);
		}

		return lanches;
	}

	public static void listarPedidos(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;

		if (lanches.size() == 0) {
			System.out.println("\nPor acaso tu chegou a inserir algum pedido? Não, né? Então pronto!\n");
		} else {

			System.out.println("\nOlha o moi de pedido que tem pra tu atender:\n");

			for (Lanche l : lanches) {
				
				System.out.println("Pedido de número " + l.getNumeroPedido() + ". Lanche: " + l.getNome());
			}

			System.out.println("\nGostasse? Agora trabalhe!\n");
		}

		MenuPrincipal(in, lanches);
	}

	public static void pesquisarPedido(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;
		int opcaoMenuPesquisar = 0;
		boolean produtoExistente = false;

		if (lanches.size() == 0) {
			System.out.println("\nComo tu vai pesquisar se a lista tá vazia?? Insira algum pedido pelo menos!\n");
		} else {

			System.out.println("\nDigite o código do pedido que tu deseja pesquisar.\n");

			try {
				opcaoMenuPesquisar = in.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("\nVocê sabe o que é um número? Letra é outra coisa!\n");
				in.next();
				pesquisarPedido(in, lanches);
			}

			for (int i = 0; i < lanches.size(); i++) {

				if (lanches.get(i).getNumeroPedido() == opcaoMenuPesquisar) {
					if (i == 0) {
						System.out.println("\nEsse pedido número " + opcaoMenuPesquisar
								+ " é o próximo já! Vai atender ou vai esperar o cliente reclamar??\n");
					} else {

						System.out.println("\nEsse pedido número " + opcaoMenuPesquisar + " tá aqui, visse?"
								+ lanches.get(i).darDescricao() + " Olha quantos tem na frente dele: " + i + "\n");
					}

					produtoExistente = true;
					break;
				}
			}

			if (!produtoExistente) {
				System.out.println("\nTá inventando número? Não tem nenhum pedido com esse número!\n");
			}
		}

		MenuPrincipal(in, lanches);
	}

	public static void encerrarAtendimento(Scanner in, ArrayList<Lanche> _lanches) {

		ArrayList<Lanche> lanches = _lanches;

		if (lanches.size() > 0) {

			System.out.println("\nVai pa onde? Terminou o serviço? Não? Então vá atender esses pedidos antes!\n");
			MenuPrincipal(in, lanches);
		}

		System.out.println("\nJá vai tarde! Tchau!");
		System.exit(0);

	}

	public static class Lanche {

		private int numeroPedido;
		private String nome;

		public Lanche(int _numeroPedido, String _nome) {

			this.numeroPedido = _numeroPedido;
			this.nome = _nome;
		}

		public String getNome() {
			return this.nome;
		}

		public int getNumeroPedido() {
			return this.numeroPedido;
		}

		public void preparar() {

		}

		public String darDescricao() {

			return "";
		}

	}

	public static class Coxinha extends Lanche {

		public Coxinha(int _numeroPedido) {
			super(_numeroPedido, "Coxinha");
		}

		@Override
		public void preparar() {
			System.out.println("\nA coxinha já está pronta aqui na estufa. Colocando na embalagem.");
			
			 try {

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nÉ uma deliciosa Coxinha!";

		}

	}

	public static class Pizza extends Lanche {

		public Pizza(int _numeroPedido) {
			super(_numeroPedido, "Pizza");
		}

		@Override
		public void preparar() {
			System.out.println("\nMontando a pizza");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

					System.out.println();

					System.out.println("Assando a pizza. Favor aguardar.");

					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}

					System.out.println();

					System.out.println("Pizza pronta. Colocando no prato para servir.");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nÉ uma deliciosa Pizza!";
		}

	}

	public static class Hamburguer extends Lanche {

		public Hamburguer(int _numeroPedido) {
			super(_numeroPedido, "Hamburguer");
		}

		@Override
		public void preparar() {
			System.out.println("\nFritando o hambúrguer e o ovo");
			
			 try {

			        for (int i = 0; i < 10; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

					System.out.println();

					System.out.println("Abrindo o pão e inserindo a carne, o ovo, salada, queijo, presunto");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}

					System.out.println();

			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nÉ um Hambúrguer suculento!";
		}

	}

	public static class Pastel extends Lanche {

		public Pastel(int _numeroPedido) {
			super(_numeroPedido, "Pastel");
		}

		@Override
		public void preparar() {
			System.out.println("\nSelecionando os ingredientes");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

					System.out.println();

					System.out.println("Montando os ingredientes na massa e fechando o pastel.");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}

					System.out.println();

					System.out.println("Fritando o pastel. Favor aguardar.");

					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nÉ um Pastel sequinho!";
		}

	}

	public static class Suco extends Lanche {

		public Suco(int _numeroPedido) {
			super(_numeroPedido, "Suco");
		}

		@Override
		public void preparar() {
			System.out.println("\nSelecionando as melhores frutas");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

					System.out.println();

					System.out.println("Colocando no liquidificador com água e açúcar.");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}

					System.out.println();

					System.out.println("Coando e colocando no copo.");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nSuquinho vegano!";
		}

	}

	public static class Sorvete extends Lanche {

		public Sorvete(int _numeroPedido) {
			super(_numeroPedido, "Sorvete");
		}

		@Override
		public void preparar() {
			System.out.println("\nPegando o copinho e a colher de sorvete");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

					System.out.println();

					System.out.println("Uma bola, duas bolas, três bolas.");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}

					System.out.println();

					System.out.println("Colocando calda, guloseimas.");

					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nSorvete Diet!";
		}

	}

	public static class Bolo extends Lanche {

		public Bolo(int _numeroPedido) {
			super(_numeroPedido, "Bolo");
		}

		@Override
		public void preparar() {
			System.out.println("\nCortando um pedaço de bolo");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

			        System.out.println();

			        System.out.println("Colocando no prato");
			        
			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nHummmm, bolo de mulhango! Nham nham!";
		}

	}

	public static class CachorroQuente extends Lanche {

		public CachorroQuente(int _numeroPedido) {
			super(_numeroPedido, "Cachorro Quente");
		}

		@Override
		public void preparar() {
			
			System.out.println("\nCortando o pão");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

			        System.out.println();

			        System.out.println("Colocando salsicha e molho");
			        
			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }
			        
			        System.out.println();
			        
			        System.out.println("Adicionando batata palha, tomate, milho, ervilha e queijo ralado");
			        
			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nUm cachorro quente bem saudável!";
		}

	}

	public static class BatataFrita extends Lanche {

		public BatataFrita(int _numeroPedido) {
			super(_numeroPedido, "Batata Frita");
		}

		@Override
		public void preparar() {
			System.out.println("\nA batata já está frita secando no escorredor. Colocando na embalagem");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

			        System.out.println();

			        System.out.println("Adicionando queijo ralado. Catchup e maionese estão na mesa para o cliente se servir.");
			        
			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nBatata sequinha, crocante e macia por dentro!";
		}

	}

	public static class CaldoDeCana extends Lanche {

		public CaldoDeCana(int _numeroPedido) {
			super(_numeroPedido, "Caldo de Cana");
		}

		@Override
		public void preparar() {
			System.out.println("\nColocando gelo no copo.");
			
			 try {

			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }

			        System.out.println();

			        System.out.println("Passando a cana no moedor e peneirando o caldo");
			        
			        for (int i = 0; i < 5; i++) {
			            Thread.sleep(1000);
			            System.out.print(".");
			        }
			        
			        System.out.println();
			        
			        System.out.println("Pedido entregue ao cliente.\n");
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}

		@Override
		public String darDescricao() {
			return "\nDelícia de garapa!";
		}

	}

}
