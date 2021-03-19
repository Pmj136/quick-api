package com.pmj.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 彭明久
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 0 未知   1男   2女
     */
    private Integer gender;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 1 在校  2毕业生
     */
    private Integer identity;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 手机
     */
    private String phone;

    /**
     * 个人简介
     */
    private String intro;

    /**
     * 学号
     */
    private String sno;

    /**
     * 学校
     */
    private Integer schoolId;


}
