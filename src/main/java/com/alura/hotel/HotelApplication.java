package com.alura.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import views.MenuPrincipal;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {

		MenuPrincipal mp= new MenuPrincipal();
		mp.setVisible(true);
		SpringApplication.run(HotelApplication.class, args);
	}

}
