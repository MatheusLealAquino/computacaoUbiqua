import br.pro.turing.javino.*;

public class Main {
	public static void main(String args[]) {
		Javino j = new Javino();
		String port = "COM3";

		String ask = "hi";
		if (j.requestData(port, ask)) {
			System.out.println(j.getData());
		}

		ask = "who";
		if (j.requestData(port, ask)) {
			System.out.println(j.getData());
		}

		ask = "status";
		if (j.requestData(port, ask)) {
			System.out.println(j.getData());
		}
	}
}
