package io.github.chenmoand.springneo4j.repositories.neo4j;

import io.github.chenmoand.springneo4j.bean.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    /**
     *
     * note: <a href=https://docs.spring.io/spring-data/neo4j/docs/5.2.6.RELEASE/reference/html/#neo4j.repositories>新版本更换了Query格式</a>
     * 一开始是{name}格式, 现在是$name格式
     *
     * @param name 成员名称
     * @return 一个关系
     */
    @Query("MATCH (root:Person{name: $name})<-[r:Relative]-(p:Person) RETURN root, r, p")
    Set<Person> graphByName(@Param("name") String name);

    @Query("MATCH (root:Person)<-[r:Relative]-(p:Person) RETURN root, r, p")
    Set<Person> graph();

}
