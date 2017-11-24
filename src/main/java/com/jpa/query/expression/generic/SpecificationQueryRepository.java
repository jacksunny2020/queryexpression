package com.jpa.query.expression.generic;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jpa.query.expression.demo.DemoEntity;

/**
 * the interface which JPA repository should implement to support dynamic query
 * 为支持动态查询Repository应该实现的接口
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 * @param <T>
 *            entity or model
 */
public interface SpecificationQueryRepository<T> extends JpaSpecificationExecutor<T> {

}
