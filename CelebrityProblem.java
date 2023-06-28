
import java.io.*;

class CelebrityProblem {
	public static void main(String[] args)
	{
		int[][] M = { { 0, 0, 1, 0 },
					{ 0, 0, 1, 0 },
					{ 0, 0, 0, 0 },
					{ 0, 0, 1, 0 } };

		int celebIdx = celebrity(M, 4);

		if (celebIdx == -1)
			System.out.println("No Celebrity");
		else {
			System.out.println("Celebrity ID " + celebIdx);
		}
	}
	public static int celebrity(int M[][], int n)
	{

		int i = 0, j = n - 1;
		while (i < j) {
			if (M[j][i] == 1)
				j--;
			else 
				i++;
		}
		int candidate = i;

		for (i = 0; i < n; i++) {
			if (i != candidate) {
				if (M[i][candidate] == 0
					|| M[candidate][i] == 1)
					return -1;
			}
		}
	
		return candidate;
	}
}
