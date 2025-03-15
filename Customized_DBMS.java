import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

class Student {
    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static {
        Generator = 0;
    }

    public Student(String str, int X, int Y) {
        this.Rno = ++Generator;
        this.Name = str;
        this.Age = X;
        this.Marks = Y;
    }

    public void Display() {
        System.out.println(this.Rno + " " + this.Name + " " + this.Age + " " + this.Marks);
    }
}

class DBMS {
    public LinkedList<Student> lobj;

    public DBMS() {
        lobj = new LinkedList<Student>();
    }

    public void InsertIntoTable(String name, int age, int marks) {
        Student sobj = new Student(name, age, marks);
        lobj.add(sobj);
    }

    public void SelectFrom(JTextArea display) {
        display.setText("");
        display.append("Rno\tName\tAge\tMarks\n");
        display.append("------------------------------\n");
        for (Student sref : lobj) {
            display.append(sref.Rno + "\t" + sref.Name + "\t" + sref.Age + "\t" + sref.Marks + "\n");
        }
    }

    public void DeleteFrom(int no) {
        boolean found = false;
        for (Student sref : lobj) {
            if (sref.Rno == no) {
                lobj.remove(sref);
                found = true;
                break;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Record Not Found!");
        }
    }

    public int Aggregate_Max() {
        if (lobj.isEmpty())
            return 0;
        int max = lobj.get(0).Marks;
        for (Student sref : lobj) {
            if (sref.Marks > max) {
                max = sref.Marks;
            }
        }
        return max;
    }

    public int Aggregate_Min() {
        if (lobj.isEmpty())
            return 0;
        int min = lobj.get(0).Marks;
        for (Student sref : lobj) {
            if (sref.Marks < min) {
                min = sref.Marks;
            }
        }
        return min;
    }

    public int Aggregate_Sum() {
        int sum = 0;
        for (Student sref : lobj) {
            sum += sref.Marks;
        }
        return sum;
    }

    public float Aggregate_Avg() {
        if (lobj.isEmpty())
            return 0;
        return (float) Aggregate_Sum() / lobj.size();
    }
}

public class DBMSGUI extends JFrame implements ActionListener {
    // GUI Components
    JTextField txtName, txtAge, txtMarks, txtRno;
    JTextArea txtDisplay;
    JButton btnInsert, btnView, btnDelete, btnMax, btnMin, btnAvg, btnSum;

    // DBMS Object
    DBMS db = new DBMS();

    public DBMSGUI() {
        // Setting up the Frame
        setTitle("Marvellous DBMS");
        setSize(650, 600);
        setLayout(new FlowLayout());

        // Input Fields
        txtName = new JTextField(10);
        txtAge = new JTextField(5);
        txtMarks = new JTextField(5);
        txtRno = new JTextField(5);

        // Display Area
        txtDisplay = new JTextArea(20, 50);
        txtDisplay.setEditable(false);

        // Buttons
        btnInsert = new JButton("Insert");
        btnView = new JButton("View All");
        btnDelete = new JButton("Delete by Rno");
        btnMax = new JButton("Max Marks");
        btnMin = new JButton("Min Marks");
        btnAvg = new JButton("Avg Marks");
        btnSum = new JButton("Sum Marks");

        // Adding Components to Frame
        add(new JLabel("Name:"));
        add(txtName);
        add(new JLabel("Age:"));
        add(txtAge);
        add(new JLabel("Marks:"));
        add(txtMarks);
        add(btnInsert);

        add(new JLabel("Rno to Delete:"));
        add(txtRno);
        add(btnDelete);

        add(btnView);
        add(btnMax);
        add(btnMin);
        add(btnAvg);
        add(btnSum);

        add(new JScrollPane(txtDisplay));

        // Adding Action Listeners
        btnInsert.addActionListener(this);
        btnView.addActionListener(this);
        btnDelete.addActionListener(this);
        btnMax.addActionListener(this);
        btnMin.addActionListener(this);
        btnAvg.addActionListener(this);
        btnSum.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsert) {
            try {
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                int marks = Integer.parseInt(txtMarks.getText());
                db.InsertIntoTable(name, age, marks);
                txtDisplay.setText("Record Inserted Successfully!");
                txtName.setText("");
                txtAge.setText("");
                txtMarks.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input! Please check the fields.");
            }
        } else if (e.getSource() == btnView) {
            db.SelectFrom(txtDisplay);
        } else if (e.getSource() == btnDelete) {
            try {
                int rno = Integer.parseInt(txtRno.getText());
                db.DeleteFrom(rno);
                txtRno.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Roll Number!");
            }
        } else if (e.getSource() == btnMax) {
            int max = db.Aggregate_Max();
            txtDisplay.setText("Maximum Marks: " + max);
        } else if (e.getSource() == btnMin) {
            int min = db.Aggregate_Min();
            txtDisplay.setText("Minimum Marks: " + min);
        } else if (e.getSource() == btnAvg) {
            float avg = db.Aggregate_Avg();
            txtDisplay.setText("Average Marks: " + avg);
        } else if (e.getSource() == btnSum) {
            int sum = db.Aggregate_Sum();
            txtDisplay.setText("Sum of Marks: " + sum);
        }
    }

    public static void main(String[] args) {
        new DBMSGUI();
    }
}
