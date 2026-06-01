package queue;

public interface Queue<E> {

    /**
     * Adicionar o elemento na fila
     * @param e
     */
    void enqueue(E e);

    /**
     * Remove da fila o primeiro elemento
     * @return
     */
    E dequeue();

    /**
     * Retorna o primeiro elemento sem remover da fila
     * @return
     */
    E peek();
    int size();
    boolean isEmpty();

}
