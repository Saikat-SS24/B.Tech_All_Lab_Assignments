interface Dosa
{
	void prepare();
}

class MasalaDosa implements Dosa
{
	String decoration;
	MasalaDosa()
	{
		this.decoration = "Masala Curry";
	};
	public void prepare()
	{
		System.out.println("Masala Dosa preparation successful!");
	}
}

class OnionDosa implements Dosa
{
	String decoration;
	OnionDosa()
	{
		this.decoration = "Onion Scraps";
	};
	public void prepare()
	{
		System.out.println("Onion Dosa preparation successful!");
	}
}

class Restaurant
{
	public static void main(String[] args)
	{
		Dosa d1 = new MasalaDosa();
		d1.prepare();
		Dosa d2 = new OnionDosa();
		d2.prepare();
	}
}
