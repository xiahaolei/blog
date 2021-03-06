package com.xiahl.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 博客实体类
 * @Author: ONESTAR
 * @Date: Created in 22:58 2020/3/25
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_blog")
public class Blog {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "首图")
    private String firstPicture;

    @ApiModelProperty(value = "开关标记")
    private String flag;

    @ApiModelProperty(value = "浏览次数")
    private Integer views;

    private Integer commentCount;

    @ApiModelProperty(value = "赞赏是否开启")
    private boolean appreciation;

    @ApiModelProperty(value = "转载声明是否开启")
    private boolean shareStatement;

    @ApiModelProperty(value = "评论是否开启")
    private boolean commentabled;

    @ApiModelProperty(value = "是否发布")
    private boolean published;

    @ApiModelProperty(value = "是否推荐")
    private boolean recommend;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @Transient
    private Long typeId;
    @Transient
    private Long userId;
    @Transient
    private String description;

    @Transient
    private Type type;
    @Transient
    private User user;
    @Transient
    private List<Tag> tags = new ArrayList<>();
    @Transient
    private List<Comment> comments = new ArrayList<>();


}