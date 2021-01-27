import java.util.Scanner;
import java.util.InputMismatchException;
public class LUDecomposition{
		
	public static void luDecomposition(double [][] MatrixArray, int n) 
	{ 
		double [][]lower = new double[n][n]; 
		double [][]upper = new double[n][n]; 
      try{
		// Decomposing matrix into Upper and Lower triangular matrices
		for (int i = 0; i < n; i++) 
		{ 
         // Upper Triangular matrix
			for (int k = i; k < n; k++) 
			{ 
				double sum = 0; 
				for (int j = 0; j < i; j++) 
            {
					sum += (lower[i][j] * upper[j][k]); 
            }
				// Evaluating U(i, k) 
				upper[i][k] = MatrixArray[i][k] - sum; 
			} 

			// Lower Triangular matrix 
			for (int k = i; k < n; k++) 
			{ 
				if (i == k)
            { 
					lower[i][i] = 1; // Diagonal values of Lower triangular matrix is always 1 
            }
				else
				{ 
 
					double sum = 0; 
					for (int j = 0; j < i; j++) 
						sum += (lower[k][j] * upper[j][i]); 

					// Evaluating L(k, i) 
               if(upper[i][i]!=0)
               {
					   lower[k][i] = (MatrixArray[k][i] - sum) / upper[i][i];
               }
               else
               {
                  throw new ArithmeticException();
               }
				} 
			} 
		} 
      }
      catch(ArithmeticException e)//Catch block to handle exceptions
      {
          System.out.println("LU DECOMPOSITION is not possible. Please try again with another matrix.");
          System.exit(0);
      }
      
      
      
		System.out.println("  Lower Triangular                              Upper Triangular"); 

		// Displaying the result : 
		for (int i = 0; i < n; i++) 
		{ 
			// Lower triangular matrix
			for (int j = 0; j < n; j++) 
				System.out.print("   "+lower[i][j]+ "  "); 
			System.out.print("                            "); 

			// Upper triangular matrix
			for (int j = 0; j < n; j++) 
				System.out.print("    "+upper[i][j]+ "  "); 
			System.out.print("\n"); 
		} 
	} 
   
	// Main Method
	public static void main(String arr[]) 
	{ 
      int decision=0;
      Scanner sc=new Scanner(System.in);//Takes user input
      System.out.print("Enter the size of NxN matrix: ");//Asks the user to enter the size of array
      int N=sc.nextInt();//Takes and stores user input in integer N
      Scanner sc1=new Scanner(System.in);
      System.out.print("Enter 1 if you would like to enter the values as rows. Otherwise enter any other number.");
      
      try
      {
       decision=sc1.nextInt();
      }
      catch(InputMismatchException e)//Exception handling for invalid input.
      {
         System.out.println("Invalid Input. Try again");
         System.exit(0);//Exits the program
      }
      
      double[][] MatrixArray=new double[N][N];//Creates an array
      
      if(decision==1)
      {
       for(int i=0;i<N;i++)
       {
         for(int j=0;j<N;j++)
         {
            System.out.print("Enter a number to store in the row of the matrix: ");//asks the user to enter a number to store in the array
            MatrixArray[i][j]=sc.nextDouble();//Stores user input in the array
         }
       }
      }
      else
      {
       for(int i=0;i<N;i++)
       {
         for(int j=0;j<N;j++)
         {
            System.out.print("Enter a number to store in the column of the matrix: ");//asks the user to enter a number to store in the array
            MatrixArray[j][i]=sc.nextDouble();//Stores user input in the array
         }
       }
      }
      System.out.print("\n\n");
      System.out.println("  Input matrix  ");
      for(int i=0;i<N;i++)
      {
          for(int j=0;j<N;j++)
          {
             System.out.print("  "+MatrixArray[i][j]+"  ");
          }
          System.out.println();
      }
      System.out.print("\n\n");
		luDecomposition(MatrixArray,N);//Calls the method 
	} 
	} 


