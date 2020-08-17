package com.portfolio.izumi.todo.domain.service.impl;

import java.time.LocalDate;

import com.portfolio.izumi.todo.domain.dao.TTodoDao;
import com.portfolio.izumi.todo.domain.model.entity.TTodo;
import com.portfolio.izumi.todo.domain.service.TodoUpdateService;
import com.portfolio.izumi.todo.form.TodoUpdateForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * TODO更新サービス実装クラス
 */
@Service
public class TodoUpdateServiceImpl implements TodoUpdateService {
    /** TTodoDao */
    @Autowired
    private TTodoDao tTodoDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean execute(TodoUpdateForm form) {
        // TODOを更新
        TTodo todo = new TTodo();
        todo.setTodoId(form.getTodoId());
        todo.setListId(form.getListId());
        todo.setTitle(form.getTitle());
        todo.setBody(form.getBody());
        todo.setDone(form.isDone());
        if (!StringUtils.isEmpty(form.getLimitDateTime())) {
            todo.setLimitDateTime(LocalDate.parse(form.getLimitDateTime()));
        }
        int updateCnt = tTodoDao.update(todo);
        if (updateCnt != 1) {
            throw new RuntimeException("更新失敗");
        }
        return true;
    }
}