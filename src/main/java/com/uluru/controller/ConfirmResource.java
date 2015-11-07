package com.uluru.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import com.uluru.bean.ConfirmBean;
import com.uluru.form.InputForm;
import com.uluru.model.InputStationItem;
import com.uluru.model.TimeData;
import com.uluru.service.StationService;

/**
 * 入力内容を確認するコントローラ
 * 
 * @author imazato
 *
 */
@Path("/confirm")
public class ConfirmResource {

	StationService stationService = new StationService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ConfirmBean getJson() {

        return new ConfirmBean();
    }
	
	@GET
	public Viewable handleRequest(@Context ResourceContext rc) {

		// 入力フォーム情報の取得
		InputForm form = rc.getResource(InputForm.class);

		// 入力確定画面に渡すbeanを作成
		ConfirmBean confirmBean = new ConfirmBean();

		// エラーメッセージリストを作成
		List<String> errorMessages = new ArrayList<String>();

		// 入力情報から集合時間のオブジェクトを作成
		TimeData meetingTime = new TimeData();
		meetingTime.setDate(form.getYear(), form.getMonth(), form.getDay());
		meetingTime.setTime(form.getHour(), form.getMinute());
		confirmBean.setMeetingTime(meetingTime);

		// 入力確定画面に表示するための駅一覧情報を作成
		List<InputStationItem> stationItemList = stationService.findInputStationItemList(form.getStationList(),
				errorMessages);
		confirmBean.setInputStationItemList(stationItemList);

		if (errorMessages.isEmpty()) {
			return new Viewable("/WEB-INF/jsp/confirm", confirmBean);
		} else {
			return new Viewable("/WEB-INF/jsp/inputForm", errorMessages);
		}
	}

}