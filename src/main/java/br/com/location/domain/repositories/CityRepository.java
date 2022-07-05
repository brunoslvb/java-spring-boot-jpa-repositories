package br.com.location.domain.repositories;

import br.com.location.domain.entities.City;
import br.com.location.domain.repositories.projections.CityProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    /**
     * Query filtrando pelo campo "name" com query nativa
     * @param name Nome a ser procurado na base de dados
     * @return Lista de cidades
     */
    @Query(nativeQuery = true, value = "SELECT c.id, c.name FROM city AS c WHERE c.name = :name")
    List<CityProjection> findByNameQueryNative(@Param("name") String name);

    /**
     * Query filtrando pelo campo "name"
     * @param name Nome a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByName(String name);

    /**
     * Query filtrando pelo campo "name" ignorando maiúsculas e minúsculas
     * @param name Nome a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByNameIgnoreCase(String name);

    /**
     * Query filtrando por parte do campo "name"
     * @param name Parte do nome a ser procurado na base de dados. Esse parâmetro deve ser concatenado com "%" no início e/ou no final
     * @return Lista de cidades
     */
    List<City> findByNameLike(String name);

    /**
     * Query filtrando por parte do campo "name" com ordenação
     * @param name Parte do nome a ser procurado na base de dados. Esse parâmetro deve ser concatenado com "%" no início e/ou no final
     * @return Lista de cidades
     */
    List<City> findByNameLike(String name, Sort sort);

    /**
     * Query filtrando por parte do campo "name" com paginação
     * @param name Parte do nome a ser procurado na base de dados. Esse parâmetro deve ser concatenado com "%" no início e/ou no final
     * @return Lista de cidades
     */
    List<City> findByNameLike(String name, Pageable pageable);

    /**
     * Query filtrando pelo começo do campo "name"
     * @param name Começo do nome a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByNameStartingWith(String name);

    /**
     * Query filtrando pelo final do campo "name"
     * @param name Final do nome a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByNameEndingWith(String name);

    /**
     * Query filtrando por parte do campo "name"
     * @param name Parte do nome a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByNameContaining(String name);

    /**
     * Query filtrando pelo campo "population"
     * @param population Quantidade de habitantes por cidade a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByPopulation(Long population);

    /**
     * Query filtrando pelo campo "population" que são menores que o parâmetro recebido
     * @param population Quantidade de habitantes por cidade a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByPopulationLessThan(Long population);

    /**
     * Query filtrando pelo campo "population" que são menores ou iguais ao parâmetro recebido
     * @param population Quantidade de habitantes por cidade a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByPopulationLessThanEqual(Long population);

    /**
     * Query filtrando pelo campo "population" que são maiores que o parâmetro recebido
     * @param population Quantidade de habitantes por cidade a ser procurado na base de dados
     * @return Lista de cidades
     */
    List<City> findByPopulationGreaterThan(Long population);

    /**
     * Query filtrando pelo campo "population" que são menores que o número recebido e com nome parecido com o recebido
     * @param population Quantidade de habitantes por cidade a ser procurado na base de dados
     * @param name Parte do nome a ser procurado na base de dados. Esse parâmetro deve ser concatenado com "%" no início e/ou no final
     * @return Lista de cidades
     */
    List<City> findByPopulationLessThanAndNameLike(Long population, String name);

}
