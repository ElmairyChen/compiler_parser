import java.util.*;
import java.io.*;

public class parser
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the file name : ");
		String file_name = input.nextLine();

		Scanner sc = null;
		try{ sc = new Scanner(new FileInputStream(file_name+".txt"));}
		catch(FileNotFoundException e)
        {
           	System.out.println("Error opening the file data.txt.");
           	System.exit(0);
       	}

       	PrintWriter outputstream = null;
		try{	outputstream = new PrintWriter(new FileOutputStream("output.txt", true));	}
		catch(FileNotFoundException e)
        {
           	System.out.println("Error opening the file output.txt.");
           	System.exit(0);
       	}

       	String s = "";
       	String r = "";
       	String n = "";
       	String t = "";
       	int j = 0;
       	int or = 1;
		ArrayList<String> rule = new ArrayList<String>();
		ArrayList<String> nonterminal = new ArrayList<String>();
		ArrayList<String> terminal = new ArrayList<String>();
		ArrayList<String> terminal2 = new ArrayList<String>();
		ArrayList<String> terminal3 = new ArrayList<String>();
		ArrayList<String> terminal4 = new ArrayList<String>();
		ArrayList<String> terminal5 = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> rule_accept = new ArrayList<String>();

		while(sc.hasNext())
		{
			if(j==0)
			{
				r = sc.next(); r = r.trim(); rule.add(r);
				j++;
			}

			s = sc.next(); s = s.trim();
			if(s.equals("|")||s.equals(">"))
			{
				t = sc.nextLine();	t = t.trim();
				if(s.equals("|"))
				{
					or++;
					switch(or)
					{
						case 2: terminal2.remove(terminal2.size()-1);
								terminal2.add(t);
								if(!t.equals("lamda")) {outputstream.println(t);temp.add(t);}
								break;
						case 3: terminal3.remove(terminal3.size()-1);
								terminal3.add(t);
								if(!t.equals("lamda")) {outputstream.println(t);temp.add(t);}
								break;
						case 4: terminal4.remove(terminal4.size()-1);
								terminal4.add(t);
								if(!t.equals("lamda")) {outputstream.println(t);temp.add(t);}
								break;
						case 5: terminal5.remove(terminal5.size()-1);
								terminal5.add(t);
								if(!t.equals("lamda")) {outputstream.println(t);temp.add(t);}
								break;
						default:
							break;
					}

					j = 0;
				}
				else
				{
					terminal.add(t);
					if(!t.equals("lamda")) {outputstream.println(t);temp.add(t);}
					terminal2.add(t);
					terminal3.add(t);
					terminal4.add(t);
					terminal5.add(t);
					j = 0;
				}

			}
			else {n = s; nonterminal.add(n);or=1;}
		}

		String[] rule_array = (String[]) rule.toArray(new String[0]);
		String[] nonterminal_array = (String[]) nonterminal.toArray(new String[0]);
		String[] terminal_array = (String[]) terminal.toArray(new String[0]);
		String[] terminal2_array = (String[]) terminal2.toArray(new String[0]);
		String[] terminal3_array = (String[]) terminal3.toArray(new String[0]);
		String[] terminal4_array = (String[]) terminal4.toArray(new String[0]);
		String[] terminal5_array = (String[]) terminal5.toArray(new String[0]);
		String[] temp_array = (String[]) temp.toArray(new String[0]);

	    Scanner scn = null;
		try{ scn = new Scanner(new FileInputStream("output.txt"));}
		catch(FileNotFoundException e)
	    {
	       	System.out.println("Error opening the file output.txt.");
	       	System.exit(0);
	    }

		String str = "";
	for(int l=10 ; l>0 ; l--){
		int size = temp.size();

		for(int i=0 ; i<size ; i++)
		{
			str = temp_array[i];
       		String str1 = "";
       		String str2 = "";

	   		for(j=0 ; j<nonterminal.size() ; j++)
	     	{
	       		str2 = str;
	       		StringTokenizer st = new StringTokenizer(str2 , " ");

	       		if(terminal_array[j].equals("lamda"))
	       		{
	       			str2 = str2.replace(" "+nonterminal_array[j], "");
	       			str2 = str2.replace(nonterminal_array[j]+" ", "");
	       		}
	       		else str2 = str2.replace(nonterminal_array[j]+" ", terminal_array[j]+" ");

	       		if(!temp.contains(str2) && !str.equals(str2)) {outputstream.println(str2); temp.add(str2);}

	       		if(str2.equals("lamda")){break;}
	       	}
	//--------------------------------------------------------------------------------------------------------------------
	       	for(j=0 ; j<nonterminal.size() ; j++)
	       	{
	       		str2 = str;
	       		StringTokenizer st = new StringTokenizer(str2 , " ");
	       		if(terminal2_array[j].equals("lamda"))
	       		{
	       			str2 = str2.replace(" "+nonterminal_array[j], "");
	       			str2 = str2.replace(nonterminal_array[j]+" ", "");
	       		}
	       		else str2 = str2.replace(nonterminal_array[j]+" ", terminal2_array[j]+" ");

	       		if(!temp.contains(str2) && !str.equals(str2)) {outputstream.println(str2); temp.add(str2);}

	       		if(str2.equals("lamda")){break;}
	       	}
	//--------------------------------------------------------------------------------------------------------------------
	       	for(j=0 ; j<nonterminal.size() ; j++)
	       	{
	       		str2 = str;
	       		StringTokenizer st = new StringTokenizer(str2 , " ");
	       		if(terminal3_array[j].equals("lamda"))
	       		{
	       			str2 = str2.replace(" "+nonterminal_array[j], "");
	       			str2 = str2.replace(nonterminal_array[j]+" ", "");
	       		}
	       		else str2 = str2.replace(nonterminal_array[j]+" ", terminal3_array[j]+" ");

	       		if(!temp.contains(str2) && !str.equals(str2)) {outputstream.println(str2); temp.add(str2);}

	       		if(str2.equals("lamda")){break;}
	       	}
	//--------------------------------------------------------------------------------------------------------------------
	       	for(j=0 ; j<nonterminal.size() ; j++)
	       	{
	       		str2 = str;
	       		StringTokenizer st = new StringTokenizer(str , " ");
	       		if(terminal4_array[j].equals("lamda"))
	       		{
	       			str2 = str2.replace(" "+nonterminal_array[j], "");
	       			str2 = str2.replace(nonterminal_array[j]+" ", "");
	       		}
	       		else str2 = str2.replace(nonterminal_array[j]+" ", terminal4_array[j]+" ");

	       		if(!temp.contains(str2) && !str.equals(str2)) {outputstream.println(str2); temp.add(str2);}

	       		if(str2.equals("lamda")){break;}
	       	}
	//--------------------------------------------------------------------------------------------------------------------
	       	for(j=0 ; j<nonterminal.size() ; j++)
	       	{
	       		str2 = str;
	       		StringTokenizer st = new StringTokenizer(str , " ");
	       		if(terminal5_array[j].equals("lamda"))
	       		{
	       			str2 = str2.replace(" "+nonterminal_array[j], "");
	       			str2 = str2.replace(nonterminal_array[j]+" ", "");
	       		}
	       		else str2 = str2.replace(nonterminal_array[j]+" ", terminal5_array[j]+" ");

	       		if(!temp.contains(str2) && !str.equals(str2)) {outputstream.println(str2); temp.add(str2);}

	       		if(str2.equals("lamda")){break;}
	       	}
	//--------------------------------------------------------------------------------------------------------------------
	    	temp_array = temp.toArray(new String[0]);
	    }
}
       	outputstream.close();

		Scanner fileinput = null;
		try{ fileinput = new Scanner(new FileInputStream("output.txt"));}
		catch(FileNotFoundException e)
	       	{
	           	System.out.println("Error opening the file output.txt.");
	           	System.exit(0);
	       	}

		System.out.println("Please input the token string : ");
		String sentence = input.nextLine();
		sentence = sentence.trim();

	    int flag = 0;
	    while(fileinput.hasNext())
		{
			String s1 = (String) fileinput.nextLine();
			if(s1.equals(sentence))
			{
				flag = 1;break;
			}
		}
		if(flag==1)System.out.println("Accept.");
		else System.out.println("Error.");
	}
}