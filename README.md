# Customized_DBMS - DBMSGUI

## Description
DBMSGUI is a graphical user interface application built in Java to manage student records. It allows users to:
- Insert student data such as name, age, and marks.
- View all student records.
- Delete student records based on the roll number.
- Calculate and display various aggregate statistics, such as:
  - Maximum marks
  - Minimum marks
  - Average marks
  - Sum of marks

## Features
- **Insert Student Record**: Add a new student by providing the name, age, and marks.
- **View All Records**: Display all stored student records in a readable format.
- **Delete Record**: Delete a student record based on the roll number.
- **Aggregate Statistics**: Display statistics such as:
  - Maximum Marks
  - Minimum Marks
  - Sum of Marks
  - Average Marks

## Requirements
- **Java 8 or higher**: The application is built using Java and requires at least Java 8.
- **IDE**: Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or the command line for compilation.

## Setup and Usage

### 1. Compile and Run the Application

1. Open the project in your preferred Java IDE or use the terminal.
2. Compile the Java files:
   - If using a terminal, navigate to the project folder and run:
     ```bash
     javac DBMSGUI.java
     ```
3. Run the application:
   - If using a terminal, run:
     ```bash
     java DBMSGUI
     ```

This will launch the GUI of the Student Database Management System.

### 2. Using the Application

The application will have the following fields and buttons:

- **Name**: Enter the student's name.
- **Age**: Enter the student's age.
- **Marks**: Enter the student's marks.
- **Rno to Delete**: Enter the roll number of the student to delete.

#### Buttons:
- **Insert**: Adds the student record to the database.
- **View All**: Displays all student records.
- **Delete by Rno**: Deletes the student record based on the roll number.
- **Max Marks**: Displays the highest marks among all students.
- **Min Marks**: Displays the lowest marks among all students.
- **Avg Marks**: Displays the average marks of all students.
- **Sum Marks**: Displays the total sum of marks of all students.

## Code Structure
- **Student Class**: Represents a student with properties like roll number, name, age, and marks. The roll number is auto-generated using a static variable.
- **DBMS Class**: Manages the list of student records. It supports operations such as inserting a record, deleting a record, and calculating aggregates (max, min, sum, and average).
- **DBMSGUI Class**: The main class that creates the GUI interface for interacting with the DBMS. It handles button clicks and user input.

## Example Output

### If you add records and click on "View All":
```
Rno   Name      Age   Marks
------------------------------
1      Sanket    20    85
2      Rahul     21    92
3      Rishi     22    78
```

### If you click on "Max Marks":
```
Maximum Marks: 92
```

### If you click on "Min Marks":
```
Minimum Marks: 78
```

### If you click on "Avg Marks":
```
Average Marks: 85.0
```

### If you click on "Sum Marks":
```
Sum of Marks: 255
```
