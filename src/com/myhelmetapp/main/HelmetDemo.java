package com.myhelmetapp.main;

import java.util.List;
import java.util.Scanner;

import com.myhelmetapp.model.Helmet;
import com.myhelmetapp.service.HelmetServiceImpl;

public class HelmetDemo {

	public static void main(String[] args) {
		HelmetServiceImpl service= new HelmetServiceImpl();
		Helmet h = null;
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("Welcome to helmet App");
			System.out.println("**********************");
			System.out.println("1. Add helmet");
			System.out.println("2. View helmet");
			System.out.println("3. Search helmet");
			System.out.println("4. Update helmet");
			System.out.println("5. Delete helmet");
			System.out.println("6. Delete All helmet");
			System.out.println("0. Exit");
			option = in.nextInt();


			String searchBrand;
			Helmet searchHelmet;
			switch (option) {
			case 1:
				System.out.println("ADD NEW Helmet");
				System.out.println("---------------");
				System.out.println("please enter Brand: ");
				String Brand = in.next();
				System.out.println("Please enter Price: ");
				int Price = in.nextInt();
				System.out.println("Please enter Colour: ");
				String Colour = in.next();
				System.out.println("Please enter Star_rating: ");
				String Star_rating = in.next();

				h = new Helmet();
				h.setBrand(Brand);
				h.setPrice(Price);
				h.setColour(Colour);
				h.setStar_rating(Star_rating);
				int status = service.addHelmet(h);
				if(status == 1) {
					System.out.println("new helmet added!!!");
				}else {
					System.out.println("Something went Wrong!!!");
				}

				break;

			case 2:
				System.out.println("View All helmet");
				List<Helmet> Helmets = service.findHelmet();
				System.out.println("BRAND \t PRICE \t COLOUR \t STAR_RATING");
				System.out.println("-----     \t------  \t-------  \t-----  \t");
				for(Helmet helmet : Helmets) {
					System.out.println(helmet.getBrand()+"\t"+helmet.getPrice()+"\t"+helmet.getColour()+"\t"+helmet.getStar_rating());

				}

				break;

			case 3:
				System.out.println("Enter the Helmet Brand: ");
				searchBrand = in.next();
				searchHelmet = service.findHelmetByName(searchBrand);
				if(searchHelmet != null) {
					System.out.println("Id: "+searchHelmet.getId());
					System.out.println("Brand: "+searchHelmet.getBrand());
					System.out.println("Price: "+searchHelmet.getPrice());
					System.out.println("Colour: "+searchHelmet.getColour());
					System.out.println("Star_rating: "+searchHelmet.getStar_rating());
				}else {
					System.out.println("No Helmet found!!!");
				}

				break;
			case 4:
				System.out.println("Update Helmet");
				System.out.println("Please enter Helmet Brand:");
				searchBrand = in.next();
				searchHelmet = service.findHelmetByName(searchBrand);
				if(searchHelmet != null) {
					System.out.println("Id:" +searchHelmet.getId());
					System.out.println("Brand:" +searchHelmet.getBrand());
					System.out.println("Price:" +searchHelmet.getPrice());
					System.out.println("Colour:" +searchHelmet.getColour());
					System.out.println("Star_rating:" +searchHelmet.getStar_rating());
					//Reading helmet update info
					System.out.println("Please enter updated Brand:");
					Brand = in.next();
					System.out.println("Please enter updated Price:");
					Price = in.nextInt();
					System.out.println("Please enter updated Colour:");
					Colour = in.next();

					System.out.println("Please enter updated star_rating:");
					Star_rating = in.next();
					Helmet updateHelmet = new Helmet();

					updateHelmet.setBrand(Brand);
					updateHelmet.setPrice(Price);
					updateHelmet.setColour(Colour);
					updateHelmet.setStar_rating(Star_rating);
					updateHelmet.setId(searchHelmet.getId());

					int updateStatus = service.updateHelmet (updateHelmet);

					if(updateStatus == 1) {
						System.out.println("Helmet updated successfully");
					}
					else{
						System.out.println("Something is wrong");
					}
				}
				else {
					System.out.println("No Helmet found with name");
				}
				break;

			case 5:
				System.out.println("Delete Helmet");
				System.out.println("Please enter Helmet Brand:");

				searchBrand = in.next();
				searchHelmet = service.findHelmetByName(searchBrand);
				if(searchHelmet != null) {
					int deleteStatus = service.deleteHelmetByName(searchBrand);
					if(deleteStatus == 1) {
						System.out.println("Helmet Deleted Successfully");
					}
					else {
						System.out.println("Something is wrong");
					}
				}else {
					System.out.println("No Helmet found");
				}
				break;

			case 6:
				System.out.println("ARE YOU SURE Delete All Helmet?[y/n]");
				String deleteConfirmStatus = in.next();
				if(deleteConfirmStatus.equalsIgnoreCase("y")) {
					service.deleteallHelmet();
					System.out.println("All Helmet Deleted!");
				}



				break;
			case 0:
				System.out.println("Bye!!!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option!!!");
				break;
			}
		} while(option != 0);

	}
}
