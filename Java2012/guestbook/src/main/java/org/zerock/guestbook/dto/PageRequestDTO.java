package org.zerock.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor // 모든 필드 값을 파라미터로 갖는 생성자를 생성.
@Data
public class PageRequestDTO {

    private int page;
    private int size;
    private String type;
    private String keyword;

    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page - 1, size, sort); // jpa를 이용하는 경우에는 페이지번호가 0부터 시작이라 -1 해준다.
        // jpa = 0부터 시작, 코드는 1부터 시작.
    }
}
