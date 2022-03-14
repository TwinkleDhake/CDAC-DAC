package Day2_Assignments;

class SwitchCaseTernaryOperators {
	public static void main(String args[])
    {
        int firstVariable, secondVariable = 1;
        firstVariable = (secondVariable > 1) ? 2 : 1;
        switch (firstVariable)
        {
            case 0 :
                System.out.print(0);
                break;
            case 1 :
                System.out.print(1);
            case 2 :
                System.out.print(2);
                break;
            case 3 :
                System.out.print(3);
                break;
        }
    }

}
