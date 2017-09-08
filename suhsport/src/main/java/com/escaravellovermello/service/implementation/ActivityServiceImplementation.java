package com.escaravellovermello.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.escaravellovermello.converter.ActivityConverter;
import com.escaravellovermello.entity.Activity;
import com.escaravellovermello.model.ActivityModel;
import com.escaravellovermello.repository.ActivityRepository;
import com.escaravellovermello.service.ActivityService;

@Service("activityService")
public class ActivityServiceImplementation implements ActivityService {

	@Autowired
	@Qualifier("activityRepository")
	public ActivityRepository activityRepository;

	@Autowired
	@Qualifier("activityConverter")
	public ActivityConverter activityConverter;

	@Override
	public List<ActivityModel> listAllActivities() {
		List<Activity> activitiesList = activityRepository.findAll();
		List<ActivityModel> activitiesModelList = new ArrayList<>();
		for (Activity activity : activitiesList) {
			activitiesModelList.add(activityConverter.entity2model(activity));
		}
		return activitiesModelList;
	}

}
