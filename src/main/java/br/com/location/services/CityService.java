package br.com.location.services;

import br.com.location.domain.entities.City;
import br.com.location.domain.repositories.CityRepository;
import br.com.location.domain.repositories.specs.CitySpec;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void saveCity(){
        var city = new City(1L, "São Paulo", 12396372L);
        cityRepository.save(city);
    }

    public void listAllCities(){
        cityRepository.findAll().forEach(System.out::println);
    }

    public void listCitiesByName(){
        cityRepository.findByNameLike("%orto%").forEach(System.out::println);
    }

    public void listCitiesByNameSort(){
        cityRepository.findByNameLike("%orto%", Sort.by("population")).forEach(System.out::println);
    }

    public void listCitiesByNamePageable(){
        Pageable pageable = PageRequest.of(1, 1);
        cityRepository.findByNameLike("%orto%", pageable).forEach(System.out::println);
    }

    public void dynamicFilter(City city){

        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase("name")
            .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

        Example<City> example = Example.of(city, matcher);
        cityRepository.findAll(example).forEach(System.out::println);
    }

    public void listCitiesByNameSpec(){
        Specification<City> specifications = CitySpec.nameEqual("São Paulo").and(CitySpec.populationGreaterThan(10L));
        cityRepository.findAll(specifications).forEach(System.out::println);
    }

    public void listCitiesSpecsDynamicFilter(City filter){
        Specification<City> specifications = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if(filter.getId() != null){
            specifications = specifications.and(CitySpec.idEqual(filter.getId()));
        }

        if(StringUtils.hasText(filter.getName())){
            specifications = specifications.and(CitySpec.nameLike(filter.getName()));
        }

        if(filter.getPopulation() != null){
            specifications = specifications.and(CitySpec.populationGreaterThan(filter.getPopulation()));
        }

        cityRepository.findAll(specifications).forEach(System.out::println);
    }

    public void listCitiesByNameQueryNative(){
        cityRepository.findByNameQueryNative("São Paulo").stream().map(
            cityProjection -> City.builder().id(cityProjection.getId()).name(cityProjection.getName()).build()
        ).forEach(System.out::println);
    }

    public void listCitiesByPopulation(){
        cityRepository.findByPopulationLessThan(0L).forEach(System.out::println);
        System.out.println();
        cityRepository.findByPopulationLessThanEqual(0L).forEach(System.out::println);
        System.out.println();
        cityRepository.findByPopulationGreaterThan(0L).forEach(System.out::println);
        System.out.println();
        cityRepository.findByPopulationLessThanAndNameLike(100000000L, "%S%").forEach(System.out::println);
    }
}
