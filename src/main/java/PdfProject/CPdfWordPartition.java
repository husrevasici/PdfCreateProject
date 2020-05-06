package PdfProject;

import java.util.regex.Pattern;

public class CPdfWordPartition extends CPdfRead {
	private String s = "(\\d+)(.)(.*?)(\\d+)(.+)(\\" + "" + "d.+\\d+)(.*)";
	static private int id;
	static private int katilanOgrenciSayisi;
	static private Double anketPuani;

	public void Partition() {

		p = Pattern.compile(s);
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			while (m.find()) {
				System.out.println(m.group(1) + "##" + m.group(2) + "##" + m.group(3) + "##" + m.group(4) + "##"
						+ m.group(5) + "##" + m.group(6));
				id = Integer.parseInt(m.group(1));
				katilanOgrenciSayisi = Integer.parseInt(m.group(4));
				anketPuani = Double.parseDouble(m.group(6));

				arrayListid.add(id);
				arrayListAnketSorulari.add(m.group(3));
				arrayListKatilanOgrenciSayisi.add(katilanOgrenciSayisi);
				arrayListAnketPuani.add(anketPuani);

			}
		}
		arrayListid.remove(0);
		arrayListAnketSorulari.remove(0);
		arrayListKatilanOgrenciSayisi.remove(0);
		arrayListAnketPuani.remove(0);
		if (arrayListid.size() > 0) {
			arrayListid.remove(arrayListid.size() - 1);
			arrayListAnketSorulari.remove(arrayListAnketSorulari.size() - 1);
			arrayListKatilanOgrenciSayisi.remove(arrayListKatilanOgrenciSayisi.size() - 1);
			arrayListAnketPuani.remove(arrayListAnketPuani.size() - 1);
		}
		System.out.println();
		System.out.println("//////////////////////////////////////////");
		System.out.println();
		for (int i = 0; i < arrayListid.size(); i++) {
			System.out.println(arrayListid.get(i) + "##" + arrayListAnketSorulari.get(i) + "##"
					+ arrayListKatilanOgrenciSayisi.get(i) + "##" + arrayListAnketPuani.get(i));
		}

		// minimum calculate anket puani
		Double min1 = arrayListAnketPuani.get(0);
		for (Double i : arrayListAnketPuani) {
			min1 = min1 < i ? min1 : i;
		}
		min = String.valueOf(min1);

		// maximum calculate anket puani
		Double max1 = arrayListAnketPuani.get(0);
		for (Double i : arrayListAnketPuani) {
			max1 = max1 > i ? max1 : i;
		}
		max = String.valueOf(max1);

		// average calculate
		double count = 0, ortalama;
		for (int i = 0; i < arrayListAnketPuani.size(); i++) {
			count = count + arrayListAnketPuani.get(i);
		}
		ortalama = count / arrayListAnketPuani.size();
		average = String.valueOf(ortalama);

		// #### maximum calculate anket sorularina cevap veren sayisi
		int max2 = arrayListKatilanOgrenciSayisi.get(0);
		for (int i : arrayListKatilanOgrenciSayisi) {
			max2 = max2 > i ? max2 : i;
		}
		countAnketSorulariKatilanMax = String.valueOf(max2);

		// #### minumum calculate anket sorularina cevap veren sayisi
		int min3 = arrayListKatilanOgrenciSayisi.get(0);
		for (int i : arrayListKatilanOgrenciSayisi) {
			min3 = min3 < i ? min3 : i;
		}
		countAnketSorularinaKatilanMin = String.valueOf(min3);

		// #### average calculate anket sorularina cevap veren sayisi
		double count1 = 0, ortalama1;
		for (int i = 0; i < arrayListKatilanOgrenciSayisi.size(); i++) {
			count1 = count1 + arrayListKatilanOgrenciSayisi.get(i);
		}
		ortalama1 = count1 / arrayListKatilanOgrenciSayisi.size();
		coutAnketSorulariKatilanAverage = String.valueOf(ortalama1);

		// 2.75 on question
		for (int i = 0; i < arrayListAnketPuani.size(); i++) {
			if (arrayListAnketPuani.get(i) <= 2.50 && arrayListAnketPuani.get(i) > 0) {
				countTwoDotFiveUnder++;
				arrayListCount.add(arrayListid.get(i));
			}
			if (arrayListAnketPuani.get(i) <= 2.60 && arrayListAnketPuani.get(i) > 2.50) {
				countTwoDotSixBetweenFive++;
				arrayListCount.add(arrayListid.get(i));
			}
			if (arrayListAnketPuani.get(i) <= 2.70 && arrayListAnketPuani.get(i) > 2.60) {
				countTwoDotSevenBetweenTwoDotSix++;
				arrayListCount.add(arrayListid.get(i));
			}
			if (arrayListAnketPuani.get(i) <= 2.80 && arrayListAnketPuani.get(i) > 2.70) {
				countTwoDotEightBetweenTwoDotSeven++;
			}

			if (arrayListAnketPuani.get(i) <= 2.90 && arrayListAnketPuani.get(i) > 2.80) {
				countTwoDotNineBetweenTwoDotEight++;
				arrayListCount1.add(arrayListid.get(i));
			}

			if (arrayListAnketPuani.get(i) <= 3 && arrayListAnketPuani.get(i) > 2.9) {
				countthreeBetweenTwoDotNine++;
				arrayListCount1.add(arrayListid.get(i));

			}
			if (arrayListAnketPuani.get(i) <= 5 && arrayListAnketPuani.get(i) > 3) {
				countthreeBetweenFive++;
				arrayListCount1.add(arrayListid.get(i));

			}

			if (arrayListAnketPuani.get(i) < 0) {
				countZeroUnder++;
			}
			System.out.println("");
			if (arrayListAnketPuani.get(i) > 5) {
				countFiveOn++;
			}
		}

		for (int i = 0; i < arrayListCount.size(); i++) {
			System.out.print(arrayListCount.get(i) + "--");
		}
		System.out.println("");
		System.out.println("2.8 ustu olan anket sorularinin numaralari");
		for (int i = 0; i < arrayListCount1.size(); i++) {
			System.out.print(arrayListCount1.get(i) + " ");
		}
//		System.out.println("");
//		System.out.println("min: " + min);
//		System.out.println("max: " + max);
//		System.out.println("avarage " + average);
//		System.out.println("sıfırın altında: " + countZeroUnder);
//		System.out.println("5 üzerinden oylanan anket soru puanı 5'in üstünde: " + countFiveOn);
//		System.out.println("Anket sorularina katilan ortalama kisi sayisi " + coutAnketSorulariKatilanAverage);
//		System.out.println("Anket sorularina katilan max kisi sayisi" + countAnketSorulariKatilanMax);
//		System.out.println("Anket sorularina katilan min kisi sayisi " + countAnketSorularinaKatilanMin);

//		System.out.println("2.5'in altinda  " + countTwoDotFiveUnder);
//		System.out.println("2.6 ile 2.5 arasında " + countTwoDotSixBetweenFive);
//		System.out.println("2.6 ile 2.7 arasında: " + countTwoDotSevenBetweenTwoDotSix);
//		System.out.println("2.7 ile 2.8 arasında: " + countTwoDotEightBetweenTwoDotSeven);
//		System.out.println("2.8 ile 2.9 arasında: " + countTwoDotNineBetweenTwoDotEight);
//		System.out.println("2.9 ile 2 arasında: " + countthreeBetweenTwoDotNine);
//		System.out.println("");
//		System.out.println("2.6 ve alti anket puanina sahip sorularin numarasi");

	}
}
