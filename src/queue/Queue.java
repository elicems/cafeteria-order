package queue;

public class Queue implements TAD_Queue{
    private Node head=null,tail=head;

    public Queue(){
        head = null;
        tail = null;
    }
    public boolean isEmpty(){
        if(head==null) return true;else return false;
    }
    public Object peek(){
        if(head==null) return null;else return head.getValue();
    }
    public Object enqueue(Object x){
        if(x==null) return null;
        if (Runtime.getRuntime().freeMemory() < x.toString().length() + 1024 * 1024) return null;
        Node novo = new Node();
        novo.setValue(x);
        novo.setNext(null);
        if (tail==null){
            head = novo;tail = novo;
        }else {
            tail.setNext(novo);
            tail = novo;
        }
        return x;
    }
    public Object dequeue(){
        if (head==null) return null;
        Object object = head.getValue();
        head = head.getNext();
        if(head==null) tail=null;
        return object;
    }
    public String toString(){
        if(!isEmpty()){
            String saida = "";
            Node aux = head;
            while (aux!=null){
                saida += aux.getValue().toString();
                aux = aux.getNext();
                if(aux != null) saida += "\n";
            }
            return ("F: [" + saida + "]" );
        }
        else return ("F: []");
    }
}
