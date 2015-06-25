package com.hm.engine.parse.omnigraffle.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hm.engine.common.ParseJSON;
import com.hm.engine.dao.graph.domain.GraphicProcess;
import com.hm.engine.dao.graph.domain.GraphicProcess.ProcessContent;
import com.hm.engine.parse.omnigraffle.generated.OmniGraffleArray;
import com.hm.engine.parse.omnigraffle.generated.OmniGraffleDict;
import com.hm.engine.parse.omnigraffle.generated.OmniGraffleInteger;
import com.hm.engine.parse.omnigraffle.generated.OmniGraffleKey;

public class JaxbParseOmniGraffleTools {
//	private static String disa
	
	public static void main(String[] args) throws Exception {
		//
		// List<MapClass> list = generalMapClasses("dtdtojava.xml");
		//
		// // List<LineGraphic> lineGs = gernalLineGraphic(list);
		// // for (LineGraphic lineGraphic : lineGs) {
		// // System.out.println(lineGraphic);
		// // }
		// // List<LineShapeGraphic> lines = gernalLineShapeGraphic(list);
		// // for (LineShapeGraphic lineShapeGraphic : lines) {
		// // System.out.println(lineShapeGraphic);
		// // }
		// // Map<Integer, String> lis =gernalShapeGraphic(list);
		// // for (Integer id : lis.keySet()) {
		// // System.out.println(id);
		// // }
		// gernalProcess("dtdtojava.xml");
	}

	/***************************************
	 * @param path
	 * @return
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 * @throws SAXException
	 * @throws FileNotFoundException
	 * 
	 * */
	private static List<MapClass> generalMapClasses(String path)
			throws ParserConfigurationException, JAXBException, SAXException,
			FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(OmniGraffleDict.class);
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		XMLReader xmlReader = spf.newSAXParser().getXMLReader();
		InputSource inputSource = new InputSource(new FileReader(path));
		SAXSource source = new SAXSource(xmlReader, inputSource);

		Unmarshaller unmarshaller = jc.createUnmarshaller();

		OmniGraffleDict d = (OmniGraffleDict) unmarshaller.unmarshal(source);
		// System.out.println();
		List<Object> arrs = d
				.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
		int i = 0;
		for (Object string : arrs) {
			i++;
			if (string instanceof OmniGraffleKey) {
				if (((OmniGraffleKey) string).getvalue().equals("GraphicsList"))
					break;
			}
		}
		OmniGraffleArray ar = (OmniGraffleArray) arrs.get(i);
		List<Object> arss = ar
				.getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
		List<OmniGraffleDict> ds = Lists.newLinkedList();

