package com.portfolio.izumi.todo.domain.service.impl;

import java.time.LocalDate;

import com.portfolio.izumi.todo.domain.dao.TTodoDao;
import com.portfolio.izumi.todo.domain.model.entity.TTodo;
import com.portfolio.izumi.todo.domain.service.TodoCreateService;
import com.portfolio.izumi.todo.form.TodoCreateForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * TODO作成サービス実装クラス
 */
@Service
public class TodoCreateServiceImpl implements TodoCreateService {
    /** TTodoDao */
    @Autowired
    private TTodoDao tTodoDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean execute(TodoCreateForm form) {
        // TODOを作成
        TTodo todo = new TTodo();
        todo.setListId(form.getListId());
        todo.setTitle(form.getTitle());
        todo.setBody(form.getBody());
        if (!StringUtils.isEmpty(form.getLimitDateTime())) {
            todo.setLimitDateTime(LocalDate.parse(form.getLimitDateTime()));
        }
        int insertCnt = tTodoDao.insert(todo);
        if (insertCnt != 1) {
            throw new RuntimeException("作成失敗");
        }
        return true;
    }
}