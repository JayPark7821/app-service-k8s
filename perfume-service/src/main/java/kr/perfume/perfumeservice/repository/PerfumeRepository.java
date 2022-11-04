package kr.perfume.perfumeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.perfume.perfumeservice.domain.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

}
