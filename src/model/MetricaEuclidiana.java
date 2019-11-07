package model;

import java.util.ArrayList;

import control.Dataset;

public class MetricaEuclidiana extends Knn{
	public String knnfunction(int k, ArrayList<Float> imagem, Dataset dataset) {
		ArrayList<Float> distanciaEuclidiana = new ArrayList<Float>();
		ArrayList<Float> knn = new ArrayList<Float>();
		for(int i = 0; i<100; i++) {
			Float dif = (float)0.0;
			Float sqr = (float)0.0;
			Float sqrt = (float)0.0;
			Float sum = (float) 0.0;
			for(int j = 0; j<1000; j++) {
				dif = imagem.get(j) - dataset.getFeatures().get(i).get(j);
				sqr = (float) Math.pow(dif, 2);//(xi-zi)²
				sum += sqr;//somatório de (xi - zi)²
				if(j==999) {
					sqrt = (float)Math.sqrt((double)sum);//raiz quadrada do somatório
				}
			}
			distanciaEuclidiana.add(sqrt);//array com a distância entre todos as imagens do dataset e
										  //a imagem passada. O índice representa qual posição da imagem
										  //no dataset
		}
		knn = this.findSmallest(distanciaEuclidiana, k);//função retorna array list com os k vizinhos mais
														//próximos
		//System.out.print("Index of eucliadian: ");
		for(int i = 0; i < k; i++) {
			int index = distanciaEuclidiana.indexOf(knn.get(i));
			//System.out.print(index + ", ");
			String tag = dataset.getTags().get(index);
			if(tag.equals("person")){
				this.person += 1;
			} else {
				noPerson += 1;
			}
		}
		//System.out.println("Euclidian: " + knn + "person "+this.person + " no person " + this.noPerson);
		if(person >= noPerson) {
			return "Person detected";
		}else {
			return "Person not detected";
		}
	}
}
