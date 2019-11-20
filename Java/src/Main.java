import br.pro.turing.javino.*;
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Javino j = new Javino();
		String port = "COM6";
		int quantity = 0;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite a quantidade de dados para coleta: ");
		quantity = keyboard.nextInt();

		List<XYChart> charts = getData(j, port, quantity);
		new SwingWrapper<XYChart>(charts).displayChartMatrix();
	}

	private static List<XYChart> getData(Javino j, String port, int quantity) {
		String message = "";
		String[] splitedValue;
		double[] arrLuminosidade = new double[quantity];
		double[] arrTemperatura = new double[quantity];
		List<XYChart> charts = new ArrayList<XYChart>();

		for (int i=0; i<quantity; i++) {
			if (j.listenArduino(port)){
				message=j.getData();
				splitedValue=message.split(";");
				System.out.println(splitedValue[0]);
				System.out.println(splitedValue[1]);
				arrLuminosidade[i] = Double.parseDouble(splitedValue[0]);
				arrTemperatura[i] = Double.parseDouble(splitedValue[1]);
			}
		}

		charts.add(mountChart(arrLuminosidade, 1));
		charts.add(mountChart(arrTemperatura, 2));
		return charts;
	}

	private static XYChart mountChart(double[] numPoints, int index) {
		XYChart chart = new XYChartBuilder().xAxisTitle("X").yAxisTitle("Y").width(600).height(400).build();
		chart.getStyler().setYAxisMin(-20.0);
		chart.getStyler().setYAxisMax(300.0);
		XYSeries series = chart.addSeries("" + index, null, numPoints);
		series.setMarker(SeriesMarkers.NONE);
		return chart;
	}
}
