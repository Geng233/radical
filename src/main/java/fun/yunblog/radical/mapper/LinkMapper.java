package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Link;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@Mapper
public interface LinkMapper {

    @Select("select * from link")
    List<Link> selectAllLink();

    @Select("select * from  link where linkId = #{linkId}")
    Link selectLinkByLinkId(Long linkId);

    @Update("update link set linkName = #{linkName},linkName = #{linkName},linkUrl = #{linkUrl}," +
            "linkDescription = #{linkDescription},linkPic = #{linkPic}, linkState = #{linkState}" +
            "where linkId = #{linkId}")
    boolean updateLink(Long linkId, String linkName, String linkUrl, String linkDescription, String linkPic, String linkState);

    @Delete("delete from link where linkId = #{linkId}")
    boolean deleteLinkByLinkId(Long linkId);

    @Insert("insert into link (`linkId`, `linkName`, `linkUrl`, `linkDescription`, `linkPic`, `linkState`) " +
            "values (#{linkId},#{linkName},#{linkUrl},#{linkDescription},#{linkPic}," +
            "#{linkState})")
    boolean insertLink(Long linkId, String linkName, String linkUrl, String linkDescription, String linkPic, String linkState);
}
