package com.jpa.query.expression.test;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jpa.query.expression.generic.SpecificationQueryRepository;

public interface DemoRepository extends SpecificationQueryRepository<DemoClass> {

}
