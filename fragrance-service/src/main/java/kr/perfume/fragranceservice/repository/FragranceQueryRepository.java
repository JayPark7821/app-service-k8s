package kr.perfume.fragranceservice.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.perfume.fragranceservice.persistence.Fragrance;
import kr.perfume.fragranceservice.persistence.QFragrance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static kr.perfume.fragranceservice.persistence.QFragrance.fragrance;
import static org.springframework.util.StringUtils.hasText;

@Repository
public class FragranceQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public FragranceQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Page<Fragrance> searchFragrancesWithCondition(String name, String description, Pageable pageable) {

        List<Fragrance> results = queryFactory
                .selectFrom(fragrance)
                .where(fragranceNameContains(name),
                        fragranceDescContains(description)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(fragrance.id.desc())
                .fetch();

        JPAQuery<Fragrance> countQuery = queryFactory
                .selectFrom(fragrance)
                .where(fragranceNameContains(name),
                        fragranceDescContains(description)
                );

        return PageableExecutionUtils.getPage(results, pageable, () -> countQuery.fetch().size());
    }

    private BooleanExpression fragranceDescContains(String desc) {
        return hasText(desc) ? fragrance.description.containsIgnoreCase(desc) : null;
    }

    private BooleanExpression fragranceNameContains(String name) {
        return hasText(name) ? fragrance.name.containsIgnoreCase(name) : null;
    }

}
