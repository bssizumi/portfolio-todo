package com.portfolio.izumi.todo.domain.service;

import com.portfolio.izumi.todo.form.TodoCreateForm;

/**
 * TODO作成サービスインターフェース
 */
public interface TodoCreateService {
    /**
     * TODO作成
     * 
     * @param form TODO作成フォーム
     * @return 実行結果
     */
    boolean execute(TodoCreateForm form);
}