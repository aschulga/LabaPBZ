package View;

import Connection.DBConnection;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelTable extends AbstractTableModel {

    private static final int columnCount = 6;
    private List<String[]> tableData;

    public ModelTable()
    {
        tableData = new ArrayList<>();
        for(int i = 0; i < tableData.size(); i++)
        {
            tableData.add(new String[getColumnCount()]);
        }
    }

    public String getColumnName(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return "Фамилия";
            case 1: return "Имя";
            case 2: return "Отчество";
            case 3: return "Дата рождения";
            case 4: return "Дата поступления в вуз";
            case 5: return "Дата окончания вуза";
        }
        return "";
    }

    public int getRowCount()
    {
        return tableData.size();
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        String []rows = tableData.get(rowIndex);
        return rows[columnIndex];
    }

    public void addDate(String[] row)
    {
        tableData.add(row);
        fireTableDataChanged();
    }

    public void addData(DBConnection connect, String name) {
        deleteAllStudent();
        ResultSet result = connect.query("SELECT * FROM "+name+"");
        try {

            while (result.next()) {
                String []row = {
                        result.getString("surname"),
                        result.getString("firstname"),
                        result.getString("middlename"),
                        result.getString("dateBirthday"),
                        result.getString("dateReceipt"),
                        result.getString("dateExpiration")
                };

                addDate(row);
            }
            result.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllStudent()
    {
        tableData.clear();
        fireTableDataChanged();
    }
}
