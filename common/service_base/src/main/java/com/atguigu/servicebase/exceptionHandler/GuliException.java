package com.atguigu.servicebase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuliException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//输出信息
}
