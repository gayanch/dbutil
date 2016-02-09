# DBUtil
Java Library for Generate Table/ComboBox Models from sql ResultSets

# Example of Usage
* Suppose you have a ResultSet called res created by executing following sql Query
`SELECT name AS Name, age AS Age FROM student`

* Lets create a table model from DBUtil by parsing our ResultSet to it
`DefaultTableModel dtm = DBUtil.resultSetToTableModel(res);`

* Now set it to a JTable as follows
`<yourTableName>.setModel(dtm);`

# Notes
* Add dbutil.jar file to your classpath before using
* And import DBUtil by `import org.gck.DBUtil;` 
