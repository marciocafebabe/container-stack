
public class Conteiner {

	// Vari�veis atribu�das ao Conteiner
	private int ID;
	private int contMove;
	
	// M�todo Construtor
	public Conteiner(int ID, int contMove) {
		super();
		this.ID = ID;
		this.contMove = contMove;
	}
	
	// Getters e Setters
	public int getContMove() {
		return contMove;
	}
	
	public void addContMove() {
		this.contMove++;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
}
