public class LinkedList {
    Node head;

    public void append(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public void delete(int data) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            prev.next = temp.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node prev = null, next = null;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node reverse(Node head) {
        Node prev = null, next = null;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public int detectAndCountLoop() {
        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return getLoopSize(slow);
            }
        }
        return 0;
    }

    private int getLoopSize(Node slow) {
        int size = 1;
        Node current = slow;
        while (current.next != slow) {
            current = current.next;
            size++;
        }
        return size;
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next;
    }

    public void invokeMergeList() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(3);
        l1.append(5);
        LinkedList l2 = new LinkedList();
        l2.append(2);
        l2.append(4);

        Node mergedHead = mergeTwoLists(l1.head, l2.head);
        printList(mergedHead);
    }

    public void reorderList() {
        if (head == null || head.next == null) {
            return;
        }
        //middle of the list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the 2nd half
        Node secondHead = reverse(slow);

        //Merge 2 halves
        Node first = head;
        while (secondHead.next != null) {
            Node temp1 = first.next;
            Node temp2 = secondHead.next;
            first.next = secondHead;
            secondHead.next = temp1;
            first = temp1;
            secondHead = temp2;
        }
    }

    public void removeNthFromEnd(Integer n) {
        if (n == null || n < 1) {
            return;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
//        list.head.next.next.next.next.next = list.head.next;
//        System.out.println(list.detectAndCountLoop());

        list.printList();
        list.removeNthFromEnd(null);
        list.printList();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}