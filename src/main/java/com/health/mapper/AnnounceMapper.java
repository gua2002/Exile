package com.health.mapper;

import com.health.po.Announcement;

import java.util.List;

/**
 * @author wuyang
 * @ClassName AnnounceMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface AnnounceMapper {

    List<Announcement> findAnnounce();

    int addAnnounce(Announcement announcement);

    int deleteAnnounceById(Integer announcementid);

    List<Announcement> findAnnounceByTime();
}
