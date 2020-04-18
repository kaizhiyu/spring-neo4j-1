package io.github.chenmoand.springneo4j.bean;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;

/**
 * 人与人的关系
 *
 * @see Person
 */
@Getter
@Setter
@Builder
@ToString(exclude = {"startPerson", "endPerson"})
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "Relative")
public class Relative implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String relationship;

    @StartNode
    private Person startPerson;

    @EndNode
    private Person endPerson;
}
