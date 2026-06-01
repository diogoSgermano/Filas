package queue;

public class LinkedListQueue<E> implements Queue<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void enqueue(E e) {
        if(isEmpty()){
            head = new Node<>(e);
            tail = head;
        }else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) throw new EmptyQueueException();
        E removido = head.value;
        head = head.next;
        size--;
        return removido;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new EmptyQueueException();
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> temp = head;
        while(temp != null){
            builder.append(temp.value);
            if(temp.next != null) builder.append(",");
            temp = temp.next;
        }
        builder.append("]");
        return builder.toString();
    }

    private class Node<E>{
        private E value;
        private Node<E> next;
        public Node(E value){
            this(null, value);
        }
        public Node(Node<E> next, E value){
            this.next = next;
            this.value = value;
        }
    }

}
