package Workshop2_DoublyLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    private static class ListNode {

        private ListNode next;
        private ListNode previous;
        private int element;

        private ListNode(int element) {
            this.setElement(element);
        }

        public void setElement(int element) {
            this.element = element;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(int element) {
        ListNode node = new ListNode(element);

        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        }
        size++;
    }

    public void addLast(int element) {
        ListNode node = new ListNode(element);

        if (this.size == 0) {
            this.tail = node;
            this.head = node;
        } else {
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public int get(int index) {
        if (index >= this.size || size < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, this.size));
        }
        ListNode node = null;
        if (index <= this.size / 2) {

            node = this.head;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }

        } else {
            node = this.tail;

            for (int i = this.size / 2; i > index; i--) {
                node = node.previous;
            }
        }

        return node.element;
    }

    public int removeFirst() {
        checkSize();

        ListNode node = this.head;
        this.head = node.next;// 1 -> .next -> null;
        if(this.head == null){
            this.tail = null;
        }else{
            this.head.previous = null;
        }
        this.size--;
        return node.element;
    }

    public int removeLast() {
        checkSize();

        ListNode node = this.tail;
        this.tail = node.previous;// 1 -> .next -> null;
        if(this.tail == null){
            this.head = null;
        }else{
            this.tail.next = null;
        }
        this.size--;
        return node.element;
    }
    public void forEach (Consumer<Integer> consumer){
        ListNode current = this.head;

        while(current != null){
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray (){
        ListNode current = this.head;
        int[] arr = new int[this.size];

        int index = 0;
        while(current != null){
            arr[index++] = current.element;
            current = current.next;
        }
        return arr;
    }
    private void checkSize() {
        if (this.size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
    }


}
