package View;

import Connection.DBConnection;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCreate {

    private JDialog dialog = new JDialog();
    private MyFrame frame;
    DBConnection connect;

    public DialogCreate(MyFrame frame, DBConnection connect) {
        this.frame = frame;
        this.connect = connect;
    }

    public void create(){

        SqlDateModel dateBirthday = new SqlDateModel();
        JDatePanelImpl datePanel1 = new JDatePanelImpl(dateBirthday);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);

        SqlDateModel dateReceipt = new SqlDateModel();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(dateReceipt);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);

        SqlDateModel dateExpiration = new SqlDateModel();
        JDatePanelImpl datePanel3 = new JDatePanelImpl(dateExpiration);
        JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3);

        dialog.setSize(400,500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        JLabel surNameLabel = new JLabel("Фамилия: ");
        JTextField surNameTextField = new JTextField(10);

        dialog.add(surNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(surNameTextField, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel firstNameLabel = new JLabel("Имя: ");
        JTextField firstNameTextField = new JTextField(10);

        dialog.add(firstNameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(firstNameTextField, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel middleNameLabel = new JLabel("Отчество: ");
        JTextField middleNameTextField = new JTextField(10);

        dialog.add(middleNameLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(middleNameTextField, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel data1Label = new JLabel("Дата рождения: ");

        dialog.add(data1Label, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(datePicker1, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel data2Label = new JLabel("Дата поступления: ");

        dialog.add(data2Label, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(datePicker2, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel data3Label = new JLabel("Дата окончания вуза: ");

        dialog.add(data3Label, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(datePicker3, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JButton addStudent = new JButton("Добавить студента");

        dialog.add(addStudent, new GridBagConstraints(0, 6, 2, 1, 2, 2,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);


        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((surNameTextField.getText()).trim().isEmpty() || (firstNameTextField.getText()).trim().isEmpty() || (middleNameTextField.getText()).trim().isEmpty()
                        || dateBirthday.getValue() == null || dateReceipt.getValue() == null || dateExpiration.getValue() == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "Одно или несколько полей не заполнены");
                    return;
                } else {
                    connect.updateQuery("INSERT INTO tableOfStudents VALUES('"+surNameTextField.getText()+"','"
                            +firstNameTextField.getText()+"','"+middleNameTextField.getText()
                            +"','"+dateBirthday.getValue()+"','"+dateReceipt.getValue()+"', '"+dateExpiration.getValue()+"')");
                    JOptionPane.showMessageDialog(dialog, "Запись успешно добавлена. Для продолжения работы нажмите \"ОК\"");
                    dialog.dispose();
                    frame.generationTable("tableOfStudents");
                }
            }
        });
    }
}
