package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

//	1) Haz un fork del proyecto a tu cuenta de GitHub, más abajo tendrás una explicación de que es un fork. El enlace del proyecto está aquí.
//	2) Clona el proyecto de tu cuenta a tu equipo.
//	3) Descarga y añade los ficheros .jar indicados anteriormente, en caso de problema fjcanofp@gmail.com.
//	4) Realiza las pruebas de unidad de los métodos de la clase Empleado que aparecen aquí citados:
//		a. calcularPrima				
//		b. establecerNumeroEmpleado		Requisito: numero entero menor de 1000
//		c. estableceNombreEmpleado		Requisito: Una palabra "^[a-zA-Z0-9]*" menor de 10
//		d. estableceMesesTrabajo		Requisito: numero entero menor de 1000, o igual a 000
//		e. establecerSerDirectivo		Requisito: '+' || '+'
//	5) Una vez realizadas las pruebas haz un push de los cambios al repositorio.

public class TestEmpleado {
	@Test
	public void establecerNumeroDeEmpleadoCorrecto() {
		Empleado e = new Empleado();
		try {e.establecerNumeroEmpleado("4");} catch (NumeroEmpleadoException ex) {fail();}
		assertEquals(4, e.getNumeroEmpleado());
	}

	/****************************************************************/
	@Test
	public void test_calcularPrima_01_Correcto() {
		calcularPrima_Test("calcularPrima 1", "625", "Jorge", "035", "+");
	}

	@Test
	public void test_calcularPrima_02_Correcto() {
		calcularPrima_Test("calcularPrima 2", "626", "Juan", "36", "-");
	}

	@Test
	public void test_calcularPrima_03_Correcto() {
		calcularPrima_Test("calcularPrima 3", "627", "Martin", "008", "+");
	}

	@Test
	public void test_calcularPrima_04_Correcto() {
		calcularPrima_Test("calcularPrima 4", "628", "Miguel", "005", "-");
	}

	@Test
	public void test_calcularPrima_05_Error() {
		calcularPrima_Test("calcularPrima 5", "000", "Felipe", "016", "+");
	}

	@Test
	public void test_calcularPrima_06_Error() {
		calcularPrima_Test("calcularPrima 6", "1234", "David", "018", "-");
	}

	@Test
	public void test_calcularPrima_07_Error() {
		calcularPrima_Test("calcularPrima 7", "629", "", "012", "+");
	}

	@Test
	public void test_calcularPrima_08_Error() {
		calcularPrima_Test("calcularPrima 8", "630", "MariaCristina", "020", "-");
	}

	@Test
	public void test_calcularPrima_09_Error() {
		calcularPrima_Test("calcularPrima 9", "631", "Laura", "seis", "+");
	}

	@Test
	public void test_calcularPrima_10_Error() {
		calcularPrima_Test("calcularPrima 10", "632", "Santiago", "1500", "-");
	}

	@Test
	public void test_calcularPrima_11_Error() {
		calcularPrima_Test("calcularPrima 11", "633", "Jorge", "006", "0");
	}

	@Test
	public void test_calcularPrima_12_Error() {
		calcularPrima_Test("calcularPrima 12", "634", "Juan", "022", "*");
	}

	@Test
	public void test_calcularPrima_13_Error() {
		calcularPrima_Test("calcularPrima 13", "635", "Martin", "012", "-");
	}

	/****************************************************************/
	@Test
	public void test_establecerNumeroEmpleado_01_Correcto() {
		establecerNumeroEmpleado_Test("625");
	}

	@Test
	public void test_establecerNumeroEmpleado_02_Correcto() {
		establecerNumeroEmpleado_Test("099");
	}

	@Test
	public void test_establecerNumeroEmpleado_03_Correcto() {
		establecerNumeroEmpleado_Test("99");
	}

	@Test
	public void test_establecerNumeroEmpleado_04_Error() {
		establecerNumeroEmpleado_Test("000");
	}

	@Test
	public void test_establecerNumeroEmpleado_05_Error() {
		establecerNumeroEmpleado_Test("1234");
	}

	@Test
	public void test_establecerNumeroEmpleado_06_Error() {
		establecerNumeroEmpleado_Test("ABC");
	}

	/****************************************************************/
	@Test
	public void test_estableceNombreEmpleado_01_Correcto() {
		estableceNombreEmpleado_Test("Jorge");
	}

	@Test
	public void test_estableceNombreEmpleado_02_Correcto() {
		estableceNombreEmpleado_Test("0Jorge0");
	}

