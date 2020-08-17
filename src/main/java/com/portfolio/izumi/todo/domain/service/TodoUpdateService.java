package com.portfolio.izumi.todo.domain.service;

import com.portfolio.izumi.todo.form.TodoUpdateForm;

/**
 * TODO更新サービスインターフェース
 */
public interface TodoUpdateService {
    /**
     * TODO更新
     * 
     * @param form TODO更新フォーム
     * @return
     */
    boolean execute(TodoUpdateForm form);
}