package com.jhonathan.view;

import com.jhonathan.dao.DepartmentDaoImpl;
import com.jhonathan.dao.StudentDaoImpl;
import com.jhonathan.entity.Department;
import com.jhonathan.entity.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */
public class MainForm {
    private JTextField txtId;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextArea txtAddress;
    private JComboBox<Department> comboDepartment;
    private JButton btnAddDepartment;
    private JButton btnUpdate;
    private JButton btnReset;
    private JButton btnSave;
    private JTable tableStudent;
    private JSplitPane rootPanel;
    private JButton btnDelete;
    private DepartmentDaoImpl departmentDao;
    private StudentDaoImpl studentDao;
    private List<Department> departments;
    private List<Student> students;
    private DefaultComboBoxModel<Department> departmentComboBoxModel;
    private StudentTableModel studentTableModel;
    private Student selectedStudent;

    public MainForm(){
        departmentDao = new DepartmentDaoImpl();
        studentDao = new StudentDaoImpl();
        departments = new ArrayList<>();
        students = new ArrayList<>();
        try {
            departments.addAll(departmentDao.fetchAll());
            students.addAll(studentDao.fetchAll());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        departmentComboBoxModel = new DefaultComboBoxModel<>(departments.toArray(new Department[0]));
        comboDepartment.setModel(departmentComboBoxModel);
        studentTableModel = new StudentTableModel(students);
        tableStudent.setModel(studentTableModel);
        tableStudent.setAutoCreateRowSorter(true);

        btnAddDepartment.addActionListener(e -> {
            String newDepartment = JOptionPane.showInputDialog(rootPanel, "New department name");
            if (newDepartment != null && !newDepartment.trim().isEmpty()){
                Department department = new Department();
                department.setName(newDepartment);
                try {
                    if (departmentDao.addData(department) == 1){
                        departments.clear();
                        departments.addAll(departmentDao.fetchAll());
                        departmentComboBoxModel.removeAllElements();
                        departmentComboBoxModel.addAll(departments);
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnSave.addActionListener(e -> {
            if (txtId.getText().trim().isEmpty() || txtFirstName.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || comboDepartment.getSelectedItem() == null){
                JOptionPane.showMessageDialog(rootPanel, "Please fill id, first name, address, " + "and department","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = new Student();
                student.setId(txtId.getText());
                student.setFirstName(txtFirstName.getText());
                student.setLastName(txtLastName.getText().trim().isEmpty() ? null : txtLastName.getText());
                student.setAddress(txtAddress.getText());
                student.setDepartment((Department) comboDepartment.getSelectedItem());
                try {
                    if (studentDao.addData(student) == 1){
                        students.clear();
                        students.addAll(studentDao.fetchAll());
                        studentTableModel.fireTableDataChanged();
                        clearAndReset();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnReset.addActionListener(e -> {
            clearAndReset();
        });
        btnUpdate.addActionListener(e -> {
            if (txtFirstName.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || comboDepartment.getSelectedItem() == null){
                JOptionPane.showMessageDialog(rootPanel, "Please fill first name, address, and department","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                selectedStudent.setAddress(txtAddress.getText());
                selectedStudent.setFirstName(txtFirstName.getText());
                selectedStudent.setLastName(txtFirstName.getText().trim().isEmpty() ? null : txtLastName.getText());
                selectedStudent.setDepartment((Department) comboDepartment.getSelectedItem());
                try {
                    if (studentDao.updateData(selectedStudent) == 1){
                        students.clear();
                        students.addAll(studentDao.fetchAll());
                        studentTableModel.fireTableDataChanged();
                        clearAndReset();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        tableStudent.getSelectionModel().addListSelectionListener(e -> {
            if (!tableStudent.getSelectionModel().isSelectionEmpty()){
                int selectedIndex = tableStudent.convertRowIndexToModel(tableStudent.getSelectedRow());
                selectedStudent = students.get(selectedIndex);
            }
            if (selectedStudent != null){
                txtId.setText(selectedStudent.getId());
                txtFirstName.setText(selectedStudent.getFirstName());
                txtLastName.setText(selectedStudent.getLastName() != null ? selectedStudent.getLastName() : "");
                txtAddress.setText(selectedStudent.getAddress());
                comboDepartment.setSelectedItem(selectedStudent.getDepartment());
                txtId.setEnabled(false);
                btnSave.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        });
        btnDelete.addActionListener(e -> {
            try {
                if (studentDao.deleteData(selectedStudent) == 1){
                    students.clear();
                    students.addAll(studentDao.fetchAll());
                    studentTableModel.fireTableDataChanged();
                    clearAndReset();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void clearAndReset(){
        txtId.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtId.setEnabled(true);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        tableStudent.clearSelection();
        selectedStudent = null;
    }

    private static class StudentTableModel extends AbstractTableModel {
        private List<Student> students;
        private final String[] COLUMNS = {"ID","FIRST NAME","LAST NAME","DEPARTMENT"};

        private StudentTableModel(List<Student> students) {
            this.students = students;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> students.get(rowIndex).getId();
                case 1 -> students.get(rowIndex).getFirstName();
                case 2 -> students.get(rowIndex).getLastName();
                case 3 -> students.get(rowIndex).getDepartment().getName();
                default -> "";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }
            return Object.class;
        }
    }
}
