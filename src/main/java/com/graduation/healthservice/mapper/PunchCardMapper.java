package com.graduation.healthservice.mapper;

import com.graduation.healthservice.domain.PunchCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author moyu
 * @since 2022-04-18
 */
public interface PunchCardMapper extends BaseMapper<PunchCard> {

    @Select("select user,count(day) from punch_card group by user order by count(day) desc")
    List<PunchCard> getPunchCardRank();
}
