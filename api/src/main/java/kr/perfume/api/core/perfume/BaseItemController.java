package kr.perfume.api.core.perfume;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseItemController {

    @PostMapping
    BaseItemDto saveItem(@RequestBody BaseItemDto baseItemDto);

    @GetMapping("/{id}")
    BaseItemDto getItemById(@PathVariable("id") Long id);

}
