package com.xiahl.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

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
@TableName("t_tag")
public class Tag {

    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String name;
}
