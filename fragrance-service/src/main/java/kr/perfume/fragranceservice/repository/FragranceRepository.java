package kr.perfume.fragranceservice.repository;

import kr.perfume.fragranceservice.persistence.Fragrance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FragranceRepository extends JpaRepository<Fragrance, Long> {

}
