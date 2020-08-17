package com.portfolio.izumi.todo.domain.service.impl;

import com.portfolio.izumi.todo.domain.dao.TListDao;
import com.portfolio.izumi.todo.domain.model.entity.TList;
import com.portfolio.izumi.todo.domain.service.ListCreateService;
import com.portfolio.izumi.todo.form.ListCreateForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * リスト作成サービス実装クラス
 */
@Service
public class ListCreateServiceImpl implements ListCreateService {
    /** TListDao */
    @Autowired
    private TListDao tListDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean execute(ListCreateForm form) {
        // リストを作成
        TList list = new TList();
        list.setTitle(form.getTitle());
        int insertCnt = tListDao.insert(list);
        if (insertCnt != 1) {
            throw new RuntimeException("作成失敗");
        }
        return true;
    }
}