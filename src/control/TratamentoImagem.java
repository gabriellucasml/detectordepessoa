package control;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;
import java.util.ArrayList;

public class TratamentoImagem {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	public ArrayList<Float> TratarImage(String caminho){
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		img = Imgcodecs.imread(caminho, Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img,features);
		ArrayList<Float> arrayOfFeatures = new ArrayList<Float>(features.toList());
		ArrayList<Float> aux = new ArrayList<Float>();
		for(int i = 0; i<1000; i++) {
			aux.add(arrayOfFeatures.get(i));
		}
		return aux;
	}
}
