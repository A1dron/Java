package Testing.repositories;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.*;

@Component
public class DatabaseWrapper {

    private static final String LOGIN = "sa";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:h2:~/test";


    @PostConstruct
    public void Init() throws SQLException, FileNotFoundException {
        registerDriver(new org.h2.Driver());
        ScriptRunner sr = new ScriptRunner(getConnection());
        Reader reader = new BufferedReader(new FileReader("src/main/resources/sqlTables.sql"));
        sr.runScript(reader);
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void close(AutoCloseable... close){
        try {
            for (AutoCloseable c: close) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
