package com.portfolio.izumi.todo.domain.dao;

import java.util.List;

import com.portfolio.izumi.todo.domain.model.entity.TTodo;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

/** TODOマスタDao */
@ConfigAutowireable
@Dao
public interface TTodoDao {

    /**
     * TODOIDに一致するTODOを取得する
     * 
     * @param todoId TODOID
     * @return TTODO
     */
    @Select
    TTodo selectByTodoId(int todoId);

    /**
     * リストIDに一致するTODOを取得する.
     * 
     * @param listId リストID
     * @return TTODO
     */
    @Select
    List<TTodo> selectByListId(int listId);

    /**
     * TODOを挿入する.
     * 
     * @param todo TTODO
     * @return 挿入件数
     */
    @Insert(excludeNull = true)
    int insert(TTodo todo);

    /**
     * TODOを更新する.
     * 
     * @param todo TTODO
     * @return 更新件数
     */
    @Update(excludeNull = true)
    int update(TTodo todo);

    /**
     * TODOを削除する.
     * 
     * @param todoId TODOID
     * @return 削除件数
     */
    @Delete
    int delete(TTodo todo);
}