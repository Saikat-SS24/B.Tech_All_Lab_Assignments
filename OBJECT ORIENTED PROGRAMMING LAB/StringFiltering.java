interface StringFilter
{
	String filter(CharSequence c);
}

class CharacterFilter implements StringFilter
{
	String arg;
	CharacterFilter(String arg)
	{
		this.arg = arg;
	}
	public String filter(CharSequence c)
	{
		this.arg = this.arg.replace(c, "");
		return this.arg;
	}
}

class NumberFilter implements StringFilter
{
	String arg;
	NumberFilter(String arg)
	{
		this.arg = arg;
	}
	public String filter(CharSequence c)
	{
		this.arg = this.arg.replace(c, "");
		return this.arg;
	}
}

class StringFiltering
{
	public static void main(String Args[])
	{
		NumberFilter n1 = new NumberFilter("S4aikat");
		CharacterFilter n2 = new CharacterFilter("Shaikat");
		System.out.println(n1.filter("4"));
		System.out.println(n2.filter("h"));
	} 
}

