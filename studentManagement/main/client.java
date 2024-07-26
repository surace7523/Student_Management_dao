package studentManagement.main;

import studentManagement.dao.StudentDao;
import studentManagement.dao.StudentDaoInterface;
import studentManagement.model.Student;

import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        StudentDaoInterface dao = new StudentDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Management Application");

        while(true){

            System.out.println("\n1.Add Student"+"\n2.Show All  Students"+
                    "\n3.Get Student Based on roll Number"+"\n4.Delete Student"+
                    "\n5.Update Student"+"\n6.Exit Application");

            System.out.println("Enter your option");
            int choice = sc.nextInt();

            switch(choice){

                case 1:{
                    System.out.println("Please Enter the details below to Add Student");
                    System.out.println("Enter your Name\n");
                    String name = sc.next();
                    System.out.println("Enter your college Name\n");
                    String clgName= sc.next();
                    System.out.println("Enter your city\n");
                    String city= sc.next();
                    System.out.println("Enter your percentage\n");
                    double percentage = sc.nextDouble();

                    Student st = new Student(name,clgName,city,percentage);

                    boolean ans = dao.insertStudent(st);
                    System.out.println(ans);
                    if(ans){

                        System.out.println("Record has been inserted successfully!!!!");
                    }else {
                        System.out.println("please try again something went wrong!!!!");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Show All  Students");
                    dao.showAllStudent();
                    break;
                }
                case 3:{
                    System.out.println("Get Student Based on roll Number");
                    System.out.println("Enter the Roll Number: ");
                    int roll = sc.nextInt();
                    boolean f = dao.showStudentById(roll);
                    if(!f){
                        System.out.println("Student with this id is not available");
                    }
                    break;
                }
                case 4:{
                    System.out.println("Delete Student");
                    System.out.println("Enter the Roll Number: ");
                    int roll = sc.nextInt();
                    boolean ff = dao.delete(roll);
                    if(ff){
                        System.out.println("Record deleted successfully...");
                    }else {
                        System.out.println("something went wrong......");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Update Student");
                    System.out.println("\n1.Update name \n2.Update collegeName");
                    System.out.println("Enter choice");
                    int Choice= sc.nextInt();
                    if(Choice==1){
                        System.out.println("Enter rollnumber");
                        int  rnum = sc.nextInt();
                        System.out.println("Enter name");
                        String sname = sc.next();
                        Student std = new Student();
                        std.setName(sname);
                        Boolean flag = dao.update(rnum,sname,Choice,std);

                        if(flag){
                            System.out.println("Name updated successfully");
                        }
                        else{
                            System.out.println("Something went wrong....");
                        }

                    }
                    break;
                }
                case 6:{
                    System.out.println("Exiting from the Application Thank you!!!!!");
                    System.exit(0);
                    break;
                }

                default:{

                    System.out.println("Enter valid number to proceed");
                }


            }
        }
    }
}
