//package com.engine.parse;
//
//import java.io.File;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//
//import com.google.common.collect.Lists;
//
//public class ParseXmlToDecisiontree {
//	private static int i = 0, j = 0;
//
//	public static void main(String[] args) {
//		parseXML("/Users/ant_shake_tree/Documents/python_work/omingraffle.xml");
//		int i = 0;
//
////		for (String key : listKey) {
////			System.out.println(key);
////		}
////		for (String key : listValue) {
////			System.out.println(key);
////		}
//		System.out.println(listKey.size());
//		System.out.println(listValue.size());
//	}
//
//	public static void parseXML(String filename) {
//		File myXML = new File(filename);
//		SAXReader sr = new SAXReader();
//		try {
//			Document doc = sr.read(myXML);
//			Element root = doc.getRootElement();
//
//			parseDom(root);
//
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void parseDom(Element root) {
//
//		Iterator fathers = root.elementIterator();
//		while (fathers.hasNext()) {
//			Element father = (Element) fathers.next();
//			System.out.println(father.getName() + " v " + father.getText());
//			if (StringUtils.isNotEmpty(father.getText())) {
////				if()
//				
//			}
//			
//			// if (!father.getName().equals("dict")
//			// && !father.getName().equals("array")) {
//			// if (father.getName().equals("key")) {
//			// listKey.add(father.getText());
//			// } else {
//			// listValue.add(father.getText());
//			// }
//			// }
//			parseDom(father);
//
//		}
//
//	}
//
//	public static List<String> listKey = Lists.newArrayList();
//	public static List<String> listValue = Lists.newArrayList();
//
//	public static class MapClass {
//		String key;
//		String value;
//
//		public String getKey() {
//			return key;
//		}
//
//		public void setKey(String key) {
//			this.key = key;
//		}
//
//		public String getValue() {
//			return value;
//		}
//
//		public void setValue(String value) {
//			this.value = value;
//		}
//
//	}
//}