package com.c3stones.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.c3stones.handler.JsonbTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * 用户信息
 *
 * @author CL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "dsl_test", autoResultMap = true)
@Document(indexName = "dsl_test")
public class User {

    /**
     * ID
     */
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @Field(type = FieldType.Keyword)
    @TableField
    private String username;

    /**
     * 账号
     */
    @Field(type = FieldType.Keyword)
    @TableField
    private String account;

    /**
     * 年龄
     */
    @Field(type = FieldType.Integer)
    @TableField
    private Integer age;

    /**
     * 性别 0-女 1-男
     */
    @Field(type = FieldType.Integer)
    @TableField
    private Integer sex;

    /**
     * 地址
     */
    @Field(type = FieldType.Keyword)
    @TableField
    private String address;

    /**
     * 创建时间
     */
    @Field(name = "create_time", type = FieldType.Date)
    @TableField
    private Date createTime;

    @TableField(typeHandler = JsonbTypeHandler.class, jdbcType = JdbcType.OTHER)
    private List<String> srcIp;

    @TableField(typeHandler = JsonbTypeHandler.class, jdbcType = JdbcType.OTHER)
    private List<String> tags;

}

