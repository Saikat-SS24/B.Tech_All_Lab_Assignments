class AdditionNotPossibleException extends Exception
{
	private int x, y;
	AdditionNotPossibleException(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public String toString()
	{
		return "Invalid dimensions "+this.x+", "+this.y;
	}
}

class Matrix
{
	int mat[][];
	int x, y;

	Matrix(int x, int y, int mat[][])
	{
		this.x = x;
		this.y = y;
		this.mat = mat;
	}

	int getElementAt(int i, int j)
	{
		try
		{
			return this.mat[i][j];
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
}

void setElementAt(int i, int j, int val)
{
	try
	{
		this.mat[i][j] = val;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}

void findItem(int val)
{
	for(int i = 0; i<5; i++)
	{
		for(int j = 0; j<5; j++)
		{
			if(this.mat[i][j] == val)
			{
				System.out.println("Value: "+val+" found in "+i+", "+j);
				return;
			}
		}
	}
	System.out.println("Value not found!");
}

void addMatrix(int x, int y, int mat2[][])
{
	try
	{
		if(this.x != x || this.y != y)
		{
			throw new AdditionNotPossibleException(x, y);
		}
		for(int i = 0; i<this.x; i++) 
		{
			for(int j = 0; j<this.y; j++) 
			{
				this.mat[i][j] += mat2[i][j];
			}
	}
}
catch(AdditionNotPossibleException e)
{
	System.out.println(e);
	}
    }
}

class Matrices
{
	public static void main(String[] args)
	{
		int x1 = 5;
		int y1 = 5;
		int x2 = 4;
		int y2 = 4;
		int[][] matrix1 = { {1, 2, 6, 3, 1},
				  {3, 5, 1, 7, 9},
		                  {6, 2, 8, 7, 6},
		                  {2, 3, 1, 4, 6},
		                  {9, 8, 1, 5, 3} };

		int[][] matrix2 = { {6, 4, 3, 2},
				  {7, 1, 3, 2},
				  {5, 1, 9, 3},
                                  {1, 5, 4, 3} };


               Matrix m1 = new Matrix(x1, y1, matrix1);
               m1.findItem(8);
               System.out.println(m1.getElementAt(3, 1));
               m1.addMatrix(x2, y2, matrix2);
        }
}

