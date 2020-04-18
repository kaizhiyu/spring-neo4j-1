package io.github.chenmoand.springneo4j.util;

import io.github.chenmoand.springneo4j.bean.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

@Data
@AllArgsConstructor
public final class Result<DATA> implements Serializable {

    private Result() {
    }

    private int code;
    private String info;
    private DATA data;

    /**
     * 成功获得数据
     *
     * @return 返回一个没有数据的结果
     */
    public static Result<Void> success() {
        return new Result<>(200, "执行成功", null);
    }

    public static <D> Result<D> success(D data) {
        return new Result<>(200, "获取成功", data);
    }

    public static <D> Result<D> failure(D data) {
        return new Result<>(500, "获取失败", data);
    }

    public static Result<Void> failure() {
        return new Result<>(500, "执行失败", null);
    }

    public static <D> Result<D> dataNotNull(D data) {
        if(data == null) {
            return (Result<D>) Result.failure();
        }
        return Result.success(data);
    }

    public static <D> Result<D> dataNotNull(Optional<D> data) {
        return data.map(Result::success).orElseGet(() -> (Result<D>) Result.failure());
    }


}
