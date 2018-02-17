import java.util.Scanner;
public class LinkedListTest
{
	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		LinkedList aLinkedList = new LinkedList();
		int again = 1;
		int option;
		while(again == 1)
		{
			System.out.print("Option:- \tTo Do:-\n1\tTo Insert at first.\n2\tTo Insert at last\n3\tTo Insert at certain Postion\n4\tTo Display Linked List element\n5\tTo close the program.\nYour option:- ");
			option = input.nextInt();
			switch(option)
			{
				case 2:
				{
					System.out.print("Enter the element to insert into the linked list:- ");
					int element = input.nextInt();
					aLinkedList.insertionAtLast(element);
					break;
				}
				case 1:
				{
					System.out.print("Enter the element to insert at first:- ");
					int element = input.nextInt();
					aLinkedList.insertionAtFirst(element);
					break;
				}
				case 3:
				{
					System.out.print("Enter the postion for the element:- ");
					int pos = input.nextInt();
					System.out.print("Enter the element to insert at first:- ");
					int element = input.nextInt();
					aLinkedList.insertionAtPosition(pos, element);
					break;
				}
				case 4:
				{
					aLinkedList.display();
					break;
				} 
				case 5:
				{
					System.out.println("Thanks you! :)");
					again = 0; // Again == NO.
					break;
				} 
				default:
					System.out.println("Please Enter valid option.");
			}
		}
	}
}
class LinkedList
{
	int info;
	LinkedList next;
	static LinkedList first;

	LinkedList()
	{
		this.next = null;
	}
	LinkedList(int info)
	{
		this.next = null;
		this.info = info;
	}
	void insertionAtLast(int info)
	{
		if(first == null)
		{
			first = new LinkedList(info);
			return;
		}
		LinkedList afirst = first;
		while(afirst.next != null)
		{
			afirst = afirst.next;
		}
		afirst.next = new LinkedList(info);
	}
	void insertionAtFirst(int info)
	{
		if(first == null)
		{
			first = new LinkedList(info);
			return;
		}
		LinkedList temp = new LinkedList(info);
		temp.next = first;
		first = temp;
	}
	void insertionAtPosition(int pos, int info)
	{
		LinkedList afirst = first;
		if(first == null)
		{
			first = new LinkedList(info);
			return;
		}
		if(pos == 1)
		{
			insertionAtFirst(info);
			return;
		}
		while(pos > 2)
		{
			pos--;
			afirst = afirst.next;
		}
		LinkedList temp = new LinkedList(info);
		temp.next = afirst.next;
		afirst.next = temp;
	}
	void display()
	{
		System.out.println("Elements on the LinkedList are:-");
		LinkedList afirst = first;
		while(afirst.next != null)
		{
			System.out.println(afirst.info);
			afirst = afirst.next;
		}
		System.out.println(afirst.info);
		return;
	}
	int noOfNodes()
	{
		LinkedList afirst = first;
		int counter = 0;
		while(afirst.next != null)
		{
			afirst = afirst.next;
			counter++;
		}
		return counter;
	}
}