		for (Object s : arss) {
			ds.add((OmniGraffleDict) s);
		}
		List<MapClass> list = Lists.newArrayList();
		for (OmniGraffleDict dict : ds) {
			MapClass m = new MapClass();
			List<Object> os = dict
					.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
			for (int k = 2; k < os.size() - 1; k += 2) {
				m.getValues().put(((OmniGraffleKey) os.get(k)).getvalue(),
						os.get(k + 1));
			}
			list.add(m);
		}
		return list;
	}

	public static class MapClass {
		Map<String, Object> values = Maps.newHashMap();

		public Map<String, Object> getValues() {
			return values;
		}

		public void setValues(Map<String, Object> values) {
			this.values = values;
		}
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private static Map<Integer, String> gernalLineGraphic(List<MapClass> list) {
		List<Integer> ids = new LinkedList<Integer>();
		List<String> texts = new LinkedList<String>();
		Map<Integer, String> lineGraphics = new HashMap<Integer, String>();
		for (MapClass mapClass : list) {
			Object classname = mapClass.getValues().get("Class");
			Object link = mapClass.values.get("Line");
			if (classname.equals("ShapedGraphic") && link != null) {
				com.hm.engine.parse.omnigraffle.generated.OmniGraffleDict dictId = (OmniGraffleDict) link;
				List<Object> idss = (dictId
						.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse());
				ids.add(Integer.parseInt(((OmniGraffleInteger) idss.get(1))
						.getvalue()));
				com.hm.engine.parse.omnigraffle.generated.OmniGraffleDict dictText = ((OmniGraffleDict) (mapClass
						.getValues().get("Text")));
				if (dictText != null) {
					List<Object> os = (dictText
							.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse());

					for (int in = 0; in < os.size(); in += 2) {
						OmniGraffleKey key = (OmniGraffleKey) os.get(in);
						if (key.getvalue().equals("Text")) {
							String content = os.get(in + 1).toString();
							texts.add(parseContent(content));
						}
					}
				}
			}

		}
		for (int k = 0; k < ids.size(); k++) {
			lineGraphics.put(ids.get(k), texts.get(k));
		}
		return lineGraphics;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private static List<GraphicProcess> gernalLineShapeGraphic(
			List<MapClass> list) {
		// int linkNum = 0;
		List<Integer> heads = new LinkedList<Integer>();
		List<Integer> tails = new LinkedList<Integer>();
		List<Integer> ids = new LinkedList<Integer>();
		List<GraphicProcess> lineGraphics = new LinkedList<GraphicProcess>();
		for (MapClass mapClass : list) {
			Object head = mapClass.getValues().get("Head");
			Object tail = mapClass.getValues().get("Tail");
			// Object classname = mapClass.getValues().get("Class");
			// Object link = mapClass.values.get("Line");

			if (head != null) {
				// ~((OmniGraffleInteger)
				// mapClass.getValues().get("ID")).getvalue();
				if (mapClass.getValues().get("Head") instanceof OmniGraffleDict) {
					// header.setValues(values);
					heads.add(Integer
							.parseInt(((OmniGraffleInteger) (((OmniGraffleDict) head)
									.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse()
									.get(1))).getvalue()));

				}

				if (mapClass.getValues().get("Tail") instanceof OmniGraffleDict) {
					tails.add(Integer
							.parseInt(((OmniGraffleInteger) (((OmniGraffleDict) tail)
									.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse()
									.get(1))).getvalue()));
				}
				OmniGraffleInteger oi = ((OmniGraffleInteger) mapClass
						.getValues().get("ID"));

				if (oi != null) {
					ids.add(Integer.parseInt(oi.getvalue()));
				}

			}
		}

		for (int i = 0; i < ids.size(); i++) {
			GraphicProcess lineGraphic = new GraphicProcess();
			// lineGraphic.setId(id);
			lineGraphic.setHead(heads.get(i));
			lineGraphic.setTail(tails.get(i));
			lineGraphic.setLinedId(ids.get(i));
			lineGraphics.add(lineGraphic);
		}
		return lineGraphics;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private static Map<Integer, String> gernalShapeGraphic(List<MapClass> list) {
		List<Integer> ids = new LinkedList<Integer>();
		List<String> texts = new LinkedList<String>();
		Map<Integer, String> lineGraphics = new HashMap<Integer, String>();
		for (MapClass mapClass : list) {
			Object head = mapClass.getValues().get("Head");
			Object link = mapClass.values.get("Line");
			Object classname = mapClass.getValues().get("Class");
			if ((head == null && link == null) && classname.equals(classname)) {

				OmniGraffleInteger oi = ((OmniGraffleInteger) mapClass
						.getValues().get("ID"));

				if (oi != null) {
					ids.add(Integer.parseInt(oi.getvalue()));
				}
				com.hm.engine.parse.omnigraffle.generated.OmniGraffleDict dictText = ((OmniGraffleDict) (mapClass
						.getValues().get("Text")));
				if (dictText != null) {
					List<Object> os = (dictText
							.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse());

					for (int in = 0; in < os.size(); in += 2) {
						OmniGraffleKey key = (OmniGraffleKey) os.get(in);
						if (key.getvalue().equals("Text")) {
							String content = os.get(in + 1).toString();
							texts.add(parseContent(content));
						}
					}
				}
			}
		}

		for (int i = 0; i < ids.size(); i++) {
			// lineGraphic.setContent(texts.get(i));
			// lineGraphic.setGraphicId(ids.get(i));

			lineGraphics.put(ids.get(i), texts.get(i));
			// lineGraphics.add(lineGraphic);
		}
		return lineGraphics;
	}

//	/**
//	 * 解析出所有流程
//	 * 
//	 * @param path
//	 * @return
//	 * @throws FileNotFoundException
//	 * @throws ParserConfigurationException
//	 * @throws JAXBException
//	 * @throws SAXException
//	 */
//	public static MappingDiseaseProcess gernalProcess(String path)
//			throws FileNotFoundException, ParserConfigurationException,
//			JAXBException, SAXException {
//		MappingDiseaseProcess maps = new MappingDiseaseProcess();
//		Map<Integer, DiseaseProcess> diseaseProcesses = Maps.newHashMap();
//		List<MapClass> list = generalMapClasses(path);
//		/**
//		 * 
//		 */
//		String diseaseCode = "";
//		List<LineShapeGraphic> lineShapeGraphics = gernalLineShapeGraphic(list);
//		Map<Integer, String> gernalShapeGraphicMap = gernalShapeGraphic(list);
//		for (Integer id : gernalShapeGraphicMap.keySet()) {
//			DiseaseProcess process = new DiseaseProcess();
//			List<Integer> chilrends = process.getChilrends();
//			for (LineShapeGraphic lineShapeGraphic : lineShapeGraphics) {
//				if (id == lineShapeGraphic.getHead()) {
//					
//					process.setGraphId(id);
//					process.setChilrends(chilrends);
//					chilrends.add(lineShapeGraphic.getTail());
//					process.setProcessContent(content);
//				}
//			}
//			diseaseProcesses.put(id, process);
//		}
//		maps.setDiseaseCode(diseaseCode);
//		maps.setProcesses(diseaseProcesses);
//		return maps;
//	}

	/**
	 * 解析出所有流程
	 * 
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 * @throws SAXException
	 */
	public static List<GraphicProcess> gernalAllProcess(String path) throws FileNotFoundException,
			ParserConfigurationException, JAXBException, SAXException {
		List<MapClass> list = generalMapClasses(path);
		/**
		 * 
		 */
		List<GraphicProcess> reGraphics = Lists.newArrayList();
		List<GraphicProcess> lineShapeGraphics = gernalLineShapeGraphic(list);
		Map<Integer, String> gernalShapeGraphicMap = gernalLineGraphic(list);
		Map<Integer, String> geMap = gernalShapeGraphic(list);
		for (GraphicProcess lineShapeGraphic : lineShapeGraphics) {
			for (Integer id : gernalShapeGraphicMap.keySet()) {
				if (id == lineShapeGraphic.getLinedId()) {
					ProcessContent content = ParseJSON
							.fromJson(gernalShapeGraphicMap.get(id),
									ProcessContent.class);
					lineShapeGraphic.setExpressionId(Integer.parseInt(content
							.getId()));
					
					ProcessContent headp = ParseJSON
							.fromJson(geMap
									.get(lineShapeGraphic.getHead()),
									ProcessContent.class);
					if (content.getType().equals("root")) {
						lineShapeGraphic.setDiseaseCode(content.getId());
					}
					lineShapeGraphic.setProcessContent(geMap.get(lineShapeGraphic.getHead()));
					reGraphics.add(lineShapeGraphic);
				}
			}
		}
		return reGraphics;
	}

	private static String parseContent(String content) {
		content = (content.substring(content.indexOf("\"") - 1,
				content.lastIndexOf("}")).replace("\\", ""));
		if (content.contains("]")) {
			content = "[" + content;
		}
		return content;
	}

}
