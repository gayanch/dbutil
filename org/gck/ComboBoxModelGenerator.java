package org.gck;

import javax.swing.DefaultComboBoxModel;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Contains methods for generate ComboBoxModels, Those methods are called by appropriate methods in DBUtill. Do not intend to call by end users.
 * @see DBUtil
 */
 
public class ComboBoxModelGenerator {
	
	private ComboBoxModelGenerator() {}
	
	protected static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, String column, String firstItem) {
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
	
	protected static DefaultComboBoxModel<Object> resultSetToComboBoxModel(ResultSet res, int column, String firstItem) {
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
}
