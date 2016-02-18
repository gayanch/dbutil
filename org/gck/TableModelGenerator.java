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
}
