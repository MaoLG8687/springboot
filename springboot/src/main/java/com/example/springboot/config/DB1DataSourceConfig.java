package com.example.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
//指定该SqlSession对象对应的dao(basePackages , dao扫包  sqlSessionFactoryRef: SqlSessionFactory对象注入到该变量中)
@MapperScan(basePackages = "com.example.springboot.DB1Dao", sqlSessionFactoryRef = "DB1Factory")
public class DB1DataSourceConfig {

    /**
     * 封装数据源对象创建, 该方法就已经将数据源的各个数据封装到该对象中
     * @return
     */
    @Bean(name = "DB1dataSource")
    @Primary //必须要有, 说明该数据源是默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.db1") //读取的数据源前缀, 跟yml文件对应
    public DataSource DB1dataSource(){
        return new DruidDataSource();
    }

    /**
     * SqlSession对象创建
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "DB1Factory")
    @Primary
    public SqlSessionFactory DB1Factory(@Qualifier("DB1dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //指定起别名的包
        bean.setTypeAliasesPackage("com.example.springboot.pojo");
        bean.setDataSource(dataSource);
        //指定该SqlSession对应的mapper.xml文件位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:DB1Mapper/*.xml"));
        return bean.getObject();
    }

}
