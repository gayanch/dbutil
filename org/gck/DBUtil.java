package org.gck;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.util.Vector;

/**
 *	Wrapper for ResultSet to generate TableModels
 *
 * @author Gayan C. Karunarathna
 * @version 0.4
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
		return TableModelGenerator.resultSetToTableModel(res);
	}

/* Methods for generating ComboBoxModel */
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (first row of ResultSet will be used)
	 * @param res ResultSet to generate ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res) {
		return ComboBoxModelGenerator.resultSetToComboBoxModel(res, 1, null);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (index'th row of ResultSet will be used)
	 * @param res ResultSet to generate ComboBoxModel
	 * @param column column index number of resultset for fill the ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, int column) {
		return ComboBoxModelGenerator.resultSetToComboBoxModel(res, column, null);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (given columnName of ResultSet will be used)
	 * @param res ResultSet to generate ComboBoxModel
	 * @param column column name of resultset for fill the ComboBoxModel
	 * @return DefaultComboBoxModel containing of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, String column) {
		return ComboBoxModelGenerator.resultSetToComboBoxModel(res, column, null);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (given columnName of ResultSet will be used).
	 * @param res ResultSet to generate ComboBoxModel	
	 * @param column column name of resultset for fill the ComboBoxModel
	 * @param firstItem first item to included in ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, String column, String firstItem) {
		return ComboBoxModelGenerator.resultSetToComboBoxModel(res, column, firstItem);
	}
	
	/**
	 * Generates a DefaultComboBoxModel from given ResultSet (given column Name of ResultSet will be used).
	 * @param res ResultSet to generate ComboBoxModel	
	 * @param column column index of resultset for fill the ComboBoxModel
	 * @param firstItem first item to included in ComboBoxModel
	 * @return DefaultComboBoxModel containing data of ResultSet
	 */
	public static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, int column, String firstItem) {
		return ComboBoxModelGenerator.resultSetToComboBoxModel(res, column, firstItem);
	}
	
	
/* Methods for generating ListModels */
	
	/**
	 * Generates a DefaultListModel from given ResultSet (first column of resultset will be used).
	 * @param res ResultSet to generate DefaultListModel	
	 * @return DefaultListModel containing data of ResultSet
	 */
	public static DefaultListModel resultSetToListModel(ResultSet res) {
		return ListModelGenerator.resultSetToListModel(res, 1);
	}
	
	/**
	 * Generates a DefaultListModel from given ResultSet (given column of resultset will be used).
	 * @param res ResultSet to generate DefaultListModel	
	 * @param column column index of resultset for fill the DefaultListModel
	 * @return DefaultListModel containing data of ResultSet
	 */
	public static DefaultListModel resultSetToListModel(ResultSet res, int column) {
		return ListModelGenerator.resultSetToListModel(res, column);
	}
	
	/**
	 * Generates a DefaultListModel from given ResultSet (given column of resultset will be used).
	 * @param res ResultSet to generate DefaultListModel	
	 * @param column name of the column in resultset
	 * @return DefaultListModel containing data of ResultSet
	 */
	public static DefaultListModel resultSetToListModel(ResultSet res, String column) {
		return ListModelGenerator.resultSetToListModel(res, column);
	}
	
	public static Vector<String> resultSetToColumnNameVector(ResultSet res) {
		return VectorGenerator.resultSetToColumnNameVector(res);
	}
	
	public static Vector<Object> resultSetToRowsVector(ResultSet res) {
		return VectorGenerator.resultSetToRowsVector(res);
	}
}
