package com.stackroute.favouriteservice.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.favouriteservice.model.Matches;
import com.stackroute.favouriteservice.repository.CricketMatchRepository;
import com.stackroute.favouriteservice.util.exception.CricketMatchAlreadyExistsException;
import com.stackroute.favouriteservice.util.exception.CricketMatchNotFoundException;

@Service
@Transactional
public class CricketMatchServiceImpl implements CricketMatchService {
	private CricketMatchRepository cricketMatchRepository;

	@Autowired
	public CricketMatchServiceImpl(CricketMatchRepository newsRepository) {
		super();
		this.cricketMatchRepository = newsRepository;
	}

	@Override
	public Matches addCricketMatch(Matches cricketMatch) throws CricketMatchAlreadyExistsException {
		return cricketMatchRepository.save(cricketMatch);
	}

	@Override
	public Matches getAllCricketMatches(String uniqueId) throws CricketMatchNotFoundException {

		Optional<Matches> optional = cricketMatchRepository.findById(Integer.valueOf(uniqueId));
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CricketMatchNotFoundException(uniqueId);
		}

	}

	@Override
	public boolean deleteCricketMatchByUniqueId(String uniqueId) throws CricketMatchNotFoundException {

		boolean isDeleted = false;
		Optional<Matches> optional = cricketMatchRepository.findById(Integer.valueOf(uniqueId));
		if (optional.isPresent()) {
			cricketMatchRepository.save(optional.get());
			isDeleted = true;
		} else {
			throw new CricketMatchNotFoundException(uniqueId);
		}

		return isDeleted;
	}

	@Override
	public boolean updateCricketMatches(Matches cricketMatchDto) throws CricketMatchNotFoundException {
		boolean isCrickMatchUpdated = false;
		try {
			Optional<Matches> optional = cricketMatchRepository.findById(cricketMatchDto.getMatchId());

			if (optional.isPresent()) {
				BeanUtils.copyProperties(cricketMatchDto, optional.get());
				cricketMatchRepository.save(cricketMatchDto);
				isCrickMatchUpdated = true;

			} else {
				throw new CricketMatchNotFoundException("Cricket match not found in the records");
			}

			return isCrickMatchUpdated;
		} catch (Exception e) {
			throw new CricketMatchNotFoundException("Cricket match not found in the records");
		}
	}

//	public News updateNews(News news, int newsId, String userId) throws NewsNotFoundException {
//
//		try {
//
//			Optional<UserNews> userNewsOptional = newsRepository.findById(userId);
//			if (userNewsOptional.isPresent()) {
//				UserNews userNewsObj = userNewsOptional.get();
//				List<News> newsList = userNewsObj.getNewslist();
//				if (!newsList.isEmpty()) {
//					newsList.stream().filter(newsObj -> newsObj.getNewsId() == newsId).findFirst()
//							.ifPresent(newsObj -> BeanUtils.copyProperties(news, newsObj));
//					userNewsObj.setNewslist(Arrays.asList(news));
//					newsRepository.save(userNewsObj);
//				}
//
//			} else {
//				throw new NewsNotFoundException(userId);
//			}
//		} catch (Exception e) {
//			throw new NewsNotFoundException(userId);
//		}
//
//		return news;
//	}
//
//	public News getNewsByNewsId(String userId, int newsId) throws NewsNotFoundException {
//
//		try {
//			Optional<UserNews> optional = newsRepository.findById(userId);
//			if (optional.isPresent()) {
//				UserNews userNews = optional.get();
//				List<News> newsList = userNews.getNewslist();
//				Optional<News> optionalNews = Optional
//						.ofNullable(newsList.stream().filter(news -> news.getNewsId() == newsId).findFirst()
//								.orElseThrow(() -> new NewsNotFoundException(userId)));
//
//				return optionalNews.isPresent() ? optionalNews.get() : null;
//			} else {
//				throw new NewsNotFoundException(userId);
//			}
//		} catch (Exception e) {
//			throw new NewsNotFoundException(userId);
//		}
//	}
//
//	public List<News> getAllNewsByUserId(String userId) {
//
//		Optional<UserNews> optional = newsRepository.findById(userId);
//		if (optional.isPresent()) {
//			return optional.get().getNewslist();
//		} else {
//			return Collections.emptyList();
//		}
//	}

}
