package org.gck;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.util.Vector;

/**
 *	Wrapper for ResultSet to generate TableModels
 *
 * @author Gayan C. Karunarathna
 * @version 0.3
 */
public class DBUtil {
	
	//no need to initialize
	private DBUtil() {}

/* Methods for generating TableModel */

	/**
	 * Generates a DefaultTableModel from given ResultSet
	 * @param res ResultSet of sql query to generate tablemodel
	 * @return DefaultTableModel with column names and rows containing data
	 */
	public static DefaultTableModel resultSetToTableModel(ResultSet res) {
		try {
			if (res == null || res.isClosed()) {
				return null;
			}
			
			//creating a vector with column names
			ResultSetMetaData data = res.getMetaData();
			int colCount = data.getColumnCount();
			Vector<String> columns = new Vector<String>(colCount);
			for (int i=1; i<=colCount; i++) {
				columns.add(data.getColumnLabel(i));
			}
			
			//Vector for store rows
			Vector<Object> rows = new Vector<Object>();
			while(res.next()) {
				//vector for row
				Vector<Object> row = new Vector<Object>(colCount);
				for (int i=1; i<=colCount; i++) {
					row.add(res.getObject(i));
				}
				
				//add row to rows
				rows.add(row);
			}
			return new DefaultTableModel(rows, columns);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

/* Methods for generating TableModel */
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (first row of ResultSet will be used)
	 * @param res ResultSet to generate ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res) {
		return resultSetToComboBoxModel(res, 1, null);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (index'th row of ResultSet will be used)
	 * @param res ResultSet to generate ComboBoxModel
	 * @param index column index number of resultset for fill the ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, int column) {
		return resultSetToComboBoxModel(res, column, null);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (given columnName of ResultSet will be used)
	 * @param res ResultSet to generate ComboBoxModel
	 * @param columnName column name of resultset for fill the ComboBoxModel
	 * @return DefaultComboBoxModel containing of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, String column) {
		return resultSetToComboBoxModel(res, column, null);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (given columnName of ResultSet will be used).
	 * @param res ResultSet to generate ComboBoxModel	
	 * @param columnName column name of resultset for fill the ComboBoxModel
	 * @param firstItem first item to included in ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, String column, String firstItem) {
		try {
			if (res == null || res.isClosed()) {
				return null;
			}
			
			Vector<Object> rows = new Vector<Object>();
			if (firstItem != null) {
				rows.add(firstItem);
			}
			
			while(res.next()) {
				rows.add(res.getObject(column));
			}
			return new DefaultComboBoxModel<Object>(rows);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (given column Name of ResultSet will be used).
	 * @param res ResultSet to generate ComboBoxModel	
	 * @param index column index of resultset for fill the ComboBoxModel
	 * @param firstItem first item to included in ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, int column, String firstItem) {
		try {
			if (res == null || res.isClosed()) {
				return null;
			}
			
			Vector<Object> rows = new Vector<Object>();
			if (firstItem != null) {
				rows.add(firstItem);
			}
			
			while(res.next()) {
				rows.add(res.getObject(column));
			}
			return new DefaultComboBoxModel<Object>(rows);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
/* Methods for generating ListModels */

	public static DefaultListModel resultSetToListModel(ResultSet res) {
		return resultSetToListModel(res, 1);
	}
	
	public static DefaultListModel resultSetToListModel(ResultSet res, int column) {
		DefaultListModel<Object> dm = new DefaultListModel<Object>();
		try {
			while(res.next()) {
				dm.addElement(res.getObject(column));
			}
			return dm;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DefaultListModel resultSetToListModel(ResultSet res, String column) {
		DefaultListModel<Object> dm = new DefaultListModel<Object>();
		try {
			while(res.next()) {
				dm.addElement(res.getObject(column));
			}
			return dm;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
