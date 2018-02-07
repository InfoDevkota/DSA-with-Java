import java.util.Scanner;
class TestQueue
{
	int rear;
	int front;
	int maxSize;
	int array[];

	TestQueue(int maxSize)
	{
		this.maxSize = maxSize;
		this.array = new int[maxSize];
		rear = -1;
		front = -1;
	}
	void deQueue()
	{
		if (rear == -1 && front == -1)
		{
			System.out.println("####****Queue is Empty****####");
			return;
		}
		else
		{
			int item = array[front];
			System.out.println( item +" is deleted from the Queue");
			if(rear == front)
			{
				rear = -1;
				front = -1;
			}
			else
				front += 1;
		}
	}
	void enQueue(int item)
	{
		if(rear == maxSize-1)
		{
			System.out.println("####****Queue is full****####");
		}
		else
		{
			if(rear == -1 && front == -1)
			{
				rear += 1;
				front += 1;
			}
			else
				rear += 1;
			array[rear] = item;
		}
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter maximum size of Queue:- ");
		int maxSize = input.nextInt();
		TestQueue queue = new TestQueue(maxSize);
		int select;
		int term = 0;
		while (term == 0)
		{
			System.out.print("\nOption:\tTo Do:\n1\tTo push element.\n2\tTo POP element.\n3\tTo Exit the Program.\nEnter your option:- ");
                	select = input.nextInt(); 
			switch(select)
			{
				case 1:
				{
					System.out.print("Enter element to insert in the Queue:- ");
					int ele = input.nextInt();
					queue.enQueue(ele);	
					break;
				}
				case 2:
				{
					queue.deQueue();
					break;
				}
				case 3:
				{
					term = 1;
					System.out.println("Thank you!");
					break;
				}
				default:
					System.out.println("Enter a valid options");
			}
		}
	}
}
