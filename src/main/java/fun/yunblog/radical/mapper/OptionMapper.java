package fun.yunblog.radical.mapper;


import fun.yunblog.radical.model.domain.Option;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@Mapper
public interface OptionMapper {

    @Select("select * from `option`")
    List<Option> selectAllOption();

    @Select("select * from `option` where optionId = #{optionId}")
    Option selectOptionByOptionId(Long optionId);

    @Select("select optionValue from `option` where optionName = #{optionName}")
    String selectOptionValueByOptionName(String optionName);
}
