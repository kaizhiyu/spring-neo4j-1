package io.github.chenmoand.springneo4j.controller.api;

import io.github.chenmoand.springneo4j.bean.Relative;
import io.github.chenmoand.springneo4j.repositories.neo4j.RelativeRepository;
import io.github.chenmoand.springneo4j.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Api("成员关系管理")
@RestController
@RequestMapping("/v1/relative")
public class RelativeController {

    @Autowired
    private RelativeRepository relativeRepository;

    @Transactional
    @PostMapping
    @ApiOperation("添加或者更新一个成员关系")
    public Result<Relative> updateRelative(@RequestBody Relative relative) {
        final Relative save = relativeRepository.save(relative);
        return Result.success(save);
    }

    @Transactional
    @DeleteMapping
    @ApiOperation("删除一个成员关系")
    public Result<Void> deleteRelative(@RequestParam @ApiParam("成员关系ID") Long id) {
        relativeRepository.deleteById(id);
        return Result.success();
    }

}
