package com.escaravellovermello.converter;

import org.springframework.stereotype.Component;

import com.escaravellovermello.entity.Activity;
import com.escaravellovermello.model.ActivityModel;

@Component("activityConverter")
public class ActivityConverter {

	public ActivityModel entity2model(Activity activity) {
		ActivityModel activityModel = new ActivityModel();
		activityModel.setId(activity.getId());
		activityModel.setDespription(activity.getDespription());
		activityModel.setName(activity.getName());
		return activityModel;
	}

	public Activity model2activity(ActivityModel activityModel) {
		Activity activity = new Activity();
		activity.setId(activityModel.getId());
		activity.setDespription(activityModel.getDespription());
		activity.setName(activityModel.getName());
		return activity;
	}
}