	@Test
	public void test_estableceNombreEmpleado_04_Error() {
		estableceNombreEmpleado_Test("");
	}

	@Test
	public void test_estableceNombreEmpleado_05_Error() {
		estableceNombreEmpleado_Test("MariaCristina");
	}

	@Test
	public void test_estableceNombreEmpleado_06_Error() {
		estableceNombreEmpleado_Test("Maria Cri");
	}

	/****************************************************************/
	@Test
	public void test_estableceMesesTrabajo_01_Correcto() {
		estableceMesesTrabajo_Test("100");
	}

	@Test
	public void test_estableceMesesTrabajo_02_Correcto() {
		estableceMesesTrabajo_Test("000");
	}

	@Test
	public void test_estableceMesesTrabajo_03_Correcto() {
		estableceMesesTrabajo_Test("018");
	}

	@Test
	public void test_estableceMesesTrabajo_04_Correcto() {
		estableceMesesTrabajo_Test("18");
	}

	@Test
	public void test_estableceMesesTrabajo_05_Error() {
		estableceMesesTrabajo_Test("seis");
	}

	@Test
	public void test_estableceMesesTrabajo_06_Error() {
		estableceMesesTrabajo_Test("1500");
	}

	/****************************************************************/
	@Test
	public void test_establecerSerDirectivo_01_Correcto() {
		establecerSerDirectivo_Test("+");
	}

	@Test
	public void test_establecerSerDirectivo_02_Correcto() {
		establecerSerDirectivo_Test("-");
	}

	@Test
	public void test_establecerSerDirectivo_03_Error() {
		establecerSerDirectivo_Test("0");
	}

	@Test
	public void test_establecerSerDirectivo_04_Error() {
		establecerSerDirectivo_Test("*");
	}

	@Test
	public void test_establecerSerDirectivo_05_Error() {
		establecerSerDirectivo_Test("+-");
	}

	@Test
	public void test_establecerSerDirectivo_06_Error() {
		establecerSerDirectivo_Test("");
	}

	/********************************/
	public void calcularPrima_Test(String numTest, String numEmpleado, String nomEmpleado, String mesesT, String dir) {
		Empleado e = new Empleado();
		try {
			e.calcularPrima(numEmpleado, nomEmpleado, mesesT, dir);
		} catch (NumeroEmpleadoException ex) {
			fail("\nNúmero empleado erróneo.");
		} catch (NombreEmpleadoException ex) {
			fail("\nNombre empleado erróneo.");
		} catch (MesesTrabajoException ex) {
			fail("\nMeses trabajados erróneos.");
		} catch (CargoException ex) {
			fail("\nDirectivo erróneo.");
		} catch (RuntimeException ex) {
			fail("\nOtros Errores (Runtime).");
		}
		assertTrue("\nError de prima", e.getPrima() == Prima.P1 || e.getPrima() == Prima.P2 || e.getPrima() == Prima.P3
				|| e.getPrima() == Prima.P4);
		System.out.println(numTest + ")\tSalida: " + e.getPrima());
	}

	public void establecerNumeroEmpleado_Test(String numEmpleado) {
		Empleado e = new Empleado();
		try {
			e.establecerNumeroEmpleado(numEmpleado);
		} catch (NumeroEmpleadoException ex) {
			fail("\nNúmero empleado erróneo");
		}
		assertTrue("\nError de Assert:", numEmpleado.contains(String.valueOf(e.getNumeroEmpleado())));
	}

	public void estableceNombreEmpleado_Test(String nomEmpleado) {
		Empleado e = new Empleado();
		try {
			e.estableceNombreEmpleado(nomEmpleado);
		} catch (NombreEmpleadoException ex) {
			fail("\nNombre empleado erróneo");
		}
		assertTrue("\nError Assert", e.getNombreEmpleado().equals(nomEmpleado));
	}

	public void estableceMesesTrabajo_Test(String mesesT) {
		Empleado e = new Empleado();
		try {
			e.estableceMesesTrabajo(mesesT);
		} catch (MesesTrabajoException ex) {
			fail("\nMeses trabajados erróneos");
		}
		assertTrue("\nError de Assert:", mesesT.contains(String.valueOf(e.getMesesTrabajo())));
	}

	public void establecerSerDirectivo_Test(String dir) {
		Empleado e = new Empleado();
		try {
			e.establecerSerDirectivo(dir);
		} catch (CargoException ex) {
			fail("\nDirectivo erróneo");
		}
		assertEquals("\nError de Assert: ", (e.getDirectivo()) ? "+" : "-", dir);
	}
}
