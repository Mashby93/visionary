package com.visionary.visionary.repository;

import com.visionary.visionary.controller.filter.EventFilter;
import com.visionary.visionary.converter.UUIDConverter;
import com.visionary.visionary.converter.UUIDUtils;
import com.visionary.visionary.domain.Event;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

public class EventSpecifications {

    public static Specification<Event> filters(EventFilter filters) {
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new LinkedList<>();
                if (Objects.nonNull(filters.getStartDate()) && Objects.nonNull(filters.getEndDate())) {
                    predicates.add(
                            criteriaBuilder.or(criteriaBuilder.lessThanOrEqualTo(root.get("end_date"), filters.getStartDate()),
                                    criteriaBuilder.greaterThanOrEqualTo(root.get("start_date"), filters.getStartDate())));
                } else if (Objects.nonNull(filters.getStartDate())) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("start_date"), filters.getStartDate()));
                } else if (Objects.nonNull(filters.getEndDate())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("end_date"), filters.getStartDate()));
                }
                if (Objects.nonNull(filters.getCategoryIdList())) {
                    predicates.add(root.get("category_id").in(UUIDUtils.convertToDatabase(filters.getCategoryIdList())));
                }
                if (Objects.nonNull(filters.getUserIdList())) {
                    predicates.add(root.get("user_id").in(UUIDUtils.convertToDatabase(filters.getUserIdList())));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }


    /*public static Specification<Event> endBefore(Date date) {
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return ;
            }
        };
    }

    public static Specification<Event> containsUserId(List<UUID> userId) {
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return root.get("user_id").in(UUIDUtils.convertToDatabase(userId));
            }
        };
    }

    public static Specification<Event> containsCategoryId(List<UUID> categoryIds) {
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return root.get("category_id").in(UUIDUtils.convertToDatabase(categoryIds));
            }
        };
    }*/
}
