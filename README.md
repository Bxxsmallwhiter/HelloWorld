# HelloWorld
public class nursery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100;
		for(int i=99;i>=0;i--)
		{
			if(i==0)
			{
				System.out.println("No more bottles of beer on the wall");
			}
			else if(i==1)
			{
				System.out.println(i+" bottle of beer on the wall,"+i+" bottle of beer."
						+ " Take one down,"
						+ " Pass it around."
						+(i-1) +" bottles of beer on the wall.");
			}
			else {
				System.out.println(i+" bottles of beer on the wall,"+i+" bottles of beer."
						+ " Take one down,"
						+ " Pass it around."
						+(i-1) +" bottle of beer on the wall.");
			}
		}
	}

}
