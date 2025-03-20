package com.radish.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DongUtil {
	
	private final String path = "https://www.code.go.kr/stdcode/regCodeL.do?";
	private static DongUtil instance;
	private DongUtil() {}
	public static DongUtil getInstance() {
		if (instance == null) instance = new DongUtil();
		return instance;
	}
	
	public List<String> getDongFilterList(String gu, String dong) {
		List<String> list = null;
		try {
			String querySet = getQuerySet(path, gu, dong);
			list = getDongsIncludeCode(path, querySet);
		} catch (Exception e) {
			System.out.println("getDongFilterList fail");
			e.printStackTrace();
		}
		return list;
	}
	
	private String getQuerySet(String path, String gu, String dong) throws Exception {
		Document doc = Jsoup.connect(path + "locataddNm=" +gu +"%20"+ dong).get();
		String fullCode = doc.select("td.table_left").getLast().text();
		String sidoCd = fullCode.substring(0, 2);
		String sggCd = fullCode.substring(2, 5);
		String query = "pageSize=" + 100 + "&sidoCd=" + sidoCd + "&sggCd=" + sggCd + "&cPage=";
		return query;
	}
	
	private List<String> getDongsIncludeCode(String path, String querySet) throws Exception{
		int cPage = 1;
		String sigu = null;
		List<String> list = new ArrayList<>();
		String query = querySet + cPage++;
		Document doc = Jsoup.connect(path + query).get();
		for(String juso : doc.select("td.table_center01").eachText()) {
			if(sigu == null)
				sigu = juso;
			juso = juso.replace(sigu, "").trim();
			if(!juso.contains(" ") && !juso.isBlank()) {
				list.add(juso);
			}
		}
		return list;
	}
}
