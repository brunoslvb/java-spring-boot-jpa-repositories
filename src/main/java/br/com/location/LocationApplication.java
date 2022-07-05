package br.com.location;

import br.com.location.domain.entities.City;
import br.com.location.domain.repositories.CityRepository;
import br.com.location.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationApplication implements CommandLineRunner {

	@Autowired
	private CityService cityService;

	@Override
	public void run(String... args) throws Exception {

		cityService.listAllCities();
		System.out.println();
		cityService.listCitiesByName();
		System.out.println();
		cityService.listCitiesByNameSort();
		System.out.println();
		cityService.listCitiesByNamePageable();
		System.out.println();
		cityService.listCitiesByPopulation();
		System.out.println();
		cityService.dynamicFilter(City.builder().name("s").build());
		System.out.println();
		cityService.listCitiesByNameSpec();
		System.out.println();
		cityService.listCitiesSpecsDynamicFilter(City.builder().name("s").build());
		System.out.println();
		cityService.listCitiesByNameQueryNative();

	}



	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}
}
