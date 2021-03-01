package backpropagation.neural.network;

public class ActivationFunction {
	
	public static float sigmoid(float x) {
		return (float) (1 / (1+Math.exp(-x)));
	}
	
	public static float dsigmoid(float x) {
		return x *(1-x);
	}

}
