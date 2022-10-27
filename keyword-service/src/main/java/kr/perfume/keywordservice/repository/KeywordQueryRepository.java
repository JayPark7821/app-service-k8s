package kr.perfume.keywordservice.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.perfume.api.core.keyword.KeywordType;
import kr.perfume.keywordservice.persistence.Keyword;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static kr.perfume.keywordservice.persistence.QKeyword.keyword;
import static org.springframework.util.StringUtils.hasText;

@Repository
public class KeywordQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public KeywordQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Page<Keyword> searchKeywordsWithCondition(String keywordName, String keywordDesc, KeywordType keywordType, Pageable pageable) {

        List<Keyword> results = queryFactory
                .selectFrom(keyword)
                .where(keywordNameContains(keywordName),
                        keywordDescContains(keywordDesc),
                        keywordTypeContains(keywordType)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(keyword.id.desc())
                .fetch();

        JPAQuery<Keyword> countQuery = queryFactory
                .selectFrom(keyword)
                .where(keywordNameContains(keywordName),
                        keywordDescContains(keywordDesc),
                        keywordTypeContains(keywordType)
                );
        return PageableExecutionUtils.getPage(results, pageable, () -> countQuery.fetch().size());
    }

    private BooleanExpression keywordTypeContains(KeywordType keywordType) {
        return keywordType != null ? keyword.keywordType.eq(keywordType) : null;
    }

    private BooleanExpression keywordDescContains(String keywordDesc) {
        return hasText(keywordDesc) ? keyword.name.containsIgnoreCase(keywordDesc) : null;
    }

    private BooleanExpression keywordNameContains(String keywordName) {
        return hasText(keywordName) ? keyword.description.containsIgnoreCase(keywordName) : null;
    }

}
