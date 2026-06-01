package queue;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(){
        super("Queue está vazia.");
    }

}
