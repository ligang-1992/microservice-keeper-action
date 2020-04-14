package com.moon.content.center.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-14 20:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage implements Serializable {

    private Integer status;
    private String message;
}
