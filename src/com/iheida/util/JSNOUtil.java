package com.iheida.util;
import java.beans.IntrospectionException;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



import com.iheida.domin.TotalJson;

/**
 * Title: Ext JS 辅助类
 * Description: 该类用于转换java对象为XML文件格式或JSON文件格式
 * @author weijun
 * @time: 2008.07.09
 */
public class JSNOUtil {
	/**
	 * 通过List生成XML数据
	 * @param recordTotal 记录总数，不一定与beanList中的记录数相等
	 * @param beanList 包含bean对象的集合
	 * @return 生成的XML数据
	 */
	/*public static String getXmlFromList(int recordTotal , List beanList) {
		Total total = new Total();
		total.setResults(recordTotal);
		List results = new ArrayList();
		results.add(total);
		results.addAll(beanList);
		XStream sm = new XStream(new DomDriver());
		for (int i = 0; i < results.size(); i++) {
			Class c = results.get(i).getClass();
			String b = c.getName();
			String[] temp = b.split("\\.");
			sm.alias(temp[temp.length - 1], c);
		}
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"	+ sm.toXML(results);
		return xml;
	}
	*//**
	 * 通过List生成XML数据  
	 * @param beanList 包含bean对象的集合    
	 * @return 生成的XML数据  
	 *//*
	public static String getXmlFromList(List beanList,int Bsize){
		return getXmlFromList(Bsize,beanList);  
	}        */
	/**
	 * 通过List生成JSON数据
	 * @param recordTotal 记录总数，不一定与beanList中的记录数相等
	 * @param beanList 包含bean对象的集合
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromList(long recordTotal , List beanList){
		int start = 0;
		int limit = 10;
		TotalJson total = new TotalJson();
		List Ll = new ArrayList();
		total.setResults(recordTotal);
		total.setItems(beanList);   
		JSONObject JsonObject = JSONObject.fromObject(total);
		return JsonObject.toString();
	}
	/**  
	 * 通过List生成JSON数据
	 * @param beanList 包含bean对象的集合
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromList(List beanList){
		return getJsonFromList(beanList.size(),beanList);
	}
	/**
	 * 通过bean生成JSON数据
	 * @param bean bean对象
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromBean(Object bean){
		JSONObject JsonObject = JSONObject.fromObject(bean);
		return JsonObject.toString();
	}
	/**  
	 * 通过JSON生成List数据
	 */
	public static List<?> getListFromJson(String jsonString,Class<?> tclass){
	     //把json数组字符串转换成json数组
		  JSONArray jsonArray2= JSONArray.fromObject(jsonString);
		  //将josn数组转换成对应类的泛型集合
		   List<?> tList=JSONArray.toList(jsonArray2, tclass);
		
		return tList;
		
	}

	   /** 
     * 功能描述:传入任意一个 javabean 对象生成一个指定规格的字符串 
     * 
     * @param bean 
     *             bean对象 
     * @return String 
     */    
   public static String beanToJson(Object bean) {     
        StringBuilder json = new StringBuilder();     
        json.append("{");     
        PropertyDescriptor[] props = null;     
       try {     
            props = Introspector.getBeanInfo(bean.getClass(), Object.class)     
                    .getPropertyDescriptors();     
        } catch (IntrospectionException e) {     
        }     
       if (props != null) {     
           for (int i = 0; i < props.length; i++) {     
               try {    
                    String name = objectToJson(props[i].getName());     
                    String value = objectToJson(props[i].getReadMethod().invoke(bean));    
                    json.append(name);     
                    json.append(":");     
                    json.append(value);     
                    json.append(",");    
                } catch (Exception e) {     
                }     
            }     
            json.setCharAt(json.length() - 1, '}');     
        } else {     
            json.append("}");     
        }     
       return json.toString();     
    }     
   
    /** 
     * @param object 
     *             任意对象 
     * @return java.lang.String 
     */    
   public static String objectToJson(Object object) {     
        StringBuilder json = new StringBuilder();     
       if (object == null) {     
            json.append("\"\"");     
        } else if (object instanceof String || object instanceof Integer) {   
            json.append("\"").append(object.toString()).append("\"");    
        } else {     
            json.append(beanToJson(object));     
        }     
       return json.toString();     
    }     
   
	 /** 
     * 功能描述:通过传入一个列表对象,调用指定方法将列表中的数据生成一个JSON规格指定字符串 
     * 
     * @param list 
     *             列表对象 
     * @return java.lang.String 
     */    
   public static String listToJson(List<?> list) {     
        StringBuilder json = new StringBuilder();     
        json.append("[");     
       if (list != null && list.size() > 0) {     
           for (Object obj : list) {     
                json.append(objectToJson(obj));     
                json.append(",");     
            }     
            json.setCharAt(json.length() - 1, ']');     
        } else {     
            json.append("]");     
        }     
       return json.toString();     
    }  
}