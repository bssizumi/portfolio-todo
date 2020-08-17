package com.portfolio.izumi.todo.domain.service;

import com.portfolio.izumi.todo.form.ListCreateForm;

/**
 * リスト作成サービスインターフェース
 */
public interface ListCreateService {
    /**
     * リスト作成
     * 
     * @param form リスト作成フォーム
     * @return 実行結果
     */
    boolean execute(ListCreateForm form);
}