package com.portfolio.izumi.todo.controller;

import java.util.List;

import com.portfolio.izumi.todo.domain.model.dto.ListResponseDto;
import com.portfolio.izumi.todo.domain.service.ListCreateService;
import com.portfolio.izumi.todo.domain.service.ListDeleteService;
import com.portfolio.izumi.todo.domain.service.ListSelectService;
import com.portfolio.izumi.todo.form.ListCreateForm;
import com.portfolio.izumi.todo.form.ListDeleteForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * リストコントローラ.
 * 
 * リストの情報を制御するコントローラクラス
 * 
 */
@RestController
@CrossOrigin
@RequestMapping("list")
public class ListController {

    /** ListSelectService */
    @Autowired
    private ListSelectService listSelectService;
    /** ListCreateService */
    @Autowired
    private ListCreateService listCreateService;
    /** ListDeleteService */
    @Autowired
    private ListDeleteService listDeleteService;

    /**
     * リスト作成
     *
     * @param form
     * @return
     */
    @PostMapping("create")
    public List<ListResponseDto> createList(@RequestBody ListCreateForm form) {
        listCreateService.execute(form);
        return listSelectService.execute();
    }

    /**
     * リスト取得
     *
     * @param form
     * @return
     */
    @PostMapping("select")
    public List<ListResponseDto> selectList() {
        return listSelectService.execute();
    }

    /**
     * リスト削除
     *
     * @param form
     * @return
     */
    @PostMapping("delete")
    public List<ListResponseDto> deleteList(@RequestBody ListDeleteForm form) {
        listDeleteService.execute(form);
        return listSelectService.execute();
    }

}