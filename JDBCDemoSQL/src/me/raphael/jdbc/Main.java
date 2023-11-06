package me.raphael.jdbc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Main {
    private JFrame frame;
    private JTextField masvField;
    private JTextField hotenField;
    private JButton nhapButton;
    private JButton suaButton;
    private JButton xoaButton;
    private JButton thoatButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection connection;

    public Main() {
        initialize();
        connectToDatabase();
        loadSinhVienData();
    }

    private void initialize() {
        frame = new JFrame("Quản lý sinh viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 750, 400);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        masvField = new JTextField(10);
        hotenField = new JTextField(20);
        nhapButton = new JButton("Nhập");
        suaButton = new JButton("Sửa");
        xoaButton = new JButton("Xoá");
        thoatButton = new JButton("Thoát");

        panel.add(new JLabel("Mã SV: "));
        panel.add(masvField);
        panel.add(new JLabel("Họ tên: "));
        panel.add(hotenField);
        panel.add(nhapButton);
        panel.add(suaButton);
        panel.add(xoaButton);
        panel.add(thoatButton);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã SV");
        tableModel.addColumn("Họ tên");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);

        nhapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themSinhVien();
            }
        });

        suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaSinhVien();
            }
        });

        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaSinhVien();
            }
        });

        thoatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thoatChuongTrinh();
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    hienThongTinSinhVien(row);
                }
            }
        });
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/QLSV2", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSinhVienData() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Sinhvien");
            while (rs.next()) {
                String masv = rs.getString("masv");
                String hoten = rs.getString("hoten");
                tableModel.addRow(new Object[]{masv, hoten});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void themSinhVien() {
        String masv = masvField.getText();
        String hoten = hotenField.getText();
        if (!masv.isEmpty() && !hoten.isEmpty()) {
            try {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Sinhvien (masv, hoten) VALUES (?, ?)");
                pstmt.setString(1, masv);
                pstmt.setString(2, hoten);
                pstmt.executeUpdate();
                tableModel.addRow(new Object[]{masv, hoten});
                masvField.setText("");
                hotenField.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void suaSinhVien() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String masv = masvField.getText();
            String hoten = hotenField.getText();
            if (!masv.isEmpty() && !hoten.isEmpty()) {
                try {
                    String oldMasv = tableModel.getValueAt(selectedRow, 0).toString();
                    PreparedStatement pstmt = connection.prepareStatement("UPDATE Sinhvien SET masv=?, hoten=? WHERE masv=?");
                    pstmt.setString(1, masv);
                    pstmt.setString(2, hoten);
                    pstmt.setString(3, oldMasv);
                    pstmt.executeUpdate();
                    tableModel.setValueAt(masv, selectedRow, 0);
                    tableModel.setValueAt(hoten, selectedRow, 1);
                    masvField.setText("");
                    hotenField.setText("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void xoaSinhVien() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String masv = tableModel.getValueAt(selectedRow, 0).toString();
                PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Sinhvien WHERE masv=?");
                pstmt.setString(1, masv);
                pstmt.executeUpdate();
                tableModel.removeRow(selectedRow);
                masvField.setText("");
                hotenField.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void hienThongTinSinhVien(int row) {
        masvField.setText(tableModel.getValueAt(row, 0).toString());
        hotenField.setText(tableModel.getValueAt(row, 1).toString());
    }

    private void thoatChuongTrinh() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
