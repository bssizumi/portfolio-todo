package com.portfolio.izumi.todo.controller;

import java.util.List;

import com.portfolio.izumi.todo.domain.model.dto.ListResponseDto;
import com.portfolio.izumi.todo.domain.model.dto.TodoResponseDto;
import com.portfolio.izumi.todo.domain.service.ListSelectService;
import com.portfolio.izumi.todo.domain.service.TodoCreateService;
import com.portfolio.izumi.todo.domain.service.TodoDeleteService;
import com.portfolio.izumi.todo.domain.service.TodoSelectService;
import com.portfolio.izumi.todo.domain.service.TodoUpdateService;
import com.portfolio.izumi.todo.form.TodoCreateForm;
import com.portfolio.izumi.todo.form.TodoDeleteForm;
import com.portfolio.izumi.todo.form.TodoSelectForm;
import com.portfolio.izumi.todo.form.TodoUpdateForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODOコントローラ.
 * 
 * TODOの情報を制御するコントローラクラス
 * 
 */
@RestController
@CrossOrigin
@RequestMapping("todo")
public class TodoController {

    /** TodoSelectService */
    @Autowired
    private TodoSelectService todoSelectService;
    /** TodoCreateService */
    @Autowired
    private TodoCreateService todoCreateService;
    /** TodoUpdateService */
    @Autowired
    private TodoUpdateService todoUpdateService;
    /** TodoDeleteService */
    @Autowired
    private TodoDeleteService todoDeleteService;

    /** ListSelectService */
    @Autowired
    private ListSelectService listSelectService;

    /**
     * TODO作成
     *
     * @param form
     * @return
     */
    @PostMapping("create")
    public List<ListResponseDto> createTodo(@RequestBody TodoCreateForm form) {
        todoCreateService.execute(form);
        return listSelectService.execute();
    }

    /**
     * TODOの詳細を取得
     * 
     * @param form
     * @return
     */
    @PostMapping("select")
    public TodoResponseDto selectTodo(@RequestBody TodoSelectForm form) {
        return todoSelectService.execute(form);
    }

    /**
     * TODO変更
     *
     * @param form
     * @return
     */
    @PostMapping("update")
    public List<ListResponseDto> updateTodo(@RequestBody TodoUpdateForm form) {
        todoUpdateService.execute(form);
        return listSelectService.execute();

    }

    /**
     * TODO削除
     *
     * @param form
     * @return
     */
    @PostMapping("delete")
    public List<ListResponseDto> deleteTodo(@RequestBody TodoDeleteForm form) {
        todoDeleteService.execute(form);
        return listSelectService.execute();
    }

}
