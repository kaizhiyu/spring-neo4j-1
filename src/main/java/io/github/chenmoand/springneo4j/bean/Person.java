package io.github.chenmoand.springneo4j.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/**
 * 基本单位人
 *
 * @see Relative
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NodeEntity(label = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Sex sex;

    @Size(min = 0, max = 120)
    private int age;

//    @JsonIgnoreProperties(value = {"startPerson", "endPerson"})
    @Relationship(type = "Relative")
    private Set<Relative> relatives = Collections.emptySet();


}
