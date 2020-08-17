package com.portfolio.izumi.todo.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.portfolio.izumi.todo.domain.dao.TListDao;
import com.portfolio.izumi.todo.domain.dao.TTodoDao;
import com.portfolio.izumi.todo.domain.model.dto.ListResponseDto;
import com.portfolio.izumi.todo.domain.model.dto.TodoResponseDto;
import com.portfolio.izumi.todo.domain.model.entity.TList;
import com.portfolio.izumi.todo.domain.model.entity.TTodo;
import com.portfolio.izumi.todo.domain.service.ListSelectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * リスト取得サービス実装クラス
 */
@Service
public class ListSelectServiceImpl implements ListSelectService {
    /** TListDao */
    @Autowired
    private TListDao tListDao;

    /** TTodoDao */
    @Autowired
    private TTodoDao tTodoDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ListResponseDto> execute() {
        // リストをすべて取得
        List<TList> lists = tListDao.selectAll();
        List<ListResponseDto> response = new ArrayList<>();
        if (lists != null) {
            lists.forEach((TList list) -> {
                // リストごとに子要素を取得する
                List<TTodo> todos = tTodoDao.selectByListId(list.getListId());
                ListResponseDto responseDto = new ListResponseDto();
                responseDto.setListId(list.getListId());
                responseDto.setTitle(list.getTitle());
                responseDto.setChildren(todos.stream().map((TTodo todo) -> {
                    return new TodoResponseDto(todo);
                }).collect(Collectors.toList()));
                response.add(responseDto);
            });
        }
        return response;
    }
}