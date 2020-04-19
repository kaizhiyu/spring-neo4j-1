package io.github.chenmoand.springneo4j.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.Set;

/**
 * 基本单位人
 *
 * @see Relative
 */
@Getter
@Setter
@Builder
@ToString(exclude = {"relatives"})
@ApiModel(value = "Person", description = "基本单位人")
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity(label = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @ApiModelProperty("成员ID")
    private Long id;

    @Index(unique = true)
    @ApiModelProperty(value = "成员姓名", example = "小明")
    private String name;

    @ApiModelProperty("成员性别")
    private Sex sex;

    @ApiModelProperty("成员年龄")
    private int age;

    @ApiModelProperty("成员亲属关系列表")
    @Relationship(type = "Relative")
//    @JsonIgnoreProperties(value = {"startPerson", "endPerson"})
    private Set<Relative> relatives;


}
