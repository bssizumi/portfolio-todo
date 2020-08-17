package com.portfolio.izumi.todo.domain.service;

import com.portfolio.izumi.todo.form.ListDeleteForm;

/**
 * List削除サービスインターフェース
 */
public interface ListDeleteService {
    /**
     * List削除
     * 
     * @param form List削除フォーム
     * @return 実行結果
     */
    boolean execute(ListDeleteForm form);
}