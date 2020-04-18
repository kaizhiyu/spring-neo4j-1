package io.github.chenmoand.springneo4j.repositories.neo4j;

import io.github.chenmoand.springneo4j.bean.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (root:Person)<-[r:Relative]-(p:Person) " +
            "WHERE root.name='{name}' RETURN root, r, p"
    )
    Set<Person> graphByName(@Param("name") String name);

    @Query("MATCH (root:Person)<-[r:Relative]-(p:Person) RETURN root, r, p")
    Set<Person> graph();

}
