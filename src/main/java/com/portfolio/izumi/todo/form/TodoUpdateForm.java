package com.portfolio.izumi.todo.form;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO更新フォーム
 */
@Getter
@Setter
public class TodoUpdateForm {
    /** TODOID. */
    private Integer todoId;

    /** リストID. */
    private Integer listId;

    /** タイトル. */
    private String title;

    /** 本文. */
    private String body;

    /** 本文. */
    private boolean done;

    /** 期限. */
    private String limitDateTime;
}