package View;

import javax.swing.*;
import java.awt.*;

public class SearchOrDelete {

    private JDialog dialog;

    private JRadioButton radiobutBirthday1 = new JRadioButton("По ФИО и дню рождения");

    private JRadioButton radiobutReceipt1 = new JRadioButton("По ФИО и дню поступления в вуз");

    private JRadioButton radiobutExpiration1 = new JRadioButton("По ФИО и дню окончания вуза");

    private JTextField surNameTextField = new JTextField(10);
    private JTextField firstNameTextField = new JTextField(10);
    private JTextField middleNameTextField = new JTextField(10);
    private JTextField dayTextField = new JTextField(10);
    private JTextField monthTextField = new JTextField(10);
    private JTextField maxTextField = new JTextField(10);
    private JTextField minTextField = new JTextField(10);

    public SearchOrDelete(JDialog dialog)
    {
        this.dialog = dialog;
    }

    public JDialog oneDialog()
    {
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        JLabel selectionVariant = new JLabel("Выберите условие: ");

        ButtonGroup buttongroup = new ButtonGroup();

        panel.add(selectionVariant, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel.add(radiobutBirthday1, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel.add(radiobutReceipt1, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel.add(radiobutExpiration1, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        buttongroup.add(radiobutBirthday1);

        buttongroup.add(radiobutReceipt1);

        buttongroup.add(radiobutExpiration1);

        JPanel panelText = new JPanel();

        panelText.setLayout(new GridBagLayout());

        JLabel surNameLabel = new JLabel("Введите фамилию: ");

        panelText.add(surNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelText.add(surNameTextField, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel firstNameLabel = new JLabel("Введите имя: ");

        panelText.add(firstNameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelText.add(firstNameTextField, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel middleNameLabel = new JLabel("Введите отчество: ");

        panelText.add(middleNameLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelText.add(middleNameTextField, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JLabel dayLabel = new JLabel("Введите день: ");

        panelText.add(dayLabel, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelText.add(dayTextField, new GridBagConstraints(3, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panelText, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        return  dialog;
    }

    public JRadioButton getRadiobutBirthday1()
    {
        return radiobutBirthday1;
    }

    public JRadioButton getRadiobutReceipt1()
    {
        return radiobutReceipt1;
    }

    public JRadioButton getRadiobutExpiration1()
    {
        return radiobutExpiration1;
    }

    public String getsurNameText()
    {
        return surNameTextField.getText();
    }

    public String getfirstNameText()
    {
        return firstNameTextField.getText();
    }

    public String getmiddleNameText()
    {
        return middleNameTextField.getText();
    }

    public String getDay()
    {
        return dayTextField.getText();
    }


    public boolean CheckOne()
    {
        boolean b = false;
        if((surNameTextField.getText().equals(""))||(firstNameTextField.getText().equals(""))
                ||(middleNameTextField.getText().equals(""))||(dayTextField.getText().equals(""))) {
            JOptionPane.showMessageDialog(new Frame(), "Заполните все необходимые поля. Для продолжения работы нажмите \"ОК\"");
        }
        else b = true;
        return b;
    }

    public boolean CheckTwo() {
        boolean b = false;
        if ((dayTextField.getText().equals("")) || (minTextField.getText().equals("") || (maxTextField.getText().equals("")))){
            JOptionPane.showMessageDialog(new Frame(), "Заполните все необходимые поля. Для продолжения работы нажмите \"ОК\"");
        }
        else b = true;
        return b;
    }

    public boolean CheckThree()
    {
        boolean b = false;
        if((dayTextField.getText().equals(""))||(monthTextField.getText().equals(""))) {
            JOptionPane.showMessageDialog(new Frame(), "Заполните все необходимые поля. Для продолжения работы нажмите \"ОК\"");
        }
        else b = true;
        return b;
    }
}
