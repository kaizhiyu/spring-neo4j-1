package io.github.chenmoand.springneo4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.chenmoand.springneo4j.bean.Person;
import io.github.chenmoand.springneo4j.bean.Relative;
import io.github.chenmoand.springneo4j.bean.Sex;
import io.github.chenmoand.springneo4j.repositories.neo4j.PersonRepository;
import io.github.chenmoand.springneo4j.repositories.neo4j.RelativeRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Slf4j
@SpringBootTest
class SpringNeo4jApplicationTests {

    @Autowired
    private RelativeRepository relativeRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {
        relativeRepository.findAll().forEach(System.out::println);
    }

    @Test
    void addPersons() {
        Person person = Person.builder()
                .name("小明")
                .sex(Sex.MALE)
                .age(18)
                .build();
        Person person2 = Person.builder()
                .name("小黑")
                .sex(Sex.MALE)
                .age(20)
                .build();

//        final Iterable<Person> peoples = personRepository.saveAll(Arrays.asList(person, person2));

        final Person one = personRepository.save(person);

        final Person two = personRepository.save(person2);


        final Relative r1 = relativeRepository.save(
                Relative.builder()
                        .startPerson(one)
                        .endPerson(two)
                        .relationship("弟弟")
                        .build()
        );

        final Relative r2 = relativeRepository.save(
                Relative.builder()
                        .startPerson(two)
                        .endPerson(one)
                        .relationship("哥哥")
                        .build()
        );

        relativeRepository.findAll().forEach(System.out::println);


    }


    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    void testMethod() {
//        final Collection<Person> people = personRepository.graphById(1L);
        final Collection graph = personRepository.graph();
//        final String toString = graph.toString();
        final String s = objectMapper.writeValueAsString(graph);
        log.info(s);
    }

    @Test
    void testMethodTwo() {
        final Optional<Person> byId = personRepository.findById(2L);

        byId.ifPresent(person -> {
//            final Set relatives = person.getRelatives();
//            log.info(relatives.toString());
        });

    }

    @Test
    void testMethodThree() {
        final Set people = personRepository.graphByName("小明");
        log.info(people.toString());
    }
}
