package io.github.chenmoand.springneo4j.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ToString
@ApiModel(value = "Person", description = "基本单位人")
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity(label = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @ApiModelProperty("成员ID")
    private Long id;
    @ApiModelProperty("成员姓名")
    private String name;
    @ApiModelProperty("成员性别")
    private Sex sex;

    @ApiModelProperty("成员年龄")
    private int age;

    @ApiModelProperty("成员亲属关系列表")
    @Relationship(type = "Relative")
    @JsonIgnoreProperties(value = {"startPerson", "endPerson"})
    private Set<Relative> relatives;


}
