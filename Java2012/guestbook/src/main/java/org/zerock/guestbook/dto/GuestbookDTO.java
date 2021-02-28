package org.zerock.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor // 파라미터가 없는 생성자 생성
@AllArgsConstructor // 모든 필드값을 갖는 파라미터로 받는 생성자 생성
@Data
public class GuestbookDTO {

    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
