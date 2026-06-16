package org.example;

import org.example.frontend.Function;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        register();
//        List<Candidate> candidates = new ArrayList<>();
//        Candidate candidate1 = new Candidate(1,"first", "last", "phone", "mail", "password", Role.EXPERIENCECANDIDATE);
//        candidates.add(candidate1);
//        candidates.add(candidate1);
//        candidates.add(candidate1);
//        candidates.add(candidate1);
//        candidates.add(candidate1);
//        candidates.add(candidate1);
//        System.out.println("+-----+---------------+---------------+---------------+---------------+---------------+-------------------------+");
//        System.out.printf("|%5s|%15s|%15s|%15s|%15s|%15s|%25s|\n", "ID", "First Name", "Last Name", "Phone", "Mail", "Password", "ROLE");
//
//        for (Candidate candidate : candidates) {
//            System.out.println("+-----+---------------+---------------+---------------+---------------+---------------+-------------------------+");
//            System.out.printf("|%5s|%15s|%15s|%15s|%15s|%15s|%25s|\n", candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getPhone(), candidate.getEmail(), candidate.getPassword(), candidate.getRole().name());
//            System.out.println(candidate);
//        }
//        System.out.println("+-----+---------------+---------------+---------------+---------------+---------------+-------------------------+");
    }

    public static void register() throws ClassNotFoundException, SQLException {
        Function function = new Function();
        System.out.println("Mời bạn đăng kí.\n 1. Đăng kí ExperienceCandidate  \n 2. Đăng kí FresherCandidate \n 3. Đăng nhập");
        int n = scanner.nextInt();
        scanner.nextLine();

        switch (n) {
            case 1:
                function.addExperienceCandidate();
                break;

            case 2:
                function.addFresherCandidate();
                break;
            case 3:
                function.login();
                break;
        }
        System.out.println("Mời bạn đăng nhập");
        function.login();

    }}
