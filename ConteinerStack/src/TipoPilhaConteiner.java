public class TipoPilhaConteiner {

		// Criação da pilha de objetos Conteiner:
	
		// "Variável" imutável que define o tamanho da pilha.
		public final static int N = 4;
		
		// Criação do vetor da pilha.
		Conteiner vagas[] = new Conteiner[N];
		int topo;
		
		// Método para zerar a pilha
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
		
		// Confere se a pilha está vazia ou não
		public boolean isEmpty() {
			if (topo == 0)
				return true;
			else
				return false;
		}
		
		// Confere se a pilha está cheia ou não
		public boolean isFull() {
			if (topo == N) {
				return true;
			} else {
				return false;
				}
		}
}
