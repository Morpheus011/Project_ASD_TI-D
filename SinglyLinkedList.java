/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
        if (C == tail){ // jika disisipkan setelah tail, tail harus diperbarui
            tail = baru;
        }
        size++;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size-1;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }

    // mengembalikan data pada index ke-i (head = index 0)
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.pointer;
        }
        return current.data;
    }

    // mencari kemunculan pertama targetData, -1 jika tidak ada
    @Override
    public int indexOf(Object targetData) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.data == null ? targetData == null : current.data.equals(targetData)) {
                return i;
            }
            current = current.pointer;
            i++;
        }
        return -1;
    }

    // mencetak dari tail ke head (singly tidak punya prev jadi pakai rekursi)
    @Override
    public void printReverse() {
        printReverse(head);
    }

    private void printReverse(Node node) {
        if (node == null) return;
        printReverse(node.pointer);
        System.out.println(node.data);
    }

    // mencari dan menghapus node pertama dengan data = targetData
    @Override
    public boolean remove(Object targetData) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.data == null ? targetData == null : current.data.equals(targetData)) {
                if (prev == null) {          // node yang dihapus adalah head
                    head = current.pointer;
                } else {
                    prev.pointer = current.pointer;
                }
                if (current == tail) {       // node yang dihapus adalah tail
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.pointer;
        }
        return false;
    }

    // seluruh data dari head sampai tail dalam bentuk array
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.pointer;
        }
        return arr;
    }
}
