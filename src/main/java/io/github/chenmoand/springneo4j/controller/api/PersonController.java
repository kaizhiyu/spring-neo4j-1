package io.github.chenmoand.springneo4j.controller.api;

import io.github.chenmoand.springneo4j.bean.Person;
import io.github.chenmoand.springneo4j.repositories.neo4j.PersonRepository;
import io.github.chenmoand.springneo4j.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Api("成员管理")
@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ApiOperation("查询所有成员")
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/pageable")
    @ApiOperation("分页查询成员")
    public Iterable<Person> getAllPersons(
            @RequestParam(defaultValue = "1")
            @ApiParam(value = "页数", defaultValue = "1") int page,
            @RequestParam(defaultValue = "10")
            @ApiParam(value = "数量", defaultValue = "10") int size
    ){
        return personRepository.findAll(
                PageRequest.of(page, size)
        );
    }

    @GetMapping("/find")
    @ApiOperation("根据ID查询成员")
    public Result<Person> getPersonById(@RequestParam @ApiParam("成员id") Long id) {
        final Optional<Person> byId = personRepository.findById(id);
        return Result.dataNotNull(byId);
    }

    @GetMapping("/graph")
    @ApiOperation("根据成员姓名查找树状图")
    public Result<Collection<Person>> graphByName(@RequestParam @ApiParam("成员姓名") String name) {
        final Collection<Person> people = personRepository.graphByName(name);
        return Result.success(people);
    }

    @GetMapping("/graph")
    @ApiOperation("查找所有树状图")
    public Result<Collection<Person>> graph() {
        final Collection<Person> people = personRepository.graph();
        return Result.success(people);
    }

    @Transient
    @PostMapping
    @ApiOperation("添加或者更新一个成员")
    public Result<Person> updatePerson(@ApiParam("成员信息") @RequestBody Person person) {
        final Person save = personRepository.save(person);
        return Result.success(save);
    }

    @Transient
    @DeleteMapping
    @ApiOperation("删除一个成员")
    public Result<Void> deletePerson(@RequestParam @ApiParam("成员id") Long id) {
        personRepository.deleteById(id);
        return Result.success();
    }

}
