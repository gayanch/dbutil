package org.gck;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Contains methods for generate TableModels, Those methods are called by appropriate methods in DBUtill. Do not intend to call by end users.
 * @see DBUtil
 */
 
public class TableModelGenerator {
	
	private TableModelGenerator(){}	
	
	/**
	 * Generates a DefaultTableModel from given ResultSet
	 * @param res ResultSet of sql query to generate tablemodel
	 * @return DefaultTableModel with column names and rows containing data
	 */
	protected static DefaultTableModel resultSetToTableModel(ResultSet res) {
		try {
			if (res == null || res.isClosed()) {
				return null;
			}
			
			//creating a vector with column names
			Vector<String> columns = VectorGenerator.resultSetToColumnNameVector(res);
			res.beforeFirst();
						
			//Vector for store rows
			Vector<Object> rows = VectorGenerator.resultSetToRowsVector(res);
			
			return new DefaultTableModel(rows, columns);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
