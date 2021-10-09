package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Option;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
public interface OptionService {

    List<Option> queryAllOption();

    Option queryOptionByOptionId(Long  optionId);

    String queryOptionValueByOptionName(String optionName);

}
