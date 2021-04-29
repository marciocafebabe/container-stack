public class TipoPilhaConteiner {

		// Cria��o da pilha de objetos Conteiner:
	
		// "Vari�vel" imut�vel que define o tamanho da pilha.
		public final static int N = 4;
		
		// Cria��o do vetor da pilha.
		Conteiner vagas[] = new Conteiner[N];
		int topo;
		
		// M�todo para zerar a pilha
		public void init() {
			topo = 0;
		}
		
		// Coloca o objeto do topo da pilha
		public void push(Conteiner conteiner) {
			if (isFull() == false) {
				vagas[topo] = conteiner;
				topo++;
			} else {
				System.out.println("Stack Overflow");
				}
		}
		
		// Tira um objeto da pilha
		public Conteiner pop() {
			topo--;
			return vagas[topo];
		}
		
		// Retorna o valor do topo da pilha.
		public Conteiner top() {
			return vagas[topo - 1];
		}
		
		// Confere se a pilha est� vazia ou n�o
		public boolean isEmpty() {
			if (topo == 0)
				return true;
			else
				return false;
		}
		
		// Confere se a pilha est� cheia ou n�o
		public boolean isFull() {
			if (topo == N) {
				return true;
			} else {
				return false;
				}
		}
}
