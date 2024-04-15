package com.c3stones.handler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author CSDN @一碗情深
 * @description PostgreSql jsonb 数据处理器
 **/
@MappedTypes({Object.class})
public class JsonbTypeHandler extends BaseTypeHandler<Object> {
    private static final PGobject jsonObject = new PGobject();
 
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        if (preparedStatement != null) {
            jsonObject.setType("jsonb");
            jsonObject.setValue(JSON.toJSONString(o));
            preparedStatement.setObject(i, jsonObject);
        }
    }
 
    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return JSON.parse(resultSet.getString(s));
    }
 
    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return JSON.parse(resultSet.getString(i));
    }
 
    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return JSON.parse(callableStatement.getString(i));
    }
}
