package com.jpa.query.expression.generic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.jpa.query.expression.QueryExpSpeficiation;

/**
 * organize query expressions 组织多个查询表达
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 * @param <T>class
 *            represents entity or model
 */
public class GenericQueryExpSpecification<T> implements Specification<T> {
	private List<QueryExpSpeficiation> expressions = new ArrayList<QueryExpSpeficiation>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.
	 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
	 * javax.persistence.criteria.CriteriaBuilder)
	 */
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (!expressions.isEmpty()) {
			List<Predicate> predicates = new ArrayList<Predicate>();
			for (QueryExpSpeficiation expression : expressions) {
				predicates.add(expression.toPredicate(root, query, builder));
			}
			// link all query expressions by logic and
			if (predicates.size() > 0) {
				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}
		return builder.conjunction();
	}

	/**
	 * add query expressions to store,then to build complex final query
	 * expression 添加简单条件表达式
	 * 
	 * @param expression
	 * @return GenericQueryExpSpecification<T>,to support continous add query
	 *         expression like .add(xxx).add(xxx)
	 */
	/**
	 * @param expression
	 * @return
	 */
	public GenericQueryExpSpecification<T> add(QueryExpSpeficiation expression) {
		if (expression != null) {
			expressions.add(expression);
		}
		return this;
	}
}
