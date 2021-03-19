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
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private String province;

    private String city;

    private String department;

    private String level;

    private String type;

    private String link;


}
