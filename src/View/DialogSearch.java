package View;

import Connection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogSearch{

    private JDialog dialog = new JDialog();
    private DBConnection connect;
    private MyFrame frame;

    public DialogSearch(DBConnection connect, MyFrame frame) {
        this.connect = connect;
        this.frame = frame;
    }

    public void search() {

        dialog.setSize(500,500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        SearchOrDelete searchOrDelete = new SearchOrDelete(dialog);

        dialog = searchOrDelete.oneDialog();

        JPanel panelTable = new JPanel();
        panelTable.setLayout(new GridBagLayout());

        JButton searchButton = new JButton("Поиск");

        JPanel panelSearchButton = new JPanel();
        panelSearchButton.setLayout(new GridBagLayout());

        panelSearchButton.add(searchButton, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelSearchButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelTable, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (searchOrDelete.getRadiobutBirthday1().isSelected() == true) {
                    if (searchOrDelete.CheckOne())
                    {
                        connect.updateQuery("TRUNCATE TABLE users ");

                        connect.updateQuery("INSERT INTO users SELECT * FROM tableOfStudents WHERE tableOfStudents.surname = '" + searchOrDelete.getsurNameText() + "' AND tableOfStudents.firstname = '"
                                + searchOrDelete.getfirstNameText() + "' AND tableOfStudents.middlename = '" + searchOrDelete.getmiddleNameText()
                                + "'AND DAYOFMONTH(tableOfStudents.dateBirthday) = '" + Integer.parseInt(searchOrDelete.getDay()) + "'");
                    }
                }


                if (searchOrDelete.getRadiobutReceipt1().isSelected() == true) {
                    if (searchOrDelete.CheckOne()) {

                        connect.updateQuery("TRUNCATE TABLE users ");

                        connect.updateQuery("INSERT INTO users SELECT * FROM tableOfStudents WHERE tableOfStudents.surname = '" + searchOrDelete.getsurNameText() + "' AND tableOfStudents.firstname = '"
                                + searchOrDelete.getfirstNameText() + "' AND tableOfStudents.middlename = '" + searchOrDelete.getmiddleNameText()
                                + "'AND DAYOFMONTH(tableOfStudents.dateReceipt) = '" + Integer.parseInt(searchOrDelete.getDay()) + "'");
                    }
                }


                if (searchOrDelete.getRadiobutExpiration1().isSelected() == true) {
                    if (searchOrDelete.CheckOne()) {

                        connect.updateQuery("TRUNCATE TABLE users ");

                        connect.updateQuery("INSERT INTO users SELECT * FROM tableOfStudents WHERE tableOfStudents.surname = '" + searchOrDelete.getsurNameText() + "' AND tableOfStudents.firstname = '"
                                + searchOrDelete.getfirstNameText() + "' AND tableOfStudents.middlename = '" + searchOrDelete.getmiddleNameText()
                                + "'AND DAYOFMONTH(tableOfStudents.dateExpiration) = '" + Integer.parseInt(searchOrDelete.getDay()) + "'");

                    }
                }

                frame.generationTable("users");
            }
        });
    }
}
