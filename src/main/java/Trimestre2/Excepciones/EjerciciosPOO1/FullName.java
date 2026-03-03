package Trimestre2.Excepciones.EjerciciosPOO1;

import java.util.Objects;

public class FullName {
    private String firstName;
    private String lastName1;
    private String lastName2;

    public FullName(String firstName, String lastName1, String lastName2) {
        this.firstName = firstName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) &&
               Objects.equals(lastName1, fullName.lastName1) &&
               Objects.equals(lastName2, fullName.lastName2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName1, lastName2);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName1 + " " + lastName2;
    }
}