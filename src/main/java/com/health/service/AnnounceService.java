package com.health.service;

import com.health.po.Announcement;

import java.util.List;

/**
 * @author wuyang
 * @ClassName AnnounceService
 * @Description 通知服务接口
 * @Version 1.0
 **/
public interface AnnounceService {
    List<Announcement> findAnnounce();

    int addAnnounce(Announcement announcement);

    int deleteAnnounceById(Integer announcementid);

    List<Announcement> findAnnounceByTime();
}
