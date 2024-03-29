package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reply", indexes = {@Index(name = "idx_reply_board_bno", columnList = "board_bno")}) //인덱스 생성
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)  //지연 로딩
    private Board board;

    private String replyText;

    private String replyer;

    public void changeText(String text){
        this.replyText = text;
    }
}
