import java.util.NoSuchElementException;

public class Pilha<E> {
	private final E[] pilha;
	private int topo;

	public Pilha(int tamanho) {
		pilha = (E[]) new Object[tamanho];
		topo = 0;
	}

	public boolean vazia() {
		return topo == 0;
	}

	private boolean cheia() {
		return topo == pilha.length;
	}

	public void empilhar(E item) {
		if (cheia()) {
			throw new IllegalStateException("Nao foi possivel empilhar o item: a pilha está cheia!");
		}

		pilha[topo] = item;
		topo++;
	}

	public E desempilhar() {
		E item = consultarTopo();
		topo--;
		
		return item;
	}

	public E consultarTopo() {
		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return pilha[topo - 1];
	}

	public void imprimirPilha() {
		if(vazia()) {
			System.out.println("A pilha está vazia!");
			return;
		} else {
			System.out.println("Itens na pilha:");
			for (int i = 0; i < topo; i++) {
				System.out.println(pilha[i]);
			}
		}
	}
}