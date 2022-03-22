package com.xiahl.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 分类实体类
 * @Author: ONESTAR
 * @Date: Created in 9:06 2020/3/26
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    private Long id;
    private String name;
}