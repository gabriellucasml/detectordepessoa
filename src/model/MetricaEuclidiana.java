package model;

import java.util.ArrayList;

import control.Dataset;

public class MetricaEuclidiana extends Knn{
	public String knnfunction(int k, ArrayList<Float> imagem, Dataset dataset) {
		ArrayList<Float> distanciaEuclidiana = new ArrayList<Float>();
		ArrayList<Float> knn = new ArrayList<Float>();
		for(int i = 0; i<100; i++) {
			Float dif;
			Float sqr;
			Float sqrt;
			Float sum = (float) 0.0;
			for(int j = 0; j<1000; j++) {
				dif = imagem.get(j) - dataset.getFeatures().get(i).get(j);
				sqr = (float) Math.pow(dif, 2);
				sum += sqr;
			}
			sqrt = (float)Math.sqrt((double)sum);
			distanciaEuclidiana.add(sqrt);//array com a distância entre todos as imagens do dataset e
										  //a imagem passada. O índice representa qual posição da imagem
										  //no dataset
		}
		knn = this.findSmallest(distanciaEuclidiana, k);//função retorna array list com os k vizinhos mais
														//próximos
		for(int i = 0; i < k; i++) {
			int index = distanciaEuclidiana.indexOf(knn.get(i));
			String tag = dataset.getTags().get(index);
			if(tag.equals("person")){
				this.person += 1;
			} else {
				noPerson += 1;
			}
		}
		
		if(person >= noPerson) {
			return "Person detected";
		}else {
			return "Person not detected";
		}
	}
}
