package com.portfolio.izumi.todo.domain.dao;

import java.util.List;

import com.portfolio.izumi.todo.domain.model.entity.TList;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

/** リストマスタDao */
@ConfigAutowireable
@Dao
public interface TListDao {

    /**
     * すべてのリストを取得する.
     * 
     * @return TList
     */
    @Select
    List<TList> selectAll();

    /**
     * リストを挿入する.
     * 
     * @param list TList
     * @return 挿入件数
     */
    @Insert(excludeNull = true)
    int insert(TList list);

    /**
     * リストを更新する.
     * 
     * @param list TList
     * @return 更新件数
     */
    @Update(excludeNull = true)
    int update(TList list);

    /**
     * リストを削除する.
     * 
     * @param list TList
     * @return 削除件数
     */
    @Delete
    int delete(TList list);
}