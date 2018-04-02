package com.zhenghao.rule.management.repository.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhenghao.rule.management.repository.constant.DataSourceConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "com.zhenghao.rule.management.repository.mapper",
        sqlSessionFactoryRef = "ruleManagementSqlSessionFactory")
@Profile("default")
public class RuleManagementDataSourceConfig {

    private static final String MAPPER_XML_LOCATION = "classpath:com/zhenghao/rule/management/repository/mapper/*.xml";

    @Bean(name = "ruleManagementDataSource")
    @Primary
    public DataSource ruleManagementDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(DataSourceConstant.RuleManagement.DRIVER);
        dataSource.setUrl(DataSourceConstant.RuleManagement.URL);
        dataSource.setUsername(DataSourceConstant.RuleManagement.USER_NAME);
        dataSource.setPassword(DataSourceConstant.RuleManagement.PASSWORD);

        return dataSource;
    }

    @Bean(name = "ruleManagementSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("ruleManagementDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name = "ruleManagementTxManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("ruleManagementDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
