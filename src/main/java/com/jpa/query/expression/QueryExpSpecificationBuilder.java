package com.jpa.query.expression;

import java.util.Collection;

import org.springframework.util.StringUtils;

import com.jpa.query.expression.QueryExpSpeficiation.Operator;

/**
 * query expression factory 创建查询表达式的工厂
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 */
public class QueryExpSpecificationBuilder {
	/**
	 * to create a query expression to represent datatable field value equals to
	 * the value 创建指定字段值等于某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple eq(String fieldName, Object value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.EQ);
	}

	/**
	 * to create a query expression to represent datatable field value not
	 * equals to the value 创建指定字段值不等于某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple ne(String fieldName, Object value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.NE);
	}

	/**
	 * to create a query expression to represent datatable field value like the
	 * value 创建指定字段值模糊匹配某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple like(String fieldName, String value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.LIKE);
	}

	/**
	 * to create a query expression to represent datatable field value not like
	 * the value 创建指定字段值未模糊匹配某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple notlike(String fieldName, String value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.NOTLIKE);
	}

	/**
	 * to create a query expression to represent datatable field value between a
	 * value and another value 创建指定字段值基于指定的两个值之间的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,start
	 *            value of the field to query
	 * @param extraValue,end
	 *            value of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple between(String fieldName, Object value, Object extraValue,
			boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		if (StringUtils.isEmpty(extraValue))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.BETWEEN, extraValue);
	}

	/**
	 * to create a query expression to represent datatable field value great
	 * than the value 创建指定字段值大于某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple gt(String fieldName, Object value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.GT);
	}

	/**
	 * to create a query expression to represent datatable field value less than
	 * the value 创建指定字段值小于某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple lt(String fieldName, Object value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.LT);
	}

	/**
	 * to create a query expression to represent datatable field value less than
	 * or equals to the value 创建指定字段值小于等于某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple lte(String fieldName, Object value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.GTE);
	}

	/**
	 * to create a query expression to represent datatable field value great
	 * than the value 创建指定字段值大于某个值的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,value
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	public static QueryExpSpecificationSimple gte(String fieldName, Object value, boolean ignoreNull) {
		if (StringUtils.isEmpty(value))
			return null;
		return new QueryExpSpecificationSimple(fieldName, value, Operator.LTE);
	}

	/**
	 * to create a query expression to represent the query expressions which are
	 * linked by logic and 创建多个查询条件表达式逻辑与后对应的查询表达式
	 * 
	 * @param criterions,some
	 *            query expression
	 * @return query expression
	 */
	public static QueryExpSpecificationComplex and(QueryExpSpeficiation... criterions) {
		return new QueryExpSpecificationComplex(criterions, Operator.AND);
	}

	/**
	 * to create a query expression to represent the query expressions which are
	 * linked by logic or 创建多个查询条件表达式逻辑或后对应的查询表达式
	 * 
	 * @param criterions,some
	 *            query expression
	 * @return query expression
	 */
	public static QueryExpSpecificationComplex or(QueryExpSpeficiation... criterions) {
		return new QueryExpSpecificationComplex(criterions, Operator.OR);
	}

	/**
	 * to create a query expression to represent datatable field in the values
	 * range 创建指定字段值在指定集合中的查询条件表达式
	 * 
	 * @param fieldName,entity
	 *            property name,or recursive form like
	 *            property1.subProperty2.subProperty3
	 * @param value,values
	 *            of the field to query
	 * @param ignoreNull,if
	 *            ignore to create query expression if value is null or empty
	 * @return query expression
	 */
	@SuppressWarnings("rawtypes")
	public static QueryExpSpecificationComplex in(String fieldName, Collection value, boolean ignoreNull) {
		if (ignoreNull && (value == null || value.isEmpty())) {
			return null;
		}
		QueryExpSpecificationSimple[] ses = new QueryExpSpecificationSimple[value.size()];
		int i = 0;
		for (Object obj : value) {
			ses[i] = new QueryExpSpecificationSimple(fieldName, obj, Operator.EQ);
			i++;
		}
		return new QueryExpSpecificationComplex(ses, Operator.OR);
	}
}
