package model;

import java.util.ArrayList;
import control.Dataset;

public abstract class Knn {
	protected int person = 0, noPerson = 0;
	
	public abstract String knnfunction(int k, ArrayList<Float> imagem, Dataset dataset);
	
	public ArrayList<Float> findSmallest(ArrayList<Float> distance, int k) {
		ArrayList<Float> knn = new ArrayList<Float>();
		ArrayList<Float> aux = new ArrayList<Float>();
		for(int i = 0; i<distance.size(); i++)
			aux.add(distance.get(i));
		aux.sort(null);
		for(int i = 0; i<k; i++) {
			knn.add(aux.get(i));
		}
		return knn;
	}
}
