//TITLE= SWAP NODE IN LINKED LIST WITHOUT USING SWAPPING DATA.
//ENROLLMENT NO=22002171510009.
//DATE=29-09-2023.
//SUBJECT=DATA STRUCTURE USING JAVA.
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
    }
}

public class Project
{
    Node head;

    //for insert a data.
    public void insert(int value)
    {
        Node newNode = new Node(value);
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = newNode;
    }

    //four cases for swap a data.
    public void swapNodes(int key1, int key2)
    {
        if (key1 == key2)
        {
            return;
        }

        //search value of prevkey1 & currkey1.
        Node prevkey1 = null, currkey1 = head;
        while (currkey1 != null && currkey1.data != key1)
        {
            prevkey1 = currkey1;
            currkey1 = currkey1.next;
        }

        //search value of prevkey2 & currkey2.
        Node prevkey2 = null, currkey2 = head;
        while (currkey2 != null && currkey2.data != key2)
        {
            prevkey2 = currkey2;
            currkey2 = currkey2.next;
        }
        
        //case:-1=one or both keys not found in the list.
        if (currkey1 == null || currkey2 == null)
        {
            return;
        }

        if (prevkey1 != null)
        {
            prevkey1.next = currkey2;
        }
        else
        {
            head = currkey2;
        }

        if (prevkey2 != null)
        {
            prevkey2.next = currkey1;
        }
        else
        {
            head = currkey1;
        }

        Node temp = currkey1.next;
        currkey1.next = currkey2.next;
        currkey2.next = temp;
    }

    //for display swap nodes.
    public void display()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Project list = new Project();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);

        System.out.println("Original List:");
        list.display();

        list.swapNodes(1, 6);
        System.out.println("List after swapping nodes 2 and 3:");
        list.display();
    }
}