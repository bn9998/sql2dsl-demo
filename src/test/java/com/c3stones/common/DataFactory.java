package com.c3stones.common;

import com.c3stones.entity.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 数据工厂
 *
 * @author CL
 */
public class DataFactory {

    /**
     * 构造用户信息
     *
     * @return {@link List}
     */
    public static List<User> user() {
        return Arrays.asList(
                new User(1L, "张三", "zhangsan", 20, 1, "西安", new Date(), Stream.of("1.1.1.1", "2.2.2.2").collect(Collectors.toList()), Stream.of("tag1", "tag2").collect(Collectors.toList())),
                new User(2L, "李四", "lisi", 25, 0, "北京", new Date(), Stream.of("3.3.3.3", "1.1.1.1").collect(Collectors.toList()), Stream.of("tag3", "tag2").collect(Collectors.toList())),
                new User(3L, "王五", "wangwu", 30, 1, "上海", new Date(), Stream.of("5.5.5.5", "2.2.2.2").collect(Collectors.toList()), Stream.of("tag1", "tag6").collect(Collectors.toList())),
                new User(4L, "赵六", "zhaoliu", 30, 0, "北京", new Date(), Stream.of("1.1.1.1", "8.8.8.8").collect(Collectors.toList()), Stream.of("tag7", "tag1").collect(Collectors.toList()))
        );
    }

    /**
     * 构造查询SQL
     * <p style="color:yellow">
     * ps: 函数必须指定别名
     * <p/>
     *
     * @return {@link List}
     */
    public static List<String> mysqlQuery() {
        return Arrays.asList(
                "select * from dsl_test",
                "select * from dsl_test order by age desc",
                "select id, username from dsl_test limit 0,2",
                "select * from dsl_test where age between 25 and 30",
                "select id, age, sex from dsl_test where create_time between '2023-01-01' and '2023-01-31'",
                "select * from dsl_test where create_time between from_unixtime(1672502400000/1000) and from_unixtime(1675180799999/1000)",
                "select * from dsl_test where id < 10 and username like concat('%' ,'张', '%')",
                "select * from dsl_test where id < 10 and username not like '%李%'",
                "select id, account, address from dsl_test where age > 18 and (username like concat('张', '%') or account = lower('zhangsan') or address in ('北京', '西安'))"
        );
    }

    /**
     * 构造聚合SQL
     * <p style="color:yellow">
     * ps: 函数必须指定别名
     * <p/>
     *
     * @return {@link List}
     */
    public static List<String> mysqlAggregation() {
        return Arrays.asList(
                "select count(*) as count from dsl_test",
                "select count(id) as count from dsl_test where sex = 0 or sex = -1",
                "select age, count(id) as count from dsl_test group by age",
                "select address, sex, count(*) as count from dsl_test group by address, sex",
                "select age, count(id) as count from dsl_test where age > 25 or username like concat('%' ,'张', '%')  group by age",
                "select min(age) as min from dsl_test",
                "select sex, max(age) as max from dsl_test group by sex",
                "select avg(age) as avg from dsl_test",
                "select sex, sum(age) as sum from dsl_test group by sex"
        );
    }

}
