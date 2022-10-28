package kr.perfume.perfumeservice.repository;


import kr.perfume.perfumeservice.persistence.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

}
