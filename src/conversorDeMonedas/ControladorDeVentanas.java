package conversorDeMonedas;

import javax.swing.*;

public class ControladorDeVentanas {
	// dialogos del programa
	private String[] opciones = { "Conversor de Moneda", "Coversor de Temperatura" };
	private String[] operacionesConMonedas = { "De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras",
			"De Pesos a Yen", "De Pesos a Won Coreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos",
			"De Yen a Pesos", "De Won Coreano a Pesos" };
	private String[] operacionesConTemperaturas = { "De Celsius a Fahrenheit", "De Celsius a Kelvin",
			"De Fahrenheit a Celsius", "De Kelvin a Celsius" };
	private String[] dialogoConMonedas = { "Elije la moneda a la que deseas convertir tu dinero", "Monedas" };
	private String[] dialogoConTemperaturas = { "Elije la unidad de temperatura a convertir", "Unidades" };
	// opciones seleccionadas
	private String opcionSeleccionada;
	private String operacionSeleccionada;
	// variabels de operacion
	private double cantidad;
	private double total;
	// valores del tipo de cambio "oficial de los bancos" del peso argentino al
	// momento de realizar el programa
	private double[] monedas = { 264.38, 297.03, 347.14, 1.92, 0.21 };
	// variables de las ventanas
	private JOptionPane panelNuevo = new JOptionPane();
	private JFrame frame = new JFrame();
	// variable de salida del programa en caso de tocar el boton cancelar
	private boolean canceloLaOperacion = false;

	public void convertirAMonedaExtrangera() {
		for (int i = 0; i < (operacionesConMonedas.length / 2); i++) {
			if (operacionSeleccionada == operacionesConMonedas[i]) {
				total = (cantidad / monedas[i]);
			}
		}
	}

	public void convertirAMonedaNacional() {
		for (int i = 0; i < (operacionesConMonedas.length / 2); i++) {
			if (operacionSeleccionada == operacionesConMonedas[i + operacionesConMonedas.length / 2]) {
				total = (cantidad * monedas[i]);
			}
		}
	}

	public void convertirAFahrenheit() {
		if (operacionSeleccionada == operacionesConTemperaturas[0]) {
			total = ((cantidad * 1.8) + 32);
		}

	}

	public void convertirAKelvin() {
		if (operacionSeleccionada == operacionesConTemperaturas[1]) {
			total = cantidad + 273;
		}

	}

	public void convertirACelsius() {
		if (operacionSeleccionada == operacionesConTemperaturas[2]) {
			total = ((cantidad - 32) * 0.56);
		}

		if (operacionSeleccionada == operacionesConTemperaturas[3]) {
			total = cantidad - 273;
		}

	}

	public void primerPanel() {
		opcionSeleccionada = (String) panelNuevo.showInputDialog(null, "Seleccione una opción de conversión", "Menu",
				JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == null) {
			canceloLaOperacion = true;
		}
	}

	public void segundoPanel() {
		if (canceloLaOperacion != true) {
			if (opcionSeleccionada == opciones[0]) {
				operacionSeleccionada = (String) panelNuevo.showInputDialog(null, dialogoConMonedas[0],
						dialogoConMonedas[1], JOptionPane.PLAIN_MESSAGE, null, operacionesConMonedas,
						operacionesConMonedas[0]);

			}
			if (opcionSeleccionada == opciones[1]) {
				operacionSeleccionada = (String) panelNuevo.showInputDialog(null, dialogoConTemperaturas[0],
						dialogoConTemperaturas[1], JOptionPane.PLAIN_MESSAGE, null, operacionesConTemperaturas,
						operacionesConTemperaturas[0]);

			}
			if (operacionSeleccionada == null) {
				canceloLaOperacion = true;
			}

		}
	}

	public void tercerPanel() {
		if (canceloLaOperacion != true) {
			String valor = (String) panelNuevo.showInputDialog(frame, "Ingrese la Cantidad:");
			if (valor != null) {

				if (valor.matches("[0-9]+")) {
					cantidad = Double.parseDouble(valor.toString());
				} else {
					soloIngreseNumeros();
				}
			} else {
				canceloLaOperacion = true;
			}
		}
	}

	public void cuartoPanel() {
		if (operacionSeleccionada != null & total != 0) {
			panelNuevo.showMessageDialog(frame, operacionSeleccionada + " " + total);
		}
	}

	public void quintoPanel() {
		int valor = panelNuevo.showConfirmDialog(frame, "¿Desea Continuar Operando?");
		if (valor == 0) {
			programa();
		} else {
			programaFinalizadoPanel();
		}
	}

	public void programaFinalizadoPanel() {
		panelNuevo.showMessageDialog(frame, "Programa Finalizado");
	}

	public void soloIngreseNumeros() {
		panelNuevo.showMessageDialog(frame, "Ingrese unicamente Numeros");
		tercerPanel();
	}

	public void redondearResultado() {

		total = (double) (Math.round(total * 100.0) / 100.0);

	}

	public void realizarConversion() {
		if (!canceloLaOperacion) {
			convertirAMonedaExtrangera();
			convertirAMonedaNacional();
			convertirAFahrenheit();
			convertirAKelvin();
			convertirACelsius();
			redondearResultado();
		}
	}

	public void programa() {
		primerPanel();
		segundoPanel();
		tercerPanel();
		realizarConversion();
		cuartoPanel();
		quintoPanel();

	}

}
