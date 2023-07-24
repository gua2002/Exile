package com.health.service.impl;

import com.health.mapper.AnnounceMapper;
import com.health.po.Announcement;
import com.health.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName AnnounceServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class AnnounceServiceImpl implements AnnounceService {
    @Autowired
    private AnnounceMapper announceMapper;
    @Override
    public List<Announcement> findAnnounce() {
        return announceMapper.findAnnounce();
    }

    @Override
    public int addAnnounce(Announcement announcement) {
        return announceMapper.addAnnounce(announcement);
    }

    @Override
    public int deleteAnnounceById(Integer announcementid) {
        return announceMapper.deleteAnnounceById(announcementid);
    }

    @Override
    public List<Announcement> findAnnounceByTime() {
        return announceMapper.findAnnounceByTime();
    }
}
