package io.github.chenmoand.springneo4j.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Relative", description = "成员关系对象")
@ToString(exclude = {"startPerson", "endPerson"})
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "Relative")
public class Relative implements Serializable {
    @Id
    @GeneratedValue
    @ApiModelProperty("关系ID")
    private Long id;

    @ApiModelProperty(value = "关系类别", example = "弟弟")
    private String relationship;

    @StartNode
    private Person startPerson;

    @EndNode
    private Person endPerson;
}
