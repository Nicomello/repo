package PASWORD;

public class PasswordCheckerUtility extends java.lang.Object {
	
public PasswordCheckerUtility(){
		
}

	public static void comparePassword(java.lang.String password, java.lang.String passwordConfirm) 
	
	{
	
	int correct = password.compareTo(passwordConfirm);
	try{
	
	if (correct < 0 || correct > 0)
		throw new UnmatchedException();
	}
	catch (UnmatchedException e)
	{
		System.out.println(e.getMessage());
	}	
	}
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm)
{
	 boolean pass = true;
	int correct = password.compareTo(passwordConfirm);
	
	if(correct < 0 || correct > 0) {
		
		pass = false;
	}
	else if (correct == 0) {
		
		pass = true;
	}
	return pass;
	
}
	public static boolean hasBetweenSixAndNineChars(java.lang.String password)
	{
		boolean pass = true;
		
		if(password.length() < 6 || password.length() > 9)
			pass = false;
		return pass;
	}

public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords)
{
	
}
public static boolean hasDigit(java.lang.String password)
        
        {
	boolean dgt = false;
	char c[] = password.toCharArray();
	int size = password.length();
	int i =0;
	try{
	while(i != size)
	{
		if(password[i] >= '0' && password[i] <= '9')
	{
	++i;
	throw new NoDigitException("there is no numeric symbole in your password. It must contain at least one numeric symbole");
	} 
	catch (NoDigitException e);
	{

	System.out.println(e.getMessage();
	}
	else{
	dgt = true;
	}
	return dgt;
	}
        }
public static boolean hasLowerAlpha(java.lang.String password)
        throws NoLowerAlphaException
        {
	
        }

public static boolean hasSameCharInSequence(java.lang.String password)
        throws InvalidSequenceException
        {
	
        }

public static boolean hasSpecialChar(java.lang.String password)
        throws NoSpecialCharacterException
        {
	
        }
public static boolean hasUpperAlpha(java.lang.String password)
        throws NoUpperAlphaException
        {
	
        }
public static boolean isValidPassword(java.lang.String password)
        throws LengthException,
               NoUpperAlphaException,
               NoLowerAlphaException,
               NoDigitException,
               NoSpecialCharacterException,
               InvalidSequenceException
               {
	
               }
public static boolean isWeakPassword(java.lang.String password)
        throws WeakPasswordException
        {
	
        }
}

