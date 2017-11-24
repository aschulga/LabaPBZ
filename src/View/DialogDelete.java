package View;

import Connection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDelete {
    private JDialog dialog = new JDialog();
    private MyFrame frame;
    private DBConnection connect;

    public DialogDelete(MyFrame frame, DBConnection connect) {
        this.frame = frame;
        this.connect = connect;
    }

    public void delete() {

        dialog.setSize(500, 500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        SearchOrDelete searchOrDelete = new SearchOrDelete(dialog);

        dialog = searchOrDelete.oneDialog();

        JButton deleteButton = new JButton("Удалить");

        JPanel panelDeleteButton = new JPanel();
        panelDeleteButton.setLayout(new GridBagLayout());

        panelDeleteButton.add(deleteButton, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelDeleteButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchOrDelete.getRadiobutBirthday1().isSelected() == true) {
                    if (searchOrDelete.CheckOne()) {
                        connect.updateQuery("DELETE FROM tableOfStudents WHERE surname = '" + searchOrDelete.getsurNameText() + "' AND firstname = '"
                                + searchOrDelete.getfirstNameText() + "' AND middlename = '" + searchOrDelete.getmiddleNameText()
                                + "'AND DAYOFMONTH(dateBirthday) = '" + Integer.parseInt(searchOrDelete.getDay()) + "'");
                    }
                }

                if (searchOrDelete.getRadiobutReceipt1().isSelected() == true) {

                    if (searchOrDelete.CheckOne()) {
                        connect.updateQuery("DELETE FROM tableOfStudents WHERE surname = '" + searchOrDelete.getsurNameText() + "' AND firstname = '"
                                + searchOrDelete.getfirstNameText() + "' AND middlename = '" + searchOrDelete.getmiddleNameText()
                                + "'AND DAYOFMONTH(dateReceipt) = '" + Integer.parseInt(searchOrDelete.getDay()) + "'");
                    }
                }

                if (searchOrDelete.getRadiobutExpiration1().isSelected() == true) {

                    if (searchOrDelete.CheckOne()) {
                        connect.updateQuery("DELETE FROM tableOfStudents WHERE surname = '" + searchOrDelete.getsurNameText() + "' AND firstname = '"
                                + searchOrDelete.getfirstNameText() + "' AND middlename = '" + searchOrDelete.getmiddleNameText()
                                + "'AND DAYOFMONTH(dateExpiration) = '" + Integer.parseInt(searchOrDelete.getDay()) + "'");
                    }
                }

                    frame.generationTable("tableOfStudents");
               }
        });
    }
}

