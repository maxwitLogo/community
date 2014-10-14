//package com.project.utils;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.project.beam.BindingPhone;
//import com.project.beam.Bracelet;
//import com.project.beam.FenceBeam;
//import com.project.beam.MapPoint;
//import com.project.beam.MaxwitBeam;
//
//public class JsonUtils {
//
//	public static ArrayList<Bracelet> parseJsonBracelets(String html) {
//		ArrayList<Bracelet> list = new ArrayList<Bracelet>();
//		JSONArray jsonArray;
//		try {
//			jsonArray = new JSONObject(html).getJSONArray("data");
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
//				Bracelet object = new Bracelet();
//				if (jsonObject.has("braceletId")) {
//					object.setBraceletId(jsonObject.getInt("braceletId"));
//				}
//				if (jsonObject.has("bindingId")) {
//					object.setBindingId(jsonObject.getInt("bindingId"));
//				}
//				if (jsonObject.has("phoneCode")) {
//					object.setPhoneCode(jsonObject.getString("phoneCode"));
//				}
//				if (jsonObject.has("braceletImg")) {
//					object.setBraceletImg(jsonObject.getString("braceletImg"));
//				}
//				if (jsonObject.has("desc")) {
//					object.setDesc(jsonObject.getString("desc"));
//				}
//				if (jsonObject.has("braceletName")) {
//					object.setBraceletName(jsonObject.getString("braceletName"));
//				}
//
//				if (jsonObject.has("controlType")) {
//					object.setControlType(jsonObject.getInt("controlType"));
//				}
//				if (jsonObject.has("lat")) {
//					object.setLat(jsonObject.getDouble("lat"));
//				}
//				if (jsonObject.has("lon")) {
//					object.setLon(jsonObject.getDouble("lon"));
//				}
//				if (jsonObject.has("radius")) {
//					object.setRadius(Float.valueOf(jsonObject
//							.getString("radius")));
//				}
//				if (jsonObject.has("isOpenFence")) {
//					object.setIsOpenFence(jsonObject.getInt("isOpenFence"));
//				}
//				if (jsonObject.has("bindingImg")) {
//					object.setBindingImg(jsonObject.getString("bindingImg"));
//				}
//				list.add(object);
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public static ArrayList<Bracelet> parseLoginJsonBracelets(
//			JSONArray jsonArray) {
//		ArrayList<Bracelet> list = new ArrayList<Bracelet>();
//		try {
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
//				Bracelet object = new Bracelet();
//				if (jsonObject.has("braceletId")) {
//					object.setBraceletId(jsonObject.getInt("braceletId"));
//				}
//				if (jsonObject.has("bindingId")) {
//					object.setBindingId(jsonObject.getInt("bindingId"));
//				}
//				if (jsonObject.has("braceletImg")) {
//					object.setBraceletImg(jsonObject.getString("braceletImg"));
//				}
//				if (jsonObject.has("phoneCode")) {
//					object.setPhoneCode(jsonObject.getString("phoneCode"));
//				}
//				if (jsonObject.has("desc")) {
//					object.setDesc(jsonObject.getString("desc"));
//				}
//				if (jsonObject.has("controlType")) {
//					object.setControlType(jsonObject.getInt("controlType"));
//				}
//				if (jsonObject.has("lat")) {
//					object.setLat(jsonObject.getDouble("lat"));
//				}
//				if (jsonObject.has("lon")) {
//					object.setLon(jsonObject.getDouble("lon"));
//				}
//				if (jsonObject.has("radius")) {
//					object.setRadius(Float.valueOf(jsonObject
//							.getString("radius")));
//				}
//				if (jsonObject.has("isOpenFence")) {
//					object.setIsOpenFence(jsonObject.getInt("isOpenFence"));
//				}
//				if (jsonObject.has("bindingImg")) {
//					object.setBindingImg(jsonObject.getString("bindingImg"));
//				}
//				list.add(object);
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public static ArrayList<MaxwitBeam> parseMessageJson(String html) {
//		ArrayList<MaxwitBeam> list = new ArrayList<MaxwitBeam>();
//		JSONArray jsonArray;
//		try {
//			jsonArray = new JSONObject(html).getJSONArray("data");
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
//				MaxwitBeam object = new MaxwitBeam();
//				if (jsonObject.has("id")) {
//					object.setId(jsonObject.getInt("id"));
//				}
//				if (jsonObject.has("title")) {
//					object.setTitle(jsonObject.getString("title"));
//				}
//				if (jsonObject.has("message")) {
//					object.setMessage(jsonObject.getString("message"));
//				}
//
//				list.add(object);
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public static ArrayList<BindingPhone> parseJsonBindingPhones(String html) {
//		ArrayList<BindingPhone> list = new ArrayList<BindingPhone>();
//		JSONArray jsonArray;
//		try {
//			jsonArray = new JSONObject(html).getJSONArray("data");
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
//				BindingPhone bindingPhone = new BindingPhone();
//				bindingPhone.setControlType(jsonObject.getInt("controlType"));
//				bindingPhone.setName(jsonObject.getString("name"));
//				bindingPhone.setPhoneCode(jsonObject.getString("phoneCode"));
//				bindingPhone.setBindingId(jsonObject.getInt("bindingId"));
//
//				list.add(bindingPhone);
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public static ArrayList<FenceBeam> parseJsonFence(String html) {
//		ArrayList<FenceBeam> list = new ArrayList<FenceBeam>();
//		JSONArray jsonArray;
//		try {
//			jsonArray = new JSONObject(html).getJSONArray("data");
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
//				FenceBeam fenceBeam = new FenceBeam();
//				if (jsonObject.has("fenceId")) {
//					fenceBeam.setFenceId(jsonObject.getInt("fenceId"));
//				}
//				if (jsonObject.has("latitude")) {
//					fenceBeam.setLatitude(jsonObject.getDouble("latitude"));
//				}
//				if (jsonObject.has("longitude")) {
//					fenceBeam.setLongitude(jsonObject.getDouble("longitude"));
//				}
//				if (jsonObject.has("radius")) {
//					fenceBeam.setRadius(jsonObject.getDouble("radius"));
//				}
//				if (jsonObject.has("desc")) {
//					fenceBeam.setDesc(jsonObject.getString("desc"));
//				}
//				if (jsonObject.has("locationName")) {
//					fenceBeam.setLocationName(jsonObject
//							.getString("locationName"));
//				}
//				list.add(fenceBeam);
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public static ArrayList<MapPoint> parseJsonMapPoint(String html) {
//		ArrayList<MapPoint> list = new ArrayList<MapPoint>();
//		JSONArray jsonArray;
//		try {
//			jsonArray = new JSONObject(html).getJSONArray("data");
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
//				MapPoint mapPoint = new MapPoint();
//				mapPoint.setX(jsonObject.getDouble("x"));
//				mapPoint.setY(jsonObject.getDouble("y"));
//				mapPoint.setTimes(jsonObject.getLong("times"));
//				list.add(mapPoint);
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//}
