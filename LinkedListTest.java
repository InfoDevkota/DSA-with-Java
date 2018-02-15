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
			System.out.print("Option:- \tTo Do:-\n1\tInsertion in first.\n2\tTo Display Linked List element\n3\tTo close the program.\nYour option:- ");
			option = input.nextInt();
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter the element to insert into the linked list:-");
					int element = input.nextInt();
					aLinkedList.insertion(element);
					break;
				}
				case 2:
				{
					aLinkedList.display();
					break;
				} 
				case 3:
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
	void insertion(int info)
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
}
