package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
@ApiModel("音乐实体")
@Data
public class Music {
//    title: 'Touch the starlight', //歌曲名称
//    artist: 'Funton', //演唱者
//    lrc: '', //LRC 歌词或者歌词文件的 URL
//    pic: '', //封面图片 URL
//    src: 'https://music.163.com/song/media/outer/url?id=1337350239.mp3' //音频文件的 URL,改掉网抑云网址上的url即可


    @ApiModelProperty("音乐id")
    private Long musicId;

    @ApiModelProperty("音乐标题")
    private String musicTitle;

    @ApiModelProperty("音乐作者")
    private String musicArtist;

    @ApiModelProperty("音乐歌词文件")
    private String musicLrc;

    @ApiModelProperty("音乐图片")
    private String musicPic;

    @ApiModelProperty("音乐路径")
    private String musicSrc;
}
