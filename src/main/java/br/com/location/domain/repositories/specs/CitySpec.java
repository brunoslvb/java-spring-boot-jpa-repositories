package br.com.location.domain.repositories.specs;

import br.com.location.domain.entities.City;
import org.springframework.data.jpa.domain.Specification;

public abstract class CitySpec {

    public static Specification<City> idEqual(Long id){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<City> nameEqual(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<City> nameLike(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + name + "%".toUpperCase());
    }

    public static Specification<City> populationGreaterThan(Long population){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("population"), population);
    }

    public static Specification<City> populationBetween(Long min, Long max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("population"), min, max);
    }

}
