package com.portfolio.izumi.todo.domain.service;

import com.portfolio.izumi.todo.domain.model.dto.TodoResponseDto;
import com.portfolio.izumi.todo.form.TodoSelectForm;

/**
 * TODO取得サービスインターフェース
 */
public interface TodoSelectService {
    /**
     * TODO取得
     * 
     * @param form TODO取得フォーム
     * @return TODOレスポンスDTO
     */
    TodoResponseDto execute(TodoSelectForm form);
}