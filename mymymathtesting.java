public class mymymathtesting {

		public static int jegob(int base, int exponent) {
			int result=1;
			for(int i=1; i<=exponent; i++)
				result*=base;
			return result;		
		}
	}
