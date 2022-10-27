package kr.perfume.api.core.fragrance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FragranceController {

    @PostMapping
    FragranceDto saveFragrance(@RequestBody FragranceDto fragranceDto);

    @GetMapping("/{id}")
    FragranceDto getFragranceById(@PathVariable("id") Long id);

    @GetMapping("/all")
    Page<FragranceDto> getAllFragrances(String fragranceName, String fragranceDesc, Pageable pageable);

}
