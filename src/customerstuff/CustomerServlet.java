package customerstuff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers?useSSL=false", "root", "password");
			st = con.createStatement();

			String query = "select * from customers where LastName = '" + request.getParameter("lastName") + "' ;";

			rs = st.executeQuery(query);
			String message = " ";
			while (rs.next()) {
				String customerID = rs.getString("customerid");
				String title = rs.getString("Title");
				String fullName = rs.getString("FullName");
				String streetAddress = rs.getString("StreetAddress");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zipCode = rs.getString("ZipCode");
				String email = rs.getString("EmailAddress");
				String position = rs.getString("Position");
				System.out.println(" ");
				String customerInfo = "Customer Number:" + customerID + "\n" + title + fullName + "\n" + streetAddress + "\n"
						+ city + ", " + state + " " + zipCode;
				message = message + "\n" + customerInfo;

			}

			// Customer newCustomer = new Customer();
			// String lastName = request.getParameter("lastName");
			// System.out.println(lastName);

			// String message = newCustomer.getData(lastName);
			// String f_name = newCustomer.getData(lastName);
			// System.out.println(f_name);
			request.setAttribute("myMessage", message);
			getServletContext().getRequestDispatcher("/NewJSPFile.jsp").forward(request, response);
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
