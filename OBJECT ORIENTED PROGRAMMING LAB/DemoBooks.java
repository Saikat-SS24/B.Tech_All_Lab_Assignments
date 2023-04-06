class Book
{
    String title;
    int copies;
    Book(){}
    Book(String title)
    {
        this.title = title;
        this.copies = 1;
    }
}
class BookLibrary
{
    int lastBook;
    Book bookList[] = new Book[10];
    BookLibrary()
    {
        this.lastBook = -1;
    };
    void add(Book newBook)
    {
        boolean present = false;
        for(int i = 0; i<= lastBook; i++)
        {
            if(bookList[i].title == newBook.title)
            {
                bookList[i].copies += 1;
                present = true;
            }
        }
        if(present == false)
        {
            bookList[++lastBook] = new Book(newBook.title);
        }
    }
    void display()
    {
        for(int i = 0; i<=this.lastBook; i++)
        {
            System.out.println("Book title: "+bookList[i].title+", "+"Number of copies: "+bookList[i].copies);
        }
    }
}

class DemoBooks
{
    public static void main(String args[])
    {
        BookLibrary library = new BookLibrary();
        Book maths = new Book("Mathematics");
        Book english = new Book("English");
        library.add(maths);
        library.add(maths);
        library.add(english);
        library.display();
    }
}