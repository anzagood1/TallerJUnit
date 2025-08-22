package tallerpruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testCsForWorkerInOddMonth() {
        Employee worker = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = worker.cs();
        // Si el mes es impar, se debe añadir el décimo (RMU / 12 * 2)
        assertEquals(1000.0f + 386.0f / 12 * 2, result, "El salario del trabajador debe incluir el décimo en meses impares.");
    }

    @Test
    public void testCsForWorkerInEvenMonth() {
        Employee worker = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = worker.cs();
        // Si el mes es par, no se añade el décimo, solo el salario
        assertEquals(1000.0f, result, "El salario del trabajador no debe incluir el décimo en meses pares.");
    }

    @Test
    public void testCsForSupervisor() {
        Employee supervisor = new Employee(1500.0f, "USD", 0.2f, EmployeeType.Supervisor);
        float result = supervisor.cs();
        // Supervisor recibe un bono adicional de 35% sobre el porcentaje de bono
        float expected = 1500.0f + (0.2f * 0.35f);
        assertEquals(expected, result, "El salario del supervisor debe incluir el bono de 35%.");
    }

    @Test
    public void testCalculateYearBonusForWorker() {
        Employee worker = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = worker.CalculateYearBonus();
        // El bono de fin de año del Worker es siempre el RMU
        assertEquals(386.0f, result, "El bono anual del trabajador debe ser el valor del RMU.");
    }

    @Test
    public void testCalculateYearBonusForSupervisor() {
        Employee supervisor = new Employee(1500.0f, "USD", 0.2f, EmployeeType.Supervisor);
        float result = supervisor.CalculateYearBonus();
        // El bono de fin de año para Supervisor es salario + RMU * 0.5
        float expected = 1500.0f + 386.0f * 0.5f;
        assertEquals(expected, result, "El bono anual del supervisor debe ser el salario + RMU * 0.5.");
    }

    @Test
    public void testCalculateYearBonusForManager() {
        Employee manager = new Employee(2000.0f, "USD", 0.3f, EmployeeType.Manager);
        float result = manager.CalculateYearBonus();
        // El bono de fin de año para Manager es salario + RMU * 1
        float expected = 2000.0f + 386.0f * 1.0f;
        assertEquals(expected, result, "El bono anual del manager debe ser el salario + RMU * 1.");
    }

    @Test
    public void testCsForCurrencyConversion() {
        Employee worker = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Worker);
        float result = worker.cs();
        // Si la moneda es EUR (no USD), el salario se debe reducir en un 5%
        float expected = 1000.0f * 0.95f;
        assertEquals(expected, result, "El salario del trabajador debe ser ajustado al tipo de cambio.");
    }
}
