package com.portfolio.izumi.todo.domain.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/** リストレスポンスDTO */
@Getter
@Setter
public class ListResponseDto {
    /** リストID. */
    private int listId;

    /** タイトル. */
    private String title;

    /** 子要素TODO. */
    private List<TodoResponseDto> children;

}