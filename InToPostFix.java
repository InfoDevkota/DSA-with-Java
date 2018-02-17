import java.util.Scanner;
class InToPostFix
{
	int maxSize;
	char astack[];
	int TOS;
	String theFinalExpression;
	String theExpression;
	
	{
		TOS = -1;
		theFinalExpression = "";
	}
	
	InToPostFix(int maxSize, String theExpression)
	{
		this.maxSize = maxSize;
		this.astack = new char [maxSize];
		this.theExpression = theExpression;
	}

	void inToPostFix()
	{
		for(int i = 0; i< maxSize ;i++)
		{
			char element = theExpression.charAt(i);
			if(isOperand(element))
				theFinalExpression = theFinalExpression + element;
			else if(isOperator(element))
			{
				if(stackIsEmpty())
					push(element);
				else
				{
					int a;
					a = checkThePrecedence(element);
					if(a == 3) // element is of higher precedence:w
						push(element);
					else if(astack[TOS] != '(')
					{
						char operator = pop();
						theFinalExpression = theFinalExpression + operator;
						push (element);
					}
				}
			}
			else if(element == '(')
				push(element);
			else if(element == ')')
			{
				char temp;
				while(astack[TOS] != '(')
				{
					temp = pop();
					theFinalExpression = theFinalExpression + temp;
				}
				pop();// Remove the '(' from stack
			}
		}
		//while(!(stackisEmpty())):q
		while(TOS != -1)
		{
			char temp = pop();
			theFinalExpression = theFinalExpression + temp;
		}
	}

	char pop()
	{
		char item = astack[TOS];
		TOS -= 1;
		return item;
	}
	
	int checkThePrecedence(char element)
	{
		char item = astack[TOS];
		int assign, assign2;
		if (item == '$')
			assign = 3;
		else if (item == '*' || item == '/')
			assign = 2;
		else //(item == '+' || item == '-')
			assign = 1;
		if (element == '$')
			assign2 = 3;
		else if(element == '*' || element == '/')
			assign2 = 2;
		else //(element == '+' || element == '-')
			assign2 = 1;
		if(assign2 > assign)
			return 3; // element is of higher precedence
		else if(assign2 == assign)
			return 2; // element is in same as in stack
		else //(assign2 < assign)
			return 1; // element is of lower precedence
	}

	boolean stackIsFull()
	{
		if(TOS == maxSize - 1)
			return true;
		else
			return false;
	}

	boolean stackIsEmpty()
	{
		if(TOS == - 1)
			return true;
		else
			return false;
	}
	
	void push(char element)
	{
		TOS += 1;
		astack[TOS] = element;
	}
	
	static boolean isOperand(char element)
	{
		if((element >='a' && element <='z') || (element >='A' && element <='Z'))
			return true;
		else
			return false;
	}
	
        static boolean isOperator(char element)
        {
                if(element == '+' || element == '-' || element == '*' || element == '/' || element == '$')
                        return true;
                else
                        return false;
        }

	void displayFinal()
	{
		System.out.println("The Final Exptession is:-\n" + theFinalExpression);
	}

	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter the InFix expression");
		String theExpression = input.nextLine();
		int maxSize = theExpression.length();
		InToPostFix inToPostFix = new InToPostFix(maxSize, theExpression);
		inToPostFix.inToPostFix();
		inToPostFix.displayFinal();
		int option;
		int next = 1;
		while(next == 1)
		{
			System.out.println("Option:- \tTo do:\n1\tConvert another expression\n2\tExit this program");
			option = input2.nextInt();
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter the InFix expression");
					theExpression = input.nextLine();
					maxSize = theExpression.length();
					InToPostFix inToPostFixOb = new InToPostFix(maxSize, theExpression);
					inToPostFixOb.inToPostFix();
					inToPostFixOb.displayFinal();
					break;
				}
				case 2:
				{
					next = 0;
					System.out.println("Thank you:)");
					break;
				}
				default:
					System.out.println("Please Enter a valid option");
			}
		}
	}
}
