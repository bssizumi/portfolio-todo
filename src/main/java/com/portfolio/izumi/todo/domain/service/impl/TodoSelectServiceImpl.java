package com.portfolio.izumi.todo.domain.service.impl;

import com.portfolio.izumi.todo.domain.dao.TTodoDao;
import com.portfolio.izumi.todo.domain.model.dto.TodoResponseDto;
import com.portfolio.izumi.todo.domain.model.entity.TTodo;
import com.portfolio.izumi.todo.domain.service.TodoSelectService;
import com.portfolio.izumi.todo.form.TodoSelectForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO取得サービス実装クラス
 */
@Service
public class TodoSelectServiceImpl implements TodoSelectService {
    /** TTodoDao */
    @Autowired
    private TTodoDao tTodoDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public TodoResponseDto execute(TodoSelectForm form) {
        // TODOを取得
        TTodo todo = tTodoDao.selectByTodoId(form.getTodoId());
        TodoResponseDto response = new TodoResponseDto(todo);
        return response;
    }
}