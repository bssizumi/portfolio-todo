package com.portfolio.izumi.todo.domain.service;

import com.portfolio.izumi.todo.form.TodoDeleteForm;

/**
 * TODO削除サービスインターフェース
 */
public interface TodoDeleteService {
    /**
     * TODO削除
     * 
     * @param form TODO削除フォーム
     * @return 実行結果
     */
    boolean execute(TodoDeleteForm form);
}