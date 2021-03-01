package optical.character.recognition;

import java.io.File;

import backpropagation.neural.network.BackpropagationNeuralNetwork;
import backpropagation.neural.network.NeuralNetConstants;

public class App {

	public static void main(String[] args) throws Exception {

//		CharacterReader characterReader = new CharacterReader();
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\0.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\1.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\2.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\3.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\4.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\5.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\6.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\7.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\8.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\9.png"));

//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\testFor2.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\testFor7.png"));
//		characterReader.readImage(new File("C:\\Users\\yousr\\Documents\\testFor8.png"));

		float[][] trainingData = new float[][] {
				new float[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0,
						0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
				new float[] { 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1,
						1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0,
						1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0,
						0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				new float[] { 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1,
						1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0,
						0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0 },
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0,
						0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0 },
				new float[] { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0,
						0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0,
						0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				new float[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0,
						0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, };

		float[][] trainingResults = new float[][] { 
				new float[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 0
				new float[] { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1
				new float[] { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new float[] { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, // 3
				new float[] { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 4
				new float[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 5
				new float[] { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 6
				new float[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 7
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // 8
				new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, }, // 9
		};

		BackpropagationNeuralNetwork backprop = new BackpropagationNeuralNetwork(64, 15, 10);

		for (int iterations = 0; iterations < NeuralNetConstants.ITERATIONS; iterations++) {

			for (int i = 0; i < trainingResults.length; i++) {
				backprop.train(trainingData[i], trainingResults[i], NeuralNetConstants.LEARNING_RATE,
						NeuralNetConstants.MOMENTUM);
			}
			if ((iterations + 1) % 1000 == 0) {
				System.out.println();
				for (int i = 0; i < trainingResults.length; i++) {
					float[] data = trainingData[i];
					float[] calculatedOutput = backprop.run(data);
					System.out.println(calculatedOutput[0] + " " + calculatedOutput[1] + " " + calculatedOutput[2] + " "
							+ calculatedOutput[3] + " " + calculatedOutput[4] + " " + calculatedOutput[5] + " "
							+ calculatedOutput[6] + " " + calculatedOutput[7] + " " + calculatedOutput[8] + " "
							+ calculatedOutput[9]);
				}
			}

		}

		System.out.println("After the training let's make some tests");
		System.out.println("------------------------------------");

		float[] calculatedOutput = backprop.run(new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1,
				1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 });    // test for 2
		System.out.println(
				calculatedOutput[0] + " " + calculatedOutput[1] + " " + calculatedOutput[2] + " " + calculatedOutput[3]
						+ " " + calculatedOutput[4] + " " + calculatedOutput[5] + " " + calculatedOutput[6] + " "
						+ calculatedOutput[7] + " " + calculatedOutput[8] + " " + calculatedOutput[9]);

		System.out.println("------------------------------------");

		calculatedOutput = backprop.run(new float[] { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1,
				0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 });    // test for 7
		System.out.println(
				calculatedOutput[0] + " " + calculatedOutput[1] + " " + calculatedOutput[2] + " " + calculatedOutput[3]
						+ " " + calculatedOutput[4] + " " + calculatedOutput[5] + " " + calculatedOutput[6] + " "
						+ calculatedOutput[7] + " " + calculatedOutput[8] + " " + calculatedOutput[9]);

		System.out.println("------------------------------------");

		calculatedOutput = backprop.run(new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1,
				0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 });   // test for 8
		System.out.println(
				calculatedOutput[0] + " " + calculatedOutput[1] + " " + calculatedOutput[2] + " " + calculatedOutput[3]
						+ " " + calculatedOutput[4] + " " + calculatedOutput[5] + " " + calculatedOutput[6] + " "
						+ calculatedOutput[7] + " " + calculatedOutput[8] + " " + calculatedOutput[9]);
	}

}
