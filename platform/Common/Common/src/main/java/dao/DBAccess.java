package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class DBAccess {

	public static Connection con;

	static String dbName = "r";
	static String dbUserName = "";
	static String dbPassword = "";
	static String dbClassName = "r";
	static String dbURL = "j";

	public static Connection getConnection() {
		try {
			dbURL = "jdbc:sqlserver://" + ObjectHelper.dburl + ":1433";

			if (con != null) {
				con.close();
			}
			con = null;
			if (con == null) {

				Class.forName(dbClassName);
				con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			}

		} catch (Exception ex) {
			con = null;
			ex.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {

		System.out.println("State :" + DBAccess.getConnection());

		//System.out.println("Record Present : " + DAO.checkrecordcreated("Select *  FROM [BCTest_Rover].[dbo].[Doctor] where replace(CONVERT( date, Last_Updated, 105), '.' '-') =" + CommonFunctions.getDateNoname(-22)));

	}

}
