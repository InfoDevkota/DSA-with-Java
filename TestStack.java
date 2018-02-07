import java.util.Scanner;
class TestStack
{
	int maxSize;
	int array[];
	int tOS = -1;

	TestStack(int maxSize)
	{
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	void pop()
	{
		if(tOS == -1)
		{
			System.out.println("####****Stack is Empty****####");
		}
		else
		{
			int item = array[tOS];
			tOS -= 1;
			System.out.println(item+" is POP out.");
		}
	}
	void push(int element)
	{
		if (tOS == maxSize-1)
		{
			System.out.println("####****Sorry! Stack is Full****####");
			return;
		}
		else
		{
			tOS += 1;
			array[tOS] = element;
		}
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter max size of Stack:- ");
		int maxSize = input.nextInt();
		TestStack stack = new TestStack(maxSize);
		int select;
		int term = 0;
		while(term == 0 )
		{
			System.out.print("Option:\tTo Do:\n1\tTo push element.\n2\tTo POP element.\n3\tTo Exit the Program.\nEnter your option:- ");
                	select = input.nextInt();
			switch(select)
			{
				case 1:
				{
					System.out.print("Enter element to push in the Stack:- ");
					int ele = input.nextInt();
					stack.push(ele);
					break;
				}
				case 2:
					stack.pop();
					break;
				case 3:
				{
					term = 1;
					System.out.println("Thank you!");
					break;
				}
				default:
					System.out.println("Please Enter a valid option:- ");
					break;
			}
		}
	}
}
