package com.portfolio.izumi.todo.domain.service;

import java.util.List;

import com.portfolio.izumi.todo.domain.model.dto.ListResponseDto;

/**
 * リスト取得サービスインターフェース
 */
public interface ListSelectService {
    /**
     * リスト取得
     * 
     * @return リストレスポンスDTO
     */
    List<ListResponseDto> execute();
}