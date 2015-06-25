package com.engine.parse;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestRules {
	public static void main(String[] args) throws IOException {
		List<String> fis = Files.readAllLines(Paths.get("testRules"),
				Charset.defaultCharset());
		for (String string : fis) {
			string = string.replace("\"", "");
			if (StringUtils.isNotEmpty(string.trim())) {
				System.out.println(Arrays.toString(string.split("\\t")));
//				System.out.println(string.split("\\t")[1]);
			}
		}
		
		SpelExpressionParser parser =new SpelExpressionParser();
		EvaluationContext context=new StandardEvaluationContext();
		context.setVariable("disease","E12");
		context.setVariable("age", 89);
		context.setVariable("prostateEnlargement", true);
		System.out.println(parser.parseExpression("not {'E11' ,'N03','N11','N18'}.contains(#disease) and #age>=60").getValue(context, Boolean.class));
		System.out.println(parser.parseExpression(" #prostateEnlargement==true").getValue(context, Boolean.class));
		
	}
}
