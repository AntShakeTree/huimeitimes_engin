package com.engine.parse;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.engine.parse.omnigraffle.generated.OmniGraffleArray;
import com.engine.parse.omnigraffle.generated.OmniGraffleDict;
import com.engine.parse.omnigraffle.generated.OmniGraffleInteger;
import com.engine.parse.omnigraffle.generated.OmniGraffleKey;
import com.engine.parse.omnigraffle.generated.OmniGraffleString;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JaxbParseOmniGraffle {
	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext
				.newInstance(OmniGraffleDict.class);

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		XMLReader xmlReader = spf.newSAXParser().getXMLReader();
		InputSource inputSource = new InputSource(new FileReader(
				"dtdtojava.xml"));
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
		System.out.println(arrs.get(i));
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
				m.getValues().put(((OmniGraffleKey) os.get(k)).getvalue(), os.get(k + 1));
			}
			list.add(m);
		}

		for (MapClass mapClass : list) {
			System.out.println(((OmniGraffleString) mapClass
					.getValues().get("Class")).getvalue());
			System.out.println(((OmniGraffleInteger) mapClass
					.getValues().get("ID")).getvalue());
			System.out
					.println(((OmniGraffleString) (((OmniGraffleDict) mapClass
							.getValues().get("Text"))
							.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse()
							.get(1))).getvalue());

		}

		// System.out.println(foo.getvalue());
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
}
