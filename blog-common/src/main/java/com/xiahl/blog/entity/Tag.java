package com.xiahl.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/19 17:40
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    private Long id;
    private String name;
}
