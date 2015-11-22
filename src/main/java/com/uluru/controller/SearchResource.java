package com.uluru.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.mvc.Viewable;

import com.uluru.bean.ResultBean;
import com.uluru.form.ConfirmForm;
import com.uluru.model.Result;
import com.uluru.model.TimeData;
import com.uluru.service.StationService;

import java.util.ArrayList;
import java.util.List;

/**
 * 中間駅を検索するリソース
 * 
 * @author imazato
 *
 */
@Path("/search")
public class SearchResource {

	StationService stationService = new StationService();

	@GET
	public Viewable handleRequest(@Context UriInfo info) {

		// 入力確認フォーム情報の取得
		ConfirmForm form = new ConfirmForm(info);

		// 入力確定画面に渡すbeanを作成
		ResultBean resultBean = new ResultBean();

		// 入力情報から集合時間のオブジェクトを作成
		TimeData meetingTime = new TimeData();
		meetingTime.setDate(form.getYear(), form.getMonth(), form.getDay());
		meetingTime.setTime(form.getHour(), form.getMinute());
		resultBean.setMeetingTime(meetingTime);

		// 集合駅の検索結果を取得
		List<Integer> testIdList = new ArrayList<>();
		testIdList.add(1130208);
		testIdList.add(1130210);
		Result result = stationService.searchUluruSpot(testIdList);
		//Result result = stationService.searchUluruSpot(form.getStationIdList());
		resultBean.setDestinationStationName(result.getDestinationStationName());
		resultBean.setDepartureStationList(result.getResultStationList());

		// 結果表示画面に移動
		return new Viewable("/WEB-INF/jsp/result", resultBean);
	}
}
