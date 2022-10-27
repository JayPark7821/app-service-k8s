package kr.perfume.keywordservice.repository;

import kr.perfume.keywordservice.persistence.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KeywordRepository extends JpaRepository<Keyword, Long> {

}
