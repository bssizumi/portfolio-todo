package com.portfolio.izumi.todo.domain.model.entity;

import java.time.LocalDate;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * TODOエンティティ
 */
@Entity
@Table(name = "app.t_todo")
@Getter
@Setter
public class TTodo {
    /** TODOID. */
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "app.t_todo_todo_id_seq")
    @Id
    private Integer todoId;

    /** リストID. */
    @Column(name = "list_id")
    private Integer listId;

    /** タイトル. */
    @Column(name = "title")
    private String title;

    /** 本文. */
    @Column(name = "body")
    private String body;

    /** 実施状況. */
    @Column(name = "done")
    private boolean done;

    /** 期限. */
    @Column(name = "limit_date_time")
    private LocalDate limitDateTime;

    /** 表示順. */
    @Column(name = "prio")
    private Integer prio;

}