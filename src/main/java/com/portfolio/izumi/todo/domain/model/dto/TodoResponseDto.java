package com.portfolio.izumi.todo.domain.model.dto;

import java.time.LocalDate;

import com.portfolio.izumi.todo.domain.model.entity.TTodo;

import lombok.Getter;
import lombok.Setter;

/** TODOレスポンスDTO */
@Getter
@Setter
public class TodoResponseDto {

    /** デフォルトコンストラクタ. */
    public TodoResponseDto() {

    }

    /**
     * コンストラクタ
     * 
     * @param todo TTodo
     */
    public TodoResponseDto(TTodo todo) {
        if (todo != null) {
            todoId = todo.getTodoId();
            title = todo.getTitle();
            body = todo.getBody();
            done = todo.isDone();
            limitDateTime = todo.getLimitDateTime();
        }
    }

    /** TODOID. */
    private int todoId;

    /** タイトル. */
    private String title;

    /** 本文. */
    private String body;

    /** 実施状況. */
    private boolean done;

    /** 期限. */
    private LocalDate limitDateTime;

}