package com.vadym.pet.project;

import com.vadym.pet.project.clients.ClinicClient;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException{
        Scanner scanner = new Scanner(System.in);
        ClinicClient clinicClient = new ClinicClient();
        String registrationKey = "";

        System.out.println("Hello Paziki. \nYou can choose next options: \n**************************");

        String key = "";
        while(!key.equals("out")) {
            System.out.println("Type 1 to get RegKey \nType 2 to create clinic \nType out to quit the program");
            key = scanner.next();
            switch (key) {
                case "1":
                    registrationKey = clinicClient.getRegKey();
                    break;
                case "2":
                    if(!registrationKey.equals("")) {
                        clinicClient.createClinic(registrationKey);
                    }
                    else{
                        System.out.println("Use first request to get RegKey 'cause now its empty");
                    }
                    break;
                case "out":
                    break;
                default:
                    System.out.println("what on earth are you imputing, dummy? Try again \n**************************");

            }
        }

    }
}
