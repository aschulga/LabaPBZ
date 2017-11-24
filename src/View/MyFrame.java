package View;

import Connection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {

    private String title;
    private Dimension d;
    private JFrame frame = new JFrame();

    DBConnection connect;

    JToolBar tb = new JToolBar();
    JButton createButton = new JButton(new ImageIcon("1.png"));
    JButton openButton = new JButton(new ImageIcon("2.png"));
    JButton searchButton = new JButton(new ImageIcon("4.png"));
    JButton deleteButton = new JButton(new ImageIcon("5.png"));
    JButton offButton = new JButton(new ImageIcon("6.png"));

    private JMenuBar menubar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Файл");
    private JMenu searchMenu = new JMenu("Поиск");
    private JMenu deleteMenu = new JMenu("Удаление");

    private JMenuItem createMenuItem = new JMenuItem("Создать");
    private JMenuItem openMenuItem = new JMenuItem("Открыть");
    private JMenuItem exitMenuItem = new JMenuItem("Выход");

    private JMenuItem searchMenuItem = new JMenuItem("Найти студента");
    private JMenuItem deleteMenuItem = new JMenuItem("Удалить студента");

    private ModelTable model = new ModelTable();
    private JTable table = new JTable(model);
    private JScrollPane jsp = new JScrollPane(table);

    public MyFrame(String title, Dimension d, DBConnection connect) {
        this.title = title;
        this.d = d;
        this.connect = connect;
    }

    public void init() {
        frame.setTitle(title);
        frame.setSize(d);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(jsp, BorderLayout.CENTER);
        jsp.setPreferredSize(new Dimension(700, 500));


        tb.add(createButton);
        tb.add(openButton);
        tb.add(searchButton);
        tb.add(deleteButton);
        tb.add(offButton);

        frame.getContentPane().add(tb, BorderLayout.NORTH);


        openButton.addActionListener(new openActionListener());
        openMenuItem.addActionListener(new openActionListener());

        createButton.addActionListener(new createActionListener());
        createMenuItem.addActionListener(new createActionListener());

        deleteButton.addActionListener(new deleteActionListener());
        deleteMenuItem.addActionListener(new deleteActionListener());

        searchButton.addActionListener(new searchActionListener());
        searchMenuItem.addActionListener(new searchActionListener());

        offButton.addActionListener(new offActionListener());

        createMenuItem.setIcon(new ImageIcon("1.png"));
        openMenuItem.setIcon(new ImageIcon("2.png"));
        exitMenuItem.setIcon(new ImageIcon("6.png"));

        fileMenu.add(createMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);

        searchMenuItem.setIcon(new ImageIcon("4.png"));
        deleteMenuItem.setIcon(new ImageIcon("5.png"));

        searchMenu.add(searchMenuItem);
        deleteMenu.add(deleteMenuItem);

        menubar.add(fileMenu);
        menubar.add(searchMenu);
        menubar.add(deleteMenu);
        frame.setJMenuBar(menubar);

        frame.setVisible(true);
        frame.pack();
    }

    public void generationTable(String name)
    {
        model.addData(connect, name);
    }

    public JScrollPane getJsp()
    {
        return jsp;
    }

    public class openActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generationTable("tableOfStudents");
            frame.repaint();
        }
    }

    public class createActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DialogCreate addStudentDialog = new DialogCreate(MyFrame.this, connect);
            addStudentDialog.create();
        }
    }

    public class deleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DialogDelete searchStudentDialog = new DialogDelete(MyFrame.this, connect);
            searchStudentDialog.delete();
        }
    }

    public class searchActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DialogSearch searchStudentDialog = new DialogSearch(connect, MyFrame.this);
            searchStudentDialog.search();
        }
    }

    public class offActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}


