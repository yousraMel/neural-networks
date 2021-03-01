package backpropagation.neural.network;

import java.util.Arrays;
import java.util.Random;


public class Layer {

	private float[] output;
	private float[] input;
	private float[] weights;
	private float[] dWeights;
	private Random random;

	public Layer(int inputSize, int outputSize) {
		this.output = new float[outputSize];
		this.input = new float[inputSize + 1];
		this.weights = new float[(inputSize + 1) * outputSize];
		this.dWeights = new float[weights.length];
		this.random = new Random();

		initWeights();
	}

	private void initWeights() {
		for (int i = 0; i < weights.length; i++) {
			weights[i] = (random.nextFloat() - 0.5f) * 4f; // [-2;2]
		}
	}

	public float[] run(float[] inputArray) {
		// We make a copy of input array in order to not change the training input
		System.arraycopy(inputArray, 0, input, 0, inputArray.length);

		// set the value of the bias node
		input[input.length - 1] = 1;

		int offset = 0;

		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < input.length; j++) {
				output[i] += weights[offset + j] * input[j];
			}
			output[i] = ActivationFunction.sigmoid(output[i]);
			/*
			 * for a layer that contains 3 inputs and 4 outputs for the first node:input[0]
			 * weights are 0 1 2 3 but for the second:node input[1] weights are 4 5 6 7 that
			 * means it starts from offset = input.lenght
			 */
			offset += input.length;
		}
		return Arrays.copyOf(output, output.length);
	}

	public float[] train(float[] error, float learningRate, float momentum) {

		int offset = 0;
		float[] nextError = new float[input.length];

		for (int i = 0; i < output.length; i++) {
			float delta = error[i] * ActivationFunction.dsigmoid(output[i]);
			
			for(int j=0;j<input.length;j++) {
				int weightIndex = offset+j;
				
				nextError[j] = nextError[j] + weights[weightIndex]*delta;
				float dw = input[j] * delta * learningRate;
				weights[weightIndex] += dWeights[weightIndex] * momentum +	dw;
				dWeights[weightIndex] = dw;
			}
			offset += input.length;
 		}
		return nextError; 
	}

}
