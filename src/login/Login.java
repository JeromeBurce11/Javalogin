/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author burceje_sd2023
 */
public class Login {

    public int age;
    public String fname;
    public String lname;

    //LoginClass a = new LoginClass();
    Scanner input = new Scanner(System.in);
    static int id = 1;

    public boolean isString(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void courseUnitSched() {

        while (true) {
            System.out.println("You want to add a subject?\nPress 1 = if yes\nPress 0 = if no");
            int ans = input.nextInt();
            try {
                if (ans == 1) {
                    System.out.print("Course: ");
                    String course = input.next();
                    System.out.print("Units: ");
                    String units = input.next();
                    System.out.print("Schedule: ");
                    String schedule = input.next();

                    FileWriter fWriter = new FileWriter("schedule.txt", true);

                    PrintWriter writer = new PrintWriter(fWriter);
                    BufferedReader reader = new BufferedReader(new FileReader("Schedule.txt"));
                    String line = reader.readLine();
                    int ids=0;
                    while (line != null) {
                        if (line.length() != 0) {
                            ids++;
                            //  ++accID;
                        }
                        line = reader.readLine();
                    }
                    writer.println(ids + "\t" + id + "\t" + course + "\t" + units + "\t" + schedule + "\n");

                    writer.close();

                    throw new Exception("Your schedule was been saved.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void personalInformation() {
        try {
            this.checkFname();
            this.checkLname();
            this.checkAge();

            FileWriter fWriter = new FileWriter("personalInformation.txt", true);
            PrintWriter writer = new PrintWriter(fWriter);

            writer.println(id + "\t" + fname + "\t" + lname + "\t" + age + "\n");

            writer.close();
        } catch (Exception e) {
            System.out.println(" input is require!");

        }
    }

    public void AddUserPass() {
        String username;
        boolean status = true;
        while (status) {
            System.out.print("Username: ");
            try {

                username = input.next();
                if (isString(username) == true) {
                    System.out.println("Invalid input!");

                } else {

                    while (true) {
                        try {
                            System.out.print("Password: ");
                            String password = input.next();
                            if (password.length() < 8) {
                                throw new Exception("Password must have 8 characters!");
                            } else {
                                while (true) {
                                    System.out.print("Confirm Password: ");
                                    String password1 = input.next();
                                    if (password.equals(password1)) {
                                        System.out.println(" password match!");
                                        FileWriter fWriter = new FileWriter("Account.txt", true);
                                        BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                                        String line = reader.readLine();
                                        while (line != null) {
                                            if (line.length() != 0) {
                                                ++id;
                                                //  ++accID;
                                            }
                                            line = reader.readLine();
                                        }
                                        PrintWriter writer = new PrintWriter(fWriter);
                                        writer.println(id + "\t" + username + "\t" + password + "\n");

                                        writer.close();

                                        status = false;
                                        break;

                                    } else {
                                        System.out.println(" Mismatch password!");
                                    }
                                }
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }

                    }
                }
            } catch (Exception e) {
                break;
            }

        }
    }

    public void checkAge() {

        String ageS;
        while (true) {
            System.out.println("age: ");
            Scanner age = new Scanner(System.in);
            try {
                ageS = age.nextLine();
                Integer.parseInt(ageS);
                break;
            } catch (Exception e) {
                System.out.println("invalid input!");
            }
        }
        this.age = Integer.parseInt(ageS);
    }

    public void checkFname() {
        String FName = null;

        while (true) {
            System.out.println("enter Firstname: ");
            Scanner firstname = new Scanner(System.in);
            try {
                FName = firstname.nextLine();
                Integer.parseInt(FName);
                System.out.println("try again! ");

            } catch (Exception e) {
                break;

            }

        }
        this.fname = FName;
    }

    public void checkLname() {
        String LName = null;
        while (true) {
            System.out.println("enter Lastname: ");
            Scanner lastname = new Scanner(System.in);
            try {
                LName = lastname.nextLine();
                Integer.parseInt(LName);
                System.out.println("try again! ");

            } catch (Exception e) {
                break;

            }

        }
        this.lname = LName;
    }

    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);
        Login j = new Login();
        boolean x = true;
        while (x == true) {

            j.AddUserPass();
            j.personalInformation();
            j.courseUnitSched();
            try {
                System.out.println("do you want to exit?enter 1");
                int ans = write.nextInt();
                if (ans == 1) {
                    x = false;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("please enter a number");

            }
        }

    }

}
