package estrutura.de.dados;

import java.util.Objects;

public class CircularDoubleList {
    private Node head;
    private Node end;
    private int counter;
    private Node aux;

    public CircularDoubleList() {
        criateList();
    }

    /**
     * Metodos especiais
     */

    /**
     * Construtor
     */
    public void criateList(){
        head = null;
        end = null;
        counter = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Node getAux() {
        return aux;
    }

    public void setAux(Node aux) {
        this.aux = aux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CircularDoubleList)) return false;
        CircularDoubleList that = (CircularDoubleList) o;
        return getCounter() == that.getCounter() && Objects.equals(getHead(), that.getHead()) && Objects.equals(getEnd(), that.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead(), getEnd(), getCounter());
    }

    @Override
    public String toString() {
        return "ListDoubly{" +
                "head=" + head +
                ", end=" + end +
                ", counter=" + counter +
                '}';
    }

    /**
     * Métodos Públicos
     */

    // Verifica se esta vazia a lista
    public boolean isEmpty(){
        return this.head == null;
    }

    // Recupera a quantidade de elementos na lista
    public int numberOfElementsInTheList(){
        return counter;
    }

    // Verifica se elemento existe na lista
    public boolean checksIfElementIsInTheList(Object element){
        setAux(head);
        int control = 0;
        do {
            if (aux.getElement().equals(element)){
                return true;
            }
            aux = aux.getNext();
            control++;
        }while (getCounter() != control);
        return false;
    }

    // Verifica se elemento existe na lista
    public int chesksIfElementIsInTheListII(Object element){
        int i = 0;
        setAux(head);
        while (aux != head){

            if (aux.getElement().equals(element)){
                return i;
            }
            aux = aux.getNext();
            i++;
        }
        return 0;
    }

    // Insere elemento no inicio da lista
    public void addToTopOfList(Object element){
        // Cria novo node
        Node newNode = new Node();
        // Novo node = elemento
        newNode.setElement(element);

        // se lista está vazia novo nó vira inicio e fim
        if (isEmpty()){
            newNode.setNext(newNode);
            newNode.setPrevius(newNode);
            setHead(newNode);
            setEnd(newNode);
            counter++;
        } else {
            // se não aux = cabeça / head
            setAux(head);
            // Enquanto aux.next for diferente de head ele continua percorrendo a lista
            while (aux.getNext() != head){
                // aux = proximo
                aux = aux.getNext();
            }
            head.setPrevius(newNode);
            // aux.next = newNode / o aux proximo recebe novo nó
            aux.setNext(newNode);
            // newNode.previus = aux / novoNó.proximo = aux
            newNode.setPrevius(aux);
            // newNode.next = head/ novoNó.proximo = cabeça para ficar circular
            newNode.setNext(head);
            // counter++/ contador = contador + 1
            counter++;
        }
    }

    // Adiciona no fim da lista
    public void addAtTheEndOfTheList(Object element){}

    // Adiciona na lista pelo indice
    public void addByIndexToList(Object element, int index){
        setAux(head);
        while (getCounter() == index){
            aux = aux.getNext();
        }

        Node newNode = new Node();
        newNode.setElement(element);
        newNode.setNext(aux.getNext());
        newNode.setPrevius(aux.getPrevius());
        aux.setNext(newNode.getNext());
        aux.setPrevius(newNode.getPrevius());
        counter++;
    }

    // Remove do inicio, um elemento da lista
    public void removeToTopOfList(Object element){
        if (isEmpty()){
            System.out.println("    + Lista está vazia! + ");
        }else{
            if (head == end){
                head = null;
                end = null;
                counter--;
                //System.out.println("2");  // Para tesete do laço
            }else{
                if (head.getElement().equals(element)){
                    aux = head;
                    aux.setNext(aux.getPrevius());
                    aux.setPrevius(end.getNext());
                    setHead(aux.getNext());
                    counter--;
                    // só pra testes
                    System.out.println(getAux());
                    System.out.println(getHead());
                    System.out.println(getEnd());
                    System.out.println(getCounter());
                    //System.out.println("3");
                }
            }
        }
    }

    public void removeItem(Object elemento){
        Node remove = head.getNext();
        Node troca = head;
        while (remove != null){
            if(remove.getElement().equals(elemento)){
                troca.setNext(remove.getNext());
                remove.setNext(null);
                remove = null;
                counter--;
                break;
            }
            remove = remove.getNext();
            troca = troca.getNext();
        }
    }
    // Remove do final, um elemento da lista

    // Remove pelo indice, um elemento da lista
    public void removeIndex(int index){
        setAux(head);
        while (getCounter() <= index){
            aux = aux.getNext();
        }
        aux.setNext(aux.getNext());
        aux.setPrevius(aux.getPrevius());
        counter--;
    }
    // Remove pelo index II
    public Node remover(int x){
        Node no;
        no = null;

        if( !this.isEmpty() ){
            Node aux = this.getEnd();

            while( aux.getNext() != this.getEnd() && aux.getNext().getElement().hashCode() != x ){
                aux = aux.getNext();
            }

            if( aux.getNext().getElement().hashCode() == x ){
                no = aux.getNext();
                if( no.getNext() == no ){
                    this.criateList();
                }else{
                    aux.setNext(no.getNext());
                    no.setNext(null);
                    if( this.getEnd() == no ){
                        this.setEnd(aux);
                    }
                }
            }
        }

        return no;
    }

    // remove um elemnto da lista
    public void removeElementList(Object element){
        //objeto para o elemento previusNode
        Node previusNode = end;
        //objeto para percorrer a lista
        Node positionHead = head;

        //procura elemento na lista, guardando previusNode
        while(positionHead != end && positionHead.getElement() != element){
            previusNode = positionHead;
            positionHead = positionHead.getNext();
        }

        //verifica se achou elemento
        if(positionHead == end){
            /*nao achou: mantem primeiro da forma como esta*/
            return;
        }

        //retira elemento
        if(previusNode == end){
            //retira elemento do inicio
            head = positionHead.getNext();
            end = positionHead.getPrevius();                    // aqui

        }else{
            //retira elemento do meio da lista
            previusNode.setNext(positionHead.getNext());
            positionHead.setPrevius(previusNode.getPrevius()); // aqui

        }
        counter--;
    }

    // Remove na mao
    public void removeElements(Object element,CircularDoubleList l){
        setAux(head);
        if (isEmpty() && checksIfElementIsInTheList(element)){
            do {
                if (aux.getElement().equals(element)){
                    aux.setNext(aux.getPrevius());
                    aux.setPrevius(aux.getNext());
                    counter--;
                }
            }while (aux != head);
        }
    }

    // Imprime a lista na ordem
    public void showList(){
        setAux(head);
        int i = 0;
        do {
            i++;
            System.out.println("    [" + i + "]° Elemento: " + aux.getElement());
            aux = aux.getNext();
        }while (aux != head);
    }

    // Imprime a lista na ordem
    public void showList2(){
        setAux(head);
        do {
            System.out.print(" " + aux.getElement());
            aux = aux.getNext();
        }while (aux != head);
    }

    // Imprime a lista na ordem inversa
    public void showListInverse(){
        setAux(head);
        int i = 0;
        do {
            i++;
            System.out.println("    [" + i + "]° Elemento: " + aux.getElement());
            aux = aux.getPrevius();
        }while (aux != head);
    }



    public static void main(String[] args) {
        System.out.println("#################################################################");
        System.out.println("#       BEMVINO A LISTA DUPLAMENTE ENCADEADA CIRCULAR!!         #");
        System.out.println("#################################################################");
        System.out.println("---------------------------------------------------------------");
        // Cria uma lista duplamente encadeada circular
        System.out.println("-   Criar uma lista: ");
        CircularDoubleList l = new CircularDoubleList();
        System.out.println("---------------------------------------------------------------");

        //  Verificar se a lista está vazia
        System.out.println("-   Verificar se a lista está vazia: (Lista vazia): " + l.isEmpty());
        System.out.println("---------------------------------------------------------------");

        // Adiciona 1 elemento na lista
        System.out.println("-   Adiciona elemento a lista! ");
        System.out.println("---------------------------------------------------------------");
        l.addToTopOfList(1);

        //  Verificar se a lista está vazia
        System.out.println("-   Verificar se a lista está vazia (lista com elemento) : " + l.isEmpty());
        System.out.println("---------------------------------------------------------------");

        //  Recuperar o número de elementos da lista
        System.out.println("-   Recuperar o número de elementos da lista: " + l.numberOfElementsInTheList());
        System.out.println("---------------------------------------------------------------");

        // Adiciona + elementos a lista
        System.out.println("-   Adiciona + elementos a lista: ");
        l.addToTopOfList(2);
        l.addToTopOfList(3);
        l.addToTopOfList(4);
        l.addToTopOfList(5);
        l.addToTopOfList(6);
        l.addToTopOfList(7);
        System.out.println("---------------------------------------------------------------");

        //  Recuperar o número de elementos da lista
        System.out.println("-   Recuperar o número de elementos da lista: " + l.numberOfElementsInTheList());
        System.out.println("---------------------------------------------------------------");

        // Verificar se um elemento existe na lista
        System.out.println("-   Verificar se um elemento existe na lista: (Elemento teste 01= '5'): " + l.checksIfElementIsInTheList(5));
        System.out.println("-   Verificar se um elemento existe na lista: (Elemento teste 02= '99'): " + l.checksIfElementIsInTheList(99));
        System.out.println("---------------------------------------------------------------");

        // Imprime a lista
        System.out.println("-   Imprime a lista: \n");
        l.showList();
        System.out.println("---------------------------------------------------------------");

        // Inserir um elemento na lista
        System.out.println("-   Inserir um elemento na lista: --> 'Novo elemento inserido!'");
        l.addToTopOfList("Novo elemento inserido!");
        System.out.println("---------------------------------------------------------------");

        // Retira um elemento da lista
        System.out.println("-   Retira um elemento da lista: '6' ");
        l.remover(6);
        System.out.println("---------------------------------------------------------------");

        // Imprime a lista
        System.out.println("-   Imprime a lista: \n");
        l.showList();
        System.out.println("---------------------------------------------------------------");
    }
}