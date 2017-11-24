package com.jpa.query.expression;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * abstract query expression 抽象查询表达式接口
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 */
public interface QueryExpSpeficiation {
	/**
	 * query operator
	 * 
	 * @author jacksunny,jacksunny2020@126.com
	 *
	 */
	public enum Operator {
		EQ, NE, LIKE, NOTLIKE, GT, LT, GTE, LTE, AND, OR, BETWEEN
	}

	/**
	 * create Predicate to implement dynamic query
	 * 
	 * @param root,the
	 *            entity to operate on
	 * @param query,query
	 *            condition
	 * @param builder,query
	 *            builder
	 * @return Predicate
	 */
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}
