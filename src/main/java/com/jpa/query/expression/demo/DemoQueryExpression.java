package com.jpa.query.expression.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jpa.query.expression.QueryExpSpeficiation;
import com.jpa.query.expression.QueryExpSpecificationBuilder;
import com.jpa.query.expression.generic.GenericQueryExpSpecification;

/**
 * demo query expression usage 演示查询表达式使用
 * 
 * @author jacksunny,jacksunny2020@126.com
 *
 */
public class DemoQueryExpression {
	@Autowired
	DemoRepository demoRepository;

	/**
	 * query entity by different query expressions 根据多个查询表达式查询实体
	 * 
	 * @param searchParam,query
	 *            parameters from client such as UI 来自界面上的查询参数集
	 */
	public void doQuery(SearchParameters searchParam) {
		int page = 1;
		int size = 20;
		Pageable paging = new PageRequest(page, size);
		Collection codes = new ArrayList();
		GenericQueryExpSpecification<DemoEntity> queryExpression = new GenericQueryExpSpecification<DemoEntity>();
		queryExpression.add(QueryExpSpecificationBuilder.like("code", searchParam.getCode(), true));
		queryExpression.add(QueryExpSpecificationBuilder.eq("level", searchParam.getLevel(), false));
		queryExpression.add(QueryExpSpecificationBuilder.eq("mainStatus", searchParam.getMainStatus(), true));
		queryExpression.add(QueryExpSpecificationBuilder.eq("flowStatus", searchParam.getFlowStatus(), true));
		queryExpression.add(QueryExpSpecificationBuilder.eq("createUser.userName", searchParam.getCreateUser(), true));
		queryExpression.add(QueryExpSpecificationBuilder.lte("submitTime", searchParam.getStartSubmitTime(), true));
		queryExpression.add(QueryExpSpecificationBuilder.gte("submitTime", searchParam.getEndSubmitTime(), true));
		queryExpression.add(QueryExpSpecificationBuilder.eq("needFollow", searchParam.getIsfollow(), true));
		queryExpression.add(QueryExpSpecificationBuilder.ne("flowStatus", "CASE_STATUS_DRAFT", true));
		queryExpression.add(QueryExpSpecificationBuilder.in("solveTeam.code", codes, true));

		Page<DemoEntity> pages = demoRepository.findAll(queryExpression, paging);
		System.out.println(pages);
	}
}
