package com.bs.poetry.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 格式化诗句按中文标点符号分割成数组
 * @author ben
 *
 */
public class UtilsForString {
	public String[] formatStringForPoetry(String str){		
		char[] charArr = str.toCharArray();	
		String[] poetryStr = new String[charArr.length];
		char[] charTemp = new char[charArr.length];
		poetryStr[0] = new String(charArr);
		int j = 0;//临时字符数组下标
		int k = 0;//字符串下标
		for(int i=0;i<charArr.length;i++){
			charTemp[j] = charArr[i];
			j++;
			//按照“，”截取成字符串数组
			if(charArr[i] == ',' || charArr[i] == '，'){
				poetryStr[k] = new String(charTemp,0,j);
				j = 0;
				k += 1;
			//按照“。”截取成字符串数组
			} else if(charArr[i] == '.' || charArr[i] == '。'){
				poetryStr[k] = new String(charTemp,0,j);
				j = 0;
				k += 1;
			//按照“？”截取成字符串数组
			} else if(charArr[i] == '?' || charArr[i] == '？'){
				poetryStr[k] = new String(charTemp,0,j);
				j = 0;
				k += 1;
			//按照“；”截取成字符串数组
			} else if(charArr[i] == ';' || charArr[i] == '；'){
				poetryStr[k] = new String(charTemp,0,j);
				j = 0;
				k += 1;
			}
		}
		
		//除去数组后面的空值
		List<String> tmpList = new ArrayList<String>();
		for(String s : poetryStr){
			if(s != null && s.length() !=0){
				tmpList.add(s);
			}
		}
		
		poetryStr  = tmpList.toArray(new String[0]);
		
		return poetryStr;
	}
}
