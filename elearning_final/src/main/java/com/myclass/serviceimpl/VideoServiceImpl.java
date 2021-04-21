package com.myclass.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;

@Service
@Scope("prototype")
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public List<VideoDto> findAll() {
		List<VideoDto> listVideoDto = new ArrayList<VideoDto>();
		try {
			List<Video> entities = videoRepository.findAll();
			for (Video entity : entities) {
				VideoDto videoDto = new VideoDto();
				videoDto.setId(entity.getId());
				videoDto.setTitle(entity.getTitle());
				videoDto.setUrl(entity.getUrl());
				videoDto.setTimeCount(entity.getTimeCount());
				videoDto.setCourseId(entity.getCourseId());
				
				listVideoDto.add(videoDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listVideoDto;
	}

	@Override
	public boolean insert(VideoDto videoDto) {
		try {
			Video entity = new Video(videoDto.getTitle(), videoDto.getUrl(), videoDto.getTimeCount(), videoDto.getCourseId());
			videoRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public VideoDto findById(int id) {
		VideoDto videoDto = new VideoDto();
		try {
			Video entity = videoRepository.findById(id).get();
			videoDto.setId(entity.getId());
			videoDto.setTitle(entity.getTitle());
			videoDto.setUrl(entity.getUrl());
			videoDto.setTimeCount(entity.getTimeCount());
			videoDto.setCourseId(entity.getCourseId());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return videoDto;
	}

	@Override
	public boolean update(int id, VideoDto videoDto) {
		try {
			Video entity = videoRepository.findById(id).get();
			entity.setTitle(videoDto.getTitle());
			entity.setUrl(videoDto.getUrl());
			entity.setTimeCount(videoDto.getTimeCount());
			entity.setCourseId(videoDto.getCourseId());
			
			videoRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			videoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
