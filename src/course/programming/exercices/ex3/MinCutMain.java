package course.programming.exercices.ex3;

public class MinCutMain {
	private static final int ITERATIONS = 1000;

	public static void main(final String[] args) {
		Integer minCut = Integer.MAX_VALUE; 
		for (int i = 0; i < ITERATIONS; i++){
			Integer parcialMinCut = MinCut.proceed();
			System.out.println("Finished ["+i+"]");
			if (parcialMinCut < minCut){
				System.out.println("["+i+"] new MinCut!: "+parcialMinCut);
				minCut = parcialMinCut;
			}
			else{
				System.out.println("["+i+"] crap: "+parcialMinCut+" minCut: "+minCut);
			}
		}
	}
}
