package model;

import java.util.ArrayList;

import control.Dataset;

public class MetricaManhattan extends Knn {

	public String knnfunction(int k, ArrayList<Float> imagem, Dataset dataset) {
		ArrayList<Float> distanciaManhattan = new ArrayList<Float>();
		ArrayList<Float> knn = new ArrayList<Float>();
		for(int i = 0; i < dataset.getQntImagens(); i++) {
			Float dif;
			Float sum = (float) 0.0;
			for(int j = 0; j<1000; j++) {
				dif = Math.abs(imagem.get(j) - dataset.getFeatures().get(i).get(j));
				sum += dif;
			}
			distanciaManhattan.add(sum);
		}
		
		knn = this.findSmallest(distanciaManhattan, k);
		
		for(int i = 0; i < k; i++) {
			int index = distanciaManhattan.indexOf(knn.get(i));
			String tag = dataset.getTags().get(index);
			if(tag.equals("person")){
				person += 1;
			} else {
				noPerson += 1;
			}
		}
		//System.out.println("Manhattan: " + knn + "person "+this.person + " no person " + this.noPerson);
		if(person >= noPerson) {
			return "Person detected";
		}else {
			return "Person not detected";
		}
	}

}
