package com.wipro.bank.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.service.BankService;
import com.wipro.bank.util.DBUtil;

public class Main {
	public static void main(String[] args) throws Exception {
		Connection con = DBUtil.getConnection();
		System.out.println("Connection Successful");

		Statement smt = con.createStatement();

		String query = "select * from transfer_tbl";

		ResultSet res = smt.executeQuery(query);

		while (res.next()) {
			System.out.println("" + res.getString(2) + "");
		}

		BankDAO bankdao = new BankDAO();

		if (bankdao.validateAccount("126")) {
			System.out.println("True");
		}

		System.out.println(bankdao.findBalance("128"));

		BankService service = new BankService();

		

		TransferBean transferbean = new TransferBean(1, "128", "123", new Date(), 1000f);
		

		System.out.println(service.transfer(transferbean));
		System.out.println(service.checkBalance("123"));

	}
}