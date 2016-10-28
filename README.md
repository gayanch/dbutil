# DBUtil
Java Library for Generate Table/ComboBox/List Models and Vectors from sql ResultSets

# Example of Usage
* Suppose you have a ResultSet called res created by executing following sql Query
`SELECT name AS Name, age AS Age FROM student`

* DefaultTableModel
`DefaultTableModel dtm = DBUtil.resultSetToTableModel(res);`

* DefaultComboBoxModel
`DefaultComboBoxModel<Object> dcm = DBUtil.resultSetToComboBoxModel(res);`

* ListModel
`DefaultListModel<Object> dlm = DBUtil.resultSetToListModel(res);`

* Vector filled with column names in ResultSet
`Vector<String> col = DBUtil.resultSetToColumnNameVector(res);`

* Vector of Vectors with row data
`Vector<Object> rows = DBUtil.resultSetToRowsVector(res);`

# Notes
* Add dbutil.jar file to your classpath before using.
* And import DBUtil by `import org.gck.dbutil.DBUtil;` 
* See JavaDocs for other useful overloaded methods.
