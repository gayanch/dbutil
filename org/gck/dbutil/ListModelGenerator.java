package org.gck;

import javax.swing.DefaultListModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Contains methods for generate ListModels, Those methods are called by appropriate methods in DBUtill. Do not intend to call by end users.
 * @see DBUtil
 */

public class ListModelGenerator {
	
	private ListModelGenerator() {}

	protected static DefaultListModel resultSetToListModel(ResultSet res, int column) {
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
	
	protected static DefaultListModel resultSetToListModel(ResultSet res, String column) {
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
