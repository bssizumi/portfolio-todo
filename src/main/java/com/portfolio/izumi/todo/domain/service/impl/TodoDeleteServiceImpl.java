package com.portfolio.izumi.todo.domain.service.impl;

import com.portfolio.izumi.todo.domain.dao.TTodoDao;
import com.portfolio.izumi.todo.domain.model.entity.TTodo;
import com.portfolio.izumi.todo.domain.service.TodoDeleteService;
import com.portfolio.izumi.todo.form.TodoDeleteForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO作成サービス実装クラス
 */
@Service
public class TodoDeleteServiceImpl implements TodoDeleteService {
    /** TTodoDao */
    @Autowired
    private TTodoDao tTodoDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean execute(TodoDeleteForm form) {
        // TODOを削除
        TTodo todo = new TTodo();
        todo.setTodoId(form.getTodoId());
        int deleteCnt = tTodoDao.delete(todo);
        if (deleteCnt != 1) {
            throw new RuntimeException("削除失敗");
        }
        return true;
    }
}