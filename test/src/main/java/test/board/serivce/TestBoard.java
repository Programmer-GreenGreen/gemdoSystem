package test.board.serivce;


import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

/**
 * 게시물에 대한 데이터 처리 모델
 * @author Geumdo 이록경
 * @since 2022.04.06
 * @version 1.0
 * @see
 *
 */
@SuppressWarnings("serial")
public class TestBoard implements Serializable {
	
	
    /** 게시글 id **/
    private int board_id;
    
    /**  작성자 **/
    @NotNull(message = "이름은 필수 항목입니다.")
    @Size(min = 1, max = 20)
    private String writer;
    
    /** 게시글 제목**/
    @NotNull(message = "제목은 필수 항목입니다.")
    @Size(min = 1, max = 20)
    private String title;
    
    
    @NotNull(message = "내용은 필수 항목입니다.")
    @Size(min = 1, max = 1000)
    /** 게시글 내용 **/
    private String content;
    
    /** 게시 날짜 **/
    private String regDate;
    
    /** 수정 날짜 **/
    private String udt_Date;
    
 
    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUdt_Date() {
        return udt_Date;
    }

    public void setUdt_Date(String upt_Date) {
        this.udt_Date = upt_Date;
    }
    
   

	public String toString() {
        return super.toString();
    }
    
    
}

