import java.util.Scanner;
class Stack
{
	int TOS = -1;
	int MaxSize;
	int aarray[];
	
	Stack(int MaxSize)
	{
		this.MaxSize = MaxSize;
		this.aarray = new int[MaxSize];
	}
	void push(int a)
	{
		if(TOS == MaxSize - 1)
		{
			System.out.println("Stack is Full");
		}
		else
		{
			TOS += 1;
			aarray[TOS] = a;
			System.out.println(a +" is inserted in the Stack");
		}
		return;
		
	}
	void pop()
	{
		if (TOS == -1)
		{
			System.out.println("Stack is Empty.");
		}
		else
		{
			int item = aarray[TOS];
			TOS -= 1;
			System.out.println(item +" is poped Out from the Stack");
		}
		return;
	}
	void display()
	{
		if (TOS == -1)
		{
			System.out.println("Stack is Empty.");
		}
		else
		{
			System.out.println("Elements in Stack are:- ");
			for(int i = TOS; i >= 0; i--)
			{
				System.out.println(aarray[i]);
			}
		}
		return;
	}
}
public class StackTest
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Maximum size of array");
		int MaxSize = input.nextInt();
		Stack astack = new Stack(MaxSize);
		int next = 0;
		while( next == 0)
		{
			System.out.println("\nOption:- \t To Do\n1 \t Push to stack. \n2 \t Pop from stack\n3 \t Display stack \n4 \t Exit the program");
			int select = input.nextInt();
			switch(select)
			{
				case 1:
					{
						System.out.println("Enter the element to push in the stack");
						int element = input.nextInt();
						astack.push(element);
						break;
					}
				case 2:
					{
						astack.pop();
						break;
					}
				case 3:
					{
						astack.display();
						break;
					}
				case 4:
					{
						next = 1;
						System.out.println("Thank You! :)");
						break;
					}
				default:
					{
						System.out.println("Please Enter a valid OPtion.");
						break;
					}
			}
		}
	}
}
				