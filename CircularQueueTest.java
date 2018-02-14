import java.util.Scanner;
public class CircularQueueTest
{
	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter total no of elements to be in the queue:- ");
		int maxSize = input.nextInt();
		CircularQueue queue = new CircularQueue(maxSize);
		int select;
		int term = 0;
		while (term == 0)
		{
			System.out.print("\nOption:\tTo Do:\n1\tTo push element.\n2\tTo POP element.\n3\tTo Display the Queue elements.\n4\tTo Exit the Program.\nEnter your option:- ");
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
					queue.display();
					break;
				}
				case 4:
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
