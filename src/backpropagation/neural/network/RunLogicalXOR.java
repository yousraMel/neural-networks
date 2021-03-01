package backpropagation.neural.network;

public class RunLogicalXOR {
public static void main(String[] args) {
		
		float[][] trainingData = new float[][] {
			new float[] {0,0},
			new float[] {0,1},
			new float[] {1,0},
			new float[] {1,1},
		};
		
		float[][] trainingResults = new float[][] {
				new float[] {0},
				new float[] {1},
				new float[] {1},
				new float[] {0},
				
		};
		
		BackpropagationNeuralNetwork backprop = new BackpropagationNeuralNetwork(2,	3, 1);
		
		for(int iteration=0; iteration< NeuralNetConstants.ITERATIONS; iteration++) {
			
			for(int i=0; i<trainingResults.length;i++) {
				backprop.train(trainingData[i], trainingResults[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
			}
			System.out.println();
			
			for(int i=0;i<trainingResults.length;i++) {
				float[] t = trainingData[i];
				System.out.println("Num of iterations: "+ (iteration+1));
				System.out.printf("%.1f, %.1f --> %.3f\n", t[0], t[1], backprop.run(t)[0]);
			}
		}

	}

}
