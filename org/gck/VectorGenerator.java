package org.gck;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
	
public class VectorGenerator {
	private VectorGenerator() {}
	
	protected static Vector<String> resultSetToColumnNameVector(ResultSet res) {
		try {
			if (res == null || res.isClosed()) 	return null;
			
			ResultSetMetaData meta = res.getMetaData();
			int colCount = meta.getColumnCount();
			
			Vector<String> columns = new Vector<String>();
			for (int i=1; i<=colCount; i++) {
				columns.add( meta.getColumnLabel(i) );
			}
			
			return columns;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//returns data in all rows
	protected static Vector<Object> resultSetToRowsVector(ResultSet res) {
		try {
			if (res == null || res.isClosed()) 	return null;
			
			ResultSetMetaData meta = res.getMetaData();
			int colCount = meta.getColumnCount();
			
			Vector<Object> rows = new Vector<Object>();
			while (res.next()) {
				Vector<Object> row = new Vector<Object>(colCount);
				
				for (int i=1; i<=colCount; i++) {
					row.add( res.getObject(i) );
				}
				rows.add(row);
			}
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//returns rows in i'th column
	protected static Vector<Object> resultSetToRowsVector(ResultSet res, int index) {
		try {
			if (res == null || res.isClosed()) 	return null;
						
			Vector<Object> rows = new Vector<Object>();
			while (res.next()) {
				rows.add( res.getObject(index) );
			}
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//returns rows in column name colName
	protected static Vector<Object> resultSetToRowsVector(ResultSet res, String colName) {
		try {
			if (res == null || res.isClosed()) 	return null;
						
			Vector<Object> rows = new Vector<Object>();
			while (res.next()) {
				rows.add( res.getObject(colName) );
			}
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
