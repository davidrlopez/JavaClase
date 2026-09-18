package Trimestre3.RepasoExamen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Tarea11 Empresa JDBC");
        System.out.println("2. TareaRA6 Colecciones");
        System.out.print("Opcion: ");
        String option = input.nextLine().trim();

        if (option.equals("1")) {
            ejecutarEmpresa(input);
        } else if (option.equals("2")) {
            new ColeccionesRepaso().run();
        } else {
            System.out.println("Opcion no valida");
        }
    }

    private static void ejecutarEmpresa(Scanner input) {
        System.out.print("URL [jdbc:mysql://localhost:3306/BDEmpresa]: ");
        String url = input.nextLine().trim();
        if (url.trim().isEmpty()) {
            url = "jdbc:mysql://localhost:3306/BDEmpresa";
        }

        System.out.print("Usuario: ");
        String user = input.nextLine().trim();
        System.out.print("Password: ");
        String password = input.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            new Menu(conn).run();
        } catch (SQLException e) {
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
    }
}
