package com.jpa.query.expression;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * complex query expression like expression1 or expressions2 复杂的查询表达式
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 */
public class QueryExpSpecificationComplex implements QueryExpSpeficiation {
	/**
	 * sub query expressions
	 */
	private QueryExpSpeficiation[] queryExpressions;
	/**
	 * the operator which will be applied to the sub query expressions
	 */
	private Operator operator;

	public QueryExpSpecificationComplex(QueryExpSpeficiation[] queryExpressions, Operator operator) {
		this.queryExpressions = queryExpressions;
		this.operator = operator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpa.query.expression.QueryExpSpeficiation#toPredicate(javax.
	 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
	 * javax.persistence.criteria.CriteriaBuilder)
	 */
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		for (int i = 0; i < this.queryExpressions.length; i++) {
			predicates.add(this.queryExpressions[i].toPredicate(root, query, builder));
		}
		switch (operator) {
		case OR:
			return builder.or(predicates.toArray(new Predicate[predicates.size()]));
		default:
			return null;
		}
	}
}
