package Trimestre3.postgres;

import java.io.File;
import Trimestre3.postgres.Data;

public class Inserts {
    File sqlFile = "";

    public boolean importfile(String route) throws IllegalAccessError {
        sqlFile = route;
        if (!sqlFile.exists() || !sqlFile.canExecute()) {
            throw new IllegalAccessError();
            return;
        }

    }

}
