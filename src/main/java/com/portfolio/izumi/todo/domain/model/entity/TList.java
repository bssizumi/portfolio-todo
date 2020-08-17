package com.portfolio.izumi.todo.domain.model.entity;

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
 * リストエンティティ
 */
@Entity
@Table(name = "app.t_list")
@Getter
@Setter
public class TList {

    /** リストID. */
    @Column(name = "list_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "app.t_list_list_id_seq")
    @Id
    private Integer listId;

    /** タイトル. */
    @Column(name = "title")
    private String title;

    /** 表示順. */
    @Column(name = "prio")
    private Integer prio;
}