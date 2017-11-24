package com.jpa.query.expression.test;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jpa.query.expression.QueryExpSpeficiation;
import com.jpa.query.expression.QueryExpSpecificationBuilder;
import com.jpa.query.expression.generic.GenericQueryExpSpecification;

public class DemoQueryExpression {
	@Autowired
	DemoRepository demoRepository;

	public void doQuery(SearchClass searchParam) {
		int page = 1;
		int size = 20;
		Pageable paging = new PageRequest(page, size);
		Collection codes = new ArrayList();
		GenericQueryExpSpecification<DemoClass> queryExpression = new GenericQueryExpSpecification<DemoClass>();
		queryExpression.add(QueryExpSpecificationBuilder.like("code", searchParam.getCode(), true))
				.add(QueryExpSpecificationBuilder.eq("level", searchParam.getLevel(), false))
				.add(QueryExpSpecificationBuilder.eq("mainStatus", searchParam.getMainStatus(), true))
				.add(QueryExpSpecificationBuilder.eq("flowStatus", searchParam.getFlowStatus(), true))
				.add(QueryExpSpecificationBuilder.eq("createUser.userName", searchParam.getCreateUser(), true))
				.add(QueryExpSpecificationBuilder.lte("submitTime", searchParam.getStartSubmitTime(), true))
				.add(QueryExpSpecificationBuilder.gte("submitTime", searchParam.getEndSubmitTime(), true))
				.add(QueryExpSpecificationBuilder.eq("needFollow", searchParam.getIsfollow(), true))
				.add(QueryExpSpecificationBuilder.ne("flowStatus", "CASE_STATUS_DRAFT", true))
				.add(QueryExpSpecificationBuilder.in("solveTeam.code", codes, true));

		Page<DemoClass> pages = demoRepository.findAll(queryExpression, paging);
		System.out.println(pages);
	}
}
