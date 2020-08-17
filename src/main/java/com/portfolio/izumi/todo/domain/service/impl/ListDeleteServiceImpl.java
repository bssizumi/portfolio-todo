package com.portfolio.izumi.todo.domain.service.impl;

import com.portfolio.izumi.todo.domain.dao.TListDao;
import com.portfolio.izumi.todo.domain.model.entity.TList;
import com.portfolio.izumi.todo.domain.service.ListDeleteService;
import com.portfolio.izumi.todo.form.ListDeleteForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * リスト作成サービス実装クラス
 */
@Service
public class ListDeleteServiceImpl implements ListDeleteService {
    /** TListDao */
    @Autowired
    private TListDao tListDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean execute(ListDeleteForm form) {
        // リストを削除
        TList list = new TList();
        list.setListId(form.getListId());
        int deleteCnt = tListDao.delete(list);
        if (deleteCnt != 1) {
            throw new RuntimeException("削除失敗");
        }
        return true;
    }
}