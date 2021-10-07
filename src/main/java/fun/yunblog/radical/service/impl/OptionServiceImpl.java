package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.mapper.OptionMapper;
import fun.yunblog.radical.model.domain.Option;
import fun.yunblog.radical.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionMapper optionMapper;

    @Override
    public List<Option> queryAllOption() {
        return optionMapper.selectAllOption();
    }

    @Override
    public Option queryOptionByOptionId(Long optionId) {
        return optionMapper.selectOptionByOptionId(optionId);
    }

    @Override
    public String queryOptionValueByOptionName(String optionName) {
        return optionMapper.selectOptionValueByOptionName(optionName);
    }
}
