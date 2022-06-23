package com.example.demo;

import com.example.demo.model.Spid;
import com.example.demo.model.User;
import com.example.demo.service.SpidService;
import com.example.demo.service.UserService;
import com.example.demo.utils.Status;
import com.example.demo.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpidApplication implements CommandLineRunner {
	@Autowired
	public UserService userService;

	@Autowired
	public SpidService spidService;

	public static void main(String[] args) {
		SpringApplication.run(SpidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Creating a user
			User newUser = userService.createUser("Bjoni", "Merkuri", "bmerkuri","bmerkuri@unitsystem.net","12345678","bjoni123");
			System.out.println(newUser);

			// Creating a spid
			Spid newSpid = spidService.createsSpid(newUser);
			System.out.println(newSpid);

			// Aprove SPID with the id of 1
			spidService.aproveSpid(1);

			// Display the list of spids
			spidService.showList();

			// Showing SPID of a user
			System.out.println(userService.showSpidOf("bmerkuri"));

			System.out.println("Modifying user with the user of 'bmerkuri'");
			// Modify user (Only the surname)
			userService.modifyUser("bmerkuri", "jhfhdf", "Merkuri","bjonimerkuri1@gmail.com","876543321","1234bjoni");

			// Modify spid
			System.out.println("Modify the SPID with the id of 1 ");
			spidService.modifySpid(1, Status.READY_FOR_REVIEW, Type.LEVEL_1);
			System.out.println(newSpid);
		} catch (Exception err) {
			System.out.println("There was an error!");
		}
	}

}
