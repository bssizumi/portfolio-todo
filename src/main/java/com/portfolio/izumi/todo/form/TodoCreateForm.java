package com.portfolio.izumi.todo.form;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO作成フォーム
 */
@Getter
@Setter
public class TodoCreateForm {
    /** リストID. */
    private Integer listId;

    /** タイトル. */
    private String title;

    /** 本文. */
    private String body;

    /** 期限. */
    private String limitDateTime;
}