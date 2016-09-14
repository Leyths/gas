package controllers;

import play.db.Database;
import play.mvc.Result;
import play.mvc.Controller;

import javax.inject.Inject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestDbController extends Controller {

    @Inject
    Database database;

    public Result doStuff() {
        Connection connection = database.getConnection();
        String name = "Pre name\n";
        try {
            connection.prepareCall("CREATE TABLE IF NOT EXISTS users (name VARCHAR)").execute();
            CallableStatement insert = connection.prepareCall("INSERT INTO users VALUES (?)");
            insert.setString(1, "David");
            insert.execute();

            CallableStatement statement = connection.prepareCall("SELECT name FROM users");
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                name += result.getString("name") + "\n";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok(name);
    }
}
