package com.myclass.service;

import java.util.List;

import com.myclass.dto.VideoDto;

public interface VideoService {

	List<VideoDto> findAll();
	boolean insert(VideoDto videoDto);
	VideoDto findById(int id);
	boolean update(int id, VideoDto videoDto);
	boolean delete(int id);
}
