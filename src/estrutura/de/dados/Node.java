package estrutura.de.dados;

import java.util.Objects;

public class Node {
    private Object element;
    private Node next;
    private Node previus;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevius() {
        return previus;
    }

    public void setPrevius(Node previus) {
        this.previus = previus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getElement(), node.getElement()) && Objects.equals(getNext(), node.getNext()) && Objects.equals(getPrevius(), node.getPrevius());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElement(), getNext(), getPrevius());
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                ", previus=" + previus +
                '}';
    }
}
