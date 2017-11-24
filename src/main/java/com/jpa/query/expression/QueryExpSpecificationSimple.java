package com.jpa.query.expression;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.jpa.query.expression.generic.GenericQueryExpSpecification;

/**
 * simple query expression like property1 equals to xxx,property2 greater than
 * 10 简单查询表达式
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 */
public class QueryExpSpecificationSimple implements QueryExpSpeficiation {

	/**
	 * entity property name
	 */
	private String fieldName;
	/**
	 * property start value to query
	 */
	private Object value;
	/**
	 * entit end value to query
	 */
	private Object extraValue;
	/**
	 * query operator,like eq,like,gt
	 */
	private Operator operator;

	protected QueryExpSpecificationSimple(String fieldName, Object value, Operator operator) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	protected QueryExpSpecificationSimple(String fieldName, Object value, Operator operator, Object extraValue) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
		this.extraValue = extraValue;
	}

	/**
	 * @return field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @return property value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @return query operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * @return a another property value
	 */
	public Object getExtraValue() {
		return extraValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpa.query.expression.QueryExpSpeficiation#toPredicate(javax.
	 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
	 * javax.persistence.criteria.CriteriaBuilder)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Path expression = null;
		if (fieldName.contains(".")) {
			String[] names = StringUtils.tokenizeToStringArray(fieldName, ".");
			expression = root.get(names[0]);
			for (int i = 1; i < names.length; i++) {
				expression = expression.get(names[i]);
			}
		} else {
			expression = root.get(fieldName);
		}

		switch (operator) {
		case EQ:
			return builder.equal(expression, value);
		case NE:
			return builder.notEqual(expression, value);
		case LIKE:
			return builder.like(expression, "%" + value + "%");
		case NOTLIKE:
			return builder.notLike(expression, "%" + value + "%");
		case LT:
			return builder.lessThan(expression, (Comparable) value);
		case GT:
			return builder.greaterThan(expression, (Comparable) value);
		case LTE:
			return builder.lessThanOrEqualTo(expression, (Comparable) value);
		case GTE:
			return builder.greaterThanOrEqualTo(expression, (Comparable) value);
		case BETWEEN:
			return builder.between(expression, (Comparable) value, (Comparable) extraValue);
		default:
			return null;
		}
	}

}
