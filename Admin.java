package com.lling.qiqu.controllers.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.lling.qiqu.beans.User;
import com.lling.qiqu.commons.Constants;
import com.lling.qiqu.commons.ResponseInfo;
import com.lling.qiqu.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


public class BorrowBooks extends JInternalFrame {
	/*declaration of the private variables used in the program*/

	//for creating the North Panel
	private JPanel northPanel = new JPanel();
	//for creating the label
	private JLabel title = new JLabel("BOOK INFORMATION");

	//for creating the Center Panel
	private JPanel centerPanel = new JPanel();
	//for creating an Internal Panel in the center panel
	private JPanel informationPanel = new JPanel();
	//for creating an array of JLabel
	private JLabel[] informationLabel = new JLabel[4];
	//for creating an array of String
	private String[] informationString = {" Write the Book ID:", " Write the Member ID:",
	                                      " The Current Data:", " The Return Date:"};
	//for creating an array of JTextField
	private JTextField[] informationTextField = new JTextField[4];
	//for creating the date in the String
	private String date = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());
	//for creating an array of string to store the data
	private String[] data;
	
	//for creating an Internal Panel in the center panel
	private JPanel borrowButtonPanel = new JPanel();
	//for creating the button
	private JButton borrowButton = new JButton("Borrow");

	//for creating South Panel
	private JPanel southPanel = new JPanel();
	//for creating the button
	private JButton cancelButton = new JButton("Cancel");

	//for creating an object
	private Books book;
	private Members member;
	private Borrow borrow;
	
	//for checking the information from the text field
	public boolean isCorrect() {
		data = new String[4];
		for (int i = 0; i < informationLabel.length; i++) {
			if (!informationTextField[i].getText().equals(""))
				data[i] = informationTextField[i].getText();
			else
				return false;
		}
		return true;
	}
	//for setting the array of JTextField to null
	public void clearTextField() {
		for (int i = 0; i < informationTextField.length; i++)
			if (i != 2)
				informationTextField[i].setText(null);
	}
	
