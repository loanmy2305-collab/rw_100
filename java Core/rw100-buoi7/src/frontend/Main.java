package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLTK;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //QLTK.run();
        //QLDepartment.showDepartment();
        QLAccount.showAccount();

    }
}